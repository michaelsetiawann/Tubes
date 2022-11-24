/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.SingletonProfile;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.User;

/**
 *
 * @author shyen
 */
public class RegistrasiTokoScreen {
    public RegistrasiTokoScreen() {
        regScreen();
    }

    private void regScreen() {

        JFrame frame = new JFrame("registrasi toko");
        frame.setSize(1080, 720);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        //font
        Font font1 = new Font("Arial", Font.PLAIN, 15);
        Font font2 = new Font("Arial", Font.PLAIN, 35);

        //Nama toko
        JLabel namaLab = new JLabel("Nama Toko:");
        namaLab.setBounds(15, 80, 150, 40);
        namaLab.setFont(font1);
        frame.add(namaLab);

        JTextField namaToko = new JTextField();
        namaToko.setBounds(175, 80, 200, 40);
        frame.add(namaToko);

        //Alamat toko
        JLabel alamatLab = new JLabel("Alamat Toko:");
        alamatLab.setBounds(15, 130, 150, 40);
        alamatLab.setFont(font1);
        frame.add(alamatLab);

        JTextArea alamat = new JTextArea();
        alamat.setBounds(175, 130, 300, 100);
        frame.add(alamat);

        //deskripsi toko
        JLabel tokoLab = new JLabel("Deskripsi Toko:");
        tokoLab.setBounds(15, 280, 250, 40);
        tokoLab.setFont(font1);
        frame.add(tokoLab);
        
        JTextArea toko = new JTextArea();
        toko.setBounds(175, 280, 300, 200);
        frame.add(toko);

        JButton reg = new JButton("registrasi");
        reg.setBounds(55, 500, 100, 40);
        frame.add(reg);

        JButton back = new JButton("back");
        back.setBounds(205, 500, 100, 40);
        frame.add(back);
        
        
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (namaToko.getText().isEmpty() || alamat.getText().isEmpty() || toko.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom wajib diisi!");
                } else {
                    User user = SingletonProfile.getInstance().getUser();
                    int user_id = user.getId();
                    int status =0; //default 0
                    JOptionPane.showMessageDialog(null, controller.TokoController.insertDataToko(namaToko.getText(),alamat.getText(),toko.getText(),user_id,status));
                    frame.dispose();
                    new HomeScreen();
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new HomeScreen();
            }
        });

    }
}
