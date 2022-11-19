/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.LogoutController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.SingletonProfile;

/**
 *
 * @author shyen
 */
public class PanelMenu {

    public JPanel getPanel(JFrame frame) {
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

        JButton transaksi = new JButton("Transaksi");
        transaksi.setBounds(215, 25, 100, 25);
        transaksi.setFont(font1);
        transaksi.setBackground(null);
        transaksi.setBorderPainted(false);
        panelMenu.add(transaksi);

        
        transaksi.addActionListener(
            new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                if(SingletonProfile.getInstance().getUser() != null)
                {
                    frame.setVisible(false);
                    new TransactionScreen();
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Mohon untuk login terlebih dahulu!");
                }
            }
        });
        
        

        JLabel label = new JLabel();
        label.setText("Cari Produk");
        label.setBounds(350, 33, 110, 10);
        panelMenu.add(label);

        JTextField namaBarang = new JTextField();
        namaBarang.setBounds(425, 27, 150, 30);
        panelMenu.add(namaBarang);
        

        JButton btnCari = new JButton("Klik Cari");
        btnCari.setBounds(600, 30, 100, 20);
        panelMenu.add(btnCari);
        btnCari.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                frame.setVisible(false);
                new CariProdukJtable(namaBarang.getText());
            }
        });
        
        if(SingletonProfile.getInstance().getUser() != null)
        {
            JButton btnLogout = new JButton("Logout");
            btnLogout.setBounds(720, 30, 100, 20);
            panelMenu.add(btnLogout);
            btnLogout.addActionListener(
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae
                ) {
                    frame.setVisible(false);
                     new LogoutController();
                }
            });
        } 
        else
        {
           JButton btnLogin = new JButton("Login");
           btnLogin.setBounds(720, 30, 100, 20);
           panelMenu.add(btnLogin);
           btnLogin.addActionListener(
                   new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae
               ) {
                   frame.setVisible(false);
                   new LoginUser();
               }
           });
        }
       

        return panelMenu;
    }

}
