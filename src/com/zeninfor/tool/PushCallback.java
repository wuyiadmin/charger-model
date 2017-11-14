/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zeninfor.tool;

import com.zeninfor.chager.EmulatorFrame;
import static com.zeninfor.chager.EmulatorFrame.deviceStatus;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author WY
 */
public class PushCallback implements MqttCallback {  
    
    
    public MqClient client;
    
    public PushCallback(MqClient client){
        this.client = client;
    }
 

    @Override
    public void connectionLost(Throwable thrwbl) {
        EmulatorFrame.emulatorFrame.disconnectServer();
        EmulatorFrame.threadFlag = false;
        EmulatorFrame.logFrame.addLogTxt("与服务器断开连接！");
    }
    
    

    @Override
    public void messageArrived(String string, MqttMessage mm) throws Exception {
         // 处理收到的消息
        String payload = new String(mm.getPayload());
        //解析出指令位
        if(StringUtils.isNotBlack(payload) && payload.length() > 2) {
            //第一位为指令
            String comm = payload.substring(0,2);
            //后面的为数据位
            String data = payload.substring(2);
            //执行指令
//            execCommand(comm, data);
        }
    }
    
    
//    
//    /**
//     * 执行指令
//     * @param comm
//     * @param data 
//     */
//    public synchronized void execCommand(String comm,String data) throws MqttException, InterruptedException{
//        Map<String,Object> mapData = null;
//        String log = null;
//        //判断指认的类型
//        switch(comm) {
//            //平台下发所有插座状态
//            case CommandUtils.DOWN_STOKET_STATUS :
//                mapData = MessageUtils.parseDownSocketStatusData(data);
//                //同步设备状态确认
////                if(mapData.get("count") != null && mapData.get("statusList") != null){
////                    Integer count = (Integer)mapData.get("count");
////                    List<Integer> statusList = (List<Integer>)mapData.get("count");
////                   
////                }
//                //记录日志
//                log = "收到平台下发设备状态消息"+ mapData.toString();
//                EmulatorFrame.logFrame.addLogTxt(log);
//                break;
//            //刷卡充电请求确认
//            case CommandUtils.CONFIRM_CARD_CHARGER :
//                mapData = MessageUtils.parseCardRequestChargerData(data);
//                if(mapData != null){
//                    if(mapData.get("number") != null && mapData.get("code") != null){
//                        Integer number = (Integer)mapData.get("number");
//                        Integer code = (Integer)mapData.get("code");
//                        if(code.equals(0)){
//                            if(mapData.get("energy") != null && mapData.get("time") != null){
//                                Long energy = Long.valueOf( mapData.get("energy").toString());
//                                Long time = Long.valueOf(mapData.get("time").toString());
//                                //更新插座状态为充电中
//                                EmulatorFrame.deviceStatus.put(number, DeviceSocketStatus.CHARGING.value());
//                                //记录日志
//                                log = "平台确认(刷卡充电) "+ number +" 号插座开始充电，可充电量: "+energy+"约可充电时长: "+ time;
//                                EmulatorFrame.logFrame.addLogTxt(log);
//                                
//                                Thread.sleep(1000 * 60);
//                                //上发充电完成指令（模拟）
//                                publishMessage(MessageUtils.getResponseStopChargerData(number, 2,null));
//                                log = number +" 号插座充电完成！";
//                                EmulatorFrame.logFrame.addLogTxt(log);
//                                //更新插座状态为空闲中
//                                EmulatorFrame.deviceStatus.put(number, DeviceSocketStatus.FREE.value());
//                            }
//                        }
//                    }
//                }
//                break;
//            //平台指示开始充电
//            case CommandUtils.DOWN_COMM_START_CHARGER :
//                mapData = MessageUtils.parseResponseStartChargerData(data);
//                if(mapData != null){
//                    if(mapData.get("number") != null && mapData.get("energy") != null && mapData.get("time") != null){
//                        Integer number = (Integer) mapData.get("number");
//                        Long energy = Long.valueOf(mapData.get("energy").toString());
//                        Long time = Long.valueOf(mapData.get("time").toString());
//                        //更新插座状态为充电中
//                        EmulatorFrame.deviceStatus.put(number, DeviceSocketStatus.CHARGING.value());
//                        //记录日志
//                        log = "平台指示 "+number+" 号插座开始充电，可充电量: "+energy+"约可充电时长: "+ time;
//                        EmulatorFrame.logFrame.addLogTxt(log);
//                        //回复平台开始充电
//                        String responseStartComm = MessageUtils.getResponseStartChargerData(number, 0, energy, time);
//                        publishMessage(responseStartComm);
//                        
//                         Thread.sleep(1000 * 10);
//                        //上发充电完成指令（模拟）
//                        publishMessage(MessageUtils.getResponseStopChargerData(number, 4,null));
//                        log = number +" 号插座充电完成！";
//                        EmulatorFrame.logFrame.addLogTxt(log);
//                        //更新插座状态为空闲中
//                        EmulatorFrame.deviceStatus.put(number, DeviceSocketStatus.FREE.value());
//                    }
//                }
//                break;
//            //平台指示停止充电
//            case CommandUtils.DOWN_COMM_STOP_CHARGER :
//                mapData = MessageUtils.parseResponseStopChargerData(data);
//                if(mapData != null){
//                    if(mapData.get("number") != null){
//                        Integer number = (Integer) mapData.get("number");
//                        //记录日志
//                        log = "平台指示 "+number+" 号插座停止充电";
//                        EmulatorFrame.logFrame.addLogTxt(log);
//                        //回复平台停止充电
//                        String responseStopComm = MessageUtils.getResponseStopChargerData(number, 0,21);
//                        publishMessage(responseStopComm);
//                        //更新插座状态为空闲中
//                        EmulatorFrame.deviceStatus.put(number, DeviceSocketStatus.FREE.value());
//                    }
//                }
//                break;
//            //扫码充电请求确认
//            case CommandUtils.CONFIRM_SCAN_CODE_CHARGER :
//                mapData = MessageUtils.parseResponseCodeChargerData(data);
//                if(mapData != null){
//                    if(mapData.get("number") != null && mapData.get("code") != null){
//                        Integer number = (Integer)mapData.get("number");
//                        Integer code = (Integer)mapData.get("code");
//                        if(code.equals(0)){
//                            if(mapData.get("energy") != null && mapData.get("time") != null){
//                                Long energy = Long.valueOf(mapData.get("energy").toString());
//                                Long time = Long.valueOf(mapData.get("time").toString());
//                                //更新插座状态为充电中
//                                EmulatorFrame.deviceStatus.put(number, DeviceSocketStatus.CHARGING.value());
//                                //记录日志
//                                log = "平台确认(付款码) "+mapData.get("number")+" 号插座开始充电，可充电量: "+energy+"约可充电时长: "+ time;
//                                EmulatorFrame.logFrame.addLogTxt(log);
//                            }
//                        }
//                    }
//                }
//                break;
//            //扫码充电添加时长请求确认
//            case CommandUtils.CONFIRM_SCAN_CODE_REQUEST_CHARGER_TIME :
//                mapData = MessageUtils.parseResponseCodeChargerData(data);
//                if(mapData != null){
//                    if(mapData.get("number") != null && mapData.get("code") != null){
//                        Integer code = (Integer)mapData.get("code");
//                        if(code.equals(0)){
//                            if(mapData.get("energy") != null && mapData.get("time") != null){
//                                Long energy = Long.valueOf(mapData.get("energy").toString());
//                                Long time = Long.valueOf(mapData.get("time").toString());
//                                //记录日志
//                                log = "平台确认(付款码) "+mapData.get("number")+" 号插座开始充电，可充电量: "+energy+"约可充电时长: "+ time;
//                                EmulatorFrame.logFrame.addLogTxt(log);
//                            }
//                        }
//                    }
//                }
//                break;
//            //回复卡片余额
//            case CommandUtils.RESPONSE_CARD_BALANCE :
//                mapData = MessageUtils.parseCardBlanceData(data);
//                if(mapData != null){
//                    if(mapData.get("carNumber") != null && mapData.get("balance") != null){
//                        String cardNumber = mapData.get("carNumber").toString();
//                        Integer balance = (Integer)mapData.get("balance");
//                        //记录日志
//                        log = "卡号: "+cardNumber+" 可用余额为："+ balance;
//                        EmulatorFrame.logFrame.addLogTxt(log);
//                        //显示信息
//                        EmulatorFrame.emulatorFrame.setDisplayTxt(balance.toString());
//                    }
//                }
//                break;
//            //插座预订信息回复
//            case CommandUtils.RESPONSE_SOCKET_RESERVE_STATUS :
//                break;
//            //下发设备参数
//            case CommandUtils.DOWN_DEVICE_CONFIRM :
//                break;
//            default:
//                
//        }
//    }
    

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
       //To change body of generated methods, choose Tools | Templates.
        System.out.println("deliveryComplete");
    }

   
    
    
}  
