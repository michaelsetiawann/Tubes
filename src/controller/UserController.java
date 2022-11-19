/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.DatabaseHandler;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import model.User;

/**
 *
 * @author Lenovo
 */
public class UserController {

    public static String LoginUser(String username, String password) {

        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();

        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            password = s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("select * from  user where username='" + username + "'");
            if (result.next()) {
                if (password.equals(result.getString("password"))) {
                    int id_user = result.getInt("id_user");
                    String userName = result.getString("username");
                    String passWord = result.getString("password");
                    String nama_lengkap_pembeli = result.getString("nama_lengkap_pembeli");
                    String tanggal_lahir = result.getString("tanggal_lahir");
                    String jenis_kelamin = result.getString("jenis_kelamin");
                    String no_telepon = result.getString("no_telepon");
                    String email = result.getString("email");
                    
                    User user = new User(nama_lengkap_pembeli, tanggal_lahir, jenis_kelamin, no_telepon, email, id_user, userName, passWord);
                    SingletonProfile.getInstance().setUser(user);
                    
                    return "Login Berhasil!";
                } else {
                    return "Password Salah!";
                }
            } else {
                return "User tidak ditemukan!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error";
        }
    }
    
    public static String LoginAdmin(String username, String password) {

        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();

        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            password = s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("select * from admin where username='" + username + "'");
            if (result.next()) {
                if (password.equals(result.getString("password"))) {
                    return "Login Berhasil!";
                } else {
                    return "Password Salah!";
                }
            } else {
                return "User tidak ditemukan!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public static void register(String nama_lengkap_pembeli, String tanggal_lahir, String jenis_kelamin, String no_telepon, String email, String username, String password) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String query = "INSERT INTO user(nama_lengkap_pembeli, tanggal_lahir, jenis_kelamin, no_telepon, email, username, password) VALUES(?,?,?,?,?,?,?)";
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            password = s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, nama_lengkap_pembeli);
            stmt.setString(2, tanggal_lahir);
            stmt.setString(3, jenis_kelamin);
            stmt.setString(4, no_telepon);
            stmt.setString(5, email);
            stmt.setString(6, username);
            stmt.setString(7, password);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil melakukan registrasi");

        } catch (SQLException e) {
            if (e.getMessage().contains("'email'")) {
                JOptionPane.showMessageDialog(null, "email sudah digunakan");
            } else if (e.getMessage().contains("'password'")) {
                JOptionPane.showMessageDialog(null, "password sudah digunakan");
            } else {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error fatal pusing!");
            }
        }
    }

    public static String findJK(JRadioButton jk1, JRadioButton jk2) {
        String jk = "";
        if (jk1.isSelected()) {
            jk = "Laki Laki";
        } else if (jk2.isSelected()) {
            jk = "Perempuan";
        }
        return jk;
    }
    
    
}
