package com.zust.itee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 黑名单实体类
 *
 * @author ruanzhiwei
 * @date 2019/12/9
 */

@Getter
@Setter
@Entity
@Table(name = "blacklist")
public class Tblacklist {

    /**
     * 黑名单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(name = "blacker_id")
    private Integer blackerId;

    @Column(name = "blacked_id")
    private Integer blackedId;

    /**
     * 用户与黑名单
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blacker_id",insertable = false,updatable = false)
    private Tuser tblackerUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blacked_id",insertable = false,updatable = false)
    private Tuser tblackedUser;
}
