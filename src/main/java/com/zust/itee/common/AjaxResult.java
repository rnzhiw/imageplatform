package com.zust.itee.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 接口返回结果，若成功找data，若失败找msg
 *
 * @author ruanzhiwei
 * @date 2019/12/10
 */

@Getter
@Setter
public class AjaxResult {

    private Boolean success = true;

    private String message;

    private Object data;

    /**
     * 将构造方法设为私有，拒绝外部直接调用构造方法，推荐外部调用静态方法获取
     */
    private AjaxResult() {
    }

    public static AjaxResult success() {
        return AjaxResult.success(null);
    }


    public static AjaxResult success(String msg) {
        return AjaxResult.success(null, msg);
    }

    public static AjaxResult success(Object data) {
        return AjaxResult.success(data, null);
    }

    public static AjaxResult success(Object data, String msg) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(true);
        ajaxResult.setData(data);
        ajaxResult.setMessage(msg);
        return ajaxResult;
    }

    public static AjaxResult error() {
        return AjaxResult.error(null);
    }

    public static AjaxResult error(String msg) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(false);
        ajaxResult.setMessage(msg);
        return ajaxResult;
    }


}
