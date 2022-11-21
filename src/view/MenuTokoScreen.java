/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author shyen
 */
public class MenuTokoScreen {
    public MenuTokoScreen() {
        homeScreen();
    }

    private void homeScreen() {

        JFrame frame = new JFrame("transaksi");
        frame.setSize(1080, 720);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        //font 
        Font font1 = new Font("SansSerif", Font.PLAIN, 15);
        Font font2 = new Font("SansSerif", Font.PLAIN, 25);
        //panel add
        PanelMenuToko menu = new PanelMenuToko();
        JPanel panelMenu = menu.getPanelToko(frame);
        frame.add(panelMenu);

        

        JLabel transaksi2 = new JLabel("ini home screen menu toko");
        transaksi2.setBounds(100, 100, 100, 100);
        frame.add(transaksi2);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
