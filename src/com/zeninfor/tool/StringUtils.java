/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zeninfor.tool;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author WY
 */
public class StringUtils {
    
    
    public static boolean isBlack(String str){
        if(str == null || "".equals(str.trim())){
            return true;
        }
        return false;
    }
    
    
    public static boolean isNotBlack(String str){
        return !isBlack(str);
    }
    
    /******************************* 日期处理  ********************************/ 
    
     /**
     * 获取现在时间
     *
     * @return 返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(currentTime);
    }
    
    /******************************* 值进制处理  ********************************/
    
    
    
    
    //计算16进制对应的数值
    public static int getHex(char ch) throws Exception {
        if (ch >= '0' && ch <= '9') {
            return (int) (ch - '0');
        }
        if (ch >= 'a' && ch <= 'f') {
            return (int) (ch - 'a' + 10);
        }
        if (ch >= 'A' && ch <= 'F') {
            return (int) (ch - 'A' + 10);
        }
        throw new Exception("error param");
    }

    //计算幂
    public static int getPower(int nValue, int nCount) throws Exception {
        if (nCount < 0) {
            throw new Exception("nCount can't small than 1!");
        }
        if (nCount == 0) {
            return 1;
        }
        int nSum = 1;
        for (int i = 0; i < nCount; ++i) {
            nSum = nSum * nValue;
        }
        return nSum;
    }

    //判断是否是16进制数
    public static boolean isHex(String strHex) {
        int i = 0;
        if (strHex.length() > 2) {
            if (strHex.charAt(0) == '0' && (strHex.charAt(1) == 'X' || strHex.charAt(1) == 'x')) {
                i = 2;
            }
        }
        for (; i < strHex.length(); ++i) {
            char ch = strHex.charAt(i);
            if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'F') || (ch >= 'a' && ch <= 'f')) {
                continue;
            }
            return false;
        }
        return true;
    }
    
    //16进制转10进制
    public static int hexToInt(String strHex) {
        int nResult = 0;
        if (!isHex(strHex)) {
            return nResult;
        }
        String str = strHex.toUpperCase();
        if (str.length() > 2) {
            if (str.charAt(0) == '0' && str.charAt(1) == 'X') {
                str = str.substring(2);
            }
        }
        int nLen = str.length();
        for (int i = 0; i < nLen; ++i) {
            char ch = str.charAt(nLen - i - 1);
            try {
                nResult += (getHex(ch) * getPower(16, i));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return nResult;
    }
    
    
    /**
     * 整数车16进制字符串
     * @param val
     * @param len
     * @return 
     */
    public static String intToHexString(Integer val){
        String firstStr = "";
        Integer len = 2;
        String hex = Integer.toHexString(val);
        if(!len.equals(hex.length())){
            for(int i  = hex.length() + 1; i <= len; i++) {
                firstStr += "0";
            }
        }
        String str = firstStr + hex;
//        if(str.length() > 2){
//            str = str.substring(str.length() - 2);
//        }
        return str;
    }
    
    /**
     * 整数车16进制字符串
     * @param val
     * @param len
     * @return 
     */
    public static String intToHexString(Integer val , Integer len){
        len *= 2;
        String hex = Integer.toHexString(val);
        String firstStr = "";
        if(!len.equals(hex.length())){
            for(int i  = hex.length() + 1; i <= len; i++) {
                firstStr += "0";
            }
        }
        return firstStr + hex;
    }
    
    /**
     * Long车16进制字符串
     * @param val
     * @param len
     * @return 
     */    
     public static String longToHexString(Long val,Integer len){
        len *= 2;
        String hex = Long.toHexString(val);
        String firstStr = "";
        if(!len.equals(hex.length())){
            for(int i  = hex.length() + 1; i <= len; i++) {
                firstStr += "0";
            }
        }
        return firstStr + hex;
    }
    
       
  public static byte[] hexStringToBytes(String hexString) {  
    if (hexString == null || hexString.equals("")) {  
        return null;  
    }  
    hexString = hexString.toUpperCase();  
    int length = hexString.length() / 2;  
    char[] hexChars = hexString.toCharArray();  
    byte[] d = new byte[length];  
    for (int i = 0; i < length; i++) {  
        int pos = i * 2;  
        d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));  
    }  
    return d;  
}  
  
  
  /** 
 * Convert char to byte 
 * @param c char 
 * @return byte 
 */  
 public static byte charToByte(char c) {  
    return (byte) "0123456789ABCDEF".indexOf(c);  
}  
 
 
 
 
    /**
     * 编码(生成二维码)
     * 
     * @param str
     *            二维码的内容
     */
    public static byte[] encode(String str, String path, int width, int height) {
        try {
            BitMatrix byteMatrix;
            byteMatrix = new MultiFormatWriter().encode(new String(str.getBytes("UTF-8"), "ISO-8859-1"), BarcodeFormat.QR_CODE,
                width, height);
            File file = new File(path);

            MatrixToImageWriter.writeToFile(byteMatrix, "png", file);
            return getBytes(path);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    /**
     * 获得指定文件的byte数组
     * 
     * @param filePath
     * @return
     */
    public static byte[] getBytes(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
    
    
    public static void main(String[] args) {
        System.out.println(intToHexString(-3));
    }
}
