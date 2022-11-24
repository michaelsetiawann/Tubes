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
import javax.swing.JTextArea;

/**
 *
 * @author Lenovo
 */
public class TambahProduk extends JFrame {
    public TambahProduk() {
        JFrame frame = new JFrame("Tambah Produk");
        frame.setSize(1080, 700);
        JPanel contentPane = new JPanel();
        frame.setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 641, 534);
        contentPane = new JPanel();

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("TAMBAH PRODUK");
        lblNewLabel.setBounds(10, 11, 130, 22);
        contentPane.add(lblNewLabel);

        JLabel label1 = new JLabel("Nama Barang");
        label1.setBounds(10, 44, 80, 14);
        contentPane.add(label1);

        JTextField nama_barang = new JTextField();
        nama_barang.setBounds(103, 44, 86, 20);
        contentPane.add(nama_barang);
        nama_barang.setColumns(10);

        JLabel label2 = new JLabel("Stok Barang");
        label2.setBounds(10, 82, 80, 14);
        contentPane.add(label2);
        
        JTextField stok_barang = new JTextField();
        stok_barang.setBounds(103, 75, 86, 20);
        contentPane.add(stok_barang);
        stok_barang.setColumns(10);

        JLabel label3 = new JLabel("Harga Barang");
        label3.setBounds(10, 124, 80, 14);
        contentPane.add(label3);

        JTextField harga_barang = new JTextField();
        harga_barang.setBounds(103, 121, 86, 20);
        contentPane.add(harga_barang);
        harga_barang.setColumns(10);
        
        JLabel label7 = new JLabel("Deskripsi Barang");
        label7.setBounds(10, 200, 105, 14);
        contentPane.add(label7);

        JTextArea deskripsi_barang = new JTextArea();
        deskripsi_barang.setBounds(120, 200, 200, 100);
        contentPane.add(deskripsi_barang);
        

        JButton tambahProduk = new JButton("TAMBAH PRODUK");
        tambahProduk.setBounds(10, 335, 150, 23);
        contentPane.add(tambahProduk);

        JButton btnBack = new JButton("BACK");
        btnBack.setBounds(170, 335, 89, 23);
        contentPane.add(btnBack);

        frame.setVisible(true);
        frame.add(contentPane);

        tambahProduk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (nama_barang.getText().isEmpty() || stok_barang.getText().isEmpty() || harga_barang.getText().isEmpty() || deskripsi_barang.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom wajib diisi!");
                } else {
                    controller.UserController.tambahProduk(nama_barang.getText(), stok_barang.getText(),harga_barang.getText(), deskripsi_barang.getText());
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
