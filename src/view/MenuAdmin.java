/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SingletonProfile;
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
        view.setLayout(null);
        view.setSize(500, 600);
        view.setLocationRelativeTo(null);
        
        JLabel title = new JLabel("Menu Admin");
        title.setFont(new Font("Serif", Font.PLAIN, 35));
        title.setBounds(160, 50, 240, 30);
        view.add(title);
        
        JButton tokoButton = new JButton("Lihat Laporan Toko");
        tokoButton.setBounds(170, 120, 160, 40);
        view.add(tokoButton);
        
        JButton barangButton = new JButton("Lihat Laporan Barang");
        barangButton.setBounds(170, 180, 160, 40);
        view.add(barangButton);
        
        JButton kembali = new JButton("Keluar Menu Admin");
        kembali.setBounds(170, 240, 160, 40);
        view.add(kembali);
        
        
        kembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeScreen();
                SingletonProfile.getInstance().setUser(null);
                view.dispose();
            }
        });
        
        tokoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new BlokirToko();
                view.dispose();
            }
        });
        
        barangButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new BlokirBarang();
                view.dispose();
            }
        });
        
        view.setVisible(true);
//        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
}
