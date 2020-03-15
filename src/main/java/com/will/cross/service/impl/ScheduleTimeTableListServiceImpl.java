package com.will.cross.service.impl;

import com.will.cross.core.AbstractService;
import com.will.cross.dao.ScheduleTimeTableListMapper;
import com.will.cross.model.ScheduleTimeTableList;
import com.will.cross.service.ScheduleTimeTableListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PualrDwade on 2019/10/05.
 */
@Service
@Transactional
public class ScheduleTimeTableListServiceImpl extends AbstractService<ScheduleTimeTableList> implements ScheduleTimeTableListService {
    @Resource
    private ScheduleTimeTableListMapper scheduleTimeTableListMapper;

}
