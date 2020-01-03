package com.zust.itee.service;

import com.zust.itee.common.PageInfo;
import com.zust.itee.dto.BlackDTO;
import org.springframework.stereotype.Service;

/**
 * @author ruanzhiwei
 * @date 2019/12/20
 */

@Service
public interface BlackService {

    /**
     * 添加黑名单
     *
     * @param userId
     * @param id
     * @return
     */
    BlackDTO addBlack(int userId,int id);

    /**
     * 查找一个用户所有的拉黑的人的信息
     *
     * @param userId
     * @param pageSize 每页的记录数
     * @param pageNum 页码
     * @return
     */
    PageInfo<BlackDTO> searchBlackeds(int userId,int pageSize,int pageNum);

    /**
     * 根据黑名单序号移出黑名单
     *
     * @param id
     * @return
     */
    boolean deleteBlack(int id);


}
