package com.zust.itee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ruanzhiwei
 * @date 2019/12/13
 */

@Getter
@Setter
@Entity
@Table(name = "complaint")
public class Tcomplaint {

    /**
     * 投诉id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    /**
     * 投诉与用户多对一的关联
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private Tuser tuser;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "time")
    private Date time;

    @Column(name = "user_id")
    private int userId;

}
