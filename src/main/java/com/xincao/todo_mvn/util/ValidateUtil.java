package com.xincao.todo_mvn.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 对字符串进行校验
 *
 * @author caoxin
 */
public class ValidateUtil {

    private static final Pattern mailPattern = Pattern.compile(PatternConstant.mail);

    private static Matcher getMailMatcher(String mailStr) {
        return mailPattern.matcher(mailStr);
    }

    public static boolean isMailStr(String mailStr) {
        return getMailMatcher(mailStr).matches();
    }
    /**
     * 点分十进制IP
     */
    private static final Pattern ipPattern = Pattern.compile(PatternConstant.ip);

    public static Matcher getIpMatcher(String ipStr) {
        return ipPattern.matcher(ipStr);
    }

    public static boolean isIpStr(String ipStr) {
        return getIpMatcher(ipStr).matches();
    }
    /**
     * 一般字符串校验（字母， 数字，下划线构成）
     */
    private static final Pattern commonPattern = Pattern.compile(PatternConstant.common);

    public static boolean isCommonStr(String commonStr) {
        return commonPattern.matcher(commonStr).matches();
    }
}