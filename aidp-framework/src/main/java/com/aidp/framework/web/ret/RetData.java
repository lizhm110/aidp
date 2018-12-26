/*******************************************************************************
 * @(#)RetData.java 2017年04月13日 10:18 
 * Copyright 2017 明医众禾科技（北京）有限责任公司. All rights reserved.
 *******************************************************************************/
package com.aidp.framework.web.ret;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description ReData.java
 * @Author lizhm
 * @Date 2018-12-7 15:15:09
 */
@Data
public class RetData implements Serializable {
    private boolean success = true;
    private String code = "";
    private String msg = "";
    private Object data = new HashMap<String, Object>();

    public RetData() {
    }
    public RetData(RetCode retCode) {
        setRetCode(retCode);
    }

    public void putData(String key, Object value) {
        if (data instanceof Map) {
            ((Map<String, Object>)data).put(key, value);
        }
    }

    public Object getData(String key) {
        if (data instanceof Map) {
            return ((Map<String, Object>) data).get(key);
        }
        return data;
    }

    public void removeData(String key) {
        if (data instanceof Map) {
            ((Map<String, Object>)data).remove(key);
        }
    }

    /**
     * 清除数据
     */
    public void clearData() {
        if (data instanceof Map) {
            ((Map<String, Object>)data).clear();
        }
    }

    public void setRetCode(RetCode retCode) {
        this.code = retCode.getCode();
        this.msg = retCode.getMsg();
        this.setSuccess(RetCode.SUCCESS.getCode().equalsIgnoreCase(this.code)?true:false);
    }

    @Override
    public String toString() {
        return "RetData{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}