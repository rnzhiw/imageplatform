package com.zust.itee.service.impl;

import com.zust.itee.dao.ConcernDao;
import com.zust.itee.dto.ConcernDTO;
import com.zust.itee.entity.Tconcern;
import com.zust.itee.service.ConcernService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ruanzhiwei
 * @date 2019/12/18
 */

@Service
@Transactional
public class ConcernServiceImpl implements ConcernService {

    @Autowired
    ConcernDao concernDao;

    @Override
    public ConcernDTO changeStatus(int userId, int id) {

        if(userId < 0 || id < 0) {
            return null;
        }





        return null;
    }

    private ConcernDTO e2d(Tconcern tconcern) {

        if(tconcern == null) {
            return null;
        }

        ConcernDTO concernDTO = new ConcernDTO();
        BeanUtils.copyProperties(tconcern,concernDTO);

        return concernDTO;
    }
}
