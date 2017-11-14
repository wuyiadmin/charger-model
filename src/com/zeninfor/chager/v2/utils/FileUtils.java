/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zeninfor.chager.v2.utils;


  
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.Scanner;  

/**
 *
 * @author WY
 */
public class FileUtils {
    /** 
     * 功能：Java读取txt文件的内容 步骤： 
     * 1：先获得文件句柄  
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取 
     * 3：读取到输入流后，需要读取生成字节流 
     *  4：一行一行的输出。readline()。 备注：需要考虑的是异常情况 
     * @param filePath 
     */  
    public static String readTxtFile(String filePath) {  
        StringBuilder builder = new StringBuilder();
        try {  
            String encoding = "UTF-8";  
            File file = new File(filePath);  
            if (file.isFile() && file.exists()) { // 判断文件是否存在  
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式  
                BufferedReader bufferedReader = new BufferedReader(read);  
                String lineTxt = null;  
                while ((lineTxt = bufferedReader.readLine()) != null) {  
                   builder.append(lineTxt);  
                }  
                read.close();  
            }  
        } catch (Exception e) {  
            System.out.println("读取文件内容出错");  
            e.printStackTrace();  
        }  
        return builder.toString();
    }  
      
    public static void writeTxtFile(String filepath,String info){  
        File file=new File(filepath);  
        BufferedWriter writer = null;  
        try {  
            if(file.isFile()&&!file.exists()){  
                System.out.println("找不到指定的文件");  
                file.createNewFile();// 不存在则创建  
            }  
            else{  
                //writer = new BufferedWriter(new FileWriter(file,true)); //这里加入true 可以不覆盖原有TXT文件内容 续写  
                writer = new BufferedWriter(new FileWriter(file));  
                writer.write(info);   
            }  
              
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (writer != null) {  
                try {  
                    writer.flush();  
                    writer.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  
}
