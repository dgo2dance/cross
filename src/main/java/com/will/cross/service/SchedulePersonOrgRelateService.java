package com.will.cross.service;
import com.will.cross.model.SchedulePersonOrgRelate;
import com.will.cross.core.Service;
import com.will.cross.model.SysOffice;


/**
 * Created by PualrDwade on 2020/02/02.
 */
public interface SchedulePersonOrgRelateService extends Service<SchedulePersonOrgRelate> {

    public int updateStatusByCustomerId(SchedulePersonOrgRelate schedulePersonOrgRelate);

}
