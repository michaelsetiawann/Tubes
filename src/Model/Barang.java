/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author acer
 */
public class Barang {

    int id_barang;
    String nama_barang;
    int stok_barang;
    double harga_barang;
    String deskripsi_barang;
    int jumlah_pengunjung;
    boolean status;

    public Barang(int id_barang, String nama_barang, int stok_barang, double harga_barang, String deskripsi_barang, int jumlah_pengunjung, boolean status) {
        this.id_barang = id_barang;
        this.nama_barang = nama_barang;
        this.stok_barang = stok_barang;
        this.harga_barang = harga_barang;
        this.deskripsi_barang = deskripsi_barang;
        this.jumlah_pengunjung = jumlah_pengunjung;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Barang{" + "id_barang=" + id_barang + ", nama_barang=" + nama_barang + ", stok_barang=" + stok_barang + ", harga_barang=" + harga_barang + ", deskripsi_barang=" + deskripsi_barang + ", jumlah_pengunjung=" + jumlah_pengunjung + ", status=" + status + '}';
    }
    
    
}
