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
    
    public static User mengubahData(int index){
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try{
            PreparedStatement stat = conn.con.prepareStatement("UPDATE user SET nama_lengkap_pembeli = ?,tgl = ?,tanggal_lahir = ?,jenis_kelamin = ?,no_telepon = ?,email = ?,username = ?,password = ? WHERE id_user ='"+index+"'");
            stat.setString(1, user.getNama_lengkap());
            stat.setString(2, user.getTanggal_lahir());
            stat.setString(3, user.getJenis_kelamin());
            stat.setString(4, user.getNo_telepon());
            stat.setString(5, user.getEmail());
            stat.setString(6, user.getUsername());
            stat.setString(6, user.getPassword());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil update profille");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error!! Gagal update profille");
        }
        conn.disconnect();
        return user;
    }
}
