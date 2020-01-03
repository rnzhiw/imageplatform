package com.zust.itee.form;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ruanzhiwei
 * @date 2019/12/10
 */

@Getter
@Setter
public class ResourceForm {

    /**
     * 资源表单id
     */
    private Integer id;

    private String resName;

    private String resKey;

    private String menuUrl;

    private Boolean status;
}
