package com.zust.itee.form;

import com.zust.itee.entity.Tresource;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

/**
 * @author ruanzhiwei
 * @date 2019/12/9
 */

@Getter
@Setter
public class SessionInfo {

    /**
     * 所有可访问的菜单
     */
    private List<Tresource> menus;

    /**
     * 所有可访问的资源标识
     */
    private Set<String> resourceKey;

    /**
     * 所有可访问的资源路径
     */
    private Set<String> urls;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 所有对应的角色名称
     */
    private List<String> roleNames;

    /**
     * 是否是管理员
     */
    private Boolean superUser;

    public boolean isSuperUser() {
        return superUser;
    }
}
