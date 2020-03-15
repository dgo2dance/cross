package com.will.cross.service.impl;

import com.will.cross.core.AbstractService;
import com.will.cross.dao.ScheduleShiftMapper;
import com.will.cross.model.ScheduleShift;
import com.will.cross.service.ScheduleShiftService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PualrDwade on 2019/10/05.
 */
@Service
@Transactional
public class ScheduleShiftServiceImpl extends AbstractService<ScheduleShift> implements ScheduleShiftService {
    @Resource
    private ScheduleShiftMapper scheduleShiftMapper;

}
