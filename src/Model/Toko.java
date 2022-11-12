/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class Toko {

    int id_toko;
    String nama_toko;
    String alamat_toko;
    String deskripsi_toko;
    boolean status;
    ArrayList<Barang> listBarang = new ArrayList();
    ArrayList<Transaksi> listTransaksi = new ArrayList();

    public Toko(int id_toko, String nama_toko, String alamat_toko, String deskripsi_toko, boolean status) {
        this.id_toko = id_toko;
        this.nama_toko = nama_toko;
        this.alamat_toko = alamat_toko;
        this.deskripsi_toko = deskripsi_toko;
        this.status = status;
    }

    public int getId_toko() {
        return id_toko;
    }

    public void setId_toko(int id_toko) {
        this.id_toko = id_toko;
    }

    public String getNama_toko() {
        return nama_toko;
    }

    public void setNama_toko(String nama_toko) {
        this.nama_toko = nama_toko;
    }

    public String getAlamat_toko() {
        return alamat_toko;
    }

    public void setAlamat_toko(String alamat_toko) {
        this.alamat_toko = alamat_toko;
    }

    public String getDeskripsi_toko() {
        return deskripsi_toko;
    }

    public void setDeskripsi_toko(String deskripsi_toko) {
        this.deskripsi_toko = deskripsi_toko;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<Barang> getListBarang() {
        return listBarang;
    }

    public void setListBarang(ArrayList<Barang> listBarang) {
        this.listBarang = listBarang;
    }

    public ArrayList<Transaksi> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(ArrayList<Transaksi> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }

    @Override
    public String toString() {
        return "Toko{" + "id_toko=" + id_toko + ", nama_toko=" + nama_toko + ", alamat_toko=" + alamat_toko + ", deskripsi_toko=" + deskripsi_toko + ", status=" + status + ", listBarang=" + listBarang + ", listTransaksi=" + listTransaksi + '}';
    }
}
