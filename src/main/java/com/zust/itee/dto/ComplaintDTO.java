package com.zust.itee.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author ruanzhiwei
 * @date 2019/12/13
 */

@Getter
@Setter
public class ComplaintDTO {

    /**
     * 投诉id
     */
    private Integer id;

    private String title;

    private String content;

    private String complaintName;

    private Date date;

    /**
     * 投诉人id
     */
    private Integer userId;


}
