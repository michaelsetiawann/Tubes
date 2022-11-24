/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author acer
 */
public class LaporanToko extends LaporanAbstract{

    int id_toko;

    public LaporanToko() {
    }

    public LaporanToko(int id_toko, int id_laporan, Date tanggal, String komentar, int status, int id_user) {
        super(id_laporan, tanggal, komentar, status, id_user);
        this.id_toko = id_toko;
    }

    public int getToko() {
        return id_toko;
    }

    public void setToko(int toko) {
        this.id_toko = toko;
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
        return "LaporanToko{" + "toko=" + id_toko + '}';
    }
}
