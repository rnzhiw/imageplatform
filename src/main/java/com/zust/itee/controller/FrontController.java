package com.zust.itee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ruanzhiwei
 * @date 2019/12/9
 */
@Controller
public class FrontController {

    @GetMapping("/main.do")
    public String main() {
        return "/main";
    }

    @GetMapping("/index.do")
    public String index() {
        return "/index";
    }

}
