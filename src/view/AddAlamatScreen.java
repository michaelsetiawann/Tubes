/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AlamatController;
import database.DatabaseHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.Keranjang;

/**
 *
 * @author Lenovo
 */
public class AddAlamatScreen extends JFrame {

    public AddAlamatScreen(ArrayList<Keranjang> keranjangList) {
        JFrame frame = new JFrame("Registrasi");
        frame.setSize(400, 400);
        JPanel contentPane = new JPanel();
        frame.setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 641, 534);
        contentPane = new JPanel();

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("ADD ALAMAT");
        lblNewLabel.setBounds(10, 11, 130, 22);
        contentPane.add(lblNewLabel);

        JLabel label1 = new JLabel("Nama Tempat");
        label1.setBounds(10, 40, 130, 14);
        contentPane.add(label1);

        JTextField namaTempat = new JTextField();
        namaTempat.setBounds(150, 40, 86, 20);
        contentPane.add(namaTempat);

        JLabel label2 = new JLabel("Alamat");
        label2.setBounds(10, 70, 130, 14);
        contentPane.add(label2);

        JTextField alamat = new JTextField();
        alamat.setColumns(10);
        alamat.setBounds(150, 70, 86, 20);
        contentPane.add(alamat);

        JLabel label3 = new JLabel("Nama Penerima");
        label3.setBounds(10, 100, 130, 14);
        contentPane.add(label3);

        JTextField namaPenerima = new JTextField();
        namaPenerima.setBounds(150, 100, 86, 20);
        contentPane.add(namaPenerima);

        JLabel label4 = new JLabel("No Telepon Penerima");
        label4.setBounds(10, 130, 150, 14);
        contentPane.add(label4);
        
        JTextField noTelp = new JTextField();
        noTelp.setBounds(150, 130, 86, 20);
        contentPane.add(noTelp);

        JButton tambahAlamat = new JButton("Tambah Alamat");
        tambahAlamat.setBounds(10, 170, 150, 30);
        contentPane.add(tambahAlamat);

        JButton btnBack = new JButton("BACK");
        btnBack.setBounds(155, 170, 89, 30);
        contentPane.add(btnBack);

        frame.setVisible(true);
        frame.add(contentPane);

        tambahAlamat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (namaTempat.getText().isEmpty() || alamat.getText().isEmpty() ||  namaPenerima.getText().isEmpty() || noTelp.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom wajib diisi!");
                } else {
                    new AlamatController().insertAlamat(namaTempat.getText(), alamat.getText(), namaPenerima.getText(), noTelp.getText());
                    frame.setVisible(false);
                    new CheckoutScreen(keranjangList);
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new CheckoutScreen(keranjangList);
                frame.setVisible(false);
            }
        });

        frame.setVisible(true);
        frame.add(contentPane);
    }
}

