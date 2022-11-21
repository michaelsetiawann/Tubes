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
public enum StatusPengirimanEnum {
    MENUNGGU_KONFIRMASI(0), DIPROSES(1), DIKIRIM(2), SAMPAI(3), SELESAI(4);

    private final int value;
    private StatusPengirimanEnum(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
}
