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
import java.util.Date;
import javax.swing.JOptionPane;
import model.Barang;
import model.LaporanBarang;
import model.LaporanToko;
import model.User;

/**
 *
 * @author shyen
 */
public class LaporController {

    static DatabaseHandler aa = new DatabaseHandler();

    public static String insertLaporToko(int id_toko, int id_user,String pesan, int status) {
        aa.connect();
        try {
            String que = "INSERT INTO laporan_toko (id_toko,id_user,tanggal,pesan,status) VALUES (?,?,NOW(),?,?)";
            PreparedStatement state = aa.con.prepareStatement(que);
            state.setString(3, pesan);
            state.setInt(2, id_user);
            state.setInt(1, id_toko);
            state.setInt(4, status);
            state.executeUpdate();
            return "insert berhasill..";
        } catch (Exception e) {
            e.printStackTrace();
            return "insert gagal!";
        }
    }
    public static String insertLaporBarang(int id_barang, int id_user,String pesan, int status) {
        aa.connect();
        try {
            String que = "INSERT INTO laporan_barang (id_barang,id_user,tanggal,pesan,status) VALUES (?,?,NOW(),?,?)";
            PreparedStatement state = aa.con.prepareStatement(que);
            state.setString(3, pesan);
            state.setInt(2, id_user);
            state.setInt(1, id_barang);
            state.setInt(4, status);
            state.executeUpdate();
            return "insert berhasill..";
        } catch (Exception e) {
            e.printStackTrace();
            return "insert gagal!";
        }
    }
    public static ArrayList<LaporanBarang> getLaporBarang() {
        aa.connect();
        ArrayList<LaporanBarang> listLaporanBarang = new ArrayList<>();
        try {
            java.sql.Statement state = aa.con.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM laporan_barang");
            while(result.next()){
                int id_laporan = result.getInt("id_laporan");
                int id_barang = result.getInt("id_barang");
                int id_user = result.getInt("id_user");
                Date tanggal = result.getDate("tanggal");
                String pesan = result.getString("pesan");
                int status = result.getInt("status");
                
                LaporanBarang laporan = new LaporanBarang(id_barang,id_laporan, tanggal, pesan, status, id_user);
                listLaporanBarang.add(laporan);                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error occured when connecting to database.");
        }
        return listLaporanBarang;
    }
    
    public static ArrayList<LaporanToko> getLaporToko() {
        aa.connect();
        ArrayList<LaporanToko> listLaporanBarang = new ArrayList<>();
        try {
            java.sql.Statement state = aa.con.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM laporan_toko");
            while(result.next()){
                int id_laporan = result.getInt("id_laporan");
                int id_toko = result.getInt("id_toko");
                int id_user = result.getInt("id_user");
                Date tanggal = result.getDate("tanggal");
                String pesan = result.getString("pesan");
                int status = result.getInt("status");
                
                LaporanToko laporan = new LaporanToko(id_toko,id_laporan, tanggal, pesan, status, id_user);
                listLaporanBarang.add(laporan);                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error occured when connecting to database.");
        }
        return listLaporanBarang;
    }
    
    public static void approveLaporanBarang (int id_laporan, int status){
        aa.connect();
        try{
            PreparedStatement state = aa.con.prepareStatement("UPDATE laporan_barang SET status = '"+status+"' WHERE id_laporan = '"+id_laporan+"'");
            state.executeUpdate();
            System.out.println("Berhasil update");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error occured when connecting to database.");
        }
    }
    public static void approveLaporanToko (int id_laporan, int status){
        aa.connect();
        try{
            PreparedStatement state = aa.con.prepareStatement("UPDATE laporan_toko SET status = '"+status+"' WHERE id_laporan = '"+id_laporan+"'");
            state.executeUpdate();
            System.out.println("Berhasil update");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error occured when connecting to database.");
        }
    }
}
