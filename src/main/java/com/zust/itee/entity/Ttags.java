package com.zust.itee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 标签实体类
 *
 * @author ruanzhiwei
 * @date 2019/12/9
 */

@Getter
@Setter
@Entity
@Table(name = "tags")
public class Ttags {

    /**
     * 标签id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(name = "tag_name")
    private String tagName;
}
