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
public class Toko {

    int id_toko;
    int id_user;
    String nama_toko;
    String alamat_toko;
    String deskripsi_toko;
    String status;

    @Override
    public String toString() {
        return "Toko{" + "id_toko=" + id_toko + ", id_user=" + id_user + ", nama_toko=" + nama_toko + ", alamat_toko=" + alamat_toko + ", deskripsi_toko=" + deskripsi_toko + ", status=" + status + '}';
    }

    public int getId_toko() {
        return id_toko;
    }

    public void setId_toko(int id_toko) {
        this.id_toko = id_toko;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
