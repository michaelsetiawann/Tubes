/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author shyen
 */
public class PanelMenuToko {

    public JPanel getPanelToko(JFrame frame) {
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(Color.GREEN);
        Font font1 = new Font("SansSerif", Font.PLAIN, 15);
        Font font2 = new Font("SansSerif", Font.PLAIN, 25);
        panelMenu.setBounds(0, 0, 1080, 75);
        panelMenu.setLayout(null);
        JButton namaApp = new JButton("TOKOMEDIA");
        namaApp.setFont(font2);
        namaApp.setBackground(null);
        namaApp.setBorderPainted(false);
        namaApp.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                frame.setVisible(false);
                new HomeScreen();
            }
        });

        namaApp.setBounds(0, 0, 200, 75);
        panelMenu.add(namaApp);

        JButton lihatProduk = new JButton("Lihat Produk di Toko");
        lihatProduk.setBounds(215, 25, 180, 25);
        lihatProduk.setFont(font1);
        lihatProduk.setBackground(null);
        lihatProduk.setBorderPainted(false);
        panelMenu.add(lihatProduk);

        lihatProduk.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });

        JButton tambah = new JButton("Tambah Produk");
        tambah.setBounds(410, 25, 150, 25);
        panelMenu.add(tambah);
        tambah.setFont(font1);
        tambah.setBackground(null);
        tambah.setBorderPainted(false);
        tambah.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {

            }
        });
        JButton update = new JButton("Update Produk");
        update.setBounds(575, 25, 130, 25);
        panelMenu.add(update);
        update.setFont(font1);
        update.setBackground(null);
        update.setBorderPainted(false);
        update.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {

            }
        });
        JButton konfirmasi = new JButton("Konfirmasi");
        konfirmasi.setBounds(740, 25, 130, 25);
        panelMenu.add(konfirmasi);
        konfirmasi.setFont(font1);
        konfirmasi.setBackground(null);
        konfirmasi.setBorderPainted(false);
        konfirmasi.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {

            }
        });
        
        JButton riwayat = new JButton("Riwayat");
        riwayat.setBounds(880, 25, 130, 25);
        panelMenu.add(riwayat);
        riwayat.setFont(font1);
        riwayat.setBackground(null);
        riwayat.setBorderPainted(false);
        riwayat.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {

            }
        });

        return panelMenu;
    }
}
