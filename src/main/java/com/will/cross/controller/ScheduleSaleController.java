package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.ScheduleSale;
import com.will.cross.service.ScheduleSaleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PualrDwade on 2020/07/26.
*/
@RestController
@RequestMapping("/schedule/sale")
public class ScheduleSaleController {
    @Resource
    private ScheduleSaleService scheduleSaleService;

    @PostMapping
    public Result add(@RequestBody ScheduleSale scheduleSale) {
        scheduleSaleService.save(scheduleSale);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        scheduleSaleService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody ScheduleSale scheduleSale) {
        scheduleSaleService.update(scheduleSale);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        ScheduleSale scheduleSale = scheduleSaleService.findById(id);
        return ResultGenerator.genSuccessResult(scheduleSale);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ScheduleSale> list = scheduleSaleService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
