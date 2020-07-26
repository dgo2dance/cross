package com.will.cross.service.impl;

import com.will.cross.dao.ScheduleRequireStuffMapper;
import com.will.cross.model.ScheduleRequireStuff;
import com.will.cross.service.ScheduleRequireStuffService;
import com.will.cross.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PualrDwade on 2020/07/26.
 */
@Service
@Transactional
public class ScheduleRequireStuffServiceImpl extends AbstractService<ScheduleRequireStuff> implements ScheduleRequireStuffService {
    @Resource
    private ScheduleRequireStuffMapper scheduleRequireStuffMapper;

}
