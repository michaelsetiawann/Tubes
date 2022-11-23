/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SingletonBarang;
import database.DatabaseHandler;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Barang;

/**
 *
 * @author Lenovo
 */
public class CariProdukJtable extends JFrame{

    JFrame frame = new JFrame();
    Barang barang;
    private JTable jTable;
    static DatabaseHandler conn = new DatabaseHandler();
    private DefaultTableModel model;

    public CariProdukJtable() {
        
    }

    public CariProdukJtable(String nama) {
        frame.setTitle("Produk yang ditemukan");
        frame.setSize(1080, 700);
        frame.setLocationRelativeTo(null);
        
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(10, 80, 1050, 500);

        String search = nama;
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{
            "ID Barang", "Nama Barang", "Stok Barang", "Harga Barang", "Deskripsi Barang", "Jumlah Pengunjung", "Status"
        });
        jTable = new JTable(model) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
         jTable.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }
//            @Override

            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
                    int selectedRow;
                    selectedRow = jTable.getSelectedRow();
                    int productId = Integer.valueOf(jTable.getValueAt(selectedRow, 0).toString());
                    new ProductDetails(productId);
                }
            }
        });
<<<<<<< Updated upstream
        
=======
>>>>>>> Stashed changes
        ArrayList<Barang> tableBarang = SingletonBarang.getInstance().getBarangByName(nama);
        for (int i = 0; i < tableBarang.size(); i++) {
            int id_barang = tableBarang.get(i).getId_barang();
            String nama_barang = tableBarang.get(i).getNama_barang();
            int stockBarang = tableBarang.get(i).getStok_barang();
            Double hargaBarang = tableBarang.get(i).getHarga_barang();
            String deskripsiBarang = tableBarang.get(i).getDeskripsi_barang();
            int jumlahPengunjung = tableBarang.get(i).getJumlah_pengunjung();
            int status = tableBarang.get(i).getStatus();
            model.addRow(new Object[]{id_barang, nama_barang, stockBarang, hargaBarang, deskripsiBarang, jumlahPengunjung, status});
        }
        PanelMenu menu = new PanelMenu();
        JPanel panelMenu = menu.getPanel(frame);
        panelMenu.setBounds(0, 200, 1080, 75);
        
        scroll.setViewportView(jTable);
        
        frame.getContentPane().add(scroll);
        
        frame.add(panelMenu);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        CariProdukJtable obj = new CariProdukJtable();
    }
}
