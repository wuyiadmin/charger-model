/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zeninfor.tool;

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
public class ClientTest {
    
    
    public static void main(String[] args){
            String topic        = "MQTT Examples";
            String content      = "Message from MqttPublishSample";
            int qos             = 2;
            String broker       = "tcp://iot.eclipse.org:1883";
            String clientId     = "JavaSample";
            MemoryPersistence persistence = new MemoryPersistence();

            try {
                MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
                MqttConnectOptions connOpts = new MqttConnectOptions();
                connOpts.setCleanSession(true);
                System.out.println("Connecting to broker: "+broker);
                sampleClient.setCallback(new MqttCallback(){

                    @Override
                    public void connectionLost(Throwable thrwbl) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void messageArrived(String string, MqttMessage mm) throws Exception {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void deliveryComplete(IMqttDeliveryToken imdt) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
                sampleClient.connect(connOpts);
                System.out.println("Connected");
                System.out.println("Publishing message: "+content);
                MqttMessage message = new MqttMessage(content.getBytes());
                message.setQos(qos);
                sampleClient.publish(topic, message);
                System.out.println("Message published");
//                sampleClient.disconnect();
//                System.out.println("Disconnected");
//                
                while(true){
                    try {
                        Thread.sleep(3000);
                        sampleClient.publish(topic, message);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ClientTest.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println(".");
                }
            } catch(MqttException me) {
                System.out.println("reason "+me.getReasonCode());
                System.out.println("msg "+me.getMessage());
                System.out.println("loc "+me.getLocalizedMessage());
                System.out.println("cause "+me.getCause());
                System.out.println("excep "+me);
                me.printStackTrace();
            }
    
 
    }
}
