package com.sun.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SHACoder {

    public static byte[] encodeSHA(String data)  {

        // 执行消息摘要
        return DigestUtils.sha(data);
    }

    /**
     * SHAHex加密
     *
     * @param data 待加密数据
     * @return String 消息摘要
     * @
     */
    public static String encodeSHAHex(String data)  {

        // 执行消息摘要
        return DigestUtils.shaHex(data);
    }

    /**
     * SHA256加密
     *
     * @param data 待加密数据
     * @return byte[] 消息摘要
     * @
     */
    public static byte[] encodeSHA256(String data)  {

        // 执行消息摘要
        return DigestUtils.sha256(data);
    }

    /**
     * SHA256Hex加密
     *
     * @param data 待加密数据
     * @return String 消息摘要
     * @
     */
    public static String encodeSHA256Hex(String data)  {

        // 执行消息摘要
        return DigestUtils.sha256Hex(data);
    }

    /**
     * SHA384加密
     *
     * @param data 待加密数据
     * @return byte[] 消息摘要
     * @
     */
    public static byte[] encodeSHA384(String data)  {

        // 执行消息摘要
        return DigestUtils.sha384(data);
    }

    /**
     * SHA384Hex加密
     *
     * @param data 待加密数据
     * @return String 消息摘要
     * @
     */
    public static String encodeSHA384Hex(String data)  {

        // 执行消息摘要
        return DigestUtils.sha384Hex(data);
    }

    /**
     * SHA512Hex加密
     *
     * @param data 待加密数据
     * @return byte[] 消息摘要
     * @
     */
    public static byte[] encodeSHA512(String data)  {

        // 执行消息摘要
        return DigestUtils.sha512(data);
    }

    /**
     * SHA512Hex加密
     *
     * @param data 待加密数据
     * @return String 消息摘要
     * @
     */
    public static String encodeSHA512Hex(String data)  {

        // 执行消息摘要
        return DigestUtils.sha512Hex(data);
    }

}
