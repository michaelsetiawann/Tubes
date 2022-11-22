/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.DatabaseHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Barang;

/**
 *
 * @author shyen
 */
public class TokoController {
    static DatabaseHandler aa = new DatabaseHandler();
    
    public static String insertDataToko(String namaToko,String alamat,String deskripsi,int id_user,int status){
        aa.connect();
        try {
            String que = "INSERT INTO toko (nama_toko,alamat_toko,deskripsi_toko,id_user,status,id_toko) VALUES (?,?,?,?,?,?)";
            PreparedStatement state = aa.con.prepareStatement(que);
            state.setString(1, namaToko);
            state.setString(2, alamat);
            state.setString(3, deskripsi);
            state.setInt(4, id_user);
            state.setInt(5, status);
            state.setInt(6, id_user);
            state.executeUpdate();
            return "insert berhasill..";
        } catch (Exception e) {
            e.printStackTrace();
            return "insert gagal!";
        }
    }
     public static boolean checkToko(int id_user){
        aa.connect();
        boolean stat=false;
        try {
            java.sql.Statement state = aa.con.createStatement();
            ResultSet result = state.executeQuery("SELECT id_user FROM toko");
            while (result.next()) {
                if(id_user == result.getInt("id_user")){
                    stat=true;
                    break;
                } else{
                stat=false;
            }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error occured when connecting to database.");
        }
        
        
        return stat;
    }
   
}
