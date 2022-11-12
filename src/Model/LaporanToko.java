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
public class LaporanToko {

    int id_laporan;
    int id_toko;
    int id_user;
//    Date tanggal;
    String pesan;
    int status;

    @Override
    public String toString() {
        return "LaporanToko{" + "id_laporan=" + id_laporan + ", id_toko=" + id_toko + ", id_user=" + id_user + ", pesan=" + pesan + ", status=" + status + '}';
    }

    public int getId_laporan() {
        return id_laporan;
    }

    public void setId_laporan(int id_laporan) {
        this.id_laporan = id_laporan;
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

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
