package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.ScheduleShift;
import com.will.cross.model.SysOffice;
import com.will.cross.service.ScheduleShiftService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
@RequestMapping("/schedule/shift")
public class ScheduleShiftController extends BaseController{
    @Resource
    private ScheduleShiftService scheduleShiftService;

    /**
     * 创建班次
     * @param scheduleShift
     * @return
     */
    @PostMapping
    public Result add(@RequestBody ScheduleShift scheduleShift) {
        scheduleShift.setId(UUID.randomUUID().toString());
        scheduleShift.setCreateBy(getOpenId());
        scheduleShift.setCreateDate(new Date());
        scheduleShift.setUpdateBy(getOpenId());
        scheduleShift.setUpdateDate(new Date());
        scheduleShift.setMaster(getMasterId());


        //设置状态，ture-->0    false-->0
        if("true".equals(scheduleShift.getStatus())){
            scheduleShift.setStatus("0");
        } else{
            scheduleShift.setStatus("1");
        }


        scheduleShiftService.save(scheduleShift);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/addWeb", method = RequestMethod.POST, produces = "application/json")
    public Result addWeb(@RequestBody ScheduleShift scheduleShift) {
        scheduleShift.setId(UUID.randomUUID().toString());
        scheduleShift.setCreateBy(getUserId());
        scheduleShift.setCreateDate(new Date());
        scheduleShift.setUpdateBy(getUserId());
        scheduleShift.setUpdateDate(new Date());
        scheduleShift.setMaster(getMasterId());


        //设置状态，ture-->0    false-->0
        if("true".equals(scheduleShift.getStatus())){
            scheduleShift.setStatus("0");
        } else{
            scheduleShift.setStatus("1");
        }


        scheduleShiftService.save(scheduleShift);
        return ResultGenerator.genSuccessResult();
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = "application/json")
    public Result delete(@RequestParam(required = true,value = "id")String id) {
        scheduleShiftService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/deleteWeb", method = RequestMethod.POST, produces = "application/json")
    public Result deleteWeb(@RequestBody ScheduleShift scheduleShift) {
        scheduleShiftService.deleteById(scheduleShift.getId());
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    public Result update(@RequestBody ScheduleShift scheduleShift) {


        //设置状态，ture-->0    false-->0
        if("true".equals(scheduleShift.getStatus())){
            scheduleShift.setStatus("0");
        } else{
            scheduleShift.setStatus("1");
        }

        scheduleShiftService.update(scheduleShift);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        ScheduleShift scheduleShift = scheduleShiftService.findById(id);
        return ResultGenerator.genSuccessResult(scheduleShift);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
       // PageHelper.startPage(page, size);


        //  PageHelper.startPage(page, size);
        Condition query=new Condition(ScheduleShift.class);
        String masterid=getMasterId();
        query.createCriteria().andEqualTo("master",masterid);
        List<ScheduleShift> list = scheduleShiftService.findByCondition(query);
      //  PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(list);
    }
}
