/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.SingletonBarang;
import controller.SingletonProfile;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Barang;

/**
 *
 * @author shyen
 */
public class MenuTokoScreen extends JFrame {

    private DefaultTableModel tableModel;
    private JTable jTable;

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

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 80, 1050, 500);
        frame.getContentPane().add(scrollPane);

        tableModel = new DefaultTableModel();
        jTable = new JTable(tableModel) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        scrollPane.setViewportView(jTable);

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
//                    System.out.println("product id: " + productId);
                    new UpdateProduk();
                    frame.setVisible(false);
                }
            }
        });
        String headerTitle[] = {
            "ID Barang", "Nama Barang", "Stock Barang", "Harga Barang", "Deskripsi Barang", "Jumlah Pengunjung", "Status"
        };
        DefaultTableModel tableModel = new DefaultTableModel(headerTitle, 0);
        int id = SingletonProfile.getInstance().getUser().getId();
        ArrayList<Barang> tableBarang = SingletonBarang.getInstance().getBarangByToko(id);
        for (int i = 0; i < tableBarang.size(); i++) {
            int id_barang = tableBarang.get(i).getId_barang();
            String nama_barang = tableBarang.get(i).getNama_barang();
            int stockBarang = tableBarang.get(i).getStok_barang();
            Double hargaBarang = tableBarang.get(i).getHarga_barang();
            String deskripsiBarang = tableBarang.get(i).getDeskripsi_barang();
            int jumlahPengunjung = tableBarang.get(i).getJumlah_pengunjung();
            int status = tableBarang.get(i).getStatus();
            int id_toko = tableBarang.get(i).getId_toko();
            tableModel.addRow(new Object[]{id_barang, nama_barang, stockBarang, hargaBarang, deskripsiBarang, jumlahPengunjung, status, id_toko});
        }

        jTable.setModel(tableModel);

        frame.setLayout(null);
        frame.add(panelMenu);
        frame.setVisible(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
