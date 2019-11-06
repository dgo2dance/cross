package com.will.cross.service.impl;

import com.will.cross.core.AbstractService;
import com.will.cross.service.SysUserService;
import com.will.cross.dao.SysUserMapper;
import com.will.cross.model.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PualrDwade on 2019/10/05.
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

}
