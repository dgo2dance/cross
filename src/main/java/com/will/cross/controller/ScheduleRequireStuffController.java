package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.ScheduleRequireStuff;
import com.will.cross.service.ScheduleRequireStuffService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PualrDwade on 2020/07/26.
*/
@RestController
@RequestMapping("/schedule/require/stuff")
public class ScheduleRequireStuffController {
    @Resource
    private ScheduleRequireStuffService scheduleRequireStuffService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public Result add(@RequestBody ScheduleRequireStuff scheduleRequireStuff) {
        scheduleRequireStuffService.save(scheduleRequireStuff);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
    public Result delete(@PathVariable String id) {
        scheduleRequireStuffService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/up", method = RequestMethod.POST, produces = "application/json")
    public Result update(@RequestBody ScheduleRequireStuff scheduleRequireStuff) {
        scheduleRequireStuffService.update(scheduleRequireStuff);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        ScheduleRequireStuff scheduleRequireStuff = scheduleRequireStuffService.findById(id);
        return ResultGenerator.genSuccessResult(scheduleRequireStuff);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ScheduleRequireStuff> list = scheduleRequireStuffService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
