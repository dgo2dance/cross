package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.ScheduleTimeTable;
import com.will.cross.model.ScheduleTimeTableList;
import com.will.cross.model.SysOffice;
import com.will.cross.model.SysUser;
import com.will.cross.service.ScheduleTimeTableListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.will.cross.util.DateUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
* Created by PualrDwade on 2019/10/05.
*/
@RestController
@RequestMapping("/schedule/time/table/list")
public class ScheduleTimeTableListController extends BaseController{
    @Resource
    private ScheduleTimeTableListService scheduleTimeTableListService;


    /**
     * 发布时，判断当前区间是否有，如有则更新，没有则添加
     * @param scheduleTimeTableList
     * @return
     */
    @PostMapping
    public Result add(@RequestBody ScheduleTimeTableList scheduleTimeTableList) {

        String orgId=getMasterId();
        String userId=getUserId();
        Condition query=new Condition(ScheduleTimeTableList.class);
        query.createCriteria().andEqualTo("orgId",orgId)
                .andLessThan("endDate",scheduleTimeTableList.getEndDate())
                .andGreaterThan("beginDate",scheduleTimeTableList.getBeginDate());

        List<ScheduleTimeTableList> list = scheduleTimeTableListService.findByCondition(query);

        if(list.size()>0){
            scheduleTimeTableList.setId(list.get(0).getId());
            scheduleTimeTableListService.update(scheduleTimeTableList);
        } else {

            scheduleTimeTableList.setId(UUID.randomUUID().toString());
            scheduleTimeTableList.setOrgId(orgId);
            scheduleTimeTableList.setMasterId(orgId);
            scheduleTimeTableList.setDelFlag("0");
            scheduleTimeTableList.setCreateBy(userId);
            scheduleTimeTableList.setCreateDate(new Date());

            scheduleTimeTableListService.save(scheduleTimeTableList);
        }
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        scheduleTimeTableListService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody ScheduleTimeTableList scheduleTimeTableList) {
        scheduleTimeTableListService.update(scheduleTimeTableList);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        ScheduleTimeTableList scheduleTimeTableList = scheduleTimeTableListService.findById(id);
        return ResultGenerator.genSuccessResult(scheduleTimeTableList);
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST, produces = "application/json")
    public Result list(@RequestBody ScheduleTimeTableList scheduleTimeTableList) {
      //  PageHelper.startPage(page, size);
        String orgId=getMasterId();
        Condition query=new Condition(ScheduleTimeTableList.class);
        query.createCriteria().andEqualTo("orgId",orgId)
                .andLessThanOrEqualTo("endDate", DateUtil.getYearMonthDay(scheduleTimeTableList.getEndDate()))
                .andGreaterThanOrEqualTo("beginDate",DateUtil.getYearMonthDay(scheduleTimeTableList.getBeginDate()));

        List<ScheduleTimeTableList> list = scheduleTimeTableListService.findByCondition(query);

        if(list.size()<1){
            // 如果没有查询到数据，则说明没有发布，以及没有添加remark;
            ScheduleTimeTableList tmp=new ScheduleTimeTableList();
            tmp.setRemark("");
            tmp.setStatus("1");
            list.add(tmp);
        }
      //  PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(list);
    }




}
