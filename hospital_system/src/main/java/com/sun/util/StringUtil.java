package com.sun.util;

import java.util.Random;

/**
 * 字符串辅助函数
 */
public class StringUtil {

    public static final Random random=new Random();

    public static String generateRandomString(int length){

        int i=0;
        StringBuffer stringBuffer = new StringBuffer();

        while (i < length) {
            stringBuffer.append(random.nextInt(10));
            i++;
        }
        return stringBuffer.toString();
    }
}
