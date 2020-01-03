package com.zust.itee.controller;

import com.zust.itee.common.AjaxResult;
import com.zust.itee.common.Constants;
import com.zust.itee.form.SessionInfo;
import com.zust.itee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author ruanzhiwei
 * @date 2019/12/11
 */

@Controller
@RequestMapping("/system/changepassword")
public class ChangePasswordController {

    @Autowired
    UserService userService;

    @GetMapping
    public String index() {
        return "/changepassword";
    }

    @ResponseBody
    @PostMapping("/update.do")
    public AjaxResult update(String newpassword1, String newpassword2, HttpSession session) {

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if(sessionInfo == null) {
            return AjaxResult.error("session不存在");
        }

        int userId = sessionInfo.getUserId();
        if(userId < 0) {
            return AjaxResult.error("该用户不存在");
        }
        userService.update(userId,newpassword1,newpassword2);

        return AjaxResult.success("密码修改成功");
    }

}
