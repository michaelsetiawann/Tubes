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
                frame.dispose();
                new HomeScreen();
            }
        });

        namaApp.setBounds(0, 0, 200, 75);
        panelMenu.add(namaApp);

        JButton lihatProduk = new JButton("Semua Pesanan");
        lihatProduk.setBounds(200, 0, 150, 75);
        lihatProduk.setFont(font1);
        lihatProduk.setBackground(null);
        lihatProduk.setBorderPainted(false);
        panelMenu.add(lihatProduk);

        lihatProduk.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new KonfirmasiPesananMasukScreen(-1);
                frame.dispose();
            }
        });

        JButton tambah = new JButton("Pesanan Baru");
        tambah.setBounds(365, 0, 130, 75);
        panelMenu.add(tambah);
        tambah.setFont(font1);
        tambah.setBackground(null);
        tambah.setBorderPainted(false);
        tambah.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                new KonfirmasiPesananMasukScreen(0);
                frame.dispose();
            }
        });
        JButton update = new JButton("Siap Dikirim");
        update.setBounds(505, 0, 120, 75);
        panelMenu.add(update);
        update.setFont(font1);
        update.setBackground(null);
        update.setBorderPainted(false);
        update.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                new KonfirmasiPesananMasukScreen(1);
                frame.dispose();
            }
        });
        JButton konfirmasi = new JButton("Dalam Pengiriman");
        konfirmasi.setBounds(630, 0, 170, 75);
        panelMenu.add(konfirmasi);
        konfirmasi.setFont(font1);
        konfirmasi.setBackground(null);
        konfirmasi.setBorderPainted(false);
        konfirmasi.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new KonfirmasiPesananMasukScreen(2);
                frame.dispose();
            }
        });
        
        JButton riwayat = new JButton("Pesanan Selesai");
        riwayat.setBounds(800, 0, 150, 75);
        panelMenu.add(riwayat);
        riwayat.setFont(font1);
        riwayat.setBackground(null);
        riwayat.setBorderPainted(false);
        riwayat.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                new KonfirmasiPesananMasukScreen(4);
                frame.dispose();
            }
        });
        
        JButton dibatalkan = new JButton("Dibatalkan");
        dibatalkan.setBounds(933, 0, 130, 75);
        panelMenu.add(dibatalkan);
        dibatalkan.setFont(font1);
        dibatalkan.setBackground(null);
        dibatalkan.setBorderPainted(false);
        dibatalkan.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                new KonfirmasiPesananMasukScreen(5);
                frame.dispose();
            }
        });
        
        JButton tambahProduk = new JButton("Tambah Produk");
        tambahProduk.setBounds(500, 200, 130, 25);
        panelMenu.add(tambahProduk);
        tambahProduk.setFont(font1);
        tambahProduk.setBackground(null);
        tambahProduk.setBorderPainted(false);
        tambahProduk.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                new TambahProduk();
                frame.dispose();            
            }
        });
        
        JButton lihatProdukToko = new JButton("Lihat produk2 toko");
        lihatProdukToko.setBounds(500, 300, 130, 25);
        panelMenu.add(lihatProdukToko);
        lihatProdukToko.setFont(font1);
        lihatProdukToko.setBackground(null);
        lihatProdukToko.setBorderPainted(false);
        lihatProdukToko.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {          
            }
        });
        

        return panelMenu;
    }
}
