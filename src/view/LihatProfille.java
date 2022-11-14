/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.DatabaseHandler;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.*;
import model.User;

/**
 *
 * @author acer
 */
public class LihatProfille {
    User user;
    boolean search = false;
    public void searchUser(int index) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM ktp WHERE id_user='" + index + "'");
            if (result.next()) {
                int idUser = result.getInt("id_user");
                String nama = result.getString("nama_lengkap_pembeli");
                Date tglLahir = result.getDate("tanggal_lahir");
                boolean jenisKelamin = result.getBoolean("jenis_kelamin");
                String noTlp = result.getString("no_telepon");
                String email = result.getString("email");
                String username = result.getString("username");
                String password = result.getString("password");

                user = new User(nama, tglLahir, jenisKelamin, noTlp, email, idUser, username, password);
                tampilProfille(user);
                search = true;
            } else {
                JOptionPane.showMessageDialog(null, "User not found.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error occured when connecting to database.");
        }
        conn.disconnect();
    }
    public void tampilProfille(User user){
        JFrame view = new JFrame();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(800, 800);
        
        JLabel []labels = new JLabel[7];
        labels[0] = new JLabel("Nama");
        labels[0].setBounds(80, 100, 120, 25);
        labels[1] = new JLabel("Tanggal lahir");
        labels[0].setBounds(80, 135, 120, 25);
        labels[1] = new JLabel("Jenis Kelamin");
        labels[0].setBounds(80, 170, 120, 25);
        labels[1] = new JLabel("No Telepon");
        labels[0].setBounds(80, 205, 120, 25);
        labels[1] = new JLabel("Email");
        labels[0].setBounds(80, 240, 120, 25);
        labels[1] = new JLabel("Username");
        labels[0].setBounds(80, 275, 120, 25);
        labels[1] = new JLabel("Password");
        labels[0].setBounds(80, 310, 120, 25);
        
        for (JLabel label : labels) {
            view.add(label);
        }
    }
}
