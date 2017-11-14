/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zeninfor.tool;

import com.zeninfor.chager.v2.ChargerFrame;
import com.zeninfor.chager.v2.utils.DataUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author WY
 */
public class MessageUtils {
    
   
    /**
     * 上报设备的状态
     * @param socketStatus
     * @return 
     */
    public static String getUpstreamDeviceStatusData(Map<Integer,Integer> socketStatus){
        Integer undoneEnergy = 300;
        //定义功率和待充电量         
        StringBuilder str = new StringBuilder();
        //增加指令位
        str.append(CommandUtils.REPORTED_DATA);
        //增加插座数量位
        str.append(StringUtils.intToHexString(socketStatus.size()));
        //加入每个插座的状态数据
        for(int i = 1; i <= socketStatus.size(); i++){
            //判断是否是空闲或故障状态
            if(!socketStatus.get(i).equals(DataUtils.FREE)){
                //加入状态
                String status = StringUtils.intToHexString(ChargerFrame.deviceStatus.get(i));
                str.append(status);
                //加入功率
                String powerStr = StringUtils.intToHexString(DataUtils.powerMap.get(i),2);
                str.append(powerStr);
                //加入已充电量 
                String undoneEnergyStr = StringUtils.intToHexString(undoneEnergy,2);
                str.append(undoneEnergyStr);
                //加入已充时间
                String time = StringUtils.intToHexString(60 * 60,2);
                str.append(time);
            }else{
                //加入功率 已充电量 已充时间
                str.append("00000000000000");
            }
        }        
        return str.toString();
    }
    
    
    
    
     /**
     * 刷卡请求充电
     * @param socketNumber
     * @param cardNumber
     * @return 
     */
    public static String getRequestCardChargerData(int socketNumber,String cardNumber){
       
        StringBuilder str = new StringBuilder();
        //增加指令位
        str.append(CommandUtils.CARD_CHARGER_REQUEST);
        //增加插座编号
        str.append(StringUtils.intToHexString(socketNumber));
        //加入卡号
        str.append(cardNumber);
        return str.toString();
    }
    
    
    
    /**
     * 回复开始充电
     * @param socketNumber
     * @param code
     * @return 
     */
    public static String getResponseStartChargerData(int socketNumber,int code, Long energy, Long time){
       
        StringBuilder str = new StringBuilder();
        //增加指令位
        str.append(CommandUtils.RESPONSE_CHARGER);
        //增加插座编号
        str.append(StringUtils.intToHexString(socketNumber));
        //加入状态码
        str.append(StringUtils.intToHexString(code));
        
        return str.toString();
    }
    
    
     /**
     * 回复停止充电
     * @param socketNumber
     * @param code
     * @param time 
     * @return 
     */
    public static String getResponseStopChargerData(int socketNumber,int code,Integer time){
        
         //定义功率和待充电量 
        Integer undoneEnergy = 10;
        
        StringBuilder str = new StringBuilder();
        //增加指令位
        str.append(CommandUtils.RESPONSE_STOP_CHARGER);
        //增加插座编号
        str.append(StringUtils.intToHexString(socketNumber));
        //加入状态码
        str.append(StringUtils.intToHexString(code));
//        if(code == 0){
            //加入待充电量
        str.append(StringUtils.intToHexString(undoneEnergy,2));
            //加入状待充时长
//            str.append(StringUtils.intToHexString(time,2));
//        }
        return str.toString();
    }
    
    
     /**
     * 扫码请求充电
     * @param socketNumber
     * @param payCode
     * @return 
     */
    public static String getRequestScanCodeChargerData(int socketNumber,String payCode){
        
        StringBuilder str = new StringBuilder();
        //增加指令位
        str.append(CommandUtils.SCAN_CODE_REQUEST_CHARGER);
        //增加插座编号
        str.append(StringUtils.intToHexString(socketNumber));
        //加入付款码信息
        str.append(payCode);
        return str.toString();
    }
    
    
    
      /**
     * 扫码请求充电
     * @param socketNumber
     * @param payCode
     * @return 
     */
    public static String getRequestScanChargerTimeData(int socketNumber,String payCode){
        
        StringBuilder str = new StringBuilder();
        //增加指令位
        str.append(CommandUtils.SCAN_CODE_REQUEST_CHARGER_TIME);
        //增加插座编号
        str.append(StringUtils.intToHexString(socketNumber));
        //加入付款码信息
        str.append(payCode);
        return str.toString();
    }
    
    
      /**
     * IC 卡余额查询
     * @param cardNumber
     * @return 
     */
    public static String getQueryCardBalanceData(String cardNumber){
        
        StringBuilder str = new StringBuilder();
        //增加指令位
        str.append(CommandUtils.QUERY_CARD_BALANCE);
        //增加卡号
        str.append(cardNumber);
        return str.toString();
    }
    
    
       /**
     * 查询插座预订信息
     * @param socketNumber
     * @return 
     */
    public static String getQuerySocketReserveStatusData(int socketNumber){
        
        StringBuilder str = new StringBuilder();
        //增加指令位
        str.append(CommandUtils.QUERY_SOCKET_RESERVE_STATUS);
        //增加卡号
        str.append(StringUtils.intToHexString(socketNumber));
        return str.toString();
    }
    
    
    
