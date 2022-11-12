/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    String alamat;
    String no_telepon;
    String email;
    ArrayList<Alamat> listAlamat = new ArrayList();
    ArrayList<Transaksi> listTransaksi = new ArrayList();
    ArrayList<Keranjang> listKeranjang = new ArrayList();

    public User(int id, String username, String password) {
        super(id, username, password);
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

    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
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
}
