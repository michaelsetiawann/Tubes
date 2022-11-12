/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author shyen
 */
public abstract class PanelScreen {
    JPanel panelMenu = new JPanel();
    public JPanel getPanelMenu(){
        
        Font font1 = new Font("SansSerif", Font.PLAIN, 15);
        Font font2 = new Font("SansSerif", Font.PLAIN, 25);
        panelMenu.setBackground(Color.GREEN);

        panelMenu.setBounds(0,0,1080,75);
        panelMenu.setLayout(null);
        JButton namaApp = new JButton("TOKOMEDIA");
        namaApp.setFont(font2);
        namaApp.setBackground(null);
        namaApp.setBorderPainted(false);
        
        namaApp.setBounds(0, 0, 200, 75);
        panelMenu.add(namaApp);
        
        JButton transaksi = new JButton ("Transaksi");
        transaksi.setBounds(215, 25, 100, 25);
        transaksi.setFont(font1);
        transaksi.setBackground(null);
        transaksi.setBorderPainted(false);
        panelMenu.add(transaksi);
        
        return panelMenu;
    }
    
}
