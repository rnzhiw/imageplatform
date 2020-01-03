package com.zust.itee.controller;

import com.zust.itee.common.Constants;
import com.zust.itee.form.SessionInfo;
import com.zust.itee.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author ruanzhiwei
 * @date 2019/12/9
 */
@Controller
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    /**
     * 获取登录页面
     *
     * @param session
     * @return
     */
    @GetMapping("/login.do")
    public String login(HttpSession session) {

        return "login";
    }

    /**
     * 执行登录
     *
     * @param session
     * @param mobile
     * @param password
     * @return
     */
    @PostMapping("/login.do")
    public String do_login(HttpSession session,Model model, @RequestParam("mobile") String mobile, @RequestParam("password") String password) {

        if(mobile == null || password == null) {
            return null;
        }
        String result = null;
        try {
            result = userService.login(mobile,password,session);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if("success".equals(result)) {
            model.addAttribute("menus",sessionInfo.getMenus());
            model.addAttribute("user", userService.findOne(sessionInfo.getUserId()));
            return "index";
        } else {
            return "/login";
        }
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.do";

    }

    @RequestMapping("/index.do")
    public String index() {
        return "/index";
    }
}
