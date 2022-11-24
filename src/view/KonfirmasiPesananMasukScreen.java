/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.SingletonProfile;
import controller.TransaksiController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Keranjang;
import model.Transaksi;
import model.User;

/**
 *
 * @author acer
 */
public class KonfirmasiPesananMasukScreen extends JFrame implements ActionListener{
    private DefaultTableModel tableModel;
    private JTable tableData;
    private Vector<Object> tableVector;
    ArrayList<Transaksi> tableTransaksi;
    ArrayList<Transaksi> selectedItems = new ArrayList<>();
    Font font2 = new Font("SansSerif", Font.PLAIN, 25);
    double total = 0;
    JLabel labelTotal = new JLabel("Total Harga : " + total);
    JButton checkout;
    
    public KonfirmasiPesananMasukScreen() {
        User user = SingletonProfile.getInstance().getUser();
        tableTransaksi = null;
    	tableTransaksi = TransaksiController.getInstance().getTransaksiToko(user.getId());
        lihatKeranjang();
    }
    
    private void lihatKeranjang() {
        JFrame frame = new JFrame("Konfirmasi Pesanan");
        
        //font 
        Font font1 = new Font("SansSerif", Font.PLAIN, 15);
        
        //panel add
        PanelMenu menu = new PanelMenu();
        JPanel panelMenu = menu.getPanel(frame);
        frame.add(panelMenu);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10,80,1050,190);
        frame.getContentPane().add(scrollPane);
        
        String headerTitle[] = {
            "ID Transaksi", "ID User", "ID Barang", "Tanggal", "Status", "Jumlah Barang", "Metode Pembayaran",  "Seleksi"
    	};
        tableModel = null;
    	tableModel = new DefaultTableModel(headerTitle, 0);
        frame.add(labelTotal);
        tableData = new JTable(tableModel) {
            public boolean isCellEditable(int row, int column) {
                    return false;
            }
        };
        scrollPane.setViewportView(tableData);
              
        
        JButton delete = new JButton("Batalkan");
        delete.setBounds(940,290,80,20);
        frame.add(delete);
        delete.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if(!selectedItems.isEmpty()){
                            for (Transaksi k : selectedItems) {
                                TransaksiController.getInstance().setTransaksi(k);
                                TransaksiController.getInstance().batalkanTransaksi();
                                loadData();
                                JOptionPane.showMessageDialog(null, "Transaksi-transaksi sudah anda batalkan");
                            }
                        }
                        loadData();
                    }
                });
        
        JButton konfirmasi = new JButton("Konfirmasi");
        konfirmasi.setBounds(800, 580, 100, 30);
        konfirmasi.addActionListener(this);
        frame.add(konfirmasi);
        konfirmasi.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if(!selectedItems.isEmpty()){
                            for (Transaksi k : selectedItems) {
                                TransaksiController.getInstance().setTransaksi(k);
                                TransaksiController.getInstance().konfirmasiTransaksi();
                                loadData();
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Transaksi-transaksi sudah anda konfirmasi");
                        }
                        loadData();
                    }
                });
        
        //frame
        frame.setSize(1080, 720);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(panelMenu);
        loadData();
    }
    
    private void loadData() {
        User user = SingletonProfile.getInstance().getUser();
        tableTransaksi = null;
    	tableTransaksi = TransaksiController.getInstance().getTransaksiToko(user.getId());
//         String headerTitle[] = {
//            "ID Transaksi", "ID Barang", "Tanggal", "Status", "Jumlah Barang", "Metode Pembayaran",  "Seleksi"
//    	};
        tableModel.setRowCount(0);
        if( !selectedItems.isEmpty() && tableTransaksi != null){
            
            for(Transaksi b : tableTransaksi) {
                if(isInArray(b, selectedItems)){
                    Vector<Object> tableVector = new Vector<>();
                    tableVector.add(b.getId_transaksi());
                    tableVector.add(b.getBarang().getId_barang());
                    tableVector.add(b.getTanggal()); 
                    tableVector.add(b.getStatus());
                    tableVector.add(b.getJumlahBarang());
                    tableVector.add(b.getMetodePembayaran());
                    tableVector.add("SELECTED");
                    tableModel.addRow(tableVector);
                }
                else{
                    Vector<Object> tableVector = new Vector<>();
                    tableVector.add(b.getId_transaksi());
                    tableVector.add(b.getBarang().getId_barang());
                    tableVector.add(b.getTanggal()); 
                    tableVector.add(b.getStatus());
                    tableVector.add(b.getJumlahBarang());
                    tableVector.add(b.getMetodePembayaran());
                    tableVector.add("UNSELECTED");
                    tableModel.addRow(tableVector);
                }
            }
    	}
        else{
//            System.out.println("check2");
            if(tableTransaksi != null){
                for(Transaksi b : tableTransaksi) {
                    Vector<Object> tableVector = new Vector<>();
                    tableVector.add(b.getId_transaksi());
                    tableVector.add(b.getBarang().getId_barang());
                    tableVector.add(b.getTanggal()); 
                    tableVector.add(b.getStatus());
                    tableVector.add(b.getJumlahBarang());
                    tableVector.add(b.getMetodePembayaran());
                    tableVector.add("UNSELECTED");
                    tableModel.addRow(tableVector);
                }
            }
        }
        tableData.setModel(tableModel);
    	
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    boolean isInArray(Transaksi x, ArrayList<Transaksi> array){
        boolean isThere = false;
        for (Transaksi a : array) {
            if(x.getId_transaksi()== a.getId_transaksi()){
                isThere = true;
            }
        }
        return isThere;
    }
}
