package com.zust.itee.dto;

import com.zust.itee.entity.Tpicture;
import com.zust.itee.entity.Trole;
import com.zust.itee.entity.Tuser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author ruanzhiwei
 * @date 2019/12/9
 */

@Getter
@Setter
public class UserDTO {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户角色id集合
     */
    private List<Integer> roleIds;

    /**
     * 用户角色名称集合
     */
    private List<String> roleNames;

    /**
     * 图片的数量
     */
    private Integer pictureSize;

    /**
     * 关注的人的数量
     */
    private Integer conernerSize;

    /**
     * 被关注的人的数量
     */
    private Integer concernedSize;

    /**
     * 用户所有图片的hash值
     */
    private Set<String> imageHashs;

    /**
     * 用户所有头像的hash值
     */
    private String address;

    private String mobile;

    private String username;

    private String password;

    private String intro;

    /**
     * 性别：
     * 1：男生
     * 2：女生
     */
    private Short gender;

    private String province;

    private String city;

    private Date registTime;

    private String email;

    private String QQ;

    private short status;

    /**
     * 用户类型：
     * 1：管理员
     * 0：普通用户
     * 2：系统管理员
     */
    private Integer type;

    private String realname;

}
