package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.ScheduleTimeTableList;
import com.will.cross.model.SysOffice;
import com.will.cross.model.SysUser;
import com.will.cross.service.ScheduleTimeTableListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PualrDwade on 2019/10/05.
*/
@RestController
@RequestMapping("/schedule/time/table/list")
public class ScheduleTimeTableListController extends BaseController{
    @Resource
    private ScheduleTimeTableListService scheduleTimeTableListService;

    @PostMapping
    public Result add(@RequestBody ScheduleTimeTableList scheduleTimeTableList) {
        scheduleTimeTableListService.save(scheduleTimeTableList);
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

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ScheduleTimeTableList> list = scheduleTimeTableListService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }




}
