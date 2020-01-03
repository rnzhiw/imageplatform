package com.zust.itee.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.zust.itee.common.AjaxResult;
import com.zust.itee.entity.Tuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/10
 */

@Controller
public class TestController {

    @RequestMapping("/test.do")
    @ResponseBody
    public AjaxResult test(Tuser tuser) {

        return AjaxResult.success(tuser);

    }

    @Autowired
    private ApplicationContext applicationContext;

    @ResponseBody
    @GetMapping("/beanList")
    public List<String> beanList() {
        return Arrays.asList(applicationContext.getBeanDefinitionNames());
    }

}
