package com.zust.itee.controller;

import com.qiniu.util.Auth;
import com.zust.itee.common.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 七牛云接口
 *
 * @author ruanzhiwei
 * @date 2019/12/14
 */

@RestController
@RequestMapping("/cloud")
public class CloudController {
    /**
     * 上传凭证生成
     *
     * @return
     */
    @RequestMapping("/uptoken.do")
    public AjaxResult getToken(){
        String accessKey = "";
        String secretKey = "";
        String bucket = "";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        return AjaxResult.success((Object) upToken);
    }
}
