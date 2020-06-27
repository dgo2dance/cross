package com.will.cross.service.impl;

import com.will.cross.dao.ScheduleLocationMapper;
import com.will.cross.model.ScheduleLocation;
import com.will.cross.service.ScheduleLocationService;
import com.will.cross.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PualrDwade on 2020/05/28.
 */
@Service
@Transactional
public class ScheduleLocationServiceImpl extends AbstractService<ScheduleLocation> implements ScheduleLocationService {
    @Resource
    private ScheduleLocationMapper scheduleLocationMapper;

}
