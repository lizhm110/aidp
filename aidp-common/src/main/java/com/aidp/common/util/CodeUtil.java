package com.aidp.common.util;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author lizhm
 * @Description Code工具类
 * @Date 9:44 2018/12/5
 **/
public class CodeUtil {

    private static final String[] DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    private static final String[] CHARACTERS = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    private static final String[] DICTIONARY = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    
    private static final  String[] CHARS = new String[] {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z" };

    private static final int DEFAULT_LEN = 6;

    /**
     * 生成6位数字随机码
     *
     * @return
     */
    public static String genRandomNumberCode() {
        return genNumericCode(DEFAULT_LEN);
    }

    /**
     * 生成指定位数数字
     * @param len 长度
     * @return
     */
    public static String genNumericCode(int len) {
        return genGenericCharacters(len, DIGITS);
    }

    /**
     * 生成6位数字符随机码
     * @return
     */
    public static String genCharacterCode() {
        return genGenericCharacters(DEFAULT_LEN, CHARACTERS);
    }

    /**
     * 生成指定位数字符
     * @param len 长度
     * @return
     */
    public static String genCharacterCode(int len) {
        return genGenericCharacters(len, CHARACTERS);
    }

    /**
     * 生成手机数字验证码(默认4位)
     * @return
     */
    public static String genVerificationCode() {
        return genNumericCode(4);
    }

    /**
     * 生成指定位数验证码
     * @param len
     * @return
     */
    public static String genVerificationCode(int len) {
        return genNumericCode(len);
    }

    /**
     * 生成指定位数字符
     * @param len 长度
     * @return
     */
    public static String genGenericCharacters(int len, String[] chars) {

        if (len < 1 || len > 100) {
            throw new IllegalArgumentException("the length must be between 1 and 100");
        }

        StringBuilder codeBuf = new StringBuilder();
        int i = 0;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        while (i < len) {
            int pos = random.nextInt(chars.length);
            codeBuf.append(chars[pos]);
            i++;
        }
        return codeBuf.toString();
    }

    /**
     * 生成唯一码
     * @return
     */
    public static String genUniqueCode() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
