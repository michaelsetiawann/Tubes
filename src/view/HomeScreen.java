/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.SingletonBarang;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Barang;

/**
 *
 * @author shyen
 */
public class HomeScreen {

    public HomeScreen() {
        homeScreen();
    }

    private DefaultTableModel tableModel;
    private JTable jTable;
    private Vector<Object> table;

    private void homeScreen() {
        JFrame frame = new JFrame("home");
        //frame
        frame.setSize(1080, 720);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        //font 
        Font font1 = new Font("SansSerif", Font.PLAIN, 15);
        Font font2 = new Font("SansSerif", Font.PLAIN, 25);

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
                    new ProductDetails(productId);
                }
            }
        });
        String headerTitle[] = {
            "ID Barang", "Nama Barang", "Stock Barang", "Harga Barang", "Deskripsi Barang", "Jumlah Pengunjung", "Status"
        };
        DefaultTableModel tableModel = new DefaultTableModel(headerTitle, 0);
        Vector<Barang> tableBarang = SingletonBarang.getInstance().getAllBarang();
        for (Barang b : tableBarang) {
            table = new Vector<>();
            table.add(b.getId_barang());
            table.add(b.getNama_barang());
            table.add(b.getStok_barang());
            table.add(b.getHarga_barang());
            table.add(b.getDeskripsi_barang());
            table.add(b.getJumlah_pengunjung());
            table.add(b.getStatus());
            tableModel.addRow(table);
        }

        jTable.setModel(tableModel);
        
        frame.setLayout(null);
        frame.setVisible(true);

        PanelMenu menu = new PanelMenu();
        JPanel panelMenu = menu.getPanel(frame);

        frame.add(panelMenu);
    }
}
