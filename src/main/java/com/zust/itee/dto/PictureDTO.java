package com.zust.itee.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author ruanzhiwei
 * @date 2019/12/14
 */

@Getter
@Setter
public class PictureDTO {

    /**
     * 图片id
     */
    private Integer id;

    private String fname;

    private String intro;

    private Date uploadTime;

    private String address;

    private String clickNum;

    private Integer userId;

    private String username;


}
