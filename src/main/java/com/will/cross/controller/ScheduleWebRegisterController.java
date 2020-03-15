package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.ScheduleWebRegister;
import com.will.cross.service.ScheduleWebRegisterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PualrDwade on 2020/02/11.
*/
@RestController
@RequestMapping("/schedule/web/register")
public class ScheduleWebRegisterController {
    @Resource
    private ScheduleWebRegisterService scheduleWebRegisterService;

    @PostMapping
    public Result add(@RequestBody ScheduleWebRegister scheduleWebRegister) {
        scheduleWebRegisterService.save(scheduleWebRegister);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        scheduleWebRegisterService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody ScheduleWebRegister scheduleWebRegister) {
        scheduleWebRegisterService.update(scheduleWebRegister);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        ScheduleWebRegister scheduleWebRegister = scheduleWebRegisterService.findById(id);
        return ResultGenerator.genSuccessResult(scheduleWebRegister);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ScheduleWebRegister> list = scheduleWebRegisterService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
