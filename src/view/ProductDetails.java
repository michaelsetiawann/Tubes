/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SingletonBarang;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import static view.LihatKeranjangScreen.frame;

/**
 *
 * @author Lenovo
 */
public class ProductDetails extends JFrame {

    static JFrame frame = new JFrame("Product Details");
    private JTextField inputNamaBarang;
    private JTextField inputQty;
    private JTextField inputPrice;
    private JTextField inputRate;
    private JTable table;

    public ProductDetails(int productId) {
        String namaBarang = SingletonBarang.getInstance().getProductDetails(productId).getNama_barang();
        int qty = SingletonBarang.getInstance().getProductDetails(productId).getStok_barang();
        double price = SingletonBarang.getInstance().getProductDetails(productId).getHarga_barang();
        String descriptionText = SingletonBarang.getInstance().getProductDetails(productId).getDeskripsi_barang();
        
//        JLabel lblProductName = new JLabel(namaBarang);
//        lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 20));
//        lblProductName.setBounds(38, 37, 1003, 34);
//        frame.getContentPane().add(lblProductName);
        
        inputNamaBarang = new JTextField();
        inputNamaBarang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        inputNamaBarang.setBounds(38, 37, 1003, 34);
        inputNamaBarang.setEditable(false);
        inputNamaBarang.setText(namaBarang);
        frame.getContentPane().add(inputNamaBarang);
        inputNamaBarang.setColumns(10);


        JLabel lblQuantity = new JLabel("Quantity");
        lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblQuantity.setBounds(38, 99, 68, 34);
        frame.getContentPane().add(lblQuantity);

        inputQty = new JTextField();
        inputQty.setFont(new Font("Tahoma", Font.PLAIN, 14));
        inputQty.setBounds(116, 102, 86, 29);
        inputQty.setEditable(false);
        inputQty.setText(String.valueOf(qty));
        frame.getContentPane().add(inputQty);
        inputQty.setColumns(10);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPrice.setBounds(38, 147, 68, 34);
        frame.getContentPane().add(lblPrice);

        inputPrice = new JTextField();
        inputPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
        inputPrice.setColumns(10);
        inputPrice.setBounds(116, 150, 86, 29);
        inputPrice.setEditable(false);
        inputPrice.setText(toString().valueOf(price));
        frame.getContentPane().add(inputPrice);

        JTextArea description = new JTextArea();
        description.setBounds(38, 237, 992, 166);
        description.setText(descriptionText);
        frame.getContentPane().add(description);
        description.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(description);
        scrollPane.setBounds(38, 230, 992, 200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add(scrollPane);

        frame.setSize(1080, 720);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

        JLabel lblDescription = new JLabel("Description");
        lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDescription.setBounds(38, 211, 79, 14);
        frame.getContentPane().add(lblDescription);

        JLabel lblRating = new JLabel("Rating & Review");
        lblRating.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblRating.setBounds(38, 431, 123, 20);
        frame.getContentPane().add(lblRating);

        double rate = SingletonBarang.getInstance().getAverage(productId);
//        JLabel lblRatingChange = new JLabel(String.valueOf(rate));
//        lblRatingChange.setFont(new Font("Tahoma", Font.PLAIN, 20));
//        lblRatingChange.setBounds(38, 462, 29, 20);
//        frame.getContentPane().add(lblRatingChange);
        
        inputRate = new JTextField();
        inputRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        inputRate.setBounds(38, 462, 60, 20);
        inputRate.setEditable(false);
        inputRate.setText(String.valueOf(rate) + " / 5.0");
        frame.getContentPane().add(inputRate);
        inputRate.setColumns(10);

//        JLabel lblRatingChange_1 = new JLabel("/ 5.0");
//        lblRatingChange_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        lblRatingChange_1.setBounds(71, 462, 46, 20);
//        frame.getContentPane().add(lblRatingChange_1);
//        JOptionPane.showMessageDialog(null, namaBarang + ",      " + rate);
//        table = new JTable();
//        table.setBounds(38, 493, 994, 155);
//        frame.getContentPane().add(table);

        JButton btnAddToCart = new JButton("Add to Cart");
        btnAddToCart.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnAddToCart.setBounds(879, 86, 149, 36);
        frame.getContentPane().add(btnAddToCart);
        frame.setVisible(true);
        
//        btnAddToCart.addActionListener(
//                new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                new Cart(productId);
//            }
//        });
        
        JButton btnBack = new JButton("Back to home");
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBack.setBounds(879, 150, 149, 36);
        frame.getContentPane().add(btnBack);
        frame.setVisible(true);
        
        btnBack.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                SingletonBarang.getInstance().reset();
                new HomeScreen();
            }
        });

    }
}