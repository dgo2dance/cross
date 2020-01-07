package com.will.cross.controller;

import com.google.common.collect.Lists;
import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.dto.ScheduleTableDTO;
import com.will.cross.dto.ScheduleTimeTableDTO;
import com.will.cross.model.*;
import com.will.cross.service.ScheduleShiftService;
import com.will.cross.service.ScheduleTimeTableService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.will.cross.service.SysOfficeService;
import com.will.cross.service.SysUserService;
import com.will.cross.util.DateUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
* Created by PualrDwade on 2019/10/05.
*/
@RestController
@RequestMapping("/schedule/time/table")
public class ScheduleTimeTableController extends BaseController{
    @Resource
    private ScheduleTimeTableService scheduleTimeTableService;

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysOfficeService sysOfficeService;

    @Resource
    private ScheduleShiftService scheduleShiftService;

    @PostMapping
    public Result add(@RequestBody ScheduleTimeTable scheduleTimeTable) {

        scheduleTimeTable.setCreateDate(new Date());
        scheduleTimeTable.setUpdateDate(new Date());

        String openId=getOpenId();
        // 1.查询当前激活组织
        Condition queryOffice=new Condition(SysOffice.class);
        queryOffice.createCriteria().andEqualTo("master",openId).andEqualTo("status","0");
        List<SysOffice> sysOffice= sysOfficeService.findByCondition(queryOffice);
        scheduleTimeTable.setOrgId(sysOffice.get(0).getId());

        scheduleTimeTable.setMasterId(openId);
        scheduleTimeTable.setDelFlag("0");
        scheduleTimeTable.setId(UUID.randomUUID().toString());
        scheduleTimeTable.setCreateBy(openId);
        scheduleTimeTable.setUpdateBy(openId);
        scheduleTimeTableService.save(scheduleTimeTable);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        scheduleTimeTableService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody ScheduleTimeTable scheduleTimeTable) {
        scheduleTimeTableService.update(scheduleTimeTable);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        ScheduleTimeTable scheduleTimeTable = scheduleTimeTableService.findById(id);
        return ResultGenerator.genSuccessResult(scheduleTimeTable);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,
                       @RequestBody ScheduleTimeTable scheduleTimeTable) {
        PageHelper.startPage(page, size);
        List<ScheduleTimeTable> list = scheduleTimeTableService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }



    /**
     * 获取排班表明细数据
     * @return
     */
    @ApiOperation(value = "获取排班表并展示", notes = "")
    @RequestMapping(value = "/getTable", method = RequestMethod.POST, produces = "application/json")
    public Result getTable(@RequestBody ScheduleTimeTable scheduleTimeTable) {


        // PageHelper.startPage(page, size);

        List<ScheduleTableDTO> scheduleTableDto = Lists.newArrayList();


        String openId=getOpenId();

        // 1.查询当前激活组织
        Condition queryOffice=new Condition(SysOffice.class);
        queryOffice.createCriteria().andEqualTo("master",openId).andEqualTo("status","0");

        List<SysOffice> sysOffice= sysOfficeService.findByCondition(queryOffice);

        //  PageHelper.startPage(page, size);

        // 1.根据当前激活组织查询所有资源，即用户
        Condition query=new Condition(SysUser.class);
        String openid=getOpenId();
        query.createCriteria().andEqualTo("officeId",sysOffice.get(0).getId());

        List<SysUser> list = sysUserService.findByCondition(query);
     //   return ResultGenerator.genSuccessResult(list);


        // 2.根据当前激活组织  及时间段区间  查询里面的排班情况
        //  PageInfo pageInfo = new PageInfo(list);
        Condition queryTable=new Condition(ScheduleTimeTable.class);
        queryTable.createCriteria().andEqualTo("orgId",sysOffice.get(0).getId())
                .andLessThan("beginDate",scheduleTimeTable.getEndDate())
                .andGreaterThan("beginDate",scheduleTimeTable.getBeginDate());

        List<ScheduleTimeTable> listTabel = scheduleTimeTableService.findByCondition(queryTable);


        //获取中间所有间隔的时间
        List<String> listDay = DateUtil.getEveryday(DateUtil.getYearMonthDay(scheduleTimeTable.getBeginDate()),
                DateUtil.getYearMonthDay(scheduleTimeTable.getEndDate()));

        //获取所有班次的名字;
        // get the shift id
        List<String> shiftId = listTabel.stream().map(s -> s.getShiftId()).collect(Collectors.toList());

        shiftId = shiftId.stream().distinct().collect(Collectors.toList());

            String shiftIds = "";
            for (String ss : shiftId)
                {
                    shiftIds += "'" +ss +"'" +  ",";
                }
            shiftIds = shiftIds.substring(0, shiftIds.length() - 1);

     //   String shiftIds = shiftId.stream().collect(Collectors.joining(","));
        List<ScheduleShift> sshift=new ArrayList<>();
        sshift = scheduleShiftService.findByIds(shiftIds);



        // 3.将资源用户  及排班数据  进行重组  展示为想要的形式；
        for(SysUser m:list){

            ScheduleTableDTO w=new ScheduleTableDTO();
            w.setResourceId(m.getId());
            w.setResourceName(m.getName());

            List<ScheduleTimeTableDTO> t=Lists.newArrayList();
            for (String day : listDay) {
                ScheduleTimeTableDTO table=new ScheduleTimeTableDTO();

                List<ScheduleTimeTable> timetable=listTabel.stream().filter(e->e.getPersonId().equals(m.getId()) )
                        .filter(e->DateUtil.getYearMonthDay(e.getBeginDate()).equals(day))
                        .collect(Collectors.toList());

                if(timetable.size()>0){
                    BeanUtils.copyProperties( timetable.get(0),table);

                    // 查找到  shiftName  设置shiftName;
                    List<ScheduleShift> ss=sshift.stream().filter(e->e.getId().equals(table.getShiftId())).collect(Collectors.toList());
                    if(ss.size()>0) {
                        table.setShiftName(ss.get(0).getName());
                    } else{
                        table.setShiftName("");
                    }
                    t.add(table);

                }else{
                    table.setBeginDate(DateUtil.toDate(day));
                    table.setShiftId("");
                    table.setShiftName("");
                    t.add(table);
                }
            }

            w.setTable(t);
            scheduleTableDto.add(w);


        }


//
//
//        list.stream().forEach(m->{
//
//
//            List<ScheduleTimeTable> timetable=listTabel.stream().filter(e->e.getPersonId().equals(m.getId()) )
//                    .collect(Collectors.toList());
//            ScheduleTableDTO w=new ScheduleTableDTO();
//            w.setResourceId(m.getId());
//            w.setResourceName(m.getName());
//            w.setTable(timetable);
//     //       w.setTable(listTabel);
//
//            scheduleTableDto.add(w);
//
//
//
//        });

        return ResultGenerator.genSuccessResult(scheduleTableDto);


    }
}
