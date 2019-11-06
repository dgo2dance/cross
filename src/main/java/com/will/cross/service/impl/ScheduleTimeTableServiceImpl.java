package com.will.cross.service.impl;

import com.will.cross.core.AbstractService;
import com.will.cross.dao.ScheduleTimeTableMapper;
import com.will.cross.model.ScheduleTimeTable;
import com.will.cross.service.ScheduleTimeTableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PualrDwade on 2019/10/05.
 */
@Service
@Transactional
public class ScheduleTimeTableServiceImpl extends AbstractService<ScheduleTimeTable> implements ScheduleTimeTableService {
    @Resource
    private ScheduleTimeTableMapper scheduleTimeTableMapper;

}
