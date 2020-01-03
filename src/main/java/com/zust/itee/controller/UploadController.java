package com.zust.itee.controller;

import com.zust.itee.common.AjaxResult;
import com.zust.itee.common.Constants;
import com.zust.itee.dto.PictureDTO;
import com.zust.itee.form.SessionInfo;
import com.zust.itee.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/system/upload")
public class UploadController {

    @Autowired
    UploadService uploadService;

    @GetMapping
    public String index() {
        return "/upload";
    }


    /**
     * 上传图片表单
     *
     * @return
     */
    @ResponseBody
    @PostMapping("/add.do")
    public AjaxResult add(HttpSession session,String name,String tag,String imageHashs) {

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if(sessionInfo == null) {
            return AjaxResult.error("session为空");
        }

        int userId = sessionInfo.getUserId();

        if(userId < 0) {
            return AjaxResult.error("session无效");
        }

        PictureDTO pictureDTO = uploadService.save(userId, name, tag, imageHashs);

        return AjaxResult.success(pictureDTO,"图片上传成功");
    }
}
