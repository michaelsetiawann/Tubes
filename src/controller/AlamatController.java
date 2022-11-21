/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.DatabaseHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Alamat;

/**
 *
 * @author acer
 */
public class AlamatController {
    private DatabaseHandler conn = new DatabaseHandler();
    private Alamat alamat;
    
    public AlamatController() {
        alamat = new Alamat(0, null, null, null, null);
    }
    
    private Alamat map(ResultSet rs) {
        int id_alamat;
        String nama_tempat;
        String alamat;
        String nama_penerima;
        String no_telp_penerima;
        
        try {
                id_alamat = rs.getInt("id_alamat");
                nama_tempat = rs.getString("nama_tempat");
                alamat = rs.getString("alamat");
                nama_penerima = rs.getString("nama_penerima");
                no_telp_penerima = rs.getString("no_telp_penerima");
                return new Alamat(id_alamat, nama_tempat, alamat, nama_penerima, no_telp_penerima);
        } catch (Exception e) {
            
        }
        return null;
    }
 
    public ArrayList<Alamat> getAll(int id_user) {
        conn.connect();
        ArrayList<Alamat> alamatList = new ArrayList<>();
        int id_alamat;
        String nama_tempat;
        String alamattt;
        String nama_penerima;
        String no_telp_penerima;
        
        try {
                java.sql.Statement stat = conn.con.createStatement();
                ResultSet result = stat.executeQuery("SELECT * FROM alamat WHERE id_user = '3'");
                
                while(result.next()) {
                    id_alamat = result.getInt("id_alamat");
                    nama_tempat = result.getString("nama_tempat");
                    alamattt = result.getString("alamat");
                    nama_penerima = result.getString("nama_penerima");
                    no_telp_penerima = result.getString("no_telepon_penerima");
                    Alamat alamatt = new Alamat(id_alamat, nama_tempat, alamattt, nama_penerima, no_telp_penerima);
                    
                    alamatList.add(alamatt);
                    return alamatList;
                }
        } catch (SQLException e) {
                // TODO: handle exception
        }
        return null;
    }
    
    public void updateAlamat(int id_alamat, int jumlah_barang, String nama_tempat, String alamat, String nama_penerima, String no_telp_penerima) {
        conn.connect();
        try {
            java.sql.Statement stat = conn.con.createStatement();
//            stat.executeUpdate("UPDATE keranjang SET jumlah_barang = '"+jumlah_barang+"' WHERE id_keranjang= '"+id_keranjang+"'");
//            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
                // TODO: handle exception
        }
    }

}
