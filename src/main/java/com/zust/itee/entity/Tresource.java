package com.zust.itee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.nio.ShortBuffer;

/**
 * @author ruanzhiwei
 * @date 2019/12/9
 */

@Getter
@Setter
@Entity
@Table(name = "resource")
public class Tresource {

    /**
     * 资源id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(name = "menu_url")
    private String menuUrl;

    @Column(name = "res_key")
    private String resKey;

    @Column(name = "res_name")
    private String resName;

    /**
     * 资源是否可用
     */
    @Column(name = "status")
    private Boolean status;

    @Column(name = "parent_id")
    private Short parentId;
}
