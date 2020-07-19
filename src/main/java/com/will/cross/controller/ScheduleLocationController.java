package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.ScheduleLocation;
import com.will.cross.model.ScheduleLocationVO;
import com.will.cross.model.SchedulePersonOrgRelate;
import com.will.cross.service.ScheduleLocationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.will.cross.service.SchedulePersonOrgRelateService;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
* Created by PualrDwade on 2020/05/28.
*/
@RestController
@RequestMapping("/schedule/location")
public class ScheduleLocationController extends  BaseController{
    @Resource
    private ScheduleLocationService scheduleLocationService;


    @Resource
    private SchedulePersonOrgRelateService schedulePersonOrgRelateService;


    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public Result add(@RequestBody ScheduleLocationVO scheduleLocation) {


        scheduleLocation.setId(UUID.randomUUID().toString());
        scheduleLocation.setDelFlag("0");
        scheduleLocation.setCreateBy(getUserId());
        scheduleLocation.setCreateDate(new Date());
        scheduleLocation.setUpdateBy(getUserId());
        scheduleLocation.setUpdateDate(new Date());

     //   scheduleLocationService.save(scheduleLocation);
        String id=scheduleLocation.getId();

        return ResultGenerator.genSuccessResult(id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        scheduleLocationService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody ScheduleLocation scheduleLocation) {
        scheduleLocationService.update(scheduleLocation);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        ScheduleLocation scheduleLocation = scheduleLocationService.findById(id);
        return ResultGenerator.genSuccessResult(scheduleLocation);
    }

    /**
     * 获取当前激活企业下的位置，地点；
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/listall", method = RequestMethod.GET, produces = "application/json")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);

        Condition query=new Condition(SchedulePersonOrgRelate.class);
        String userId=getUserId();
        query.createCriteria().andEqualTo("personId",userId).andEqualTo("status","0");

        List<SchedulePersonOrgRelate> list = schedulePersonOrgRelateService.findByCondition(query);
        SchedulePersonOrgRelate sys=list.get(0);


        Condition queryLoc=new Condition(ScheduleLocation.class);
        queryLoc.createCriteria().andEqualTo("master",sys.getOrgId());
        List<ScheduleLocation> listLoc = scheduleLocationService.findByCondition(queryLoc);
        PageInfo pageInfo = new PageInfo(listLoc);
        return ResultGenerator.genSuccessResult(pageInfo);


    }

}
