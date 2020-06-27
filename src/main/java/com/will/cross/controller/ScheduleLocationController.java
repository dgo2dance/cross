package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.ScheduleLocation;
import com.will.cross.service.ScheduleLocationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
* Created by PualrDwade on 2020/05/28.
*/
@RestController
@RequestMapping("/schedule/location")
public class ScheduleLocationController extends  BaseController{
    @Resource
    private ScheduleLocationService scheduleLocationService;

    @PostMapping
    public Result add(@RequestBody ScheduleLocation scheduleLocation) {


        scheduleLocation.setId(UUID.randomUUID().toString());
        scheduleLocation.setDelFlag("0");
        scheduleLocation.setCreateBy(getUserId());
        scheduleLocation.setCreateDate(new Date());
        scheduleLocation.setUpdateBy(getUserId());
        scheduleLocation.setUpdateDate(new Date());

        scheduleLocationService.save(scheduleLocation);
        String id=scheduleLocation.getId();

        return ResultGenerator.genSuccessResult(id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        scheduleLocationService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody ScheduleLocation scheduleLocation) {
        scheduleLocationService.update(scheduleLocation);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        ScheduleLocation scheduleLocation = scheduleLocationService.findById(id);
        return ResultGenerator.genSuccessResult(scheduleLocation);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ScheduleLocation> list = scheduleLocationService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
