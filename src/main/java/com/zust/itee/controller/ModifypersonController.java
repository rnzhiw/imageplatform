package com.zust.itee.controller;

import com.zust.itee.common.AjaxResult;
import com.zust.itee.common.Constants;
import com.zust.itee.dto.UserDTO;
import com.zust.itee.form.SessionInfo;
import com.zust.itee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author ruanzhiwei
 * @date 2019/12/11
 */

@Controller
@RequestMapping("/system/modifyperson")
public class ModifypersonController {

    @Autowired
    UserService userService;

    @GetMapping
    public String modifyperson() {
        return "/modifyperson";
    }

    @ResponseBody
    @PostMapping("/modify.do")
    public AjaxResult modify(HttpSession session,String username,String province,String city,String QQ) {

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if(sessionInfo == null) {
            return AjaxResult.error("session为空");
        }

        int userId = sessionInfo.getUserId();

        if(userId < 0) {
            return AjaxResult.error("session无效");
        }

        UserDTO userDTO = userService.modify(userId, username, province, city, QQ);

        return AjaxResult.success(userDTO,"修改个人信息成功");
    }
}
