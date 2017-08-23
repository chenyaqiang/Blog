package com.blog.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @description:
 * @author: wb
 * @data: 2017/8/23 14:05
 * @see:
 * @since:
 */
public class MD5 {

    private static final String salt = "0123456789ABCDEF";

    public static String md5(String str,String salt){
        return new Md5Hash(str,salt).toString();
    }

    public static String md5(String str){
        return new Md5Hash(str,salt).toString();
    }


    public static void main(String[] args) {
        String password="123456";
        System.out.println("Md5加密："+MD5.md5(password));
    }

}
