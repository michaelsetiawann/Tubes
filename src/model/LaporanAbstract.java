/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author acer
 */
public abstract class LaporanAbstract implements StatusLaporanInterface{
    int id_laporan;
    Date tanggal;
    String komentar;
    int status;
    int id_user;

    public LaporanAbstract() {
    }

    public LaporanAbstract(int id_laporan, Date tanggal, String komentar, int status, int user) {
        this.id_laporan = id_laporan;
        this.tanggal = tanggal;
        this.komentar = komentar;
        this.status = status;
        this.id_user = user;
    }

    

    public int getId_laporan() {
        return id_laporan;
    }

    public void setId_laporan(int id_laporan) {
        this.id_laporan = id_laporan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    

    public int getUser() {
        return id_user;
    }

    public void setUser(int user) {
        this.id_user = user;
    }

    @Override
    public String toString() {
        return "LaporanAbstract{" + "id_laporan=" + id_laporan + ", tanggal=" + tanggal + ", komentar=" + komentar + ", status=" + status + ", user=" + id_user + '}';
    }
}
