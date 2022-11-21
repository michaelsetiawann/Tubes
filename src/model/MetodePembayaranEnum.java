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
    
    public int getValue(){
        return value;
    }
}
