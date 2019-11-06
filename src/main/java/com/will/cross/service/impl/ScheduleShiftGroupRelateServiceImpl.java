package com.will.cross.service.impl;

import com.will.cross.core.AbstractService;
import com.will.cross.dao.ScheduleShiftGroupRelateMapper;
import com.will.cross.model.ScheduleShiftGroupRelate;
import com.will.cross.service.ScheduleShiftGroupRelateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PualrDwade on 2019/10/05.
 */
@Service
@Transactional
public class ScheduleShiftGroupRelateServiceImpl extends AbstractService<ScheduleShiftGroupRelate> implements ScheduleShiftGroupRelateService {
    @Resource
    private ScheduleShiftGroupRelateMapper scheduleShiftGroupRelateMapper;

}
