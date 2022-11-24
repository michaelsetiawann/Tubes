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

    private int id_toko;

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

    @Override
    public String toString() {
        return "LaporanToko{" + "toko=" + id_toko + '}';
    }
}
