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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/11
 */

@Controller
@RequestMapping("/system/concerner")
public class ConcernerController {

    @Autowired
    UserService userService;

    @Autowired
    PictureService pictureService;

//    @GetMapping
//    public String index() {
//        return "/concerner";
//    }

    @GetMapping("/list")
    public String list(HttpSession session, Model model) {

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
        if(sessionInfo == null) {
            return "/index";
        }

        int userId = sessionInfo.getUserId();

        if(userId < 0) {
            return "index";
        }

        List<UserDTO> allConcerners = userService.findAllConcerners(userId);

        if(allConcerners == null) {
            return "index";
        }

        System.out.println(allConcerners.size());

        model.addAttribute("allConcerners",allConcerners);

        return "/concerner";
    }

    @GetMapping("/getdetail.do")
    public String getDetail(int id,Model model) {

        if(id < 0) {
            return "/index";
        }

        model.addAttribute("id",id);

        return "/concerner-detail";
    }

    @ResponseBody
    @GetMapping("/getpersondetail.do")
    public AjaxResult getpersondetail(int id) {

        if(id < 0) {
            return AjaxResult.error("传入该用户的id错误");
        }

        UserDTO userDTO = userService.findPersondetail(id);

        if(userDTO == null) {
            return AjaxResult.error("找不到该用户");
        }

        return AjaxResult.success(userDTO,"成功找到该用户");
    }

    @ResponseBody
    @GetMapping("/searchconcernpicture.do")
    public AjaxResult searchconcernpicture(int id,String fname) {

        if(id < 0 || fname == null) {
            return AjaxResult.error("前端传递过来的参数错误");
        }

        List<PictureDTO> pictureDTOS = pictureService.searchConcernPicture(id, fname);

        if(pictureDTOS == null) {
            return AjaxResult.error("找不到图片");
        }

        return AjaxResult.success(pictureDTOS,"找到图片");
    }

    @ResponseBody
    @PostMapping("/addConcerner.do")
    public AjaxResult changeConcern(HttpSession session,int id) {

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

        UserDTO userDTO = userService.addConcern(userId, id);

        if(userDTO == null) {
            return AjaxResult.error("更改失败");
        }

        return AjaxResult.success(userDTO,"更改成功");
    }

    @ResponseBody
    @PostMapping("/removeconcerner.do")
    public AjaxResult changeConcern2(HttpSession session,int id) {

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

        UserDTO userDTO = userService.removeConcern(userId, id);

        if(userDTO == null) {
            return AjaxResult.error("更改失败");
        }

        return AjaxResult.success(userDTO,"更改成功");
    }


}
