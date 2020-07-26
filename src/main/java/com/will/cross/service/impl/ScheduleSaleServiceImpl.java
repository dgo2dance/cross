package com.will.cross.service.impl;

import com.will.cross.dao.ScheduleSaleMapper;
import com.will.cross.model.ScheduleSale;
import com.will.cross.service.ScheduleSaleService;
import com.will.cross.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PualrDwade on 2020/07/26.
 */
@Service
@Transactional
public class ScheduleSaleServiceImpl extends AbstractService<ScheduleSale> implements ScheduleSaleService {
    @Resource
    private ScheduleSaleMapper scheduleSaleMapper;

}
