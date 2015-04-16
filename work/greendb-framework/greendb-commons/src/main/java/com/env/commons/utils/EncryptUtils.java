package com.env.commons.utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 加密解密
 * @author acer
 *
 */
public final class EncryptUtils {
    
    /**
     * 对某字符串进行加密
    
     * @param input
     * @return
     * @exception   {说明在某情况下,将发生什么异常}
     */
    public static String encrypt(String input) {
        if (input == null || "".equals(input)) {
            return "";
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] buffer = digest.digest(input.getBytes());
            String output = new String(buffer);
            return encoderByBase64(output);
        }
        catch (NoSuchAlgorithmException e) {
        	e.printStackTrace();
            return "";
        }
    }


    /**
     * 对字符串进行encoder为base 64
    
     * @param input
     * @return
     * @exception   {说明在某情况下,将发生什么异常}
     */
    public static String encoderByBase64(String input) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(input.getBytes());
    }


    /**
     * 对base64的字符串进行解码
    
     * @param input
     * @return
     * @throws Exception
     * @exception   {说明在某情况下,将发生什么异常}
     * @Author       
     */
    public static String decoderByBase64(String input) throws Exception {
        BASE64Decoder decoder = new BASE64Decoder();
        return new String(decoder.decodeBuffer(input));
    }


    /**
     * {方法的功能/动作描述}
    
     * @param input
     * @return
     * @exception   {说明在某情况下,将发生什么异常}
     * @Author       
     */
    public final static String encodeMD5(String input) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd','e', 'f'};
        try {
          byte[] strTemp = input.getBytes();
          MessageDigest mdTemp = MessageDigest.getInstance("MD5");
          mdTemp.update(strTemp);
          byte[] md = mdTemp.digest();
          int j = md.length;
          char str[] = new char[j * 2];
          int k = 0;
          for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
          }
          return new String(str);
        }
        catch (Exception e) {
          return null;
        }
      }
    public static void main(String[] args) {
        
        
    }
}
