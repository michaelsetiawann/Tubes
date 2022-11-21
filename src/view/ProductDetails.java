/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.KeranjangController;
import controller.SingletonBarang;
import controller.SingletonProfile;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import model.Keranjang;
import model.Review;
import static view.LihatKeranjangScreen.frame;

/**
 *
 * @author Lenovo
 */
public class ProductDetails extends JFrame {

    static JFrame frame = new JFrame("Product Details");
    private JTextField inputNamaBarang;
    private JTextField inputPrice;
    private JTextField inputRate;
    private JTable table = new JTable();

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

        JLabel lblStok = new JLabel("Stock = " + SingletonBarang.getInstance().getProductDetails(productId).getStok_barang());
        lblStok.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblStok.setBounds(225, 99, 100, 34);
        frame.getContentPane().add(lblStok);

        JSpinner inputQty = new JSpinner();
        inputQty.setFont(new Font("Tahoma", Font.PLAIN, 14));
        inputQty.setBounds(116, 102, 86, 29);
//        inputQty.setEditable(false);
//        inputQty.setText(String.valueOf(qty));
        frame.getContentPane().add(inputQty);
//        inputQty.setColumns(10);

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
        inputRate = new JTextField();
        inputRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        inputRate.setBounds(38, 462, 60, 20);
        inputRate.setEditable(false);
        inputRate.setText(String.valueOf(rate) + " / 5.0");
        frame.getContentPane().add(inputRate);
        inputRate.setColumns(10);

        JButton btnAddToCart = new JButton("Add to Cart");
        btnAddToCart.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnAddToCart.setBounds(879, 86, 149, 36);
        frame.getContentPane().add(btnAddToCart);
        frame.setVisible(true);
        btnAddToCart.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (SingletonProfile.getInstance().getUser() != null) {
                    int x = (Integer) inputQty.getValue();
                    if (x == 0) {
                        JOptionPane.showMessageDialog(null, "Kuantitas masih 0");
                    } else if (x > SingletonBarang.getInstance().getProductDetails(productId).getStok_barang()) {
                        JOptionPane.showMessageDialog(null, "Kuantitas melebihi stok barang!");
                    } else {
                        int id_user = SingletonProfile.getInstance().getUser().getId();
                        ArrayList<Keranjang> listKeranjang = new KeranjangController().getAll(id_user);
                        Keranjang temp = new Keranjang();
                        if (listKeranjang != null) {
                            boolean isThere = false;
                            for (Keranjang k : listKeranjang) {
                                if (productId == k.getBarang().getId_barang()) {
                                    isThere = true;
                                    temp = k;
                                }
                            }
                            if (isThere) {
                                int jumlah = temp.getJumlah_barang() + x;
                                System.out.println(jumlah);
                                new KeranjangController().updateKeranjang(temp.getId_keranjang(), jumlah);
                                frame.setVisible(false);
                                new LihatKeranjangScreen();
                            } else {
                                new KeranjangController().insertKeranjang(productId, x);
                                frame.setVisible(false);
                                new LihatKeranjangScreen();
                            }
                        } else {
                            new KeranjangController().insertKeranjang(productId, x);
                            frame.setVisible(false);
                            new LihatKeranjangScreen();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Maaf Anda harus login terlebih dahulu");
                }

            }
        });

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
        JButton laporToko = new JButton("Lapor Toko");
        laporToko.setFont(new Font("Tahoma", Font.PLAIN, 16));
        laporToko.setBounds(879, 490, 149, 36);
        frame.getContentPane().add(laporToko);
        frame.setVisible(true);

        laporToko.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                int id_toko = SingletonBarang.getInstance().getBarang().getId_toko();
                if (SingletonProfile.getInstance().getUser() != null) {
                    int id_user = SingletonProfile.getInstance().getUser().getId();
                    new LaporTokoScreen(id_toko, id_user);
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Anda harus login terlebih dahulu");
                }
            }
        });

        JButton laporBarang = new JButton("Lapor Barang");
        laporBarang.setFont(new Font("Tahoma", Font.PLAIN, 16));
        laporBarang.setBounds(879, 440, 149, 36);
        frame.getContentPane().add(laporBarang);
        frame.setVisible(true);

        laporBarang.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (SingletonProfile.getInstance().getUser() != null) {
                    int id_user = SingletonProfile.getInstance().getUser().getId();
                    new LaporBarangScreen(productId, id_user);
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Anda harus login terlebih dahulu");
                }
            }
        });

        JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setBounds(38, 490, 700, 150);
        scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add(scrollPane1);
        String headerTitle[] = {
            "ID User", "Review", "Rating"
        };
        DefaultTableModel tableModel = new DefaultTableModel(headerTitle, 0);
        ArrayList<Review> tableBarang = SingletonBarang.getInstance().getUserReview(productId);
        for (int i = 0; i < tableBarang.size(); i++) {
            int id_user = tableBarang.get(i).getId_user();
            String pesan_review = tableBarang.get(i).getPesan_review();
            int rating = tableBarang.get(i).getRating();
            tableModel.addRow(new Object[]{id_user, pesan_review, rating});
        }

        table.setModel(tableModel);
        frame.setLayout(null);
        scrollPane1.setViewportView(table);
        frame.setVisible(true);

    }
}
