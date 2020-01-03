package com.zust.itee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 角色实体类
 *
 * @author ruanzhiwei
 * @date 2019/12/9
 */

@Getter
@Setter
@Entity
@Table(name = "role")
public class Trole {
    /**
     * 角色id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    /**
     * 可以访问的资源
     */
    @ManyToMany
    @JoinTable(name = "t_role_resource", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns =
            {@JoinColumn(name = "resource_id")})
    private List<Tresource> resource;

    @Column(name = "role_name")
    private String roleName;

    /**
     * 标识角色是否可用
     */
    @Column(name = "status")
    private Boolean status;

    @Column(name = "description")
    private String description;
}
