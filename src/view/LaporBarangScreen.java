/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.LaporController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author shyen
 */
public class LaporBarangScreen {
    public LaporBarangScreen(int id_barang,int id_user) {
        tokoScreen(id_barang,id_user);
    }

    private void tokoScreen(int id_toko,int id_user) {

        JFrame frame = new JFrame("Lapor Barang");
        frame.setSize(1080, 720);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        //font 
        Font font1 = new Font("SansSerif", Font.PLAIN, 15);
        Font font2 = new Font("SansSerif", Font.PLAIN, 25);
        
        JLabel lblNewLabel = new JLabel("Laporkan Barang");
        lblNewLabel.setBounds(10, 11, 200, 40);
        lblNewLabel.setFont(font2);
        frame.add(lblNewLabel);
        
        JLabel label1 = new JLabel("masukkan laporan");
        label1.setBounds(10, 44, 300, 40);
        frame.add(label1);

        JTextArea laporan = new JTextArea();
        laporan.setBounds(10, 100, 400, 200);
        frame.add(laporan);
        
        JButton sub = new JButton("submit");
        sub.setBounds(55, 500, 100, 40);
        frame.add(sub);

        JButton back = new JButton("back");
        back.setBounds(205, 500, 100, 40);
        frame.add(back);
        
        
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (laporan.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom wajib diisi!");
                } else {
                    int status =0;
                    String aa = LaporController.insertLaporToko(id_toko, id_user, laporan.getText(),status);   
                    JOptionPane.showMessageDialog(null, aa);
            
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new HomeScreen();
            }
        });
        
        
        
        
        
        
        

    }
}
