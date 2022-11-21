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
import javax.swing.JOptionPane;
import model.User;
import static view.LihatProfille.tampilProfille;

/**
 *
 * @author acer
 */
public class ControlUser {
    static User user;
    static boolean search = false;
    public static User searchUser(int index) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM user WHERE id_user='" + index + "'");
            if (result.next()) {
                int idUser = result.getInt("id_user");
                String nama = result.getString("nama_lengkap_pembeli");
                String tglLahir = result.getString("tanggal_lahir");
                String jenisKelamin = result.getString("jenis_kelamin");
                String noTlp = result.getString("no_telepon");
                String email = result.getString("email");
                String username = result.getString("username");
                String password = result.getString("password");

                user = new User(nama, tglLahir, jenisKelamin, noTlp, email, idUser, username, password);
                search = true;
            } else {
                JOptionPane.showMessageDialog(null, "User not found.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error occured when connecting to database.");
        }
        conn.disconnect();
        return user;
    }
    
    public static User mengubahData(int index, String namaLengkap, String tglLahir, String jenisKelamin, String noTelepon, String email, String username, String password){
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try{
            PreparedStatement stat = conn.con.prepareStatement("UPDATE user SET nama_lengkap_pembeli = ?,tanggal_lahir = ?,jenis_kelamin = ?,no_telepon = ?,email = ?,username = ?,password = ? WHERE id_user ='"+index+"'");
            stat.setString(1, namaLengkap);
            stat.setString(2, tglLahir);
            stat.setString(3, jenisKelamin);
            stat.setString(4, noTelepon);
            stat.setString(5, email);
            stat.setString(6, username);
            stat.setString(7, password);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil update profille");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error!! Gagal update profille");
            System.out.println(e);
        }
        conn.disconnect();
        return user;
    }
}
