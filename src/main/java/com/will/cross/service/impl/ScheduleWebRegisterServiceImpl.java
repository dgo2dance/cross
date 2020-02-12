package com.will.cross.service.impl;

import com.will.cross.dao.ScheduleWebRegisterMapper;
import com.will.cross.model.ScheduleWebRegister;
import com.will.cross.service.ScheduleWebRegisterService;
import com.will.cross.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PualrDwade on 2020/02/11.
 */
@Service
@Transactional
public class ScheduleWebRegisterServiceImpl extends AbstractService<ScheduleWebRegister> implements ScheduleWebRegisterService {
    @Resource
    private ScheduleWebRegisterMapper scheduleWebRegisterMapper;

}
