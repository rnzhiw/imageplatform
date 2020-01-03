package com.zust.itee.util;

/**
 * 字符串工具类
 *
 * @author ruanzhiwei
 * @date 2019/12/9
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }

    /**
     * 判断字符串是否不为空
     *
     * @param s
     * @return
     */
    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }
}
