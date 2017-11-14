/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zeninfor.tool;

/**
 *
 * @author WY
 */
public class CommandUtils {
    
    
    /******************************* 设备上行 ******************************/
    //上报所有插座现场状态
    public static final String REPORTED_DATA = "01";
    //刷卡充电请求
    public static final String CARD_CHARGER_REQUEST = "02";
    //刷卡充电时长添加请求
    public static final String CARD_CHARGER_REQUEST_TIME = "03";
    //扫码请求充电
    public static final String SCAN_CODE_REQUEST_CHARGER = "04";
    //扫码充电时长添加请求
    public static final String SCAN_CODE_REQUEST_CHARGER_TIME = "05";
    //回复开始充电
    public static final String RESPONSE_CHARGER = "0A";
    //回复停止充电
    public static final String RESPONSE_STOP_CHARGER = "07";
    //IC卡余额查询
    public static final String QUERY_CARD_BALANCE = "08";
    //查询插座预订信息
    public static final String QUERY_SOCKET_RESERVE_STATUS = "09";
    
    
    
    
     /******************************* 设备下行 ******************************/
    
    //平台下发所有插座状态
    public static final String DOWN_STOKET_STATUS = "81";
    //刷卡充电请求确认
    public static final String CONFIRM_CARD_CHARGER = "82";
    //刷卡充电请求添加时长确认
    public static final String CONFIRM_CARD_CHARGER_TIME = "83";    
    //扫码充电请求确认
    public static final String CONFIRM_SCAN_CODE_CHARGER = "84";
    //扫码充电添加时长请求确认
    public static final String CONFIRM_SCAN_CODE_REQUEST_CHARGER_TIME = "85";
    //平台指示开始充电
    public static final String DOWN_COMM_START_CHARGER = "86";
    //平台指示停止充电
    public static final String DOWN_COMM_STOP_CHARGER = "87";
    //回复卡片余额
    public static final String RESPONSE_CARD_BALANCE = "88";
    //插座预订信息回复
    public static final String RESPONSE_SOCKET_RESERVE_STATUS = "89";
    //下发设备参数
    public static final String DOWN_DEVICE_CONFIRM = "8A";
    
    
    
    //
    
    
}
