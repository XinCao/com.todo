package com.xincao.todo_mvn.util;

import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author caoxin
 */
public class StringUtil {

    public static String getRandomStr(int length) {
        return RandomStringUtils.random(length, "aAbBcCdDeEfFgGhHijJkKLmMnNoOpPqQrRsStTuUvVwWxXyYzZ123456789");
    }
}