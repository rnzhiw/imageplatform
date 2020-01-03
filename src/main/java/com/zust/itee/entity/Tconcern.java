package com.zust.itee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * 关注实体类
 *
 * @author ruanzhiwei
 * @date 2019/12/9
 */

@Getter
@Setter
@Entity
@Table(name = "concern")
public class Tconcern {

    /**
     * 关注id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(name = "concern_time")
    private Date concernTime;
}
