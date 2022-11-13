/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Barang;
import model.Keranjang;
import model.User;

/**
 *
 * @author acer
 */
public class LihatKeranjangScreen extends TemplateScreen{
    public LihatKeranjangScreen() {
//        User loggedInUser = new User();
//        lihatKeranjang(loggedInUser, listKeranjang);
    }
    
    private void lihatKeranjang(User loggedInUser) {
        JFrame frame = getTemplate();
        //produk 1 toko per page
        //max 5 produk per toko
        ArrayList<Keranjang> listKeranjang = loggedInUser.getListKeranjang();
        
        ArrayList<String> namaTokoToko = new ArrayList();
//        for (int i = 0; i < listKeranjang.size; i++) {
//            Keranjang keranjang = new Keranjang();
//            keranjang = listKeranjang.get(i);
//            Barang barang = keranjang.getBarang();
//            for (int j = 0; j < namaTokoToko.size; j++) {
//                
//            }
//        }
        JPanel KeranjangProduk1 = new JPanel();
        JLabel labelToko1 = new JLabel();
        JLabel labelNamaBarang1 = new JLabel();
        JLabel labelHargaBarang1 = new JLabel();
        JTextField jumlahBarang1 = new JTextField();
        JButton deleteBarang1 = new JButton();
        
        //font 
        Font font1 = new Font("SansSerif", Font.PLAIN, 15);
        Font font2 = new Font("SansSerif", Font.PLAIN, 25);
        //panel
        KeranjangProduk1.setBounds(0,0,1080,75);
        KeranjangProduk1.setLayout(null);
        
        JButton namaApp = new JButton("TOKOMEDIA");
        namaApp.setFont(font2);
        namaApp.setBackground(null);
        namaApp.setBorderPainted(false);
        namaApp.setBounds(0, 0, 200, 75);
        KeranjangProduk1.add(namaApp);
        
        JButton transaksi = new JButton ("Transaksi");
        transaksi.setBounds(215, 25, 100, 25);
        transaksi.setFont(font1);
        transaksi.setBackground(null);
        transaksi.setBorderPainted(false);
        KeranjangProduk1.add(transaksi);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        JPanel KeranjangProduk2 = new JPanel();
        JLabel labelToko2 = new JLabel();
        JLabel labelNamaBarang2 = new JLabel();
        JLabel labelHargaBarang2 = new JLabel();
        JTextField jumlahBarang2 = new JTextField();
        JButton deleteBarang2 = new JButton();
        
        JPanel KeranjangProduk3 = new JPanel();
        JLabel labelToko3 = new JLabel();
        JLabel labelNamaBarang3 = new JLabel();
        JLabel labelHargaBarang3 = new JLabel();
        JTextField jumlahBarang3 = new JTextField();
        JButton deleteBarang3 = new JButton();
        
        JPanel KeranjangProduk4 = new JPanel();
        JLabel labelToko4 = new JLabel();
        JLabel labelNamaBarang4 = new JLabel();
        JLabel labelHargaBarang4 = new JLabel();
        JTextField jumlahBarang4 = new JTextField();
        JButton deleteBarang4 = new JButton();
        
        JPanel KeranjangProduk5 = new JPanel();
        JLabel labelToko5 = new JLabel();
        JLabel labelNamaBarang5 = new JLabel();
        JLabel labelHargaBarang5 = new JLabel();
        JTextField jumlahBarang5 = new JTextField();
        JButton deleteBarang5 = new JButton();
    }
}
