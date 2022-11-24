/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author acer
 */
public class Barang {

    private int id_barang;
    private String nama_barang;
    private int stok_barang;
    private double harga_barang;
    private String deskripsi_barang;
    private int jumlah_pengunjung;
    private int status;
    private int id_toko;

    public Barang(int id_barang, String nama_barang, int stok_barang, double harga_barang, String deskripsi_barang, int jumlah_pengunjung, int status, int id_toko) {
        this.id_barang = id_barang;
        this.nama_barang = nama_barang;
        this.stok_barang = stok_barang;
        this.harga_barang = harga_barang;
        this.deskripsi_barang = deskripsi_barang;
        this.jumlah_pengunjung = jumlah_pengunjung;
        this.status = status;
        this.id_toko = id_toko;
    }

    public Barang(int id_barang, String nama_barang, int stok_barang, double harga_barang, String deskripsi_barang, int jumlah_pengunjung, int status) {
        this.id_barang = id_barang;
        this.nama_barang = nama_barang;
        this.stok_barang = stok_barang;
        this.harga_barang = harga_barang;
        this.deskripsi_barang = deskripsi_barang;
        this.jumlah_pengunjung = jumlah_pengunjung;
        this.status = status;
    }

    

    public Barang() {
    }
    
    public int getId_barang() {
        return id_barang;
    }

    public void setId_barang(int id_barang) {
        this.id_barang = id_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public int getStok_barang() {
        return stok_barang;
    }

    public void setStok_barang(int stok_barang) {
        this.stok_barang = stok_barang;
    }

    public double getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(double harga_barang) {
        this.harga_barang = harga_barang;
    }

    public String getDeskripsi_barang() {
        return deskripsi_barang;
    }

    public void setDeskripsi_barang(String deskripsi_barang) {
        this.deskripsi_barang = deskripsi_barang;
    }

    public int getJumlah_pengunjung() {
        return jumlah_pengunjung;
    }

    public void setJumlah_pengunjung(int jumlah_pengunjung) {
        this.jumlah_pengunjung = jumlah_pengunjung;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId_toko() {
        return id_toko;
    }

    public void setId_toko(int id_toko) {
        this.id_toko = id_toko;
    }
    
    

    @Override
    public String toString() {
        return "Barang{" + "id_barang=" + id_barang + ", nama_barang=" + nama_barang + ", stok_barang=" + stok_barang + ", harga_barang=" + harga_barang + ", deskripsi_barang=" + deskripsi_barang + ", jumlah_pengunjung=" + jumlah_pengunjung + ", status=" + status + '}';
    }
    
    
}
