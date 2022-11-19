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
import java.util.Vector;

/**
 *
 * @author acer
 */
public class Keranjang {

    private int id_keranjang;
    private Barang barang;
    private int jumlah_barang;
    
    private DatabaseHandler con = new DatabaseHandler();

    public Keranjang() {
    }
    
    public Keranjang(int id_keranjang, Barang barang, int jumlah_barang) {
        this.id_keranjang = id_keranjang;
        this.barang = barang;
        this.jumlah_barang = jumlah_barang;
    }
    private Barang map(ResultSet rs) {
        int id_barang;
        String nama_barang;
        int stok_barang;
        double harga_barang;
        String deskripsi_barang;
        int jumlah_pengunjung;
        boolean status;

        try {
                id_barang = rs.getInt("id_barang");
                nama_barang = rs.getString("nama_barang");
                stok_barang = rs.getInt("stok_barang");
                harga_barang = rs.getDouble("harga_barang");
                deskripsi_barang = rs.getString("deskripsi_barang");
                jumlah_pengunjung = rs.getInt("jumlah_pengunjung");
                status = rs.getBoolean("status");
                return new Barang(id_barang, nama_barang, stok_barang, harga_barang, deskripsi_barang, jumlah_pengunjung,
                                status);
        } catch (Exception e) {

        }
        return null;
    }
  
    public Barang getProductDetails(int id) {
        String query = String.format("SELECT * FROM barang WHERE id_barang=?");
        PreparedStatement preparedStatement = con.prepareStatement(query);
        con.resultSet = null;
        try {
                preparedStatement.setInt(1, id);
                con.resultSet = preparedStatement.executeQuery();
                if(con.resultSet.next()) {
                        Barang barang = map(con.resultSet);
                        return barang;
                }
        } catch (SQLException e) {
                // TODO: handle exception
        }
        return null;
    }
    
    private Keranjang mapKeranjang(ResultSet rs) {
        int id_keranjang;
        Barang barang;
        int jumlah_barang;
        int id_barang;

        try {
                id_keranjang = rs.getInt("id_keranjang");
                jumlah_barang = rs.getInt("jumlah_barang");
                id_barang = rs.getInt("id_barang");
                barang = getProductDetails(id_barang);
//                stok_barang = rs.getInt("stok_barang");
//                harga_barang = rs.getDouble("harga_barang");
//                deskripsi_barang = rs.getString("deskripsi_barang");
//                jumlah_pengunjung = rs.getInt("jumlah_pengunjung");
//                status = rs.getBoolean("status");
                return new Keranjang(id_keranjang, barang, jumlah_barang);
        } catch (Exception e) {

        }
        return null;
    }
    public Vector<Keranjang> getAll(int id_user) {
        con.resultSet = con.execQuery("SELECT * FROM keranjang WHERE id_user=?");
        Vector<Keranjang> keranjangVector = new Vector<>();
        try {
                while (con.resultSet.next()) {
                        Keranjang keranjang = mapKeranjang(con.resultSet);
                        keranjangVector.add(keranjang);
                }
        } catch (Exception e) {
                // TODO: handle exception
        }
        return keranjangVector;
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
        return "Keranjang{" + "id_keranjang=" + id_keranjang + ", barang=" + barang + ", jumlah_barang=" + jumlah_barang + '}';
    }

}
