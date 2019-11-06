package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.ScheduleShiftGroup;
import com.will.cross.service.ScheduleShiftGroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PualrDwade on 2019/10/07.
*/
@RestController
@RequestMapping("/schedule/shift/group")
public class ScheduleShiftGroupController {
    @Resource
    private ScheduleShiftGroupService scheduleShiftGroupService;

    @PostMapping
    public Result add(@RequestBody ScheduleShiftGroup scheduleShiftGroup) {
        scheduleShiftGroupService.save(scheduleShiftGroup);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        scheduleShiftGroupService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody ScheduleShiftGroup scheduleShiftGroup) {
        scheduleShiftGroupService.update(scheduleShiftGroup);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        ScheduleShiftGroup scheduleShiftGroup = scheduleShiftGroupService.findById(id);
        return ResultGenerator.genSuccessResult(scheduleShiftGroup);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ScheduleShiftGroup> list = scheduleShiftGroupService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
