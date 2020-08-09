package com.ywxiang.mall.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ywxiang
 * @date 2020/8/7 下午9:20
 */
public class HttpUtils {
    /**
     * 获取HttpServletRequest对象
     * @return
     */
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 输出信息到浏览器
     * @param response
     * @param data
     * @throws IOException
     */
    public static void write(HttpServletResponse response, Object data) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        String json = JSONObject.toJSONString(data);
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();
    }

    /**
     * 输出信息到浏览器
     * @param response
     * @param data
     * @throws IOException
     */
    public static void write(HttpServletResponse response, Object data, int code) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(code);
        String json = JSONObject.toJSONString(data);
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
