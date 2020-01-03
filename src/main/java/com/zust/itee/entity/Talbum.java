package com.zust.itee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 相册实体类
 *
 * @author ruanzhiwei
 * @date 2019/12/9
 */

@Getter
@Setter
@Entity
@Table(name = "album")
public class Talbum {
    /**
     * 相册id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(name = "album_name")
    private String albumName;
}
