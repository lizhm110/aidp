/*******************************************************************************
 * @(#)RetCode.java 2017年04月13日 10:18 
 * Copyright 2017 明医众禾科技（北京）有限责任公司. All rights reserved.
 *******************************************************************************/
package com.aidp.framework.web.ret;

import java.io.Serializable;

/**
 * @Description 响应code
 * @Author lizhm
 * @Date 2018-12-7 15:13:35
 */
public class RetCode implements Serializable {
    /** 公共 */
    public static RetCode SUCCESS = new RetCode("success", "1", "成功");
    public static RetCode FAIL = new RetCode("fail", "0", "失败");
    public static RetCode Unknown_Exception = new RetCode("unknown.exception", "500", "未知服务器异常");
    public static RetCode Common_Session_Expire = new RetCode("common.session.expire", "10000", "用户会话失效或过期，请重新登录");
    public static RetCode Common_Parameter_Required = new RetCode("common.parameter.required","10001", "参数错误");
    public static RetCode Common_Token_Required = new RetCode("common.session.required","10002", "token不能为空");
    public static RetCode Common_Token_Authority_Error = new RetCode("common.session.error","10003", "token错误或已过期");
    public static RetCode Common_Sign_Required = new RetCode("common.sign.required","10004", "sign不能为空");
    public static RetCode Common_Sign_Error = new RetCode("common.sign.error","10005", "签名错误");
    public static RetCode Common_Verify_Code_Required = new RetCode("common.verify.code.required", "10006", "验证码不能为空");
    public static RetCode Common_Verify_Code_Error = new RetCode("common.verify.code.error","10007", "验证码错误或已过期");
    public static RetCode User_Not_Exist = new RetCode("user.not.exist","10008", "用户不存在");
    public static RetCode User_And_Password_Error = new RetCode("user.and.password.error","10009", "用户密码错误");

    private String code;
    private String msg;
    private String key;

    public RetCode() {

    }
    public RetCode(String key, String code, String msg) {
        this.key = key;
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getKey() {
        return key;
    }
}