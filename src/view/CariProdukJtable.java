/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.DatabaseHandler;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Barang;

/**
 *
 * @author Lenovo
 */
public class CariProdukJtable extends JFrame {

    Barang barang;
    boolean found = false;
    static DatabaseHandler conn = new DatabaseHandler();

    public CariProdukJtable() {

    }

    public CariProdukJtable(String nama) {
        setTitle("Produk yang ditemukan");
        setSize(350, 200);
        setLocationRelativeTo(null);
        userInterfaceGUI(nama);
        setVisible(true);
    }

    private void userInterfaceGUI(String nama) {
        String search = nama;
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{
            "ID Barang", "Nama Barang", "Stok Barang", "Harga Barang", "Deskripsi Barang", "Jumlah Pengunjung", "Status", "Tambah Keranjang"
        });
        JTable tabel = new JTable(model);

        conn.connect();
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM barang WHERE nama_barang like'%" + search + "%'");
            java.sql.Statement stat1 = conn.con.createStatement();
            ResultSet countSize = stat1.executeQuery("SELECT count(*) as 'size' FROM barang WHERE nama_barang like'%" + search + "%'");

            if (countSize.next()) {
                int size = countSize.getInt("size");
                for (int i = 0; i < size; i++) {
                    if (result.next()) {
                        int id_barang = result.getInt("id_barang");
                        String nama_barang = result.getString("nama_barang");
                        int stok_barang = result.getInt("stok_barang");
                        double harga_barang = result.getDouble("harga_barang");
                        String deskripsi_barang = result.getString("deskripsi_barang");
                        int jumlah_pengunjung = result.getInt("jumlah_pengunjung");
                        boolean status = result.getBoolean("status");
                        JButton btnCari = new JButton("Klik Cari");
                                btnCari.setBounds(580, 20, 150, 40);
                        model.addRow(new Object[]{id_barang, nama_barang, stok_barang, harga_barang, deskripsi_barang, jumlah_pengunjung, status, new JButton("Button1")});

                        found = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "User not found.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "User not found.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error occured when connecting to database.");
        }
        conn.disconnect();

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(tabel);

        getContentPane().add(scroll);
    }

    public static void main(String[] args) {
        CariProdukJtable obj = new CariProdukJtable();
    }
}
