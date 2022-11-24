/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author acer
 */
public class MenuAdmin {
    public MenuAdmin(){
        menampilkanMenu();
    }
    
    public void menampilkanMenu(){
        JFrame view = new JFrame("Menu Admin");
        view.setSize(180, 280);
        
        JLabel title = new JLabel("Menu Admin");
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setBounds(20, 30, 140, 40);
        
        JButton tokoButton = new JButton("Lihat Laporan Toko");
        tokoButton.setBounds(20, 80, 140, 50);
        JButton barangButton = new JButton("Lihat Laporan Barang");
        barangButton.setBounds(20, 140, 140, 50);
        JButton kembali = new JButton("Kembali");
        kembali.setBounds(20, 200, 140, 50);
        
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        kembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeScreen();
                view.dispose();
            }
        });
        
        tokoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new BlokirToko();
            }
        });
        
        barangButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new BlokirBarang();
            }
        });
    }
}
