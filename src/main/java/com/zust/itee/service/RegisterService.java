package com.zust.itee.service;

import org.springframework.stereotype.Service;

/**
 * @author ruanzhiwei
 * @date 2019/12/10
 */

@Service
public interface RegisterService {

    /**
     * 用户注册
     *
     */
    public String save(String mobile, String password1,String password2);
}
