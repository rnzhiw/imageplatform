package com.zust.itee.controller;

import com.zust.itee.common.AjaxResult;
import com.zust.itee.common.Constants;
import com.zust.itee.common.PageInfo;
import com.zust.itee.dto.ComplaintDTO;
import com.zust.itee.form.SessionInfo;
import com.zust.itee.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/system/complaint")
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    @GetMapping
    public String index() {
        return "/complaint";
    }

    @ResponseBody
    @PostMapping("/submit.do")
    public AjaxResult submitConplain(HttpSession session,String title,String content) {

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if(sessionInfo == null) {
            return AjaxResult.error("session为空");
        }

        int userId = sessionInfo.getUserId();

        if(userId < 0) {
            return AjaxResult.error("session无效");
        }

        ComplaintDTO complaintDTO = complaintService.saveComplaint(userId, title, content);

        return AjaxResult.success(complaintDTO,"提交投诉成功");
    }
}