    /************************************* 下行数据解析包装 ************************************/
    
    
     /**
     * 下行所有插座平台状态
     * @param data
     * @return 
     */
    public static Map<String,Object> parseDownSocketStatusData(String data){
        Map<String,Object> result = new HashMap<>();
        //解析插座数量
        String count = data.substring(0,2);
        result.put("count", Integer.valueOf(count,16));
        //处理各插座的状态数据
        String statusData = data.substring(2);
        List<Integer> statusList = new ArrayList<>();
        for(int i = 0; i < statusData.length() / 2; i++){
            String itemData = statusData.substring(i,i+2);
            statusList.add(Integer.valueOf(itemData,16));
        }    
        result.put("statusList", statusList);
        return result;
    }
    
    
    
    /**
     * 刷卡充电请求确认
     * @param data
     * @return 
     */
    public static Map<String,Object> parseCardRequestChargerData(String data){
        Map<String,Object> result = new HashMap<>();
        //解析插座编号
        String number = data.substring(0,2);
        result.put("number", Integer.valueOf(number,16));
        //解析状态码
        String code = data.substring(2,4);
        result.put("code", Integer.valueOf(code,16));
        //解析最大充电量
        String energy = data.substring(4,8);
        result.put("energy", Integer.valueOf(energy,16));
        //解析最大充时长
        String time = data.substring(8, 12);
        result.put("time", Integer.valueOf(time,16));
        return result;
    }
    
    
    /**
     * 平台指示开始充电
     * @param data
     * @return 
     */
    public static Map<String,Object> parseResponseStartChargerData(String data){
        Map<String,Object> result = new HashMap<>();
        //解析插座编号
        String number = data.substring(0,2);
        result.put("number", Integer.valueOf(number,16));
        //解析可用最大充电量
        String energy = data.substring(2,6);
        result.put("energy", Integer.valueOf(energy,16));
        //解析可用最大充电时长
        String time = data.substring(6,10);
        result.put("time", Integer.valueOf(time,16));
        return result;
    }
    
    
    
     /**
     * 平台指示停止充电
     * @param data
     * @return 
     */
    public static Map<String,Object> parseResponseStopChargerData(String data){
        Map<String,Object> result = new HashMap<>();
        //解析插座编号
        String number = data.substring(0,2);
        result.put("number", Integer.valueOf(number,16));
        return result;
    }
    
    
    
    
     /**
     * 扫码充电请求确认/或增加时长
     * @param data
     * @return 
     */
    public static Map<String,Object> parseResponseCodeChargerData(String data){
        Map<String,Object> result = new HashMap<>();
        //解析插座编号
        String number = data.substring(0,2);
        result.put("number", Integer.valueOf(number,16));
        //解析状态码
        String code = data.substring(2,4);
        result.put("code", Integer.valueOf(code,16));
        //解析最大充电量
        String energy = data.substring(4,8);
        result.put("energy", Integer.valueOf(energy,16));
        //解析最大充电时长
        String time = data.substring(8,12);
        result.put("time", Integer.valueOf(time,16));
        
        return result;
    }
    
    
    /**
     * 回复卡余额
     * @param data
     * @return 
     */
    public static Map<String,Object> parseCardBlanceData(String data){
        Map<String,Object> result = new HashMap<>();
        //解析卡号
        String carNumber = data.substring(0,4);
        result.put("carNumber", carNumber);
        //解析余额
        String blance = data.substring(4,8);
        result.put("balance", Integer.valueOf(blance,16));
      
        return result;
    }
    
    /**
     * 插座预订信息回复
     * @param data
     * @return 
     */
    public static Map<String,Object> parseResponseReserveInfoData(String data){
        Map<String,Object> result = new HashMap<>();
        //解析插座编号
        String number = data.substring(0,2);
        result.put("number", Integer.valueOf(number,16));
        //解析预订方式
        String type = data.substring(2,4);
        result.put("type", Integer.valueOf(type,16));
        //解析手机号后四位
        String mobile = data.substring(4,6);
        result.put("type", Integer.valueOf(mobile,16));
        return result;
    }
    
    
    
    /**
     * 下发设备参数
     * @param data
     * @return 
     */
    public static Map<String,Object> parseDeviceConfigData(String data){
        Map<String,Object> result = new HashMap<>();
        //解析插座编号(0表示所有)
        String number = data.substring(0,2);
        result.put("number", Integer.valueOf(number,16));
        //解析单路量大功率
        String power = data.substring(2,6);
        result.put("power", Integer.valueOf(power,16));
        //解析总功率
        String totalPower = data.substring(6,10);
        result.put("totalPower", Integer.valueOf(totalPower,16));
        //解析电价
        String price = data.substring(10,14);
        result.put("price", Double.valueOf(price));
        return result;
    }
    
}
