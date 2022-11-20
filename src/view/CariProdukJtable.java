/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SingletonBarang;
import database.DatabaseHandler;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
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
    static DatabaseHandler conn = new DatabaseHandler();

    public CariProdukJtable() {

    }

    public CariProdukJtable(String nama) {
        setTitle("Produk yang ditemukan");
        setSize(1080, 700);
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
        tabel = new JTable(model) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Vector<Barang> tableBarang = SingletonBarang.getInstance().getBarangByName(nama);
        for (Barang b : tableBarang) {
            int id_barang = b.getId_barang();
            String nama_barang = b.getNama_barang();
            int stok_barang = b.getStok_barang();
            double harga_barang = b.getHarga_barang();
            String deskripsi_barang = b.getDeskripsi_barang();
            int jumlah_pengunjung = b.getJumlah_pengunjung();
            boolean status = b.isStatus();
            JButton btnCari = new JButton("Klik Cari");
            btnCari.setBounds(580, 20, 150, 40);
            model.addRow(new Object[]{id_barang, nama_barang, stok_barang, harga_barang, deskripsi_barang, jumlah_pengunjung, status, new JButton("Button1")});
        }

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(tabel);

        getContentPane().add(scroll);
    }

    public static void main(String[] args) {
        CariProdukJtable obj = new CariProdukJtable();
    }
}
