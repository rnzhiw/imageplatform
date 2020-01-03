package com.zust.itee.controller;

import com.zust.itee.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author ruanzhiwei
 * @date 2019/12/9
 */
@Controller
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @GetMapping("/register.do")
    public String register() {
        return "/register";
    }

    @PostMapping("/register.do")
    public String do_register(String mobile,String password1,String password2) {
        if(mobile == null || password1 == null || password2 == null) {
            return null;
        }

        String result = null;

        try {
            result = registerService.save(mobile,password1,password2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if("success".equals(result)) {
            return "/login";
        } else {
            return "register";
        }
    }

}
