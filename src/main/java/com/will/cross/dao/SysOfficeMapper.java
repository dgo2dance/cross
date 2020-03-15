package com.will.cross.dao;

import com.will.cross.core.Mapper;
import com.will.cross.model.SysOffice;

public interface SysOfficeMapper extends Mapper<SysOffice> {

    int updateStatusByCustomerId(SysOffice sysOffice);
}