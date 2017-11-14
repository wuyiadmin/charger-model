/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zeninfor.chager;

import com.zeninfor.tool.DeviceSocketStatus;
import com.zeninfor.tool.MessageUtils;
import com.zeninfor.tool.MqClient;
import com.zeninfor.tool.StringUtils;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author WY
 */
public class EmulatorFrame extends javax.swing.JFrame {

    /**
     * Creates new form EmulatorFrame
     */
    public EmulatorFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayPanel = new javax.swing.JPanel();
        displayTxt = new javax.swing.JTextField();
        buttonPanel = new javax.swing.JPanel();
        ICButton = new javax.swing.JButton();
        socketButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        payButton = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        labNumber = new javax.swing.JLabel();
        txtCardNumber = new javax.swing.JTextField();
        btnCardOK = new javax.swing.JButton();
        butLog = new javax.swing.JButton();
        btnCardQuery = new javax.swing.JButton();
        txtInfo = new javax.swing.JLabel();
        connectPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        btnDisconnect = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemConfig = new javax.swing.JMenuItem();
        menuItemCode = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        displayTxt.setFont(new java.awt.Font("仿宋", 0, 48)); // NOI18N
        displayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        displayTxt.setText("8.8.8.8.");
        displayTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        displayTxt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        displayTxt.setEnabled(false);

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(displayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        displayPanelLayout.setVerticalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(displayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        ICButton.setBackground(new java.awt.Color(204, 204, 204));
        ICButton.setText("I C");
        ICButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ICButtonActionPerformed(evt);
            }
        });

        socketButton.setBackground(new java.awt.Color(204, 204, 204));
        socketButton.setText("Socket");
        socketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                socketButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(204, 204, 204));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        payButton.setBackground(new java.awt.Color(204, 204, 204));
        payButton.setText("Pay");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(socketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(ICButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ICButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(socketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        cardPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cardPanel.setToolTipText("IC卡");

        labNumber.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        labNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        txtCardNumber.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N

        btnCardOK.setBackground(new java.awt.Color(204, 204, 204));
        btnCardOK.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        btnCardOK.setText("充电");
        btnCardOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardOKActionPerformed(evt);
            }
        });

        butLog.setBackground(new java.awt.Color(204, 204, 204));
        butLog.setText("Log");
        butLog.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        butLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLogActionPerformed(evt);
            }
        });

        btnCardQuery.setBackground(new java.awt.Color(204, 204, 204));
        btnCardQuery.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        btnCardQuery.setText("余额");
        btnCardQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardQueryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cardPanelLayout = new javax.swing.GroupLayout(cardPanel);
        cardPanel.setLayout(cardPanelLayout);
        cardPanelLayout.setHorizontalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butLog)
                .addGap(22, 22, 22))
            .addGroup(cardPanelLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(labNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cardPanelLayout.createSequentialGroup()
                        .addComponent(btnCardOK, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCardQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        cardPanelLayout.setVerticalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCardOK)
                    .addComponent(btnCardQuery))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(butLog)
                .addContainerGap())
        );

        txtInfo.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N

        connectPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel2.setText("UserName:");

        txtUserName.setText("1011743000001");

        jLabel3.setText("Password:");

        txtPassword.setText("17430001");

        btnConnect.setBackground(new java.awt.Color(204, 204, 204));
        btnConnect.setText("连 接");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        jLabel4.setText("Host:");

        txtHost.setText("tcp://106.14.95.2:1883");

        btnDisconnect.setBackground(new java.awt.Color(204, 204, 204));
        btnDisconnect.setText("断 开");
        btnDisconnect.setEnabled(false);
        btnDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisconnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout connectPanelLayout = new javax.swing.GroupLayout(connectPanel);
        connectPanel.setLayout(connectPanelLayout);
        connectPanelLayout.setHorizontalGroup(
            connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(connectPanelLayout.createSequentialGroup()
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtHost))
                .addGap(26, 26, 26)
                .addComponent(btnConnect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDisconnect)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        connectPanelLayout.setVerticalGroup(
            connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, connectPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConnect)
                    .addComponent(btnDisconnect))
                .addContainerGap())
        );

        jMenu1.setText("配置");

        menuItemConfig.setText("参数配置");
        jMenu1.add(menuItemConfig);

        menuItemCode.setText("设备二维码");
        menuItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCodeActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemCode);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(txtInfo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(displayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(connectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(connectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(displayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtInfo))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCardOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardOKActionPerformed
        // TODO add your handling code here:
        if(deviceStatus.isEmpty()){
            JOptionPane.showMessageDialog(null, "请确认设备已连接到服务器！", "提示消息",JOptionPane.ERROR_MESSAGE); 
            return;
        }
        if(currentButton != BUTTON_IC){
            JOptionPane.showMessageDialog(null, "未选择IC卡操作！", "错误提示",JOptionPane.ERROR_MESSAGE); 
            return ;
        }
        //刷卡请求充电
        String cardNumber = this.txtCardNumber.getText();
        if(StringUtils.isBlack(cardNumber)){
            JOptionPane.showMessageDialog(null, "请输入IC卡号！", "错误提示",JOptionPane.ERROR_MESSAGE); 
            return ;
        }
        if(currentSocket == null){
            JOptionPane.showMessageDialog(null, "未选择任何插座！", "错误提示",JOptionPane.ERROR_MESSAGE); 
            return ;
        }
        String msg = MessageUtils.getRequestCardChargerData(currentSocket, cardNumber);
        try {
            client.publishMessage(msg);
        } catch (MqttException ex) {
            Logger.getLogger(EmulatorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        logFrame.addLogTxt("卡号：" + cardNumber + " 请求在 "+currentSocket+" 号插座充电!");
    }//GEN-LAST:event_btnCardOKActionPerformed

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        // TODO add your handling code here:
        if(initConnectInfo()){        
            if(client.connect()){
                this.btnConnect.setEnabled(false);
                this.btnDisconnect.setEnabled(true);
                JOptionPane.showMessageDialog(null, "连接服务器成功！", "提示消息",JOptionPane.INFORMATION_MESSAGE); 
                //初始化插座位
                initSocketStatus();
                //初始化上报设备状态线程
                upstreamDeviceStatus();
            }else{
                JOptionPane.showMessageDialog(null, "连接服务器失败，请确认连接信息！", "提示消息",JOptionPane.ERROR_MESSAGE); 
            }
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisconnectActionPerformed
        // TODO add your handling code here:
        client.disconnect();
        //清除状态数据
        deviceStatus.clear();
        
        this.btnConnect.setEnabled(true);
        this.btnDisconnect.setEnabled(false);
        //取消选择
        this.checkedButton(0);
        //上发状态线程停止
        threadFlag = false;
        
        JOptionPane.showMessageDialog(null, "连接已断开！", "提示消息",JOptionPane.INFORMATION_MESSAGE); 
    }//GEN-LAST:event_btnDisconnectActionPerformed

    private void socketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_socketButtonActionPerformed
        // TODO add your handling code here:
        //当前操作第一个按钮
        currentButton = BUTTON_SOCKET;
        if(deviceStatus.isEmpty()){
            JOptionPane.showMessageDialog(null, "请确认设备已连接到服务器！", "提示消息",JOptionPane.ERROR_MESSAGE); 
            return;
        }
        if(currentSocket == null){
            for(int i = 1 ; i <= deviceStatus.size() ; i++){
                if(deviceStatus.get(i).equals(DeviceSocketStatus.FREE.value())){
                    currentSocket = i;
                    break;
                }
            }
        }else{
            boolean flag = false;
            for(int i = currentSocket + 1 ; i <= deviceStatus.size() ; i++){
                if(deviceStatus.get(i).equals(DeviceSocketStatus.FREE.value())){
                    currentSocket = i;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                for(int i = 1 ; i <= currentSocket ; i++){
                    if(deviceStatus.get(i).equals(DeviceSocketStatus.FREE.value())){
                        currentSocket = i;
                        break;
                    }
                }
            }
        }
        //显示空闲插座号
        this.displayTxt.setText(currentSocket+"");
        logFrame.addLogTxt("已切换到空闲插座"+currentSocket);
        //更改为选中
        checkedButton(BUTTON_SOCKET);
    }//GEN-LAST:event_socketButtonActionPerformed

    private void butLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLogActionPerformed
        // TODO add your handling code here:
        if(logFrame.isVisible()){
            //防止小化了
            logFrame.setExtendedState(Frame.NORMAL);
            //激活窗体
            logFrame.toFront();            
        }else{
            logFrame.setLocationRelativeTo(null);
            logFrame.setVisible(true);
        }
    }//GEN-LAST:event_butLogActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        if(deviceStatus.isEmpty()){
            JOptionPane.showMessageDialog(null, "请确认设备已连接到服务器！", "提示消息",JOptionPane.ERROR_MESSAGE); 
            return;
        }
        labNumber.setText("");
        logFrame.addLogTxt("取消当前操作");
        currentButton = null;
        //清除操作按钮选择
        checkedButton(0);

    }//GEN-LAST:event_cancelButtonActionPerformed

    private void ICButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ICButtonActionPerformed
        // TODO add your handling code here:
        if(deviceStatus.isEmpty()){
            JOptionPane.showMessageDialog(null, "请确认设备已连接到服务器！", "提示消息",JOptionPane.ERROR_MESSAGE); 
            return;
        }
        labNumber.setText("IC卡号：");
        logFrame.addLogTxt("当前切换到IC卡操作方式");
        //当前操作第二个按钮
        currentButton = BUTTON_IC;
        //更改为选中
        checkedButton(BUTTON_IC);
    }//GEN-LAST:event_ICButtonActionPerformed

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payButtonActionPerformed
        // TODO add your handling code here:
        if(deviceStatus.isEmpty()){
            JOptionPane.showMessageDialog(null, "请确认设备已连接到服务器！", "提示消息",JOptionPane.ERROR_MESSAGE); 
            return;
        }
        labNumber.setText("付款码编号：");
        logFrame.addLogTxt("当前切换到付款码支付充电方式");
        //当前操作第三个按钮
        currentButton = BUTTON_PAY;
        //更改为选中
        checkedButton(BUTTON_PAY);
    }//GEN-LAST:event_payButtonActionPerformed

    private void btnCardQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardQueryActionPerformed
        // TODO add your handling code here:
        if(deviceStatus.isEmpty()){
            JOptionPane.showMessageDialog(null, "请确认设备已连接到服务器！", "提示消息",JOptionPane.ERROR_MESSAGE); 
            return;
        }
         if(currentButton != BUTTON_IC){
            JOptionPane.showMessageDialog(null, "未选择IC卡操作！", "错误提示",JOptionPane.ERROR_MESSAGE); 
            return ;
        }
        //刷卡请求查询余额
        String cardNumber = this.txtCardNumber.getText();
        if(StringUtils.isBlack(cardNumber)){
            JOptionPane.showMessageDialog(null, "请输入IC卡号！", "错误提示",JOptionPane.ERROR_MESSAGE); 
            return ;
        }
        String msg = MessageUtils.getQueryCardBalanceData(cardNumber);
        try {
            client.publishMessage(msg);
        } catch (MqttException ex) {
            Logger.getLogger(EmulatorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        logFrame.addLogTxt("卡号：" + cardNumber + " 请求查询余额!");
    }//GEN-LAST:event_btnCardQueryActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed

    private void menuItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCodeActionPerformed
        // TODO add your handling code here:
        if(StringUtils.isBlack(this.txtUserName.getText())){
             JOptionPane.showMessageDialog(null, "请输入设备编号！", "错误提示",JOptionPane.ERROR_MESSAGE); 
        }
        showCode(this.txtUserName.getText());
    }//GEN-LAST:event_menuItemCodeActionPerformed

    
     
    
    /**
     * 显示二维码
     * @param number 
     */
    public void showCode(String number) {
        if (codeFrame == null) {
            codeFrame = new JFrame();
            codeFrame.setTitle("二维码");
            codeFrame.setSize(400, 450);
            // 设置显示的位置
            int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
            codeFrame.setLocation((screen_width - codeFrame.getWidth()) / 2, (screen_height - codeFrame.getHeight()) / 2);
            codeFrame.setLocationRelativeTo(null);
            codePanel = new JPanel();
        }
        String code = "http://charger.j1st.io/qrcode?deviceNumber="+number;
        String path = "code.png";
        ImageIcon icon = new ImageIcon(StringUtils.encode(code, path, 400, 400));
        codeLab.setIcon(icon);
        codeLab.setSize(400, 400);
        codeLab.repaint();
        codePanel.add(codeLab);
        codePanel.setOpaque(false);

        codeFrame.add(codePanel);
        codeFrame.setVisible(true);
    }
    
    /**
     * 初始化连接配置
     */
    public boolean initConnectInfo(){
        String host = this.txtHost.getText().trim();
        String userName = this.txtUserName.getText().trim();
        String password = this.txtPassword.getText().trim();
        if(StringUtils.isBlack(host)){
            JOptionPane.showMessageDialog(null, "请输入连接主机信息！", "提示消息",JOptionPane.WARNING_MESSAGE); 
            return false;
        }
        if(StringUtils.isBlack(userName)){
            JOptionPane.showMessageDialog(null, "请输入连接名称！", "提示消息",JOptionPane.WARNING_MESSAGE); 
            return false;
        }
        if(StringUtils.isBlack(password)){
            JOptionPane.showMessageDialog(null, "请输入连接密码！", "提示消息",JOptionPane.WARNING_MESSAGE); 
            return false;
        }
        client.host = host;
        client.clientId = userName;
        client.userName = userName;
        client.passWord = password;
        return true;
    }
    
    
    /**
     * 定时上报设备的状态
     */
    public void upstreamDeviceStatus(){
        upstreamDeviceStatusThread = new Thread(){
           @Override
           public void run() {
              // compute primes larger than minPrime
                while(true){
                    if(threadFlag){
                        try {
                            Thread.sleep(60 * 1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EmulatorFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         //上发设备状态到平台
                         String upstreamDeviceStatusData = MessageUtils.getUpstreamDeviceStatusData(deviceStatus);
//                         try {
//                             client.publishMessage(upstreamDeviceStatusData);
//                         } catch (MqttException ex) {
//                             Logger.getLogger(EmulatorFrame.class.getName()).log(Level.SEVERE, null, ex);
//                         }
                    }
               }
            }  
        };
        upstreamDeviceStatusThread.start();
    }
    
    
    /**
     * 初始化插座的状态为空闲中
     */
    public void initSocketStatus(){
        deviceStatus.put(1, DeviceSocketStatus.FREE.value());
        deviceStatus.put(2, DeviceSocketStatus.FREE.value());
        deviceStatus.put(3, DeviceSocketStatus.CHARGING.value());
        deviceStatus.put(4, DeviceSocketStatus.FREE.value());
        deviceStatus.put(5, DeviceSocketStatus.FREE.value());
        deviceStatus.put(6, DeviceSocketStatus.FREE.value());
        deviceStatus.put(7, DeviceSocketStatus.FREE.value());
        deviceStatus.put(8, DeviceSocketStatus.FREE.value());
        deviceStatus.put(9, DeviceSocketStatus.FREE.value());
        deviceStatus.put(10, DeviceSocketStatus.FREE.value());
    }
    
    /**
     * 修改显示内容
     */
    public void setDisplayTxt(String txt){
        this.displayTxt.setText(txt);
    }
    
    /**
     * 断开连接
     */
    public void disconnectServer(){
        //清除状态数据
        deviceStatus.clear();
        
        this.btnConnect.setEnabled(true);
        this.btnDisconnect.setEnabled(false);
        //取消选择
        this.checkedButton(0);
        //上发状态线程停止
        threadFlag = false;
    }
    
    
    //操作按钮的颜色
    public void checkedButton(Integer btn){
        if(btn == BUTTON_SOCKET){
            socketButton.setBackground(checkedColor);
            ICButton.setBackground(backColor);
            payButton.setBackground(backColor);
        }else if(btn == BUTTON_IC){
            socketButton.setBackground(backColor);
            ICButton.setBackground(checkedColor);
            payButton.setBackground(backColor);
        }else if(btn == BUTTON_PAY){
            socketButton.setBackground(backColor);
            ICButton.setBackground(backColor);
            payButton.setBackground(checkedColor);
        }else{
            socketButton.setBackground(backColor);
            ICButton.setBackground(backColor);
            payButton.setBackground(backColor);
        }
    }
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(EmulatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(EmulatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(EmulatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EmulatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        emulatorFrame = new EmulatorFrame();
//        emulatorFrame.setLocationRelativeTo(null);
//        emulatorFrame.setVisible(true);
//    }
    
    
    //Button Color
    Color backColor = new Color(204,204,204);
    Color checkedColor = Color.GREEN;
    
    //MqClient 对象
    public static MqClient client = new MqClient();
    //定时上发设备状态线程
    Thread upstreamDeviceStatusThread;
    public static boolean threadFlag = true;
    
    //定义插座
    public static Map<Integer,Integer> deviceStatus = new TreeMap<>();
    //按钮切换当前插座号（默认无）
    Integer currentSocket = null;
    //当前操作的按钮编号 （1，2，3，4）
    Integer currentButton = null;
    
    //按钮定义
    final Integer BUTTON_SOCKET = 1;
    final Integer BUTTON_IC = 2;
    final Integer BUTTON_PAY = 3;
    
    //主窗体对象
    public static EmulatorFrame emulatorFrame = null;
   //日志窗口
    public static LogFrame logFrame = new LogFrame();
    
    
    //显示二维码
    public JFrame codeFrame = null;
    // 显示二给码的窗体
    public JPanel codePanel;
    JLabel codeLab = new JLabel();
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ICButton;
    private javax.swing.JButton btnCardOK;
    private javax.swing.JButton btnCardQuery;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnDisconnect;
    private javax.swing.JButton butLog;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JPanel connectPanel;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JTextField displayTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labNumber;
    private javax.swing.JMenuItem menuItemCode;
    private javax.swing.JMenuItem menuItemConfig;
    private javax.swing.JButton payButton;
    private javax.swing.JButton socketButton;
    private javax.swing.JTextField txtCardNumber;
    private javax.swing.JTextField txtHost;
    private javax.swing.JLabel txtInfo;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}