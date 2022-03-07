package com.xxxx.config;

import com.alibaba.fastjson.JSON;
import com.xxxx.vo.CommonResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



/**
 * 对于响应报文增加处理
 */
@RestControllerAdvice
@Component
public class MyControllerAdvice implements ResponseBodyAdvice<Object> {
    private Logger logger = LoggerFactory.getLogger(MyControllerAdvice.class);


    /**
     * 全局异常处理
     * @param response
     * @param exception
     */
    @ExceptionHandler
    public void baseErrorHandler(HttpServletResponse response, Exception exception){
        logger.info("全局异常处理开始");
        Map<String,Object> respMap = new HashMap<>();
        response.setCharacterEncoding("UTF-8");
        respMap.put("code","99");
        respMap.put("traceId", MDC.get("traceId"));
        respMap.put("msg", exception.getMessage());
        try {
            response.getWriter().write(JSON.toJSONString(respMap));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Map<String,Object> respMap = new HashMap<>();
        respMap.put("code","00");
        respMap.put("message","ok");
        respMap.put("traceId",MDC.get("traceId"));
        if(o instanceof  String){
            return JSON.toJSONString(CommonResp.success(o,MDC.get("traceId")));
        }else{
            respMap.put("data",o);
        }
        return respMap;
    }
}
