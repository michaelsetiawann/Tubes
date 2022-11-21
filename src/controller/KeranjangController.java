/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.DatabaseHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Barang;
import model.Keranjang;

/**
 *
 * @author acer
 */
public class KeranjangController {

    private DatabaseHandler con = new DatabaseHandler();
    private Keranjang keranjang;

    public void setKeranjang(Keranjang keranjang){
        this.keranjang = keranjang;
    }
    
    public KeranjangController() {
        keranjang = new Keranjang(0, null, 0);
    }
    
    private Barang map(ResultSet rs) {
        int id_barang;
        String nama_barang;
        int stok_barang;
        double harga_barang;
        String deskripsi_barang;
        int jumlah_pengunjung;
        int status;

        try {
                id_barang = rs.getInt("id_barang");
                nama_barang = rs.getString("nama_barang");
                stok_barang = rs.getInt("stok_barang");
                harga_barang = rs.getDouble("harga_barang");
                deskripsi_barang = rs.getString("deskripsi_barang");
                jumlah_pengunjung = rs.getInt("jumlah_pengunjung");
                status = rs.getInt("status");
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
    public ArrayList<Keranjang> getAll(int id_user) {
        con.connect();
        ArrayList<Keranjang> keranjangList = new ArrayList<>();
        try {
                java.sql.Statement stat = con.con.createStatement();
                ResultSet result = stat.executeQuery("SELECT * FROM keranjang WHERE id_user='" + id_user + "'");
                if(result.next()) {
                        Keranjang keranjang = mapKeranjang(result);
                        keranjangList.add(keranjang);
                        return keranjangList;
                }
        } catch (SQLException e) {
                // TODO: handle exception
        }
        return null;
    }
    public Keranjang getKeranjang(int id_keranjang) {
        con.connect();
        ArrayList<Keranjang> keranjangList = new ArrayList<>();
        try {
                java.sql.Statement stat = con.con.createStatement();
                ResultSet result = stat.executeQuery("SELECT * FROM keranjang WHERE id_keranjang='" + id_keranjang + "'");
                if(result.next()) {
                        Keranjang keranjang = mapKeranjang(result);
                        System.out.println(keranjang);
                        return keranjang;
                }
        } catch (SQLException e) {
                // TODO: handle exception
        }
        return null;
    }
    
    public void updateKeranjang(int id_keranjang, int jumlah_barang) {
        con.connect();
        try {
            System.out.println("id_keranjang" + id_keranjang);
            System.out.println("jumlah_barang " + jumlah_barang);
            java.sql.Statement stat = con.con.createStatement();
            stat.executeUpdate("UPDATE keranjang SET jumlah_barang = '"+jumlah_barang+"' WHERE id_keranjang= '"+id_keranjang+"'");
//            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
                // TODO: handle exception
        }
    }

}