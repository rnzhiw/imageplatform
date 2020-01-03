package com.zust.itee.controller;

import com.zust.itee.common.AjaxResult;
import com.zust.itee.common.PageInfo;
import com.zust.itee.dto.ComplaintDTO;
import com.zust.itee.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ruanzhiwei
 * @date 2019/12/11
 */

@Controller
@RequestMapping("/system/complaintmanage")
public class ComplainManagerController {

    @Autowired
    ComplaintService complaintService;

    @GetMapping
    public String index() {
        return "/complaintmanage";
    }

    /**
     * 查找第一面的投诉
     *
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String list(Model model) {

        PageInfo<ComplaintDTO> complaints = complaintService.searchComplaints(100, 1);

        if(complaints == null) {
            return null;
        }

        model.addAttribute("complaints",complaints);

        return "/complaintmanage";
    }

    @GetMapping("/getdetail.do")
    public String getDetail(int id,Model model) {

        if(id < 0) {
            return "/index";
        }

        model.addAttribute("id",id);

        return "/complaintmanage-detail";
    }

    @ResponseBody
    @GetMapping("/getcomplaintdetail.do")
    public AjaxResult getcomplaintdetail(int id) {

        if(id < 0) {
            return AjaxResult.error("前端传参错误");
        }

        ComplaintDTO complaintDTO = complaintService.findOne(id);

        if(complaintDTO == null) {
            return AjaxResult.error("没有找到这个用户详情页");
        }

        return AjaxResult.success(complaintDTO,"已经成功找到该投诉详情信息");
    }

    @ResponseBody
    @PostMapping("/delete.do")
    public AjaxResult delete(int id) {

        if(id < 0) {
            return AjaxResult.error("前端传来的参数错误");
        }

        boolean result = complaintService.deleteComplaint(id);

        if(result) {
            return AjaxResult.success("删除投诉成功");
        } else {
            return AjaxResult.error("删除投诉失败");
        }

    }

    @ResponseBody
    @GetMapping("/detail.do")
    public AjaxResult showDetail(int id) {

        if(id < 0) {
            return AjaxResult.error("前端传来的该投诉id有误");
        }

        ComplaintDTO complaintDTO = complaintService.findOne(id);

        if(complaintDTO == null) {
            return AjaxResult.error("找不到改投诉详情");
        }

        return AjaxResult.success(complaintDTO,"已经找到投诉详情");
    }
}
