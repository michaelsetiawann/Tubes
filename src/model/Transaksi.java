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
public class Transaksi {

    int id_transaksi;
    Barang barang;
    int jumlahBarang;
    Date tanggal;
    StatusPengirimanEnum status;
    MetodePembayaranEnum metodePembayaran;
    String pesan_review;
    int rating;

    public Transaksi(int id_transaksi, Barang barang, int jumlahBarang, Date tanggal, StatusPengirimanEnum status, MetodePembayaranEnum metodePembayaran, String pesan_review, int rating) {
        this.id_transaksi = id_transaksi;
        this.barang = barang;
        this.jumlahBarang = jumlahBarang;
        this.tanggal = tanggal;
        this.status = status;
        this.metodePembayaran = metodePembayaran;
        this.pesan_review = pesan_review;
        this.rating = rating;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public StatusPengirimanEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPengirimanEnum status) {
        this.status = status;
    }

    public MetodePembayaranEnum getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(MetodePembayaranEnum metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public String getPesan_review() {
        return pesan_review;
    }

    public void setPesan_review(String pesan_review) {
        this.pesan_review = pesan_review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Transaksi{" + "id_transaksi=" + id_transaksi + ", barang=" + barang + ", jumlahBarang=" + jumlahBarang + ", tanggal=" + tanggal + ", status=" + status + ", metodePembayaran=" + metodePembayaran + ", pesan_review=" + pesan_review + ", rating=" + rating + '}';
    }
    
    
}
