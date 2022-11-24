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

    private int id_barang;

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

    @Override
    public String toString() {
        return "LaporanBarang{" + "barang=" + id_barang + '}';
    }
}
