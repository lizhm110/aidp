package com.aidp.common.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * @Author lizhm
 * @Date 2018-12-6 14:55:12
 * @Description Object工具类
 */
public class ObjectUtil {

    private ObjectUtil() {
        // to avoid creating instance
    }

    /**
     * judge a given string if blank
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }

    /**
     * judge a given string if not blank
     *
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
    public static boolean isNotBlank(Object str) {
        return str!=null;
    }

    /**
     * judge a given collection if blank
     *
     * @param col
     * @return
     */
    public static boolean isBlank(Collection col) {
        return col == null || col.isEmpty();
    }
    public static boolean isBlank(Object col) {
        return col == null;
    }

    /**
     * judge a given collection if not blank
     *
     * @param col
     * @return
     */
    public static boolean isNotBlank(Collection col) {
        return !isBlank(col);
    }

    /**
     * judge a given map if blank
     *
     * @param map
     * @return
     */
    public static boolean isBlank(Map map) {
        return map == null || map.isEmpty();
    }

    /**
     * judge a given map if not blank
     *
     * @param map
     * @return
     */
    public static boolean isNotBlank(Map map) {
        return !isBlank(map);
    }

    /**
     * judge a given array if blank
     *
     * @param objs
     * @return
     */
    public static boolean isBlank(Object[] objs) {
        return objs == null || objs.length == 0;
    }

    /**
     * judge a given array if not blank
     *
     * @param objs
     * @return
     */
    public static boolean isNotBlank(Object[] objs) {
        return !isBlank(objs);
    }

    /**
     * return empty string if the given string is empty or null
     * otherwise return the original string
     *
     * @param str
     * @return
     */
    public static String emptyIfBlank(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        return str;
    }

    /**
     * 判断给定的对象是否为空
     * @param obj 给定对象
     * @return true or false
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }

        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    /**
     * 判断传入的对象是否为空
     * @param objects 传入对象集
     * @return true or false
     */
    public static boolean isEmpty(Object... objects){
        for (int i = 0; i < objects.length; i++) {
            if(isEmpty(objects[i])){
                return true;
            }
        }
        return false;
    }

}
