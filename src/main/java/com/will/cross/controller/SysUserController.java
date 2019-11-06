package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.configurer.WxApiConstant;
import com.will.cross.model.SysOffice;
import com.will.cross.model.SysUser;
import com.will.cross.service.SysOfficeService;
import com.will.cross.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.will.cross.service.WxService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* Created by PualrDwade on 2019/10/05.
*/
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends BaseController{
    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysOfficeService sysOfficeService;

    @Resource
    private  WxService wxService;

    @Autowired
    private Environment environment;

    @PostMapping
    public Result add(@RequestBody SysUser sysUser) {
        sysUserService.save(sysUser);

        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        sysUserService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody SysUser sysUser) {
        sysUserService.update(sysUser);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        SysUser sysUser = sysUserService.findById(id);
        return ResultGenerator.genSuccessResult(sysUser);
    }


    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysUser> list = sysUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    /**
     * 根据客户端传过来的code从微信服务器获取appid和session_key，然后生成3rdkey返回给客户端，后续请求客户端传3rdkey来维护客户端登录态
     * @param wxCode	小程序登录时获取的code
     * @return
     */
    @ApiOperation(value = "获取sessionId", notes = "小用户允许登录后，使用code 换取 session_key api，将 code 换成 openid 和 session_key")
    @ApiImplicitParam(name = "code", value = "用户登录回调内容会带上 ", required = true, dataType = "String")
    @RequestMapping(value = "/openid", method = RequestMethod.GET, produces = "application/json")
    public Result createSssion(@RequestParam(required = true,value = "code")String wxCode){
        Map<String,Object> wxSessionMap = wxService.getWxSession(wxCode);

        if(null == wxSessionMap){
            return ResultGenerator.genFailResult("获取openid异常");
        }
        //获取异常
        if(wxSessionMap.containsKey(WxApiConstant.ERROR_CODE)){
            return ResultGenerator.genFailResult("获取openid异常");
        }
        String wxOpenId = (String)wxSessionMap.get("openid");
        String wxSessionKey = (String)wxSessionMap.get("session_key");
        System.out.println(wxSessionKey);
        Long expires = Long.valueOf(String.valueOf(wxSessionMap.get("expires_in")));
        String thirdSession = wxService.create3rdSession(wxOpenId, wxSessionKey, expires);
        return ResultGenerator.genSuccessResult(thirdSession);
    }


    @ApiOperation(value = "获取组织用户", notes = "")
    @RequestMapping(value = "/listUser", method = RequestMethod.GET, produces = "application/json")
    public Result listUser(){

        String openId=getOpenId();

        Condition queryOffice=new Condition(SysOffice.class);
        queryOffice.createCriteria().andEqualTo("master",openId).andEqualTo("status","0");

        List<SysOffice> sysOffice= sysOfficeService.findByCondition(queryOffice);

        //  PageHelper.startPage(page, size);
        Condition query=new Condition(SysUser.class);
        String openid=getOpenId();
        query.createCriteria().andEqualTo("officeId",sysOffice.get(0).getId());

        List<SysUser> list = sysUserService.findByCondition(query);
        return ResultGenerator.genSuccessResult(list);
    }




}
