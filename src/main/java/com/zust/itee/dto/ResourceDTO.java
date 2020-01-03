package com.zust.itee.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ruanzhiwei
 * @date 2019/12/10
 */

@Getter
@Setter
public class ResourceDTO {

    /**
     * 资源id
     */
    private Integer id;

    private String menuUrl;

    private String resKey;

    private String resName;

    private Boolean status;

    private Short parentId;
}
