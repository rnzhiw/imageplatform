package com.zust.itee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.print.attribute.IntegerSyntax;
import java.util.Date;

/**
 * @author ruanzhiwei
 * @date 2019/12/9
 */

@Getter
@Setter
@Entity
@Table(name = "picture")
public class Tpicture {

    /**
     * 图片id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    /**
     * 图片与用户多对一的关联
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private Tuser tuser;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "fname")
    private String fname;

    @Column(name = "intro")
    private String intro;

    @Column(name = "upload_time")
    private Date uploadTime;

    @Column(name = "address")
    private String address;

    @Column(name = "click_num")
    private Integer clickNum;

}
