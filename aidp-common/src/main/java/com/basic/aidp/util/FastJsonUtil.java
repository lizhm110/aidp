package com.basic.aidp.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @Author lizhm
 * @Date 2018-12-6 14:55:12
 * @Description FastJson生成json字符串、解析json工具类
 */
public class FastJsonUtil {
    /**
     * 生成json字符串
     * @param object 对象信息
     * @return json字符串
     */
    public static String toJson(Object object){
        return JSON.toJSONString(object);
    }

    /**
     * 生成json字符串,增加对日期格式的处理，如果不传日子格式默认转化为“yyyy-MM-dd HH:mm:ss”格式
     * @param object 对象信息
     * @param dateFormat 日期时间格式，如：“yyyy-MM-dd HH:mm:ss”
     * @return json字符串
     */
    public static String toJsonWithDateFormat(Object object, String dateFormat){
        if(!StringUtils.isNotEmpty(dateFormat)){
            dateFormat = JSON.DEFFAULT_DATE_FORMAT;
        }
        return JSON.toJSONStringWithDateFormat(object, dateFormat);
    }

    /**
     * 解析json字符串，最终返回Map格式的数据，用key取对应的value值
     * @param json json字符串
     * @return Map
     */
    public static Map<String, Object> parseJsonObject(String json){
        if(!StringUtils.isNotEmpty(json)){
            return null;
        }
        return JSON.parseObject(json);
    }

    /**
     * 解析json字符串,映射到具体的实体上，只支持简单的泛型，不支持自定义的泛型
     * @param json json字符串
     * @param clazz 实体类
     * @return 对象实例
     */
    public static <T> T parseJson(String json, Class<T> clazz){
        if(!StringUtils.isNotEmpty(json)){
            return null;
        }
        return JSON.parseObject(json, clazz);
    }

    /**
     * 解析json字符串，映射到list集合，前提是json是个数组
     * @param json json数组
     * @param clazz 实体类
     * @return 实体类的集合
     */
    public static <T> List<T> parseJsonArray(String json, Class<T> clazz){
        if(!StringUtils.isNotEmpty(json)){
            return null;
        }
        return JSON.parseArray(json, clazz);
    }

    /**
     * 解析json字符串，支持自定义泛型，万能方法
     * 例子：
     * String json = "{\"users\":[{\"age\":24,\"birthday\":1502443890615,\"id\":20,\"man\":true,\"name\":\"张三\",\"salary\":3600.22},{\"age\":34,\"birthday\":1502443890615,\"id\":30,\"man\":false,\"name\":\"李四\",\"salary\":5500.22}]}";
     * Map<String, List<User>> map= FastJsonUtil.parseJson(json, new TypeReference<Map<String, List<User>>>(){});
     * @param json json字符串
     * @param type 泛型类型
     * @return Java对象
     */
    public static <T> T parseJson(String json, TypeReference<T> type){
        if(!StringUtils.isNotEmpty(json)){
            return null;
        }
        return JSON.parseObject(json, type);
    }

    public static <T> T parseJson(InputStream inputStream, TypeReference<T> typeReference){
        try {
            return JSON.parseObject(inputStream, typeReference.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}