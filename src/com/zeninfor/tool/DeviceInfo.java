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
public class DeviceInfo {
    
    
    private int socketNumber; //插座编号 
    
    private int socketStatus; //状态
    
    private long power; //功率(W)
    
    private long energy;//已完成电量（W/h）
    
    private long chargeTime;//充电时长   

    /**
     * @return the socketNumber
     */
    public int getSocketNumber() {
        return socketNumber;
    }

    /**
     * @param socketNumber the socketNumber to set
     */
    public void setSocketNumber(int socketNumber) {
        this.socketNumber = socketNumber;
    }

    /**
     * @return the socketStatus
     */
    public int getSocketStatus() {
        return socketStatus;
    }

    /**
     * @param socketStatus the socketStatus to set
     */
    public void setSocketStatus(int socketStatus) {
        this.socketStatus = socketStatus;
    }

    /**
     * @return the power
     */
    public long getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(long power) {
        this.power = power;
    }

    /**
     * @return the energy
     */
    public long getEnergy() {
        return energy;
    }

    /**
     * @param energy the energy to set
     */
    public void setEnergy(long energy) {
        this.energy = energy;
    }

    /**
     * @return the chargeTime
     */
    public long getChargeTime() {
        return chargeTime;
    }

    /**
     * @param chargeTime the chargeTime to set
     */
    public void setChargeTime(long chargeTime) {
        this.chargeTime = chargeTime;
    }
    
   
    
    
}
