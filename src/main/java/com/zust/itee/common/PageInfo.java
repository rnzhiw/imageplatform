package com.zust.itee.common;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 分页返回格式
 *
 * @author ruanzhiwei
 * @date 2019/12/16
 */

@Getter
@Setter
public class PageInfo<T> {

    /**
     * 未分页前的数据总数
     */
    private Long total;

    /**
     * 本页的数据数
     */
    private Integer size;

    /**
     * 本页的数据
     */
    private List<T> list;

    /**
     * 总页数
     */
    private Integer pages;

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 一页的标准数据行
     */
    private Integer pageSize;

    /**
     * 是否为第一页
     */
    private Boolean firstPage;

    /**
     * 是否为最后一页
     */
    private Boolean lastPage;

}
