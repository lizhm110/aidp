package com.aidp.common.util;

/**
 * @Author lizhm
 * @Date 2018-12-6 14:55:12
 * @Description 系统工具类
 */
public class SystemUtil {

    /**
     * 获取操作系统名称
     * @return
     */
    public static String getOperationSystemName() {
        return System.getProperty("os.name");
    }

    /**
     * 是否Mac环境
     * @return
     */
    public static boolean isMac() {
        return getOperationSystemName().startsWith("Mac ");
    }

    /**
     * 是否windows环境
     * @return
     */
    public static boolean isWindows() {
        return getOperationSystemName().startsWith("Windows ");
    }

    /**
     * 是否Linux环境
     * @return
     */
    public static boolean isLinux() {
        return getOperationSystemName().startsWith("Linux ");
    }


    /**
     * 获取当前登录用户名
     * @return
     */
    public static String getUserName() {
        return System.getProperty("user.name");
    }

    /**
     * 获取当前用户目录
     * @return
     */
    public static String getUserHome() {
        return System.getProperty("user.home");
    }

    /**
     * 获取当前工作空间
     * @return
     */
    public static String getUserDir() {
        return System.getProperty("user.dir");
    }

}
