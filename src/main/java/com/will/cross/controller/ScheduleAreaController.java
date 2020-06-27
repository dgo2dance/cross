package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.ScheduleArea;
import com.will.cross.model.ScheduleAreaVO;
import com.will.cross.service.ScheduleAreaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PualrDwade on 2020/05/28.
*/
@RestController
@RequestMapping("/schedule/area")
public class ScheduleAreaController {
    @Resource
    private ScheduleAreaService scheduleAreaService;

    @PostMapping
    public Result add(@RequestBody ScheduleAreaVO scheduleArea) {

          System.out.println("sss");
   //     scheduleAreaService.save(scheduleArea);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        scheduleAreaService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody ScheduleArea scheduleArea) {
        scheduleAreaService.update(scheduleArea);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        ScheduleArea scheduleArea = scheduleAreaService.findById(id);
        return ResultGenerator.genSuccessResult(scheduleArea);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ScheduleArea> list = scheduleAreaService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
