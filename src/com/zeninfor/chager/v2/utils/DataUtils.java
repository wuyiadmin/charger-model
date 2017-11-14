/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zeninfor.chager.v2.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author WY
 */
public class DataUtils {
    
    public static Map<Integer,Boolean> electricalStatus = new HashMap<Integer,Boolean>();
    
    
    public static Map<Integer,Boolean> duanluStatus = new HashMap<Integer,Boolean>();
    
    //功率值
    public static Map<Integer,Integer> powerMap = new HashMap<Integer,Integer>();
    
    /**
     * 定义插座状态
    */
    public static Integer FREE = 0;//      空闲
    public static Integer INIT = 1;//       初始暂态
    public static Integer CHARGE = 2;//       充电
    public static Integer TRICKLE = 3;//       涓流
    public static Integer NORMAL_END = 16;//       充电结束（正常结束）
    public static Integer LOAD_OUT = 17;//       充电结束（负载被拔出）
    public static Integer COMM_STOP = 18;//       充电结束（指令停止）
    public static Integer OVERLOAD_RECOVERY = 24;//       充电结束（过载恢复）
    public static Integer OVER_LOAD = 32;//       充电结束（超负载）
    public static Integer STEALING_POWER = 33;//       充电结束（偷电）
    public static Integer OVERLOAD_PROTECTION = 40;//       过载保护(短路)
    public static Integer DISABLE = 255;//       禁用
    
    
    /**
     * 定义取消充电原因
    */
    public static Integer START_CHARGING = 0;//      开始充电
    public static Integer SINGLE_OVER_LOAD = 255;//       单路超功率
    public static Integer TOTAL_OVER_LOAD = 254;//       总输出超功率
    public static Integer NO_EQUIPMENT = 253;//       无设备
    public static Integer SHORT_CIRCUIT = 252;//       短路
    public static Integer BUTTON_CANCELLED = 251;//       用户按键取消
    public static Integer PLATFORM_INSTRUCTION_STOP = 250;//      平台指令停止
    
    //默认都未接入用电器
    static{
        for(int i = 1 ; i <= 10; i++){
            electricalStatus.put(i,false);
            powerMap.put(i, 80);
        }
    }
    
    
}
