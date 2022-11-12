/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author acer
 */
public abstract class LaporanAbstract {
    int id_laporan;
    Date tanggal;
    String komentar;
    boolean status;
    User user;

    public LaporanAbstract(int id_laporan, Date tanggal, String komentar, boolean status, User user) {
        this.id_laporan = id_laporan;
        this.tanggal = tanggal;
        this.komentar = komentar;
        this.status = status;
        this.user = user;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LaporanAbstract{" + "id_laporan=" + id_laporan + ", tanggal=" + tanggal + ", komentar=" + komentar + ", status=" + status + ", user=" + user + '}';
    }
}
