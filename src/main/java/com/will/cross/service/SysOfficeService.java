package com.will.cross.service;
import com.will.cross.dao.SysOfficeMapper;
import com.will.cross.model.SysOffice;
import com.will.cross.core.Service;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by PualrDwade on 2019/10/07.
 */
public interface SysOfficeService extends Service<SysOffice> {


    public int updateStatusByCustomerId(SysOffice sysOffice);



    }
