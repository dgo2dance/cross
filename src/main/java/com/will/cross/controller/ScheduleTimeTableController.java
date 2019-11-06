package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.ScheduleTimeTable;
import com.will.cross.service.ScheduleTimeTableService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PualrDwade on 2019/10/05.
*/
@RestController
@RequestMapping("/schedule/time/table")
public class ScheduleTimeTableController extends BaseController{
    @Resource
    private ScheduleTimeTableService scheduleTimeTableService;

    @PostMapping
    public Result add(@RequestBody ScheduleTimeTable scheduleTimeTable) {
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
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ScheduleTimeTable> list = scheduleTimeTableService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
