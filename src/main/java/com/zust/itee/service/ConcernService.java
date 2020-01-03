package com.zust.itee.service;

import com.zust.itee.dto.ConcernDTO;
import org.springframework.stereotype.Service;

/**
 * @author ruanzhiwei
 * @date 2019/12/18
 */

@Service
public interface ConcernService {

    /**
     * 改变关注状态：从未关注到关注，从关注到未关注
     *
     * @param userId
     * @param id
     * @return
     */
    ConcernDTO changeStatus(int userId,int id);
}
