/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zeninfor.tool;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author WY
 */
public class Test {
    
    
    public static void main(String [] args) throws UnsupportedEncodingException{
//        Double d = 12.1235685689;
//        String ds = Double.toHexString(d);
//        System.out.println(ds);
//        Double v = Double.valueOf(ds);
//        System.out.println(v);
        
//        String number = "010A10000001";
////        Integer num = Integer.valueOf(number,16);
////        System.out.println(num);
//        byte[] data = hexStringToBytes(number);
//        byte[] arr = number.getBytes();
//        System.out.println(new String(data));
        
        
        
//       StringBuilder str = new StringBuilder();
//       str.append("860600640000");
//       System.out.println(str.toString());
        
//        System.out.println(System.currentTimeMillis() / 1000);
        
        System.out.println(StringUtils.intToHexString(32));
        
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
}
