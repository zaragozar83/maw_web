package com.coffee.maqzar.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by exrzaragoza on 01/12/2016.
 */
public class ProcessingTimeLogInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = Logger.getLogger(ProcessingTimeLogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        String query = request.getQueryString() == null ? "" : "?" + request.getQueryString();
        String path = request.getRequestURL() + query;

        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();

        LOGGER.info(String.format("%s millisecond taken to process the request %s.",(endTime - startTime), path));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
