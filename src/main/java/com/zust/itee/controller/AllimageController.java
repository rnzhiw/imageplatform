package com.zust.itee.controller;

import com.zust.itee.common.AjaxResult;
import com.zust.itee.common.Constants;
import com.zust.itee.dto.PictureDTO;
import com.zust.itee.form.SessionInfo;
import com.zust.itee.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ruanzhiwei
 * @date 2019/12/11
 */

@Controller
@RequestMapping("/system/allimage")
public class AllimageController {

    @Autowired
    PictureService pictureService;

    @GetMapping
    public String index() {
        return "/allimage";
    }

    @GetMapping("/list")
    public String list(Model model, HttpSession session) {

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if(sessionInfo == null) {
            return "/index";
        }

        int userId = sessionInfo.getUserId();

        if(userId < 0) {
            return "/index";
        }


        List<PictureDTO> pictureDTOS = pictureService.searchall(userId);

        if(pictureDTOS == null) {
            return "/index";
        }

        model.addAttribute("pictureDTOS",pictureDTOS);

        return "/allimage";
    }

}
