package com.zust.itee.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author ruanzhiwei
 * @date 2019/12/18
 */

@Getter
@Setter
public class ConcernDTO {

    private Integer id;

    private Date concernTime;

    /**
     * status：
     * 1：两者已关注
     * 0：两者未关注
     */
    private Integer status;
}
