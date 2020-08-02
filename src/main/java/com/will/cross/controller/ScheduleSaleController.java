package com.will.cross.controller;

import com.will.cross.core.Result;
import com.will.cross.core.ResultGenerator;
import com.will.cross.dto.ScheduleSaleDTO;
import com.will.cross.model.ScheduleSale;
import com.will.cross.service.ScheduleSaleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.will.cross.util.DateUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
* Created by PualrDwade on 2020/07/26.
*/
@RestController
@RequestMapping("/schedule/sale")
public class ScheduleSaleController  extends BaseController{
    @Resource
    private ScheduleSaleService scheduleSaleService;
	
	
	// 录入销售数据；
    @RequestMapping(value = "/addSale", method = RequestMethod.POST, produces = "application/json")
    public Result add(@RequestBody ScheduleSaleDTO scheduleSale) {
		
		ScheduleSale sv= new ScheduleSale();

		// 循环设置sale数据，并保存
        String[] tableDate=scheduleSale.getTableData().split(",");
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
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
     

             //  PageHelper.startPage(page, size);
//        Condition query=new Condition(ScheduleSale.class);
//        String masterid=getMasterId();
//        query.createCriteria().andEqualTo("master",masterid);
//        List<ScheduleShift> list = scheduleShiftService.findByCondition(query);
//
        List<ScheduleSale> list = scheduleSaleService.findAll();
        PageInfo pageInfo = new PageInfo(list);
       return ResultGenerator.genSuccessResult(pageInfo);
//


    }
}
