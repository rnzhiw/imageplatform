package com.zust.itee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 用户实体类
 *
 * @author ruanzhiwei
 * @date 2019/12/9
 */

@Getter
@Setter
@Entity
@Table(name = "user")
public class Tuser {

    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    /**
     * 用户与图片一对多的关联的一端
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "tuser")
    private Set<Tpicture> tpictures;

    /**
     * 用户与投诉一对多的关联的一端
     */
    @OneToMany(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY,mappedBy = "tuser")
    private Set<Tcomplaint> tcomplaints;

    /**
     * 用户与黑名单
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "tblackerUser")
    private List<Tblacklist> tblacklisters;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "tblackedUser")
    private List<Tblacklist> tblacklisteds;


    /**
     * 该用户关注的用户
     */
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "concern",joinColumns = @JoinColumn(name = "concerner_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "concerned_id",referencedColumnName = "id"))
    private Set<Tuser> concerner;
    /**
     * 关注该用户的用户
     */
    @ManyToMany(mappedBy = "concerner")
    private Set<Tuser> concerned;

    /**
     * 用户与角色的多对多关系
     */
    @ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinTable(name = "t_user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns =
            {@JoinColumn(name = "role_id")})
    private List<Trole> troles;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "intro")
    private String intro;

    /**
     * 性别：
     * 1：男生
     * 2：女生
     */
    @Column(name = "gender")
    private Short gender;

    @Column(name = "province")
    private String province;

    @Column(name = "city")
    private String city;

    @Column(name = "regist_time")
    private Date registTime;

    @Column(name = "email")
    private String email;

    @Column(name = "QQ")
    private String QQ;

    @Column(name = "status")
    private short status;

    /**
     * 用户类型：
     * 1：管理员
     * 0：用户
     */
    @Column(name = "type")
    private Integer type;

    @Column(name = "realname")
    private String realname;

    /**
     * 用户头像地址
     */
    @Column(name = "address")
    private String address;

}









