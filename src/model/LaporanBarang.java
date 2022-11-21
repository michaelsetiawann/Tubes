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
public class LaporanBarang extends LaporanAbstract{

    int id_barang;

    public LaporanBarang() {
    }

    public LaporanBarang(int id_barang, int id_laporan, Date tanggal, String komentar, int status, int id_user) {
        super(id_laporan, tanggal, komentar, status, id_user);
        this.id_barang = id_barang;
    }

    public int getBarang() {
        return id_barang;
    }

    public void setBarang(Barang barang) {
        this.id_barang = id_barang;
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
        return "LaporanBarang{" + "barang=" + id_barang + '}';
    }
}
