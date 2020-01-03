package com.zust.itee.controller;

import com.zust.itee.common.AjaxResult;
import com.zust.itee.common.Constants;
import com.zust.itee.dto.PictureDTO;
import com.zust.itee.dto.UserDTO;
import com.zust.itee.form.SessionInfo;
import com.zust.itee.service.PictureService;
import com.zust.itee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/11
 */

@Controller
@RequestMapping("/system/person")
public class PersonController {

    @Autowired
    UserService userService;

    @Autowired
    PictureService pictureService;

    @GetMapping("/list")
    public String list(HttpSession session, Model model) {

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if(sessionInfo == null) {
            return "/index";
        }

        int userId = sessionInfo.getUserId();

        if(userId < 0) {
            return "/index";
        }

        UserDTO user = userService.showPerson(userId);

        if(user == null) {
            return "/index";
        }

        model.addAttribute("user",user);

        List<PictureDTO> pictureDTOS = pictureService.searchAllPicture(userId);

        if(pictureDTOS == null) {
            return "/index";
        }

        model.addAttribute("pictureDTOS",pictureDTOS);

        return "/person";
    }

    @ResponseBody
    @PostMapping("/deletepicture.do")
    public AjaxResult deletePicture(int id) {

        if(id < 0) {
            return AjaxResult.error("前端传参错误");
        }

        boolean result = pictureService.delete(id);

        if(result) {
            return AjaxResult.success("图片成功删除");
        } else {
            return AjaxResult.error("图片删除失败");
        }

    }

    @ResponseBody
    @GetMapping("/search.do")
    public AjaxResult search(HttpSession session) {

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if(sessionInfo == null) {
            return AjaxResult.error("session不存在");
        }

        int userId = sessionInfo.getUserId();

        if(userId < 0) {
            return AjaxResult.error("找不到这个用户");
        }

        List<PictureDTO> pictureDTOS = pictureService.searchAllPicture(userId);

        return AjaxResult.success(pictureDTOS,"查找个人所有照片成功");
    }

    @ResponseBody
    @GetMapping("/searchoneperson.do")
    public AjaxResult searchPersonone(HttpSession session,String fname) {

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if(sessionInfo == null) {
            return AjaxResult.error("session不存在");
        }

        int userId = sessionInfo.getUserId();

        if(userId < 0) {
            return AjaxResult.error("找不到这个用户");
        }

        if(fname == null) {
            return AjaxResult.error("输入的fname参数为空");
        }

        List<PictureDTO> pictureDTOS = pictureService.searchonePerson(userId, fname);

        if(pictureDTOS == null) {
            return AjaxResult.error("没有找到该对象");
        }

        return AjaxResult.success(pictureDTOS,"找到该对象");
    }

    @ResponseBody
    @GetMapping("/searchone.do")
    public AjaxResult searchPerson(String fname,HttpSession session) {

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if(sessionInfo == null) {
            return AjaxResult.error("session不存在");
        }

        int userId = sessionInfo.getUserId();

        if(userId < 0) {
            return AjaxResult.error("找不到这个用户");
        }

        if(fname == null) {
            return AjaxResult.error("输入的fname参数为空");
        }

        List<PictureDTO> pictureDTOS = pictureService.searchOne(userId,fname);

        if(pictureDTOS == null) {
            return AjaxResult.error("没有找到该对象");
        }

        return AjaxResult.success(pictureDTOS,"找到该对象");
    }

    @ResponseBody
    @GetMapping("/searchall.do")
    public AjaxResult searchAll(HttpSession session) {

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if(sessionInfo == null) {
            return null;
        }

        int userId = sessionInfo.getUserId();

        if(userId < 0) {
            return null;
        }
        List<PictureDTO> pictureDTOS = pictureService.searchall(userId);

        if(pictureDTOS == null) {
            return AjaxResult.error("找不到图片");
        }

        return AjaxResult.success(pictureDTOS,"成功找到所有图片");
    }

    @GetMapping
    public String index(HttpSession session, Model model) {

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if(sessionInfo == null) {
            return "/index";
        }

        int userId = sessionInfo.getUserId();

        if(userId < 0) {
            return "/index";
        }

        UserDTO user = userService.showPerson(userId);

        if(user == null) {
            return "/index";
        }

        model.addAttribute("user",user);

        return "/person";
    }
}
