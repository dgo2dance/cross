package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.ScheduleShift;
import com.will.cross.service.ScheduleShiftService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Result add(@RequestBody ScheduleShift scheduleShift) {
        scheduleShift.setId(UUID.randomUUID().toString());
        scheduleShift.setCreateBy(getOpenId());
        scheduleShift.setCreateDate(new Date());
        scheduleShiftService.save(scheduleShift);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        scheduleShiftService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody ScheduleShift scheduleShift) {
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
        PageHelper.startPage(page, size);
        List<ScheduleShift> list = scheduleShiftService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
