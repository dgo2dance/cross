package com.will.cross.controller;

import com.google.common.collect.Lists;
import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.dto.ScheduleSaleDTO;
import com.will.cross.model.ScheduleArea;
import com.will.cross.model.ScheduleLocation;
import com.will.cross.model.ScheduleSale;
import com.will.cross.service.ScheduleAreaService;
import com.will.cross.service.ScheduleLocationService;
import com.will.cross.service.ScheduleSaleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.will.cross.util.DateUtil;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
* Created by PualrDwade on 2020/07/26.
*/
@RestController
@RequestMapping("/schedule/sale")
public class ScheduleSaleController  extends BaseController{
    @Resource
    private ScheduleSaleService scheduleSaleService;

    @Resource
    private ScheduleLocationService scheduleLocationService;

    @Resource
    private ScheduleAreaService scheduleAreaService;


	// 录入销售数据；
    @RequestMapping(value = "/addSale", method = RequestMethod.POST, produces = "application/json")
    public Result add(@RequestBody ScheduleSaleDTO scheduleSale) {
		
		ScheduleSale sv= new ScheduleSale();

        // 删除已有数据首先，根据areaId  日期 删除

        String[] tableDate=scheduleSale.getTableData().split(",");
        for(int i=0;i<=scheduleSale.getTableData().split(",").length;i=i+25){

            String areaId=tableDate[i];


                Condition querySale=new Condition(ScheduleSale.class);
                querySale.createCriteria().andEqualTo("areaId",areaId).andEqualTo("delFlag","0")
                   .andLessThanOrEqualTo("beginDate",scheduleSale.getDate())
                   .andGreaterThanOrEqualTo("beginDate",scheduleSale.getDate());

                List<ScheduleSale> list = scheduleSaleService.findByCondition(querySale);

                for(ScheduleSale s:list){
                    //根据ID删除
                    scheduleSaleService.deleteById(s.getId());
                }


        }


		// 循环设置sale数据，并保存
		for(int i=0;i<=scheduleSale.getTableData().split(",").length;i=i+25){
			
			sv.setId(UUID.randomUUID().toString());
			sv.setAmount(Double.valueOf(tableDate[i]));
            sv.setBegTime(DateUtil.toDate(tableDate[i]));
            sv.setEndTime(DateUtil.toDate(tableDate[i]));
            sv.setCreateBy(getOpenId());
            sv.setCreateDate(new Date());
            sv.setUpdateBy(getOpenId());
            sv.setUpdateDate(new Date());
            sv.setMasterId(getMasterId());
            sv.setLocationId("");
            sv.setAreaId("");

			scheduleSaleService.save(sv);

		}
		
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/delSale", method = RequestMethod.POST, produces = "application/json")
    public Result delete(@PathVariable String id) {
        scheduleSaleService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/upSale", method = RequestMethod.POST, produces = "application/json")
    public Result update(@RequestBody ScheduleSale scheduleSale) {
        scheduleSaleService.update(scheduleSale);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        ScheduleSale scheduleSale = scheduleSaleService.findById(id);
        return ResultGenerator.genSuccessResult(scheduleSale);
    }
	
	
    // 查询数据并展示
    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = "application/json")
    public Result list(@RequestBody ScheduleSale scheduleSale)  {
     

             //  PageHelper.startPage(page, size);
//        Condition query=new Condition(ScheduleSale.class);
//        String masterid=getMasterId();
//        query.createCriteria().andEqualTo("master",masterid);
//        List<ScheduleShift> list = scheduleShiftService.findByCondition(query);
//        以树的形式返回数据，在前端判断展示;   data  example

//         this.data = [
//          ["", "09:00AM", "10:00AM", "11:00AM", "12:00AM", "13:00AM", "14:00AM", "15:00AM", "16:00AM", "17:00AM", "18:00AM", "19:00AM", "20:00AM", "21:00AM", "22:00AM", "23:00AM", "24:00AM"],
//          ["Sales", 10, 11, 12, 13],
//          ["Aadmin", 20, 11, 14, 13],
//          ["Bars", 30, 15, 12, 13]
//        ];

        List<ScheduleSale> list = scheduleSaleService.findAll();

        // 返回结果集；
        List<List<String>> returnData =  Lists.newArrayList();
        // 加入头部  string
        List<String> head = Arrays.asList(new String[]{"", "", "09:00AM", "10:00AM", "11:00AM", "12:00AM", "13:00AM", "14:00AM",
                "15:00AM", "16:00AM", "17:00AM", "18:00AM", "19:00AM", "20:00AM", "21:00AM",
                "22:00AM", "23:00AM", "24:00AM"});
        returnData.add(head);


        // 查询当前用户下的所有Location
        Condition queryLoc=new Condition(ScheduleLocation.class);
        queryLoc.createCriteria().andEqualTo("master",getMasterId()).andEqualTo("delFlag","0");
        List<ScheduleLocation> listLoc = scheduleLocationService.findByCondition(queryLoc);


        for(ScheduleLocation s:listLoc){

            if("000000".equals(scheduleSale.getLocationId())
                ||(s.getId()).equals(scheduleSale.getLocationId())){

             // 查询所有区域   
            Condition queryArea=new Condition(ScheduleArea.class);
            queryArea.createCriteria().andEqualTo("locationId",s.getId()).andEqualTo("delFlag","0");

            List<ScheduleArea> area = scheduleAreaService.findByCondition(queryArea);

             for(ScheduleArea m:area){

                   // 根据位置 区域  查询  amount

                Condition querySale=new Condition(ScheduleSale.class);
                querySale.createCriteria().andEqualTo("locationId",s.getId()).andEqualTo("areaId",m.getId()).andEqualTo("delFlag","0")
                   .andLessThanOrEqualTo("beginDate",DateUtil.getYearMonthDay(scheduleSale.getBegTime()))
                   .andGreaterThanOrEqualTo("beginDate",DateUtil.getYearMonthDay(scheduleSale.getEndTime()));

                List<ScheduleSale> listSale = scheduleSaleService.findByCondition(querySale);

                //拼装List

                List<String> tmp=Lists.newArrayList();

                tmp.add(m.getId());
                tmp.add(s.getName()+m.getName());

                // 拼接入各个时间段的内容
                for(int i=9;i<=24;i++){

                    Boolean flag=false;
                    for(ScheduleSale u:list){
                        if(u.getBegTime().getHours()==i){
                            flag=Boolean.TRUE;
                            tmp.add(String.valueOf(u.getAmount()));
                        }
                    }
                    //            Date date = new Date();
                    //            int hours = date.getHours();
                    if(!flag){
                        tmp.add("");
                    }

                }

                for(int i=1;i<=8;i++){

                    Boolean flag=false;
                    for(ScheduleSale u:list){
                        if(u.getBegTime().getHours()==i){
                            flag=Boolean.TRUE;
                            tmp.add(String.valueOf(u.getAmount()));
                        }
                    }
        //            Date date = new Date();
        //            int hours = date.getHours();
                    if(!flag){
                    tmp.add("");
                     }

                }

                    }
         
                }
        
            }

        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);


    }
}
