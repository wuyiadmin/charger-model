/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zeninfor.tool;


import com.zeninfor.chager.v2.ChargerFrame;
import com.zeninfor.chager.v2.utils.DataUtils;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author WY
 */
public class MqClient {
        
    public String host = "tcp://106.14.95.2:1883";  
    public String topic = "101";  
    public String clientId = "1011743000001";  
    public MqttConnectOptions options;  
    public String userName = "1011743000001";  
    public String passWord = "17430001";  
    public MqttClient mqttClient;  

//    private ScheduledExecutorService scheduler;  
  
    //重新链接  
//    public void startReconnect() {  
//        scheduler = Executors.newSingleThreadScheduledExecutor();  
//        scheduler.scheduleAtFixedRate(new Runnable() {  
//            public void run() {  
//                if (!mqttClient.isConnected()) {  
//                    try {  
//                        mqttClient.connect(options);  
//                    } catch (MqttSecurityException e) {  
//                        e.printStackTrace();  
//                    } catch (MqttException e) {  
//                        e.printStackTrace();  
//                    }  
//                }  
//            }  
//        }, 0 * 1000, 10 * 1000, TimeUnit.MILLISECONDS);  
//    }  
  
    /**
     * Mqtt 连接
     * @return 
     */
    public boolean connect() {  
//        
        try {  
             //host为主机名，test为clientid即连接MQTT的客户端ID，一般以客户端唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存  
            mqttClient = new MqttClient(host, clientId, new MemoryPersistence());  
            // MQTT的连接设置  
            options = new MqttConnectOptions();  
            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接  
            options.setCleanSession(true);  
            // 设置连接的用户名  
            options.setUserName(userName);  
            // 设置连接的密码  
            options.setPassword(passWord.toCharArray());  
            // 设置超时时间 单位为秒  
            options.setConnectionTimeout(90);  
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制  
            options.setKeepAliveInterval(60);  
            // 设置回调  
            mqttClient.setCallback(new MqttCallback(){

                @Override
                public void connectionLost(Throwable thrwbl) {
                    ChargerFrame.chargerFrame.disconnectServer();
                    ChargerFrame.threadFlag = false;
                    ChargerFrame.logFrame.addLogTxt("与服务器断开连接！");
                    ChargerFrame.isConnected = false;
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
                        execCommand(comm, data);
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken imdt) {
                    
                }
            });
            
            mqttClient.connect(options);  
            //添加日志
            ChargerFrame.logFrame.addLogTxt("与mqtt连接服务器成功！");
            //订阅消息  
            mqttClient.subscribe(passWord);  
            //添加日志
            ChargerFrame.logFrame.addLogTxt("订阅主题 "+ passWord+" 成功！");
            return true;
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return false;
    }  
    
    
    
    /**
     * 执行指令
     * @param comm
     * @param data 
     */
    public void execCommand(String comm,String data) throws MqttException, InterruptedException{
        Map<String,Object> mapData = null;
        String log = null;
        //判断指认的类型
        switch(comm) {
            //平台下发所有插座状态
            case CommandUtils.DOWN_STOKET_STATUS :
                mapData = MessageUtils.parseDownSocketStatusData(data);
                //同步设备状态确认
//                if(mapData.get("count") != null && mapData.get("statusList") != null){
//                    Integer count = (Integer)mapData.get("count");
//                    List<Integer> statusList = (List<Integer>)mapData.get("count");
//                   
//                }
                //记录日志
                log = "收到平台下发设备状态消息"+ mapData.toString();
                ChargerFrame.logFrame.addLogTxt(log);
                break;
            //刷卡充电请求确认
            case CommandUtils.CONFIRM_CARD_CHARGER :
                mapData = MessageUtils.parseCardRequestChargerData(data);
                if(mapData != null){
                    if(mapData.get("number") != null && mapData.get("code") != null){
                        Integer number = (Integer)mapData.get("number");
                        Integer code = (Integer)mapData.get("code");
                        if(code.equals(0)){
                            if(mapData.get("energy") != null && mapData.get("time") != null){
                                Long energy = Long.valueOf( mapData.get("energy").toString());
                                Long time = Long.valueOf(mapData.get("time").toString());
                                //更新插座状态为充电中
                                ChargerFrame.deviceStatus.put(number, DeviceSocketStatus.CHARGING.value());
                                //记录日志
                                log = "平台确认(刷卡充电) "+ number +" 号插座开始充电，可充电量: "+energy+"约可充电时长: "+ time;
                                ChargerFrame.logFrame.addLogTxt(log);
                                
                                Thread.sleep(1000 * 60);
                                //上发充电完成指令（模拟）
                                publishMessage(MessageUtils.getResponseStopChargerData(number, 2,null));
                                log = number +" 号插座充电完成！";
                                ChargerFrame.logFrame.addLogTxt(log);
                                //更新插座状态为空闲中
                                ChargerFrame.deviceStatus.put(number, DeviceSocketStatus.FREE.value());
                            }
                        }
                    }
                }
                break;
            //平台指示开始充电
            case CommandUtils.DOWN_COMM_START_CHARGER :
                mapData = MessageUtils.parseResponseStartChargerData(data);
                if(mapData != null){
                    if(mapData.get("number") != null && mapData.get("energy") != null && mapData.get("time") != null){
                        Integer number = (Integer) mapData.get("number");
                        Long energy = Long.valueOf(mapData.get("energy").toString());
                        Long time = Long.valueOf(mapData.get("time").toString());
                        //更新插座状态为充电中
                        //记录日志
                        log = "平台指示 "+number+" 号插座开始充电，可充电量: "+energy+"约可充电时长: "+ time;
                        ChargerFrame.logFrame.addLogTxt(log);
                        //回复平台开始充电
                        try {
                                Thread.sleep(2 * 1000);
                               //上发充电完成指令（模拟）
                           }catch (InterruptedException ex) {
                              Logger.getLogger(ChargerFrame.class.getName()).log(Level.SEVERE, null, ex);
                          }
                        //查询是否有接入负载
                        if(DataUtils.electricalStatus.get(number)){
                            ChargerFrame.deviceStatus.put(number, DataUtils.CHARGE);
                            String responseStartComm = MessageUtils.getResponseStartChargerData(number, DataUtils.START_CHARGING, energy, time);
                            publishMessage(responseStartComm);
                            //修改按钮颜色为在充电
                            ChargerFrame.chargerFrame.setButtonColor(number,ChargerFrame.greenColor);
                        }else{
                            ChargerFrame.deviceStatus.put(number, DataUtils.LOAD_OUT);
                            String responseStartComm = MessageUtils.getResponseStartChargerData(number, DataUtils.NO_EQUIPMENT, energy, time);
                            publishMessage(responseStartComm);
                        } 
//                        new Thread(){
//                            @Override
//                            public void run() {
//                               // compute primes larger than minPrime
//                                try {
//                                     Thread.sleep(5 * 60 * 1000);
//                                    //上发充电完成指令（模拟）
//                                      String successlog = number +" 号插座充电完成！";
//                                      ChargerFrame.logFrame.addLogTxt(successlog);
////                                      publishMessage(MessageUtils.getResponseStopChargerData(number, 4,null));
//                                      //更新插座状态为空闲中
//                                      ChargerFrame.deviceStatus.put(number, DataUtils.FREE);
////                                } catch (MqttException ex) {
////                                    Logger.getLogger(EmulatorFrame.class.getName()).log(Level.SEVERE, null, ex);
//                                }catch (InterruptedException ex) {
//                                   Logger.getLogger(ChargerFrame.class.getName()).log(Level.SEVERE, null, ex);
//                               }
//                           }
//                      }.start();
                    }
                }
                break;
            //平台指示停止充电
            case CommandUtils.DOWN_COMM_STOP_CHARGER :
                mapData = MessageUtils.parseResponseStopChargerData(data);
                if(mapData != null){
                    if(mapData.get("number") != null){
                        Integer number = (Integer) mapData.get("number");
                        //记录日志
                        log = "平台指示 "+number+" 号插座停止充电";
                        ChargerFrame.logFrame.addLogTxt(log);
                        //回复平台停止充电
                        String responseStopComm = MessageUtils.getResponseStopChargerData(number, 0,21);
                        publishMessage(responseStopComm);
                        //更新插座状态为空闲中
                        ChargerFrame.deviceStatus.put(number, DeviceSocketStatus.FREE.value());
                    }
                }
                break;
            //扫码充电请求确认
            case CommandUtils.CONFIRM_SCAN_CODE_CHARGER :
                mapData = MessageUtils.parseResponseCodeChargerData(data);
                if(mapData != null){
                    if(mapData.get("number") != null && mapData.get("code") != null){
                        Integer number = (Integer)mapData.get("number");
                        Integer code = (Integer)mapData.get("code");
                        if(code.equals(0)){
                            if(mapData.get("energy") != null && mapData.get("time") != null){
                                Long energy = Long.valueOf(mapData.get("energy").toString());
                                Long time = Long.valueOf(mapData.get("time").toString());
                                //更新插座状态为充电中
                                ChargerFrame.deviceStatus.put(number, DeviceSocketStatus.CHARGING.value());
                                //记录日志
                                log = "平台确认(付款码) "+mapData.get("number")+" 号插座开始充电，可充电量: "+energy+"约可充电时长: "+ time;
                                ChargerFrame.logFrame.addLogTxt(log);
                            }
                        }
                    }
                }
                break;
            //扫码充电添加时长请求确认
            case CommandUtils.CONFIRM_SCAN_CODE_REQUEST_CHARGER_TIME :
                mapData = MessageUtils.parseResponseCodeChargerData(data);
                if(mapData != null){
                    if(mapData.get("number") != null && mapData.get("code") != null){
                        Integer code = (Integer)mapData.get("code");
                        if(code.equals(0)){
                            if(mapData.get("energy") != null && mapData.get("time") != null){
                                Long energy = Long.valueOf(mapData.get("energy").toString());
                                Long time = Long.valueOf(mapData.get("time").toString());
                                //记录日志
                                log = "平台确认(付款码) "+mapData.get("number")+" 号插座开始充电，可充电量: "+energy+"约可充电时长: "+ time;
                                ChargerFrame.logFrame.addLogTxt(log);
                            }
                        }
                    }
                }
                break;
            //回复卡片余额
            case CommandUtils.RESPONSE_CARD_BALANCE :
                mapData = MessageUtils.parseCardBlanceData(data);
                if(mapData != null){
                    if(mapData.get("carNumber") != null && mapData.get("balance") != null){
                        String cardNumber = mapData.get("carNumber").toString();
                        Integer balance = (Integer)mapData.get("balance");
                        //记录日志
                        log = "卡号: "+cardNumber+" 可用余额为："+ balance;
                        ChargerFrame.logFrame.addLogTxt(log);
                    }
                }
                break;
            //插座预订信息回复
            case CommandUtils.RESPONSE_SOCKET_RESERVE_STATUS :
                break;
            //下发设备参数
            case CommandUtils.DOWN_DEVICE_CONFIRM :
                break;
            default:
                
        }
    }
    
    
    /**
     * 上发消息到服务器端
     * @param topic
     * @param qos
     * @param info
     * @throws MqttException 
     */
    public void publishMessage(String topic,int qos, String info) throws MqttException{
        new Thread(){
           @Override
           public void run() {
                MqttMessage message = new MqttMessage();
                message.setQos(qos);
                byte[] payload = StringUtils.hexStringToBytes(info);
                message.setPayload(payload);
                if(mqttClient.isConnected()){
                    try {
                        mqttClient.publish(topic, message);
                    } catch (MqttException ex) {
                        Logger.getLogger(MqClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ChargerFrame.logFrame.addLogTxt("上发消息：！"+info);
                }
        }}.start();
    }
    
     /**
     * 上发消息到服务器端
     * @param topic
     * @param qos
     * @param info
     * @throws MqttException 
     */
    public void publishMessage(String topic,String info) throws MqttException{
        publishMessage(topic,0,info);
    }
    
    
      /**
     * 上发消息到服务器端
     * @param topic
     * @param qos
     * @param info
     * @throws MqttException 
     */
    public void publishMessage(String info) throws MqttException{
       publishMessage(topic,info);
    }
    
    /**
     * 断开连接
     */
    public void disconnect() {  
         try {  
             if(mqttClient != null && mqttClient.isConnected()){
                mqttClient.disconnect();
                ChargerFrame.threadFlag = false;
                ChargerFrame.logFrame.addLogTxt("与mqtt服务器断开连接！");
             }
        } catch (MqttException e) {  
            e.printStackTrace();  
        }  
    }  
    
    
    
}
