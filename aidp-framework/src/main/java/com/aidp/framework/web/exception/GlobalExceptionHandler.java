/*******************************************************************************
 * @(#)GlobalExceptionHandler.java 2016年07月29日 16:21
 * Copyright 2016 明医众禾科技（北京）有限责任公司. All rights reserved.
 *******************************************************************************/
package com.aidp.framework.web.exception;

import com.aidp.framework.web.ret.RetCode;
import com.aidp.framework.web.ret.RetData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Locale;

/**
 * @Description ExceptionHandler
 * @Author lizhm
 * @Date 2018-12-7 16:16:17
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @Autowired
    MessageSource messageSource;

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleControllerException(Exception exception) {
        log.error("全局异常：", exception);
        if (exception instanceof BindingResult) {
            return onBindError((BindingResult) exception);
        } else if (exception instanceof ServletRequestBindingException) {
            return onRequestBindError(exception);
        } else {
            log.error("Error occurs:", exception);
        }
        exception.printStackTrace();
        RetData resData = new RetData();
        resData.setRetCode(RetCode.Unknown_Exception);
        return new ResponseEntity<>(resData, HttpStatus.OK);
    }

    /**
     * 请求参数绑定错误
     * @param ex
     * @return
     */
    private ResponseEntity<Object> onRequestBindError(Exception ex) {
        RetData resData = new RetData();
        resData.setRetCode(RetCode.Common_Parameter_Required);
        resData.setMsg(ex.getMessage());
        return new ResponseEntity<>(resData, HttpStatus.OK);
    }

    /**
     * 请求参数绑定错误
     * @param bindingResult
     * @return
     */
    private ResponseEntity<Object> onBindError(BindingResult bindingResult) {
        List<FieldError> errorList = bindingResult.getFieldErrors();
        String message = "";
        if (errorList != null && errorList.size() > 0) {
            for(FieldError error : errorList) {
                String code = error.getDefaultMessage();
                message += messageSource.getMessage(code, error.getArguments(), Locale.CHINA) + ";";
                log.error("binding parameter error, code={}, message={}", code, message);
            }
        }
        RetData resData = new RetData();
        resData.setRetCode(RetCode.Common_Parameter_Required);

        return new ResponseEntity<>(resData, HttpStatus.OK);
    }
}
