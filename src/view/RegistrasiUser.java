/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.DatabaseHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import controller.DateLabelFormatter;
import controller.SingletonProfile;
import javax.swing.JCheckBox;

/**
 *
 * @author Lenovo
 */
public class RegistrasiUser extends JFrame {

    public RegistrasiUser() {
        JFrame frame = new JFrame("Registrasi");
        frame.setSize(1080, 700);
        JPanel contentPane = new JPanel();
        frame.setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 641, 534);
        contentPane = new JPanel();

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("REGISTRASI");
        lblNewLabel.setBounds(10, 11, 130, 22);
        contentPane.add(lblNewLabel);

        JLabel label1 = new JLabel("Username");
        label1.setBounds(10, 44, 69, 14);
        contentPane.add(label1);

        JTextField username = new JTextField();
        username.setBounds(103, 44, 86, 20);
        contentPane.add(username);
        username.setColumns(10);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(10, 82, 69, 14);
        contentPane.add(label2);

        JPasswordField password = new JPasswordField();
        password.setColumns(10);
        password.setBounds(103, 75, 86, 20);
        contentPane.add(password);

        JCheckBox showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(195, 74, 150, 25);
        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    password.setEchoChar((char) 0);
                } else {
                    password.setEchoChar('???');
                }
            }
        });
        contentPane.add(showPassword);

        JLabel label3 = new JLabel("Nama Lengkap");
        label3.setBounds(10, 124, 86, 14);
        contentPane.add(label3);

        JTextField namaLengkap = new JTextField();
        namaLengkap.setBounds(103, 121, 86, 20);
        contentPane.add(namaLengkap);
        namaLengkap.setColumns(10);

        JLabel label4 = new JLabel("Tanggal Lahir");
        label4.setBounds(10, 163, 86, 14);
        contentPane.add(label4);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl tanggalLahir = new JDatePickerImpl(datePanel, new controller.DateLabelFormatter());
        tanggalLahir.setBounds(103, 160, 86, 20);
        contentPane.add(tanggalLahir);
//        tanggalLahir.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setBounds(10, 204, 46, 14);
        contentPane.add(lblNewLabel_5);

        JLabel label6 = new JLabel("Jenis Kelamin");
        label6.setBounds(10, 204, 86, 14);
        contentPane.add(label6);

        JRadioButton jk1 = new JRadioButton("Laki-Laki");
        jk1.setBounds(103, 195, 109, 23);
        contentPane.add(jk1);

        JRadioButton jk2 = new JRadioButton("Perempuan");
        jk2.setBounds(233, 195, 109, 23);
        contentPane.add(jk2);

        JLabel label7 = new JLabel("Nomor Telepon");
        label7.setBounds(10, 246, 86, 14);
        contentPane.add(label7);

        JTextField noTelepon = new JTextField();
        noTelepon.setBounds(103, 243, 86, 20);
        contentPane.add(noTelepon);
        noTelepon.setColumns(10);

        JLabel label8 = new JLabel("Email");
        label8.setBounds(10, 279, 46, 14);
        contentPane.add(label8);

        JTextField email = new JTextField();
        email.setBounds(103, 276, 86, 20);
        contentPane.add(email);
        email.setColumns(10);

        JButton btnRegis = new JButton("REGISTRASI");
        btnRegis.setBounds(10, 335, 119, 23);
        contentPane.add(btnRegis);

        JButton btnBack = new JButton("BACK");
        btnBack.setBounds(155, 335, 89, 23);
        contentPane.add(btnBack);

        frame.setVisible(true);
        frame.add(contentPane);

        jk1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (jk1.isSelected()) {
                    jk2.setEnabled(false);
                } else {
                    jk2.setEnabled(true);
                }
            }
        });

        jk2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (jk2.isSelected()) {
                    jk1.setEnabled(false);
                } else {
                    jk1.setEnabled(true);
                }
            }

        });

        btnRegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (namaLengkap.getText().isEmpty() || tanggalLahir.getJFormattedTextField().getText().isEmpty() || controller.UserController.findJK(jk1, jk2).isEmpty() || noTelepon.getText().isEmpty() || email.getText().isEmpty() || username.getText().isEmpty() || password.getPassword().equals("")) {
                    JOptionPane.showMessageDialog(null, "Semua kolom wajib diisi!");
                } else {
                    controller.UserController.register(namaLengkap.getText(), tanggalLahir.getJFormattedTextField().getText(), controller.UserController.findJK(jk1, jk2), noTelepon.getText(), email.getText(), username.getText(), password.getText());
                    controller.UserController.LoginUser(username.getText(), password.getText());
                    new HomeScreen();
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new HomeScreen();
            }
        });

        frame.setVisible(true);
        frame.add(contentPane);
    }
}
