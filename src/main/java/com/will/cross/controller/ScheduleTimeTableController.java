package com.will.cross.controller;

import com.google.common.collect.Lists;
import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.dto.ScheduleTableDTO;
import com.will.cross.dto.ScheduleTablePCDTO;
import com.will.cross.dto.ScheduleTimeTableDTO;
import com.will.cross.dto.ScheduleTimeTableIamDTO;
import com.will.cross.model.*;
import com.will.cross.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.will.cross.util.DateUtil;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;





/**
* Created by PualrDwade on 2019/10/05.
*/
@RestController
@RequestMapping("/schedule/time/table")
public class ScheduleTimeTableController extends BaseController{
    @Resource
    private ScheduleTimeTableService scheduleTimeTableService;

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysOfficeService sysOfficeService;

    @Resource
    private ScheduleShiftService scheduleShiftService;


    @Resource
    private SchedulePersonOrgRelateService schedulePersonOrgRelateService;

    @PostMapping
    public Result add(@RequestBody ScheduleTimeTable scheduleTimeTable) {


        //获取中间所有间隔的时间,拆分将每一条保存
        List<String> listDay = DateUtil.getEveryday(DateUtil.getYearMonthDay(scheduleTimeTable.getBeginDate()),
                DateUtil.getYearMonthDay(scheduleTimeTable.getEndDate()));
        String openId = getMasterId();
        for(String ss:listDay) {
            ScheduleTimeTable m=new ScheduleTimeTable();
            BeanUtils.copyProperties(scheduleTimeTable,m);

            m.setBeginDate(DateUtil.toDate(ss));
            m.setEndDate(DateUtil.toDate(ss));
            m.setCreateDate(new Date());
            m.setUpdateDate(new Date());


            // 1.查询当前激活组织
        /*
        Condition queryOffice=new Condition(SysOffice.class);
        queryOffice.createCriteria().andEqualTo("master",openId).andEqualTo("status","0");
        List<SysOffice> sysOffice= sysOfficeService.findByCondition(queryOffice);
        scheduleTimeTable.setOrgId(sysOffice.get(0).getId());
        */
            m.setOrgId(openId);
            m.setMasterId(openId);

            m.setDelFlag("0");
            m.setId(UUID.randomUUID().toString());
            m.setCreateBy(openId);
            m.setUpdateBy(openId);
            scheduleTimeTableService.save(m);
        }
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
    public Result delete(@RequestBody ScheduleTimeTable scheduleTimeTable) {
        scheduleTimeTableService.deleteById(scheduleTimeTable.getId());
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    public Result update(@RequestBody ScheduleTimeTable scheduleTimeTable) {
        scheduleTimeTableService.update(scheduleTimeTable);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        ScheduleTimeTable scheduleTimeTable = scheduleTimeTableService.findById(id);
        return ResultGenerator.genSuccessResult(scheduleTimeTable);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,
                       @RequestBody ScheduleTimeTable scheduleTimeTable) {
        PageHelper.startPage(page, size);
        List<ScheduleTimeTable> list = scheduleTimeTableService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }



    /**
     * 获取排班表明细数据
     * @return
     */
    @ApiOperation(value = "获取小程序端排班表并展示", notes = "")
    @RequestMapping(value = "/getTable", method = RequestMethod.POST, produces = "application/json")
    public Result getTable(@RequestBody ScheduleTimeTable scheduleTimeTable) {


        // PageHelper.startPage(page, size);

        List<ScheduleTableDTO> scheduleTableDto = Lists.newArrayList();

        /**
        String openId=getOpenId();

        // 1.查询当前激活组织
        Condition queryOffice=new Condition(SysOffice.class);
        queryOffice.createCriteria().andEqualTo("master",openId).andEqualTo("status","0");

        List<SysOffice> sysOffice= sysOfficeService.findByCondition(queryOffice);

        //  PageHelper.startPage(page, size);

        // 1.根据当前激活组织查询所有资源，即用户
        Condition query=new Condition(SysUser.class);
        String openid=getOpenId();
        query.createCriteria().andEqualTo("officeId",sysOffice.get(0).getId());

        List<SysUser> list = sysUserService.findByCondition(query);
     //   return ResultGenerator.genSuccessResult(list);
        */

        String orgId=getMasterId();

        Condition query=new Condition(SchedulePersonOrgRelate.class);
        query.createCriteria().andEqualTo("orgId",orgId);

        List<SchedulePersonOrgRelate> sys= schedulePersonOrgRelateService.findByCondition(query);

        // 2.根据当前激活组织  及时间段区间  查询里面的排班情况
        //  PageInfo pageInfo = new PageInfo(list);
        Condition queryTable=new Condition(ScheduleTimeTable.class);
        queryTable.createCriteria().andEqualTo("orgId",orgId)
               .andLessThanOrEqualTo("beginDate",DateUtil.getYearMonthDay(scheduleTimeTable.getEndDate()))
                .andGreaterThanOrEqualTo("beginDate",DateUtil.getYearMonthDay(scheduleTimeTable.getBeginDate()));

        List<ScheduleTimeTable> listTabel = scheduleTimeTableService.findByCondition(queryTable);


        //获取中间所有间隔的时间
        List<String> listDay = DateUtil.getEveryday(DateUtil.getYearMonthDay(scheduleTimeTable.getBeginDate()),
                DateUtil.getYearMonthDay(scheduleTimeTable.getEndDate()));

        //获取所有班次的名字;
        // get the shift id
        List<String> shiftId = listTabel.stream().map(s -> s.getShiftId()).collect(Collectors.toList());

        shiftId = shiftId.stream().distinct().collect(Collectors.toList());

            String shiftIds = "";
            for (String ss : shiftId)
                {
                    shiftIds += "'" +ss +"'" +  ",";
                }
            if(shiftIds.length()>1) {
                shiftIds = shiftIds.substring(0, shiftIds.length() - 1);
            }

     //   String shiftIds = shiftId.stream().collect(Collectors.joining(","));
        List<ScheduleShift> sshift=new ArrayList<>();
            if(shiftIds.length()>0) {
                sshift = scheduleShiftService.findByIds(shiftIds);
            }


        // 3.将资源用户  及排班数据  进行重组  展示为想要的形式；
        for(SchedulePersonOrgRelate m:sys){

            ScheduleTableDTO w=new ScheduleTableDTO();
            w.setResourceId(m.getPersonId());
            w.setResourceName(m.getPersonName());

            List<ScheduleTimeTableDTO> t=Lists.newArrayList();
            for (String day : listDay) {
                ScheduleTimeTableDTO table=new ScheduleTimeTableDTO();

                List<ScheduleTimeTable> timetable=listTabel.stream().filter(e->e.getPersonId().equals(m.getPersonId()) )
                        .filter(e->DateUtil.getYearMonthDay(e.getBeginDate()).equals(day))
                        .collect(Collectors.toList());

                if(timetable.size()>0){
                    BeanUtils.copyProperties( timetable.get(0),table);

                    // 查找到  shiftName  设置shiftName;
                    List<ScheduleShift> ss=sshift.stream().filter(e->e.getId().equals(table.getShiftId())).collect(Collectors.toList());
                    if(ss.size()>0) {
                        table.setShiftName(ss.get(0).getName());
                    } else{
                        table.setShiftName("");
                    }
                    t.add(table);

                }else{
                    table.setBeginDate(DateUtil.toDate(day));
                    table.setShiftId("");
                    table.setShiftName("");
                    t.add(table);
                }
            }

            w.setTable(t);
            scheduleTableDto.add(w);


        }


//
//
//        list.stream().forEach(m->{
//
//
//            List<ScheduleTimeTable> timetable=listTabel.stream().filter(e->e.getPersonId().equals(m.getId()) )
//                    .collect(Collectors.toList());
//            ScheduleTableDTO w=new ScheduleTableDTO();
//            w.setResourceId(m.getId());
//            w.setResourceName(m.getName());
//            w.setTable(timetable);
//     //       w.setTable(listTabel);
//
//            scheduleTableDto.add(w);
//
//
//
//        });

        return ResultGenerator.genSuccessResult(scheduleTableDto);


    }



    /**
     * 获取排班表明细数据
     * @return
     */
    @ApiOperation(value = "获取端排班表并展示", notes = "eee")
    @RequestMapping(value = "/getTablePC", method = RequestMethod.POST, produces = "application/json")
    public Result getTablePC(@RequestBody ScheduleTimeTable scheduleTimeTable) {


        // PageHelper.startPage(page, size);

        List<ScheduleTablePCDTO> scheduleTablePCDto = Lists.newArrayList();

        /**
         String openId=getOpenId();

         // 1.查询当前激活组织
         Condition queryOffice=new Condition(SysOffice.class);
         queryOffice.createCriteria().andEqualTo("master",openId).andEqualTo("status","0");

         List<SysOffice> sysOffice= sysOfficeService.findByCondition(queryOffice);

         //  PageHelper.startPage(page, size);

         // 1.根据当前激活组织查询所有资源，即用户
         Condition query=new Condition(SysUser.class);
         String openid=getOpenId();
         query.createCriteria().andEqualTo("officeId",sysOffice.get(0).getId());

         List<SysUser> list = sysUserService.findByCondition(query);
         //   return ResultGenerator.genSuccessResult(list);
         */

        String orgId=getMasterId();

        Condition query=new Condition(SchedulePersonOrgRelate.class);
        query.createCriteria().andEqualTo("orgId",orgId);

        List<SchedulePersonOrgRelate> sys= schedulePersonOrgRelateService.findByCondition(query);

        // 2.根据当前激活组织  及时间段区间  查询里面的排班情况
        //  PageInfo pageInfo = new PageInfo(list);
        Condition queryTable=new Condition(ScheduleTimeTable.class);
        queryTable.createCriteria().andEqualTo("orgId",orgId)
                .andLessThanOrEqualTo("beginDate",DateUtil.getYearMonthDay(scheduleTimeTable.getEndDate()))
                .andGreaterThanOrEqualTo("beginDate",DateUtil.getYearMonthDay(scheduleTimeTable.getBeginDate()));

        List<ScheduleTimeTable> listTabel = scheduleTimeTableService.findByCondition(queryTable);


        //获取中间所有间隔的时间
        List<String> listDay = DateUtil.getEveryday(DateUtil.getYearMonthDay(scheduleTimeTable.getBeginDate()),
                DateUtil.getYearMonthDay(scheduleTimeTable.getEndDate()));

        //获取所有班次的名字;
        // get the shift id
        List<String> shiftId = listTabel.stream().map(s -> s.getShiftId()).collect(Collectors.toList());

        shiftId = shiftId.stream().distinct().collect(Collectors.toList());

        String shiftIds = "";
        for (String ss : shiftId)
        {
            shiftIds += "'" +ss +"'" +  ",";
        }
        if(shiftIds.length()>1) {
            shiftIds = shiftIds.substring(0, shiftIds.length() - 1);
        }

        //   String shiftIds = shiftId.stream().collect(Collectors.joining(","));
        List<ScheduleShift> sshift=new ArrayList<>();
        if(shiftIds.length()>0) {
            sshift = scheduleShiftService.findByIds(shiftIds);
        }


        // 3.将资源用户  及排班数据  进行重组  展示为想要的形式；
        for(SchedulePersonOrgRelate m:sys){



            List<ScheduleTimeTableDTO> t=Lists.newArrayList();
            for (String day : listDay) {

                ScheduleTablePCDTO w=new ScheduleTablePCDTO();

                ScheduleTimeTableDTO table=new ScheduleTimeTableDTO();

                List<ScheduleTimeTable> timetable=listTabel.stream().filter(e->e.getPersonId().equals(m.getPersonId()) )
                        .filter(e->DateUtil.getYearMonthDay(e.getBeginDate()).equals(day))
                        .collect(Collectors.toList());

                if(timetable.size()>0){
                    w.setResourceId(m.getPersonId());
                    BeanUtils.copyProperties( timetable.get(0),table);
                    w.setStart(day+" 00:00:00");
                    w.setEnd(day+" 23:59:00");
                    w.setId(table.getId());
                    // 查找到  shiftName  设置shiftName;
                    List<ScheduleShift> ss=sshift.stream().filter(e->e.getId().equals(table.getShiftId())).collect(Collectors.toList());
                    if(ss.size()>0) {
                        w.setTitle(ss.get(0).getName());
                        w.setBgColor(ss.get(0).getColor());
                    } else{
                        w.setTitle("");
                    }

                    scheduleTablePCDto.add(w);
                }
            }

        }


//
//
//        list.stream().forEach(m->{
//
//
//            List<ScheduleTimeTable> timetable=listTabel.stream().filter(e->e.getPersonId().equals(m.getId()) )
//                    .collect(Collectors.toList());
//            ScheduleTableDTO w=new ScheduleTableDTO();
//            w.setResourceId(m.getId());
//            w.setResourceName(m.getName());
//            w.setTable(timetable);
//     //       w.setTable(listTabel);
//
//            scheduleTableDto.add(w);
//
//
//
//        });

        return ResultGenerator.genSuccessResult(scheduleTablePCDto);


    }


    /**
     * 获取我的班表情况
     * @return
     */
    @ApiOperation(value = "获取排班表并展示", notes = "")
    @RequestMapping(value = "/getTableIam", method = RequestMethod.POST, produces = "application/json")
    public Result getTableIam(@RequestBody ScheduleTimeTable scheduleTimeTable) {


        // PageHelper.startPage(page, size);


        List<ScheduleTimeTableIamDTO> scheduleTimeTableIamDTO = Lists.newArrayList();

        /**
         String openId=getOpenId();

         // 1.查询当前激活组织
         Condition queryOffice=new Condition(SysOffice.class);
         queryOffice.createCriteria().andEqualTo("master",openId).andEqualTo("status","0");

         List<SysOffice> sysOffice= sysOfficeService.findByCondition(queryOffice);

         //  PageHelper.startPage(page, size);

         // 1.根据当前激活组织查询所有资源，即用户
         Condition query=new Condition(SysUser.class);
         String openid=getOpenId();
         query.createCriteria().andEqualTo("officeId",sysOffice.get(0).getId());

         List<SysUser> list = sysUserService.findByCondition(query);
         //   return ResultGenerator.genSuccessResult(list);
         */

        String orgId=getMasterId();

        Condition query=new Condition(SchedulePersonOrgRelate.class);
        query.createCriteria().andEqualTo("orgId",orgId);

        List<SchedulePersonOrgRelate> sys= schedulePersonOrgRelateService.findByCondition(query);

        // 2.根据当前激活组织  及时间段区间  查询里面的排班情况
        //  PageInfo pageInfo = new PageInfo(list);
        Condition queryTable=new Condition(ScheduleTimeTable.class);
        queryTable.createCriteria().andEqualTo("orgId",orgId)
                .andLessThanOrEqualTo("beginDate",DateUtil.getYearMonthDay(scheduleTimeTable.getEndDate()))
                .andGreaterThanOrEqualTo("beginDate",DateUtil.getYearMonthDay(scheduleTimeTable.getBeginDate()));

        List<ScheduleTimeTable> listTabel = scheduleTimeTableService.findByCondition(queryTable);


        //获取中间所有间隔的时间
        List<String> listDay = DateUtil.getEveryday(DateUtil.getYearMonthDay(scheduleTimeTable.getBeginDate()),
                DateUtil.getYearMonthDay(scheduleTimeTable.getEndDate()));

        //获取所有班次的名字;
        // get the shift id
        List<String> shiftId = listTabel.stream().map(s -> s.getShiftId()).collect(Collectors.toList());

        shiftId = shiftId.stream().distinct().collect(Collectors.toList());

        String shiftIds = "";
        for (String ss : shiftId)
        {
            shiftIds += "'" +ss +"'" +  ",";
        }
        if(shiftIds.length()>1) {
            shiftIds = shiftIds.substring(0, shiftIds.length() - 1);
        }

        //   String shiftIds = shiftId.stream().collect(Collectors.joining(","));
        List<ScheduleShift> sshift=new ArrayList<>();
        if(shiftIds.length()>0) {
            sshift = scheduleShiftService.findByIds(shiftIds);
        }


        // 3.将资源用户  及排班数据  进行重组  展示为想要的形式；
        for(SchedulePersonOrgRelate m:sys) {
            // 如果是当前用户
            if (m.getPersonId().equals(getUserId())) {



                for (String day : listDay) {
                    ScheduleTimeTableIamDTO w = new ScheduleTimeTableIamDTO();

                    List<ScheduleTimeTable> timetable = listTabel.stream().filter(e -> e.getPersonId().equals(m.getPersonId()))
                            .filter(e -> DateUtil.getYearMonthDay(e.getBeginDate()).equals(day))
                            .collect(Collectors.toList());

                    if (timetable.size() > 0) {

                        w.setMonth(day.substring(5,7));
                        w.setDay(day.substring(8,10));
                        w.setShiftId(timetable.get(0).getShiftId());



                        // 查找到  shiftName  设置shiftName;
                        List<ScheduleShift> ss = sshift.stream().filter(e -> e.getId().equals(w.getShiftId())).collect(Collectors.toList());
                        if (ss.size() > 0) {
                            w.setShiftName(ss.get(0).getName());
                            w.setBeginDate1(ss.get(0).getBeginDate1());
                            w.setEndDate1(ss.get(0).getEndDate1());
                            w.setBeginDate2(ss.get(0).getBeginDate2());
                            w.setEndDate2(ss.get(0).getEndDate2());
                            w.setRemark(ss.get(0).getRemark());
                        } else {
                            w.setShiftName("");
                            w.setBeginDate1("");
                            w.setEndDate1("");
                            w.setBeginDate2("");
                            w.setEndDate2("");
                            w.setRemark("");
                        }
                        scheduleTimeTableIamDTO.add(w);

                    } else {
                        w.setMonth(day.substring(5,7));
                        w.setDay(day.substring(8,10));
                        w.setShiftId("");
                        w.setShiftName("");
                        w.setBeginDate1("");
                        w.setEndDate1("");
                        w.setBeginDate2("");
                        w.setEndDate2("");
                        w.setRemark("");
                        scheduleTimeTableIamDTO.add(w);
                    }
                }

            }

        }
//
//
//        list.stream().forEach(m->{
//
//
//            List<ScheduleTimeTable> timetable=listTabel.stream().filter(e->e.getPersonId().equals(m.getId()) )
//                    .collect(Collectors.toList());
//            ScheduleTableDTO w=new ScheduleTableDTO();
//            w.setResourceId(m.getId());
//            w.setResourceName(m.getName());
//            w.setTable(timetable);
//     //       w.setTable(listTabel);
//
//            scheduleTableDto.add(w);
//
//
//
//        });

        return ResultGenerator.genSuccessResult(scheduleTimeTableIamDTO);


    }








    /**
     * 获取排班表明细数据
     * @return
     */
    @ApiOperation(value = "自动", notes = "eee")
    @RequestMapping(value = "/solve", method = RequestMethod.POST, produces = "application/json")
    public Result solve(@RequestBody ScheduleTimeTable scheduleTimeTable) {


        // PageHelper.startPage(page, size);

        List<ScheduleTablePCDTO> scheduleTablePCDto = Lists.newArrayList();

      

        String orgId=getMasterId();

        Condition query=new Condition(SchedulePersonOrgRelate.class);
        query.createCriteria().andEqualTo("orgId",orgId);

        List<SchedulePersonOrgRelate> sys= schedulePersonOrgRelateService.findByCondition(query);

        // 传递所有人员名单；

        // 传递参数时间段

        // 获取当前资源列表人员

        // 传递开始时间   结束时间     最小间隔      固定每个人时长




        /*

        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建HttpPost对象，设置url访问地址
        HttpPost httpPost = new HttpPost("http://yun.itheima.com/search");

        //声明List集合，封装表单中的参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        //设置请求地址是：http://yun.itheima.com/search?keys=Java
        params.add(new BasicNameValuePair("keys","Java"));

        //创建表单的Entity对象,第一个参数就是封装好的表单数据，第二个参数就是编码
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params,"utf8");

        //设置表单的Entity对象到Post请求中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        try {
            //使用HttpClient发起请求，获取response
             response = httpClient.execute(httpPost);

            //解析响应
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "utf8");
                System.out.println(content.length());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭response
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



*/









        // 2.根据当前激活组织  及时间段区间  查询里面的排班情况
        //  PageInfo pageInfo = new PageInfo(list);
        Condition queryTable=new Condition(ScheduleTimeTable.class);
        queryTable.createCriteria().andEqualTo("orgId",orgId)
                .andLessThanOrEqualTo("beginDate",DateUtil.getYearMonthDay(scheduleTimeTable.getEndDate()))
                .andGreaterThanOrEqualTo("beginDate",DateUtil.getYearMonthDay(scheduleTimeTable.getBeginDate()));

        List<ScheduleTimeTable> listTabel = scheduleTimeTableService.findByCondition(queryTable);


        //获取中间所有间隔的时间
        List<String> listDay = DateUtil.getEveryday(DateUtil.getYearMonthDay(scheduleTimeTable.getBeginDate()),
                DateUtil.getYearMonthDay(scheduleTimeTable.getEndDate()));

        //获取所有班次的名字;
        // get the shift id
        List<String> shiftId = listTabel.stream().map(s -> s.getShiftId()).collect(Collectors.toList());

        shiftId = shiftId.stream().distinct().collect(Collectors.toList());

        String shiftIds = "";
        for (String ss : shiftId)
        {
            shiftIds += "'" +ss +"'" +  ",";
        }
        if(shiftIds.length()>1) {
            shiftIds = shiftIds.substring(0, shiftIds.length() - 1);
        }

        //   String shiftIds = shiftId.stream().collect(Collectors.joining(","));
        List<ScheduleShift> sshift=new ArrayList<>();
        if(shiftIds.length()>0) {
            sshift = scheduleShiftService.findByIds(shiftIds);
        }


        // 3.将资源用户  及排班数据  进行重组  展示为想要的形式；
        for(SchedulePersonOrgRelate m:sys){



            List<ScheduleTimeTableDTO> t=Lists.newArrayList();
            for (String day : listDay) {

                ScheduleTablePCDTO w=new ScheduleTablePCDTO();

                ScheduleTimeTableDTO table=new ScheduleTimeTableDTO();

                List<ScheduleTimeTable> timetable=listTabel.stream().filter(e->e.getPersonId().equals(m.getPersonId()) )
                        .filter(e->DateUtil.getYearMonthDay(e.getBeginDate()).equals(day))
                        .collect(Collectors.toList());

                if(timetable.size()>0){
                    w.setResourceId(m.getPersonId());
                    BeanUtils.copyProperties( timetable.get(0),table);
                    w.setStart(day+" 00:00:00");
                    w.setEnd(day+" 23:59:00");
                    w.setId(table.getId());
                    // 查找到  shiftName  设置shiftName;
                    List<ScheduleShift> ss=sshift.stream().filter(e->e.getId().equals(table.getShiftId())).collect(Collectors.toList());
                    if(ss.size()>0) {
                        w.setTitle(ss.get(0).getName());
                        w.setBgColor(ss.get(0).getColor());
                    } else{
                        w.setTitle("");
                    }

                    scheduleTablePCDto.add(w);
                }
            }

        }


//
//
//        list.stream().forEach(m->{
//
//
//            List<ScheduleTimeTable> timetable=listTabel.stream().filter(e->e.getPersonId().equals(m.getId()) )
//                    .collect(Collectors.toList());
//            ScheduleTableDTO w=new ScheduleTableDTO();
//            w.setResourceId(m.getId());
//            w.setResourceName(m.getName());
//            w.setTable(timetable);
//     //       w.setTable(listTabel);
//
//            scheduleTableDto.add(w);
//
//
//
//        });

        return ResultGenerator.genSuccessResult(scheduleTablePCDto);


    }


}
