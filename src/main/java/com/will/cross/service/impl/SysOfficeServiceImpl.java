package com.will.cross.service.impl;

import com.will.cross.dao.SysOfficeMapper;
import com.will.cross.model.SysOffice;
import com.will.cross.service.SysOfficeService;
import com.will.cross.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PualrDwade on 2019/10/07.
 */
@Service
@Transactional
public class SysOfficeServiceImpl extends AbstractService<SysOffice> implements SysOfficeService {
    @Resource
    private SysOfficeMapper sysOfficeMapper;



    public int updateStatusByCustomerId(SysOffice sysOffice){
        return  sysOfficeMapper.updateStatusByCustomerId(sysOffice);
    };
}
