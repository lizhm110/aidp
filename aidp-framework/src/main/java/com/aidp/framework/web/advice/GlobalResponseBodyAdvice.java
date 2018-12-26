package com.aidp.framework.web.advice;

import com.aidp.framework.web.ret.RetData;
import com.alibaba.fastjson.JSON;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Description
 * @Author lizhm
 * @Date 2018-12-7 15:05:41
 */
@RestControllerAdvice
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private final static ThreadLocal<Boolean> useWrapper = new ThreadLocal<Boolean>();

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o
            , MethodParameter methodParameter
            , MediaType mediaType
            , Class<? extends HttpMessageConverter<?>> selectedConverterType
            , ServerHttpRequest serverHttpRequest
            , ServerHttpResponse serverHttpResponse) {

        if (useWrapper.get() != null && !useWrapper.get()) {
            return o;
        }

        if (selectedConverterType == Jaxb2RootElementHttpMessageConverter.class) {
            return o;
        }

        if (selectedConverterType == StringHttpMessageConverter.class) {

            RetData retData = new RetData();
            retData.setData(o);
            return JSON.toJSON(retData);
        }

        if (o instanceof RetData) {
            return o;
        }

        RetData retData = new RetData();
        if(o == null){
            o = new Object();
        }
        retData.setData(o);
        return retData;
    }

}
