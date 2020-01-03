package com.zust.itee.controller;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.zust.itee.common.AjaxResult;
import com.zust.itee.dto.ResourceDTO;
import com.zust.itee.form.ResourceForm;
import com.zust.itee.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/10
 */

@Controller
@RequestMapping("/system/resource")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @GetMapping
    public String index() {
        return "/resource";
    }

    /**
     * 列出所有资源，只有超级管理员才能管理
     * @return
     */
    @ResponseBody
    @GetMapping("/list")
    public AjaxResult list() {
        List<ResourceDTO> allResources = resourceService.findAll();
        return AjaxResult.success(allResources);
    }

    @ResponseBody
    @PostMapping("/save.do")
    public AjaxResult save(String resName,String resKey,String menuUrl,Boolean status) {

        if(resName == null || resKey == null || menuUrl == null || status == null) {
            return AjaxResult.error("前端传过来的参数有问题");
        }

        ResourceDTO resourceDTO = resourceService.save(resName, resKey, menuUrl, status);

        if(resourceDTO == null) {
            return AjaxResult.error("保存资源失败");
        }

        return AjaxResult.success(resourceDTO,"保存资源成功");
    }

    @ResponseBody
    @GetMapping("/get.do")
    public AjaxResult get(int id) {
        if(id < 0) {
            return AjaxResult.error("前端传来的资源id有误");
        }

        ResourceDTO resourceDTO = resourceService.findOne(id);

        if(resourceDTO == null) {
            return AjaxResult.error("找不到该资源");
        }

        return AjaxResult.success(resourceDTO,"已经找到该资源");
    }

    @ResponseBody
    @PostMapping("/update.do")
    public AjaxResult update(int id,String resName,String resKey,String menuUrl,Boolean status) {

        if(id < 0 || resName == null || resKey == null || menuUrl == null || status == null) {
            return AjaxResult.error("前端传过来的参数有问题");
        }

        ResourceDTO resourceDTO = resourceService.update(id, resName, resKey, menuUrl, status);

        if(resourceDTO == null) {
            return AjaxResult.error("更新资源失败");
        }

        return AjaxResult.success(resourceDTO,"更新资源成功");
    }

    @ResponseBody
    @PostMapping("/delete.do")
    public AjaxResult delete(int id) {

        if(id < 0) {
            return AjaxResult.error("前端传参失败");
        }

        boolean result = resourceService.delete(id);

        if(result) {
            return AjaxResult.success("删除成功");
        } else {
            return AjaxResult.error("删除失败");
        }
    }

}
