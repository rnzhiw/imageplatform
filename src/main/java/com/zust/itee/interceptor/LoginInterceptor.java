package com.zust.itee.interceptor;

import com.zust.itee.common.Constants;
import com.zust.itee.form.SessionInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 *
 * @author ruanzhiwei
 * @date 2018/11/29
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("登录拦截器上线");
        HttpSession session = request.getSession();
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        if (sessionInfo == null) {
            if (this.isAjax(request)) {
                // ajax请求，返回错误码
                // 标记http错误
                response.setStatus(402);
            } else {
                response.sendRedirect("/login.do");
            }
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
    }
}
