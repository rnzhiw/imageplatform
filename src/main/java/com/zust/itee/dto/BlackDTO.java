package com.zust.itee.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ruanzhiwei
 * @date 2019/12/20
 */

@Getter
@Setter
public class BlackDTO {

    private Integer id;

    private Integer blackerId;

    private Integer blackedId;

    /**
     * 用户拉黑的人的用户名
     */
    private String username;

    /**
     * 用户拉黑的人的来源地
     */
    private String province;

    /**
     * 用户拉黑的人的邮箱
     */
    private String email;
}
