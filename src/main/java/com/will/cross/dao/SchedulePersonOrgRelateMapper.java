package com.will.cross.dao;

import com.will.cross.core.Mapper;
import com.will.cross.model.SchedulePersonOrgRelate;
import com.will.cross.model.SysOffice;

public interface SchedulePersonOrgRelateMapper extends Mapper<SchedulePersonOrgRelate> {

    int updateStatusByCustomerId(SchedulePersonOrgRelate sys);
}