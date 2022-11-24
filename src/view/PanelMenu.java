/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.LogoutController;
import controller.SingletonBarang;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Barang;
import controller.TokoController;
import javax.swing.Icon;
import javax.swing.ImageIcon;

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
        panelMenu.setBounds(0, 1, 1080, 75);
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

        namaApp.setBounds(0, 2, 200, 75);
        panelMenu.add(namaApp);

        JButton transaksi = new JButton("Transaksi");
        transaksi.setBounds(200, 2, 120, 75);
        transaksi.setFont(font1);
        transaksi.setBackground(null);
        transaksi.setBorderPainted(false);
        panelMenu.add(transaksi);

        transaksi.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (SingletonProfile.getInstance().getUser() != null) {
                    frame.setVisible(false);
                    new TransactionScreen();
                } else {
                    JOptionPane.showMessageDialog(null, "Mohon untuk login terlebih dahulu!");
                }
            }
        });

        JLabel label = new JLabel();
        label.setText("Cari Produk");
        label.setBounds(350, 33, 110, 13);
        panelMenu.add(label);

        JTextField namaBarang = new JTextField();
        namaBarang.setBounds(425, 27, 150, 30);
        panelMenu.add(namaBarang);

        JButton btnCari = new JButton("🔍");
        btnCari.setBounds(570, 3, 60, 75);
        btnCari.setFont(font2);
        btnCari.setBackground(null);
        btnCari.setBorderPainted(false);
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

        if (SingletonProfile.getInstance().getUser() != null) {
            JButton btnLogout = new JButton("Logout");
            btnLogout.setFont(font1);
            btnLogout.setBounds(730, 2, 80, 75);
            btnLogout.setBackground(null);
            btnLogout.setBorderPainted(false);
            btnLogout.setFont(font1);
            btnLogout.setBounds(860, 2, 100, 75);
            btnLogout.setBackground(null);
            btnLogout.setBorderPainted(false);


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
            
            String name = SingletonProfile.getInstance().getUser().getUsername();
            JLabel lblName = new JLabel(name);
            lblName.setBounds(1010, 2, 100, 75);
            panelMenu.add(lblName);
            
            JButton btnProfile = new JButton("👤");
            btnProfile.setFont(font2);
            btnProfile.setBounds(940, 2, 70, 75);
            btnProfile.setBackground(null);
            btnProfile.setBorderPainted(false);
            panelMenu.add(btnProfile);
            btnProfile.addActionListener(
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae
                ) {
                    frame.dispose();
                    new LihatProfille();
                }
            });

            if (TokoController.checkToko(SingletonProfile.getInstance().getUser().getId())) {
                JButton menuToko = new JButton("Menu Toko");
                menuToko.setFont(font1);
                menuToko.setBackground(null);
                menuToko.setBorderPainted(false);
                menuToko.setBounds(710, 2, 120, 75);

                panelMenu.add(menuToko);
                menuToko.addActionListener(
                        new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        frame.setVisible(false);
                        new MenuTokoScreen();
                    }
                });

            } else {
                JButton regisToko = new JButton("Ingin Buat Toko?");
                regisToko.setFont(font1);
                regisToko.setBackground(null);
                regisToko.setBorderPainted(false);
                regisToko.setBounds(700, 2, 150, 75);
                panelMenu.add(regisToko);
                regisToko.addActionListener(
                        new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        frame.setVisible(false);
                        new RegistrasiTokoScreen();
                    }
                });
            }

//            Icon icon = new ImageIcon("1250px-Shopping_cart_icon.svg.png");
            JButton btnKeranjang = new JButton("🛒");
            btnKeranjang.setBounds(640, 7, 60, 75);

            btnKeranjang.setFont(font2);
            btnKeranjang.setBackground(null);
            btnKeranjang.setBorderPainted(false);
            panelMenu.add(btnKeranjang);
            btnKeranjang.addActionListener(
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae
                ) {
                    frame.setVisible(false);
                    new LihatKeranjangScreen();
                }
            });
        } else {
            JButton btnLogin = new JButton("Login");
            btnLogin.setFont(font1);
            btnLogin.setBackground(null);
            btnLogin.setBorderPainted(false);
            btnLogin.setBounds(640, 2, 100, 75);
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

        frame.add(panelMenu);

        return panelMenu;
    }
}
