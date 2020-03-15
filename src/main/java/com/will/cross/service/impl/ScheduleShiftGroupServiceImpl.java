package com.will.cross.service.impl;

import com.will.cross.dao.ScheduleShiftGroupMapper;
import com.will.cross.model.ScheduleShiftGroup;
import com.will.cross.service.ScheduleShiftGroupService;
import com.will.cross.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PualrDwade on 2019/10/07.
 */
@Service
@Transactional
public class ScheduleShiftGroupServiceImpl extends AbstractService<ScheduleShiftGroup> implements ScheduleShiftGroupService {
    @Resource
    private ScheduleShiftGroupMapper scheduleShiftGroupMapper;

}
