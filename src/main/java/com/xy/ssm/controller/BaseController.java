package com.xy.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.util.UrlPathHelper;

import com.alibaba.fastjson.JSONObject;

public class BaseController {

    Logger log = Logger.getLogger(BaseController.class);

    protected HttpSession session;

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    @SuppressWarnings("unused")
    @ModelAttribute
    private void handlerRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    protected final String getServerURL(HttpServletRequest request, String lastUrl) {
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath() + "/";
        return basePath + lastUrl;
    }

    // forward
    public String forward(String path) {
        return "forward:" + path;
    }

    // redirect
    public String redirect(String path) {
        return "redirect:" + path;
    }

    public String getURI(HttpServletRequest request) {
        UrlPathHelper helper = new UrlPathHelper();
        String ctx = helper.getOriginatingContextPath(request);
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + ctx;
        return url;
    }

    protected String getRefer() {
        String url = request.getHeader("Referer");
        return url;
    }

    /**
     * 获取访问者IP
     * <p>
     * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
     * <p>
     * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)，
     * 如果还不存在则调用Request .getRemoteAddr()。
     *
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

    public void writeJson(Object object) {
        try {
            PrintWriter out = response.getWriter();
            out.write(JSONObject.toJSONString(object));
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toJson(Object object) {
        return JSONObject.toJSONString(object);
    }

    protected void out(String html) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println(html);
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    protected void saveLoginUser(Object admin) {
//        session.setAttribute("admin", admin);
//    }
//
//    protected Object getLoginUser() {
//        return session.getAttribute("admin");
//    }

    protected Map<String, Object> getLoginUser() {
        return (Map<String, Object>) session.getAttribute("loginuser");
    }

    protected void saveLoginUser(Map<String, Object> user) {
        session.setAttribute("loginuser", user);
    }


}
