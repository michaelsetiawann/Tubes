/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.LaporController.aa;
import database.DatabaseHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String alamatt;
        String nama_penerima;
        String no_telp_penerima;
        
        try {
                id_alamat = rs.getInt("id_alamat");                
                nama_tempat = rs.getString("nama_tempat");                
                alamatt = rs.getString("alamat");                
                nama_penerima = rs.getString("nama_penerima");                
                no_telp_penerima = rs.getString("no_telepon_penerima");
                Alamat x = new Alamat(id_alamat, nama_tempat, alamatt, nama_penerima, no_telp_penerima);
                return x;
        } catch (Exception e) {
            
        }
        return null;
    }
 
    public ArrayList<Alamat> getAll(int id_user) {
        conn.connect();
        ArrayList<Alamat> alamatList = new ArrayList<>();
        
        try {
                java.sql.Statement stat = conn.con.createStatement();
                ResultSet result = stat.executeQuery("SELECT * FROM alamat WHERE id_user = '"+id_user+"'");
                
                while(result.next()) {
                    Alamat alamatt = map(result);
                    alamatList.add(alamatt);
                }
                return alamatList;
        } catch (SQLException e) {
                // TODO: handle exception
        }
        return null;
    }
    
//    public void updateAlamat(int id_alamat, int jumlah_barang, String nama_tempat, String alamat, String nama_penerima, String no_telp_penerima) {
//        conn.connect();
//        try {
//            java.sql.Statement stat = conn.con.createStatement();
////            stat.executeUpdate("UPDATE keranjang SET jumlah_barang = '"+jumlah_barang+"' WHERE id_keranjang= '"+id_keranjang+"'");
////            System.out.println(result);
//        } catch (SQLException e) {
//            e.printStackTrace();
//                // TODO: handle exception
//        }
//    }
//    public void updateAlamat(String nama_tempat, String alamat, String nama_penerima, String no_telp_penerima) {
//        conn.connect();
//        try {
//            java.sql.Statement stat = conn.con.createStatement();
//            stat.executeUpdate("UPDATE keranjang SET jumlah_barang = '"+jumlah_barang+"' WHERE id_keranjang= '"+id_keranjang+"'");
////            System.out.println(result);
//        } catch (SQLException e) {
//            e.printStackTrace();
//                // TODO: handle exception
//        }
//    }
    public void insertAlamat( String nama_tempat, String alamat, String nama_penerima, String no_telp_penerima) {
//        conn.connect();
//        System.out.println("in hereeeeesasdf");
//        int id_user = SingletonProfile.getInstance().getUser().getId();
//        String query = "INSERT INTO alamat (id_user, nama_tempat, alamat, nama_penerima, no_telepon_penerima) VALUES "
//                        + "("+id_user+",'"
//                                        +nama_tempat+"','"
//                                                +alamat+"','"
//                                                        +nama_penerima+"','"
//                                                                +no_telp_penerima
//                        +"')";
//        try {
//            System.out.println("in hereaq34523452354");
//            java.sql.Statement stat = conn.con.createStatement();        
//            System.out.println("check1");
//            stat.executeUpdate(query);
//            System.out.println("cehck2");
////                stmt.executeUpdate();
//        } catch (SQLException e) {
//                // TODO: handle exception
//        }
        conn.connect();
        int id_user = SingletonProfile.getInstance().getUser().getId();
        try {
            String query = "INSERT INTO alamat (id_user, nama_tempat, alamat, nama_penerima, no_telepon_penerima) VALUES (?,?,?,?,?)";
            PreparedStatement state = conn.con.prepareStatement(query);
            state.setInt(1, id_user);
            state.setString(2, nama_tempat);
            state.setString(3, alamat);
            state.setString(4, nama_penerima);
            state.setString(5, no_telp_penerima);
            state.executeUpdate();
//            sout "insert berhasill..";
        } catch (Exception e) {
            e.printStackTrace();
//            return "insert gagal!";
        }
    }

}
