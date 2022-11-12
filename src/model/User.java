/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author acer
 */
public class User extends PersonAbstract{

    String nama_lengkap;
    Date tanggal_lahir;
    boolean jenis_kelamin;
    String no_telepon;
    String email;
    ArrayList<Alamat> listAlamat = new ArrayList();
    ArrayList<Transaksi> listTransaksi = new ArrayList();
    ArrayList<Keranjang> listKeranjang = new ArrayList();

    public User(int id, String username, String password) {
        super(id, username, password);
    }
    public User(){
        
    }
    public User(String nama_lengkap, Date tanggal_lahir, boolean jenis_kelamin, String no_telepon, String email, int id, String username, String password) {
        super(id, username, password);
        this.nama_lengkap = nama_lengkap;
        this.tanggal_lahir = tanggal_lahir;
        this.jenis_kelamin = jenis_kelamin;
        this.no_telepon = no_telepon;
        this.email = email;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public boolean isJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(boolean jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Alamat> getListAlamat() {
        return listAlamat;
    }

    public void setListAlamat(ArrayList<Alamat> listAlamat) {
        this.listAlamat = listAlamat;
    }

    public ArrayList<Transaksi> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(ArrayList<Transaksi> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }

    public ArrayList<Keranjang> getListKeranjang() {
        return listKeranjang;
    }

    public void setListKeranjang(ArrayList<Keranjang> listKeranjang) {
        this.listKeranjang = listKeranjang;
    }

    @Override
    public String toString() {
        return "User{" + "nama_lengkap=" + nama_lengkap + ", tanggal_lahir=" + tanggal_lahir + ", jenis_kelamin=" + jenis_kelamin + ", no_telepon=" + no_telepon + ", email=" + email + ", listAlamat=" + listAlamat + ", listTransaksi=" + listTransaksi + ", listKeranjang=" + listKeranjang + '}';
    }
}
