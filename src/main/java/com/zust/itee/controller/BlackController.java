package com.zust.itee.controller;

import com.zust.itee.common.AjaxResult;
import com.zust.itee.common.Constants;
import com.zust.itee.common.PageInfo;
import com.zust.itee.dto.BlackDTO;
import com.zust.itee.form.SessionInfo;
import com.zust.itee.service.BlackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author ruanzhiwei
 * @date 2019/12/18
 */

@Controller
@RequestMapping("/system/black")
public class BlackController {

    @Autowired
    BlackService blackService;

    @GetMapping
    public String index() {
        return "/black";
    }

    @ResponseBody
    @RequestMapping("/list.do")
    public AjaxResult list(int pageSize,int pageNum,HttpSession session) {

        if(pageSize < 0 || pageNum < 0) {
            return AjaxResult.error("前端传来的参数错误");
        }

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if(sessionInfo == null) {
            return AjaxResult.error("session不存在");
        }

        int userId = sessionInfo.getUserId();

        if(userId < 0) {
            return AjaxResult.error("找不到当前登录用户");
        }

        PageInfo<BlackDTO> blackDTOPageInfo = blackService.searchBlackeds(userId, pageSize, pageNum);

        if(blackDTOPageInfo == null) {
            return AjaxResult.error("找不到黑名单中的用户");
        }

        return AjaxResult.success(blackDTOPageInfo,"已经找到黑名单列表");
    }

    @ResponseBody
    @PostMapping("/delete.do")
    public AjaxResult delete(int id) {

        if(id < 0) {
            return AjaxResult.error("前端传参错误");
        }

        boolean result = blackService.deleteBlack(id);

        if(result) {
            return AjaxResult.success("移出黑名单成功");
        } else {
            return AjaxResult.error("移出黑名单失败");
        }
    }

    @ResponseBody
    @PostMapping("/addblack.do")
    public AjaxResult addBlack(HttpSession session,int id) {

        if(id < 0) {
            return AjaxResult.error("前端传参错误");
        }

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if(sessionInfo == null) {
            return AjaxResult.error("session不存在");
        }

        int userId = sessionInfo.getUserId();

        if(userId < 0) {
            return AjaxResult.error("找不到这个用户");
        }

        BlackDTO blackDTO = blackService.addBlack(userId, id);

        if(blackDTO == null) {
            return AjaxResult.error("加入黑名单失败");
        }

        return AjaxResult.success(blackDTO,"加入黑名单成功");
    }
}
