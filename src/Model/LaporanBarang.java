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
public class LaporanBarang {

    int id_laporan;
    int id_barang;
    int id_user;
//    Date tanggal_;aporan;
    String pesan;
    int status;

    @Override
    public String toString() {
        return "LaporanBarang{" + "id_laporan=" + id_laporan + ", id_barang=" + id_barang + ", id_user=" + id_user + ", pesan=" + pesan + ", status=" + status + '}';
    }

    public int getId_laporan() {
        return id_laporan;
    }

    public void setId_laporan(int id_laporan) {
        this.id_laporan = id_laporan;
    }

    public int getId_barang() {
        return id_barang;
    }

    public void setId_barang(int id_barang) {
        this.id_barang = id_barang;
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
