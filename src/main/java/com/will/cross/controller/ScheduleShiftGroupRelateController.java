package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.ScheduleShiftGroupRelate;
import com.will.cross.service.ScheduleShiftGroupRelateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PualrDwade on 2019/10/05.
*/
@RestController
@RequestMapping("/schedule/shift/group/relate")
public class ScheduleShiftGroupRelateController extends BaseController{
    @Resource
    private ScheduleShiftGroupRelateService scheduleShiftGroupRelateService;

    @PostMapping
    public Result add(@RequestBody ScheduleShiftGroupRelate scheduleShiftGroupRelate) {
        scheduleShiftGroupRelateService.save(scheduleShiftGroupRelate);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        scheduleShiftGroupRelateService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody ScheduleShiftGroupRelate scheduleShiftGroupRelate) {
        scheduleShiftGroupRelateService.update(scheduleShiftGroupRelate);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        ScheduleShiftGroupRelate scheduleShiftGroupRelate = scheduleShiftGroupRelateService.findById(id);
        return ResultGenerator.genSuccessResult(scheduleShiftGroupRelate);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ScheduleShiftGroupRelate> list = scheduleShiftGroupRelateService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
