/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lenovo
 */
public enum MetodePembayaranEnum {
    TRANSFER_BANK(0), COD(1), EMONEY(2);
    
    private final int value;
    private MetodePembayaranEnum(int value){
        this.value = value;
    }
    public static String getStringValueFromInt(int i) {
        for (MetodePembayaranEnum status : MetodePembayaranEnum.values()) {
            if (status.getValue() == i) {
                return status.toString();
            }
        }
        // throw an IllegalArgumentException or return null
        throw new IllegalArgumentException("the given number doesn't match any Status.");
    }
    public int getValue(){
        return value;
    }
}
