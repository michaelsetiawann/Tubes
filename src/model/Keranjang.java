/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DatabaseHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author acer
 */
public class Keranjang {

    private int id_keranjang;
    private Barang barang;
    private int jumlah_barang;

    public Keranjang() {
    }
    
    public Keranjang(int id_keranjang, Barang barang, int jumlah_barang) {
        this.id_keranjang = id_keranjang;
        this.barang = barang;
        this.jumlah_barang = jumlah_barang;
    }
    
    public int getId_keranjang() {
        return id_keranjang;
    }

    public void setId_keranjang(int id_keranjang) {
        this.id_keranjang = id_keranjang;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public int getJumlah_barang() {
        return jumlah_barang;
    }

    public void setJumlah_barang(int jumlah_barang) {
        this.jumlah_barang = jumlah_barang;
    }

    @Override
    public String toString() {
        return "Keranjang{" + "id_keranjang=" + id_keranjang + ", barang=" + barang + ", jumlah_barang=" + jumlah_barang + "}\n";
    }

}
