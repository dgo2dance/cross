package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.ScheduleArea;
import com.will.cross.model.ScheduleAreaVO;
import com.will.cross.model.SchedulePersonOrgRelate;
import com.will.cross.model.ScheduleTimeTable;
import com.will.cross.service.ScheduleAreaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
* Created by PualrDwade on 2020/05/28.
*/
@RestController
@RequestMapping("/schedule/area")
public class ScheduleAreaController extends BaseController {
    @Resource
    private ScheduleAreaService scheduleAreaService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public Result add(@RequestBody ScheduleArea scheduleArea) {

        scheduleArea.setId(UUID.randomUUID().toString());
        scheduleArea.setDelFlag("0");
        scheduleArea.setCreateBy(getUserId());
        scheduleArea.setCreateDate(new Date());
        scheduleArea.setUpdateBy(getUserId());
        scheduleArea.setUpdateDate(new Date());
        scheduleAreaService.save(scheduleArea);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
    public Result delete(@RequestBody ScheduleArea scheduleArea) {


        scheduleArea.setDelFlag("1");
        scheduleAreaService.update(scheduleArea);
     //   scheduleAreaService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    public Result update(@RequestBody ScheduleArea scheduleArea) {
        scheduleAreaService.update(scheduleArea);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        ScheduleArea scheduleArea = scheduleAreaService.findById(id);
        return ResultGenerator.genSuccessResult(scheduleArea);
    }

    @RequestMapping(value = "/listall", method = RequestMethod.POST, produces = "application/json")
    public Result list(@RequestBody  ScheduleArea scheduleArea) {
    //    PageHelper.startPage(page, size);

        Condition query=new Condition(ScheduleArea.class);
        String userId=getUserId();
        query.createCriteria().andEqualTo("locationId",scheduleArea.getId()).andEqualTo("delFlag","0");

        List<ScheduleArea> list = scheduleAreaService.findByCondition(query);

        //   List<ScheduleArea> list = scheduleAreaService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
