/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class Alamat {
    
    private int id_alamat;
    private String nama_tempat;
    private String alamat;
    private String nama_penerima;
    private String no_telp_penerima;

    public int getId_alamat() {
        return id_alamat;
    }

    public void setId_alamat(int id_alamat) {
        this.id_alamat = id_alamat;
    }

    public String getNama_tempat() {
        return nama_tempat;
    }

    public void setNama_tempat(String nama_tempat) {
        this.nama_tempat = nama_tempat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama_penerima() {
        return nama_penerima;
    }

    public void setNama_penerima(String nama_penerima) {
        this.nama_penerima = nama_penerima;
    }

    public String getNo_telp_penerima() {
        return no_telp_penerima;
    }

    public void setNo_telp_penerima(String no_telp_penerima) {
        this.no_telp_penerima = no_telp_penerima;
    }

    @Override
    public String toString() {
        return "Alamat{" + "id_alamat=" + id_alamat + ", nama_tempat=" + nama_tempat + ", alamat=" + alamat + ", nama_penerima=" + nama_penerima + ", no_telp_penerima=" + no_telp_penerima + '}';
    }
}
