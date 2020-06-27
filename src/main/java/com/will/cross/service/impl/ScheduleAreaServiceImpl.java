package com.will.cross.service.impl;

import com.will.cross.dao.ScheduleAreaMapper;
import com.will.cross.model.ScheduleArea;
import com.will.cross.service.ScheduleAreaService;
import com.will.cross.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PualrDwade on 2020/05/28.
 */
@Service
@Transactional
public class ScheduleAreaServiceImpl extends AbstractService<ScheduleArea> implements ScheduleAreaService {
    @Resource
    private ScheduleAreaMapper scheduleAreaMapper;

}
