package com.todo.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import java.security.MessageDigest;

/**
 * MD 消息摘要组建
 *
 * @author CaoXin
 * @version 1.0
 */
public class MdImplement {

    /**
     * MD2消息摘要（JDK实现）
     *
     * @param data
     * @return byte[]
     * @throws Exception
     */
    private static byte[] encodeMD2To128(byte[] data) throws Exception {
        MessageDigest md2 = MessageDigest.getInstance("MD2");
        byte[] digest = md2.digest();
        return digest;
    }

    /**
     * MD5消息摘要（JDK实现）
     *
     * @param data
     * @return byte[]
     * @throws Exception
     */
    private static byte[] encodeMD5To128(byte[] data) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest();
        return digest;
    }

    /**
     * MD2消息摘要（JDK实现）
     *
     * @param data
     * @return String
     * @throws Exception
     */
    public static String encodeMD2To32(byte[] data) throws Exception {
        return HexBin.encode(MdImplement.encodeMD2To128(data));
    }

    /**
     * MD5消息摘要（JDK实现）
     *
     * @param data
     * @return String
     * @throws Exception
     */
    public static String encodeMD5To32(byte[] data) {
        try {
            return HexBin.encode(MdImplement.encodeMD5To128(data));
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String... args) throws Exception {
        String s = "hello world!";
        System.out.println(encodeMD5To32(s.getBytes()));
    }
}