package com.zust.itee.controller;

import com.zust.itee.common.AjaxResult;
import com.zust.itee.common.Constants;
import com.zust.itee.common.PageInfo;
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
 * @date 2019/12/16
 */

@Controller
@RequestMapping("/system/member")
public class MemberController {

    @Autowired
    UserService userService;

    @GetMapping
    public String index() {
        return "/member";
    }

    @ResponseBody
    @GetMapping("/getimage.do")
    public AjaxResult getimage(HttpSession session) {

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if(sessionInfo == null) {
            return AjaxResult.error("session为空");
        }

        int userId = sessionInfo.getUserId();

        if(userId < 0) {
            return AjaxResult.error("session无效");
        }

        UserDTO userDTO = userService.findOne(userId);

        if(userDTO == null) {
            return AjaxResult.error("查找用户失败");
        }

        return AjaxResult.success(userDTO,"查找用户成功");
    }

    @ResponseBody
    @RequestMapping("/change.do")
    public AjaxResult changeImage(String imageHashs, HttpSession session) {
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if(sessionInfo == null) {
            return AjaxResult.error("session为空");
        }

        int userId = sessionInfo.getUserId();

        if(userId < 0) {
            return AjaxResult.error("session无效");
        }

        UserDTO userDTO = userService.changeImage(userId, imageHashs);

        if(userDTO == null) {
            return AjaxResult.error("更新头像失败");
        }

        return AjaxResult.success(userDTO,"更新头像成功");
    }

    @ResponseBody
    @RequestMapping("/list.do")
    public AjaxResult list(int pageSize,int pageNum) {

        if(pageSize < 0 || pageNum < 0) {
            return AjaxResult.error("前端传来的参数错误");
        }

        PageInfo<UserDTO> userDTOPageInfo = userService.searchMembers(pageSize, pageNum);

        if(userDTOPageInfo == null) {
            return AjaxResult.error("找不到用户");
        }

        return AjaxResult.success(userDTOPageInfo,"成功找到用户");
    }

    @ResponseBody
    @PostMapping("/save.do")
    public AjaxResult save(String name,String mobile,String province,int roleId,String email) {

        if(name == null || mobile == null || province == null || roleId < 0 || email == null) {
            return AjaxResult.error("前端传来的参数错误");
        }

        UserDTO userDTO = userService.save(name, mobile, province, roleId,email);

        if(userDTO == null) {
            return AjaxResult.error("保存用户失败");
        }

        return AjaxResult.success(userDTO,"保存用户成功");
    }

    @ResponseBody
    @PostMapping("/delete.do")
    public AjaxResult delete(int id) {

        if(id < 0) {
            return AjaxResult.error("前端传参错误");
        }

        boolean result = userService.delete(id);

        if(result) {
            return AjaxResult.success("删除该用户成功");
        } else {
            return AjaxResult.error("删除该用户失败");
        }
    }

    @ResponseBody
    @PostMapping("/update.do")
    public AjaxResult update(int id,String name,String mobile,String province,int roleId,String email) {

        if(id < 0 || name == null || mobile == null || province == null || roleId < 0 || email == null) {
            return AjaxResult.error("前端传来的参数错误");
        }

        UserDTO userDTO = userService.update(id,name, mobile, province, roleId,email);

        if(userDTO == null) {
            return AjaxResult.error("更新用户失败");
        }

        return AjaxResult.success(userDTO,"更新用户成功");
    }
}
