package com.zust.itee.interceptor;


import com.zust.itee.common.Constants;
import com.zust.itee.form.SessionInfo;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * 权限拦截器
 *
 * @author ruanzhiwei
 * @date 2018/11/29
 */
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("权限拦截器上线");
        HttpSession session = request.getSession();
        HandlerMethod hm = (HandlerMethod) handler;

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);

        //当前用户所有可访问的路径
        Set<String> urls = (Set<String>) sessionInfo.getUrls();

        for (String url : urls) {
            System.out.println(url);
        }

        //当前访问的路径
        String uri = request.getRequestURI();

//        boolean isSuper = sessionInfo.isSuperUser();
//
//        if (hm.getBean() instanceof AppController || isSuper) {
//            //App里面的就不做权限控制了，相当于公共的，省的写一个就要配置一个例外
//            //超管也直接跳过权限
//            return true;
//        }

        // 获取用户所有可以访问的请求

        if (!urls.contains(uri)) {

            System.out.println(uri);

            if (isAjax(request)) {
                response.setStatus(401);
            } else {
                response.setContentType("text/html;charset=utf-8");
                // 非ajax请求，没有权限，转到提示页面
                request.getRequestDispatcher("/reject").forward(request, response);
            }
            // 没有权限
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
