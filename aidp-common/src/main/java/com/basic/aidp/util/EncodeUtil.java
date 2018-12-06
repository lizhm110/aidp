package com.basic.aidp.util;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Objects;

/**
 * @Author lizhm
 * @Description 编码转义工具类
 * @Date 2018-12-6
 */
@Slf4j
public class EncodeUtil {

    /** 16进制的字符串数组 */
    private final static String[] hexDigitsStrings = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f" };
    /** 16进制的字符集 */
    private final static char [] hexDigitsChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * URL编码
     * @param origin
     * @return
     */
    public static String encode(String origin) {
        String result = null;
        try {
            result = URLEncoder.encode(origin, StandardCharsets.UTF_8.displayName());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * URL解码
     * @param origin
     * @return
     */
    public static String decode(String origin) {

        String result = null;
        try {
            result = URLDecoder.decode(origin, StandardCharsets.UTF_8.displayName());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * M5加密
     * @param source
     * @return
     */
    public static String md5Encode(String source) {
        Objects.requireNonNull(source, "Encode source must not be null.");

        String result = null;
        try {
            result = source;
            // 获得MD5摘要对象
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            // 使用指定的字节数组更新摘要信息
            messageDigest.update(result.getBytes(StandardCharsets.UTF_8.name()));
            // messageDigest.digest()获得16位长度
            result = byteArrayToHexString(messageDigest.digest());

        } catch (Exception e) {
            log.info("MD5 encode error : {}", e.getMessage());
        }
        return result;


    }



    /**
     * 转换字节数组为16进制字符串
     *
     * @param bytes
     *            字节数组
     * @return
     */
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte tem : bytes) {
            stringBuilder.append(byteToHexString(tem));
        }
        return stringBuilder.toString();
    }

    /**
     * * 将字节数组中指定区间的子数组转换成16进制字符串
     *
     * @param bytes
     *            目标字节数组
     *
     * @param start
     *            起始位置（包括该位置）
     *
     * @param end
     *            结束位置（不包括该位置）
     *
     * @return 转换结果
     */
    public static String bytesToHex(byte bytes[], int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < start + end; i++) {
            sb.append(byteToHexString(bytes[i]));
        }
        return sb.toString();

    }

    /**
     * 转换byte到16进制
     *
     * @param b
     *            要转换的byte
     * @return 16进制对应的字符
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigitsStrings[d1] + hexDigitsStrings[d2];
    }






}
