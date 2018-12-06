package com.basic.aidp.constant;

/**
 * @Description 公共常量类
 * @Author lizhm
 * @Date 2018-12-6 15:41:11
 */
public class Const {

    /**
     * 普通、通用
     */
    public static final int NORMAL = 1;

    /**
     * 普通、通用
     */
    public static final int ZERO = 0;

    /**
     * 标识符
     */
    public static class Flag {
        /**
         * 可用状态
         */
        public static class  EnableStatus {
            /**禁用、不可用*/
            public static final int NO = 0;
            /**启用、可用*/
            public static final int YES = 1;
        }

    }

    /**
     * 时间（单位：秒）
     */
    public static class Time {

        public static final long ONE_MINUTE = 60;

        public static final long ONE_HOUR   = ONE_MINUTE * 60;

        public static final long ONE_DAY    = ONE_HOUR * 24;

        public static final long ONE_MONTH  = ONE_DAY * 30;
    }

}
