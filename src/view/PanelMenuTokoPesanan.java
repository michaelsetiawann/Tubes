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
public class PanelMenuTokoPesanan {

    public JPanel getPanelToko(JFrame frame, int enumValue) {
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(Color.GREEN);
        Font font1 = new Font("SansSerif", Font.PLAIN, 15);
        Font font2 = new Font("SansSerif", Font.PLAIN, 25);
        panelMenu.setBounds(0, 0, 1080, 75);
        panelMenu.setLayout(null);
        JButton namaApp = new JButton("Back");
        namaApp.setFont(font2);
        namaApp.setBackground(null);
        namaApp.setBorderPainted(false);
        namaApp.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                frame.dispose();
                new MenuTokoScreen();
            }
        });

        namaApp.setBounds(0, 0, 200, 75);
        panelMenu.add(namaApp);

        JButton semuaPesanan = new JButton("Semua Pesanan");
        semuaPesanan.setBounds(200, 0, 150, 75);
        semuaPesanan.setFont(font1);
        semuaPesanan.setBackground(null);
        semuaPesanan.setBorderPainted(false);
        panelMenu.add(semuaPesanan);

        semuaPesanan.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new KonfirmasiPesananMasukScreen(-1);
                
            }
        });

        JButton pesananBaru = new JButton("Pesanan Baru");
        pesananBaru.setBounds(365, 0, 130, 75);
        panelMenu.add(pesananBaru);
        pesananBaru.setFont(font1);
        pesananBaru.setBackground(null);
        pesananBaru.setBorderPainted(false);
        pesananBaru.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                frame.dispose();
                new KonfirmasiPesananMasukScreen(0);
                
            }
        });
        JButton siapDikirim = new JButton("Siap Dikirim");
        siapDikirim.setBounds(505, 0, 120, 75);
        panelMenu.add(siapDikirim);
        siapDikirim.setFont(font1);
        siapDikirim.setBackground(null);
        siapDikirim.setBorderPainted(false);
        siapDikirim.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                frame.dispose();
                new KonfirmasiPesananMasukScreen(1);
                
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
                frame.dispose();
                new KonfirmasiPesananMasukScreen(2);
                
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
                frame.dispose();
                new KonfirmasiPesananMasukScreen(4);
                
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
                frame.dispose();
                new KonfirmasiPesananMasukScreen(5);
                
            }
        });
        
        
//        switch (enumValue){
//            case -1:
//                semuaPesanan.setBackground(new Color(0,100,0));
//                break;
//            case 0:
//                pesananBaru.setBackground(new Color(0,100,0));
//                break;
//            case 1:
//                siapDikirim.setBackground(new Color(0,100,0));
//                break;
//            case 2:
//                konfirmasi.setBackground(new Color(0,100,0));
//                break;
//            case 3:
//                riwayat.setBackground(new Color(0,100,0));
//                break;
//            case 4:
//                dibatalkan.setBackground(new Color(0,100,0));
//                break;
//            case 5:
//                semuaPesanan.setBackground(new Color(0,100,0));
//                break;
//            default:
//                break;
//        }
        return panelMenu;
    }
}
