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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author shyen
 */
public abstract class TemplateScreen {

    static JFrame frame = new JFrame("Tokomedia");

    public JFrame getTemplate() {
        //frame
        frame.setSize(1080, 720);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        //font 
        Font font1 = new Font("SansSerif", Font.PLAIN, 15);
        Font font2 = new Font("SansSerif", Font.PLAIN, 25);
        //panel
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(Color.GREEN);

        panelMenu.setBounds(0, 0, 1080, 75);
        panelMenu.setLayout(null);
        JButton namaApp = new JButton("TOKOMEDIA");
        namaApp.setFont(font2);
        namaApp.setBackground(null);
        namaApp.setBorderPainted(false);

        namaApp.setBounds(0, 0, 200, 75);
        panelMenu.add(namaApp);

        JButton transaksi = new JButton("Transaksi");
        transaksi.setBounds(215, 25, 100, 25);
        transaksi.setFont(font1);
        transaksi.setBackground(null);
        transaksi.setBorderPainted(false);
        panelMenu.add(transaksi);

        JLabel label = new JLabel();
        label.setText("Cari Produk");
        label.setBounds(350, 33, 110, 10);
        panelMenu.add(label);

        JTextField namaBarang = new JTextField();
        namaBarang.setBounds(425, 27, 150, 30);
        panelMenu.add(namaBarang);

        JButton btnCari = new JButton("Klik Cari");
        btnCari.setBounds(580, 20, 150, 40);
        panelMenu.add(btnCari);
        btnCari.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {

                new CariProdukJtable(namaBarang.getText());
            }
        });
        
        frame.add(panelMenu);

        return frame;

    }

    public TemplateScreen() {

    }
}
