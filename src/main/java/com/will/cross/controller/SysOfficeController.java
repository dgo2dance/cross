package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.model.SysOffice;
import com.will.cross.service.SysOfficeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;
/**
* Created by PualrDwade on 2019/10/07.
*/
@RestController
@RequestMapping("/sys/office")
public class SysOfficeController extends  BaseController{
    @Resource
    private SysOfficeService sysOfficeService;

    @PostMapping
    public Result add(@RequestBody SysOffice sysOffice) {
        sysOffice.setId(UUID.randomUUID().toString());
        sysOffice.setParentId("0");
        sysOffice.setDelFlag("0");
        sysOffice.setStatus("0");
        sysOffice.setMaster(getOpenId());


        //更新其他组织状态为1;
        SysOffice tmp= new SysOffice();
        tmp.setMaster(getOpenId());
        sysOfficeService.updateStatusByCustomerId(tmp);

        //插入新的
        sysOfficeService.save(sysOffice);

        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        sysOfficeService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody SysOffice sysOffice) {
        sysOfficeService.update(sysOffice);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        SysOffice sysOffice = sysOfficeService.findById(id);
        return ResultGenerator.genSuccessResult(sysOffice);
    }

    /**
     * 依据条件查去当前用户下的有效组织；
     * @param page
     * @param size
     * @return
     */
    @GetMapping
    public Result list(@RequestParam String sign, HttpServletRequest request) {


      //  PageHelper.startPage(page, size);
        Condition query=new Condition(SysOffice.class);
        String openid=getOpenId();
        query.createCriteria().andEqualTo("master","onDD80C0oSuFwM4_swUXx_esEr2A").andEqualTo("status","0");

        List<SysOffice> list = sysOfficeService.findByCondition(query);
        SysOffice sysOffice=list.get(0);
      //  PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(sysOffice);
    }



    /**
     * 获取当前用户组织列表；
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "获取组织列表", notes = "")
    @ApiImplicitParam(name = "sign", value = "标识 ", required = true, dataType = "String")
    @RequestMapping(value = "/listall", method = RequestMethod.GET, produces = "application/json")
    public Result listall(@RequestParam String sign, HttpServletRequest request) {


        //  PageHelper.startPage(page, size);
        Condition query=new Condition(SysOffice.class);
        String openid=getOpenId();
        query.createCriteria().andEqualTo("master","onDD80C0oSuFwM4_swUXx_esEr2A");

        List<SysOffice> list = sysOfficeService.findByCondition(query);
        //  PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(list);
    }



    @ApiOperation(value = "选择某一个组织", notes = "")
    @RequestMapping(value = "/selectOrg", method = RequestMethod.GET, produces = "application/json")
    public Result selectOrg(@RequestParam String id, HttpServletRequest request) {


        //更新其他组织状态为1;
        SysOffice tmp= new SysOffice();
        tmp.setMaster(getOpenId());
        int flag =sysOfficeService.updateStatusByCustomerId(tmp);

        //更新当前组织状态为0;
        SysOffice tmp_a= new SysOffice();
        tmp_a.setStatus("0");
        tmp_a.setId(id);
        sysOfficeService.update(tmp_a);


        return ResultGenerator.genSuccessResult();
    }




}
