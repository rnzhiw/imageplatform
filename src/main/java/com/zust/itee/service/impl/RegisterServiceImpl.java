package com.zust.itee.service.impl;

import com.zust.itee.dao.UserDao;
import com.zust.itee.entity.Tuser;
import com.zust.itee.service.RegisterService;
import com.zust.itee.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author ruanzhiwei
 * @date 2019/12/10
 */

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    UserDao userDao;

    @Override
    public String save(String mobile, String password1,String password2) {

        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password1) || StringUtils.isEmpty(password2)) {
            return "表单部分选项仍为空";
        }

        if(!password1.equals(password2)) {
            return "两次输入的密码不一致";
        }

        Tuser tuser = new Tuser();
        tuser.setMobile(mobile);
        tuser.setPassword(password1);
        userDao.save(tuser);
        return "success";
    }
}
