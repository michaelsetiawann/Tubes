/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public class LoginUser extends JFrame {

    public LoginUser() {
        JFrame frame = new JFrame("Registrasi");
        frame.setSize(1080, 700);
        JPanel contentPane = new JPanel();
        frame.setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 579, 456);
        contentPane = new JPanel();

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label1 = new JLabel("SELAMAT DATANG DI MENU LOGIN");
        label1.setBounds(190, 46, 269, 25);
        contentPane.add(label1);

        JLabel label2 = new JLabel("USERNAME");
        label2.setBounds(144, 93, 106, 14);
        contentPane.add(label2);

        JTextField username = new JTextField("adminAlpha");
        username.setBounds(265, 90, 111, 20);
        contentPane.add(username);
        username.setColumns(10);

        JLabel label3 = new JLabel("PASSWORD");
        label3.setBounds(144, 142, 94, 14);
        contentPane.add(label3);

        JPasswordField password = new JPasswordField("ayam");
        password.setBounds(265, 139, 111, 20);
        contentPane.add(password);
        password.setColumns(10);

        JCheckBox showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(380, 136, 150, 25);
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

        JLabel label4 = new JLabel("TIDAK PUNYA AKUN?");
        label4.setBounds(144, 247, 200, 14);
        contentPane.add(label4);

        JButton btnRegistrasi = new JButton("REGISTRASI");
        btnRegistrasi.setBounds(144, 272, 106, 23);
        contentPane.add(btnRegistrasi);

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setBounds(287, 197, 89, 23);
        contentPane.add(btnLogin);

        JButton btnBack = new JButton("BACK");
        btnBack.setBounds(270, 272, 106, 23);
        contentPane.add(btnBack);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String loginUser = controller.UserController.LoginUser(username.getText(), password.getText());
                String loginAdmin = controller.UserController.LoginAdmin(username.getText(), password.getText());
                if (loginUser.equals("Login Berhasil!")) {
                    JOptionPane.showMessageDialog(null, "Selamat Datang " + username.getText() + "!!!");
                    new HomeScreen();
                    frame.dispose();
                    //masukin tujuan dibawah
                }
                if (loginAdmin.equals("Login Berhasil!")) {
                    JOptionPane.showMessageDialog(null, "Selamat Datang Admin!!!");
                    new MenuAdmin();
                    frame.dispose();
                    //masukin tujuan dibawah
                } else if (loginUser.equals("Password Salah!")) {
                    JOptionPane.showMessageDialog(null, loginUser);
                    password.setText("");
                    password.requestFocus();
                } else if (loginAdmin.equals("Password Salah!")) {
                    JOptionPane.showMessageDialog(null, loginAdmin);
                    password.setText("");
                    password.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, loginUser);
                    username.setText("");
                    password.setText("");
                    username.requestFocus();
                }
            }
        });

        btnRegistrasi.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                frame.dispose();
                new RegistrasiUser();
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new HomeScreen();
            }
        });

        frame.setVisible(true);
        frame.add(contentPane);
    }

}
