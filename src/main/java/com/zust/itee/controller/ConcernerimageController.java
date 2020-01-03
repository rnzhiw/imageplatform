package com.zust.itee.controller;

import com.zust.itee.common.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ruanzhiwei
 * @date 2019/12/11
 */

@Controller
@RequestMapping("/system/concernerimage")
public class ConcernerimageController {

    @GetMapping
    public String index() {
        return "/concernerimage";
    }

    @ResponseBody
    @GetMapping("/search.do")
    public AjaxResult search() {


        return null;
    }


}
