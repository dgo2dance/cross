package com.will.cross.controller;

import com.google.common.collect.Lists;
import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.*;
import com.will.cross.service.ScheduleAreaService;
import com.will.cross.service.ScheduleLocationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.will.cross.service.SchedulePersonOrgRelateService;
import com.will.cross.service.SysUserService;
import org.springframework.beans.BeanUtils;
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
    private ScheduleAreaService scheduleAreaService;


    @Resource
    private SysUserService sysUserService;


    @Resource
    private SchedulePersonOrgRelateService schedulePersonOrgRelateService;


    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public Result add(@RequestBody ScheduleLocationVO scheduleLocation) {


        // 保存 loca
        ScheduleLocation l = new ScheduleLocation();

        l.setMaster(getMasterId());
        l.setId(UUID.randomUUID().toString());
        l.setDelFlag("0");
        l.setCreateBy(getUserId());
        l.setCreateDate(new Date());
        l.setUpdateBy(getUserId());
        l.setUpdateDate(new Date());
        l.setName(scheduleLocation.getLocaName());
        scheduleLocationService.save(l);

        //保存 area
        ScheduleArea a=new ScheduleArea();

        for(AreaVO s:scheduleLocation.getAreaName()){
            a.setId(UUID.randomUUID().toString());
            a.setLocationId(l.getId());
            a.setLocationName(l.getName());
            a.setName(s.getName());
            a.setRemark(s.getRemark());
            a.setDelFlag("0");
            a.setStatus("0");
            a.setCreateBy(getUserId());
            a.setCreateDate(new Date());
            a.setUpdateBy(getUserId());
            a.setUpdateDate(new Date());
            scheduleAreaService.save(a);


        }

        // save  person
        SysUser u = new SysUser();
        SchedulePersonOrgRelate pr=new SchedulePersonOrgRelate();
        for(PersonVO v:scheduleLocation.getPersonName()){
            u.setId(UUID.randomUUID().toString());
            u.setName(v.getName());
            u.setMobile(v.getPhone());
            u.setEmail(v.getMail());

            u.setLocationid(l.getId());
            u.setLocationname(l.getName());
            u.setDelFlag("0");
            u.setCreateBy(getUserId());
            u.setCreateDate(new Date());
            u.setUpdateBy(getUserId());
            u.setUpdateDate(new Date());
            sysUserService.save(u);

            // 保存人员 组织的关系
            pr.setId(UUID.randomUUID().toString());
            pr.setOrgId(getMasterId());
            pr.setPersonId(u.getId());
            u.setDelFlag("0");
            u.setCreateBy(getUserId());
            u.setCreateDate(new Date());
            u.setUpdateBy(getUserId());
            u.setUpdateDate(new Date());
            schedulePersonOrgRelateService.save(pr);
        }

        String id=scheduleLocation.getId();
        return ResultGenerator.genSuccessResult(id);

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
    public Result delete(@RequestBody ScheduleLocation scheduleLocation) {

        scheduleLocation.setDelFlag("1");
        scheduleLocationService.update(scheduleLocation);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
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
        queryLoc.createCriteria().andEqualTo("master",sys.getOrgId()).andEqualTo("delFlag","0");
        List<ScheduleLocation> listLoc = scheduleLocationService.findByCondition(queryLoc);

        List<ScheduleLocationRVO> rvo= Lists.newArrayList();
        for(ScheduleLocation s:listLoc){
            ScheduleLocationRVO r=new ScheduleLocationRVO();
            BeanUtils.copyProperties( s,r);

            Condition queryArea=new Condition(ScheduleArea.class);
            queryArea.createCriteria().andEqualTo("locationId",s.getId()).andEqualTo("status","0");

            List<ScheduleArea> area = scheduleAreaService.findByCondition(queryArea);
            r.setArea(area);
            rvo.add(r);
        }

        PageInfo pageInfo = new PageInfo(rvo);
        return ResultGenerator.genSuccessResult(pageInfo);


    }

}
