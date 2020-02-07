package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.SchedulePersonOrgRelate;
import com.will.cross.service.SchedulePersonOrgRelateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PualrDwade on 2020/02/02.
*/
@RestController
@RequestMapping("/schedule/person/org/relate")
public class SchedulePersonOrgRelateController {
    @Resource
    private SchedulePersonOrgRelateService schedulePersonOrgRelateService;

    @PostMapping
    public Result add(@RequestBody SchedulePersonOrgRelate schedulePersonOrgRelate) {
        schedulePersonOrgRelateService.save(schedulePersonOrgRelate);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        schedulePersonOrgRelateService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody SchedulePersonOrgRelate schedulePersonOrgRelate) {
        schedulePersonOrgRelateService.update(schedulePersonOrgRelate);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        SchedulePersonOrgRelate schedulePersonOrgRelate = schedulePersonOrgRelateService.findById(id);
        return ResultGenerator.genSuccessResult(schedulePersonOrgRelate);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SchedulePersonOrgRelate> list = schedulePersonOrgRelateService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
