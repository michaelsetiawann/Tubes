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
import controller.DateLabelFormatter;
import java.util.Date;
import java.util.Properties;
import javax.swing.*;
import model.User;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author acer
 */
public class LihatProfille {
    static User user;
    static boolean search = false;
    public static void searchUser(int index) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM ktp WHERE id_user='" + index + "'");
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
    public static void tampilProfille(User user){
        JFrame view = new JFrame();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(800, 800);
        
        JLabel []labels = new JLabel[7];
        labels[0] = new JLabel("Nama");
        labels[0].setBounds(80, 100, 120, 25);
        labels[1] = new JLabel("Tanggal lahir");
        labels[1].setBounds(80, 135, 120, 25);
        labels[2] = new JLabel("Jenis Kelamin");
        labels[2].setBounds(80, 170, 120, 25);
        labels[3] = new JLabel("No Telepon");
        labels[3].setBounds(80, 205, 120, 25);
        labels[4] = new JLabel("Email");
        labels[4].setBounds(80, 240, 120, 25);
        labels[5] = new JLabel("Username");
        labels[5].setBounds(80, 275, 120, 25);
        labels[6] = new JLabel("Password");
        labels[6].setBounds(80, 310, 120, 25);
        
        JLabel[] valueLabel = new JLabel[labels.length];
        valueLabel[0] = new JLabel(user.getNama_lengkap());
        valueLabel[0].setBounds(210, 100, 150, 25);
        valueLabel[1] = new JLabel(user.getTanggal_lahir());
        valueLabel[1].setBounds(210, 135, 150, 25);
        valueLabel[2] = new JLabel(user.getJenis_kelamin());
        valueLabel[2].setBounds(210, 170, 150, 25);
        valueLabel[3] = new JLabel(user.getNo_telepon());
        valueLabel[3].setBounds(210, 205, 150, 25);
        valueLabel[4] = new JLabel(user.getEmail());
        valueLabel[4].setBounds(210, 240, 150, 25);
        valueLabel[5] = new JLabel(user.getUsername());
        valueLabel[5].setBounds(210, 275, 150, 25);
        valueLabel[6] = new JLabel(user.getPassword());
        valueLabel[6].setBounds(210, 310, 150, 25);
        
        JTextField txtNama = new JTextField();
        txtNama.setBounds(200, 100, 120, 25);
        txtNama.setText(user.getNama_lengkap());
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl tglLahir = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        tglLahir.setBounds(200, 135, 120, 25);
        JTextField txtJenisKelamin = new JTextField();
        txtJenisKelamin.setBounds(200, 170, 120, 25);
        JTextField txtNoTelepon = new JTextField();
        txtNoTelepon.setBounds(200, 205, 120, 25);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(200, 240, 120, 25);
        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(200, 275, 120, 25);
        JTextField txtPassword = new JTextField();
        txtPassword.setBounds(200, 310, 120, 25);
        
        for (JLabel label : labels) {
            view.add(label);
        }
        for(JLabel value : valueLabel){
            view.add(value);
        }
        view.add(txtNama);
        view.add(tglLahir);
        view.add(txtJenisKelamin);
        view.add(txtNoTelepon);
        view.add(txtEmail);
        view.add(txtUsername);
        view.add(txtPassword);
        view.getContentPane().setLayout(null);
        view.setVisible(true);
    }
    public static void main(String[] args) {
        User user1 = new User("Udin Saepufin ", "2003-01-02", "Pria", "09823164372", "usin@gmail.com", 2211, "DinSAe", "DIDINGANT");
        tampilProfille(user1);
    }
}
