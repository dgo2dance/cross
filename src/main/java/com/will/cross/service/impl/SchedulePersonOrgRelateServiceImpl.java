package com.will.cross.service.impl;

import com.will.cross.dao.SchedulePersonOrgRelateMapper;
import com.will.cross.model.SchedulePersonOrgRelate;
import com.will.cross.service.SchedulePersonOrgRelateService;
import com.will.cross.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PualrDwade on 2020/02/02.
 */
@Service
@Transactional
public class SchedulePersonOrgRelateServiceImpl extends AbstractService<SchedulePersonOrgRelate> implements SchedulePersonOrgRelateService {
    @Resource
    private SchedulePersonOrgRelateMapper schedulePersonOrgRelateMapper;


    public int updateStatusByCustomerId(SchedulePersonOrgRelate sysOffice){
        return  schedulePersonOrgRelateMapper.updateStatusByCustomerId(sysOffice);
    };

    public int updateNameBypersonId(SchedulePersonOrgRelate sysOffice){
        return  schedulePersonOrgRelateMapper.updateNameBypersonId(sysOffice);
    };
}
