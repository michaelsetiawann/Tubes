/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.KeranjangController;
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
import java.util.concurrent.TimeUnit;
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
    int enumValue;
    
    public KonfirmasiPesananMasukScreen(int enum_value) {
        enumValue = enum_value;
        User user = SingletonProfile.getInstance().getUser();
        tableTransaksi = null;
    	tableTransaksi = TransaksiController.getInstance().getTransaksiTokoBerdasarkanEnumValue(enumValue);
        lihatKeranjang();
    }
    
    private void lihatKeranjang() {
        JFrame frame = new JFrame("Daftar Pesanan");
        
        //font 
        Font font1 = new Font("SansSerif", Font.PLAIN, 15);
        
        //panel add
        PanelMenuToko menu = new PanelMenuToko();
        JPanel panelMenu = menu.getPanelToko(frame);
        frame.add(panelMenu);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10,80,1050,190);
        frame.getContentPane().add(scrollPane);
        if(enumValue == 0 || enumValue == 1){
            String headerTitle[] = {
                "ID Transaksi",  "ID Barang", "Tanggal", "Status", "Jumlah Barang", "Metode Pembayaran",  "Seleksi"
            };
            tableModel = null;
            tableModel = new DefaultTableModel(headerTitle, 0);
        }
        else{
            String headerTitle[] = {
                "ID Transaksi",  "ID Barang", "Tanggal", "Status", "Jumlah Barang", "Metode Pembayaran"
            };
            tableModel = null;
            tableModel = new DefaultTableModel(headerTitle, 0);
        }
        
        
        frame.add(labelTotal);
        tableData = new JTable(tableModel) {
            public boolean isCellEditable(int row, int column) {
                    return false;
            }
        };
        scrollPane.setViewportView(tableData);
              
        tableData.addMouseListener(new MouseListener() {
                Date pressedTime;
                long timeClicked;
			
                @Override
                public void mouseReleased(MouseEvent e) {
                    
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                        // TODO Auto-generated method stub

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                        // TODO Auto-generated method stub

                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    //select/deselect product
                    if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
//                        System.out.println(" in here at least");
                        int selectedRow;
                        selectedRow = tableData.getSelectedRow();
                        int transaksiId = Integer.valueOf(tableData.getValueAt(selectedRow, 0).toString());
                        //check if in selected
                        boolean isThere = false;
                        Transaksi transaksi = TransaksiController.getInstance().getTrans(transaksiId);
                        for (Transaksi c : selectedItems) {
                            if(c.getId_transaksi() == transaksiId){
                                isThere = true;
                                transaksi = c;
                            }
                        }
                        if(isThere){
//                            System.out.println("in here1");
                            selectedItems.remove(transaksi);
                        }
                        else{
//                            System.out.println("in here 2");
//                            System.out.println(enumValue);
                            if(!selectedItems.isEmpty() && enumValue == 1){
//                                System.out.println("sdkfjlaksdjf");
                                JOptionPane.showMessageDialog(null, "Hanya bisa upload resi per transaksi");
                            }
                            else{
//                                System.out.println("ahem");
                                selectedItems.add(transaksi);
                            }
                        }
                        System.out.println(selectedItems);
                        //alter selected
                        tableData.setModel(tableModel);
                        loadData();
                    }
                }
        });
        if(enumValue == 0){
            JButton delete = new JButton("Batalkan");
            delete.setBounds(940,290,100,35);
            frame.add(delete);
            delete.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            if(!selectedItems.isEmpty()){
                                for (Transaksi k : selectedItems) {
                                    TransaksiController.getInstance().setTransaksi(k);
                                    TransaksiController.getInstance().setStatusTransaksi(5);
                                    loadData();
                                }
                                if(selectedItems.size() > 1){
                                    JOptionPane.showMessageDialog(null, "Transaksi-transaksi sudah anda batalkan");
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Transaksi sudah anda batalkan");
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Silahkan select transaksi terlebih dahulu");
                            }
                            loadData();
                        }
                    });

            JButton konfirmasi = new JButton("Konfirmasi");
            konfirmasi.setBounds(810, 290, 100, 35);
            konfirmasi.addActionListener(this);
            frame.add(konfirmasi);
            konfirmasi.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            System.out.println(selectedItems.isEmpty());
                            if(!selectedItems.isEmpty()){
                                if(selectedItems.size() > 1){
                                    JOptionPane.showMessageDialog(null, "Transaksi-transaksi sudah anda konfirmasi");
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Transaksi sudah anda konfirmasi");
                                }
                                for (Transaksi k : selectedItems) {
                                    TransaksiController.getInstance().setTransaksi(k);
                                    TransaksiController.getInstance().setStatusTransaksi(1);
                                    loadData();
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Silahkan select transaksi terlebih dahulu");
                            }
                            loadData();
                        }
                    });
        }
        else if(enumValue == 1){
            JButton siapDikirim = new JButton("Upload Resi Pengiriman");
            siapDikirim.setBounds(860,290,190,35);
            frame.add(siapDikirim);
            siapDikirim.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            if(!selectedItems.isEmpty()){
                                JOptionPane.showMessageDialog(null, "Resi sudah diupload ke Kurir Instan\n"
                                            + "(Langsung cek Pesanan Selesai)");
                                for (Transaksi k : selectedItems) {
                                    TransaksiController.getInstance().setTransaksi(k);
                                    TransaksiController.getInstance().setStatusTransaksi(3);
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Silahkan select transaksi terlebih dahulu");
                            }
                            loadData();
                        }
                    });
        }
        
        
        //frame
        frame.setSize(1080, 720);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(panelMenu);
        loadData();
//        if(enumValue == 2){
//            try {
//                Thread.sleep(2000);
//              } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//              }
//            for (Transaksi s : tableTransaksi) {
//                TransaksiController.getInstance().setTransaksi(s);
//                TransaksiController.getInstance().setStatusTransaksi(3);
//            }
//        }
    }
    
    private void loadData() {
        User user = SingletonProfile.getInstance().getUser();
        tableTransaksi = null;
    	tableTransaksi = TransaksiController.getInstance().getTransaksiTokoBerdasarkanEnumValue(enumValue);
//         String headerTitle[] = {
//            "ID Transaksi", "ID Barang", "Tanggal", "Status", "Jumlah Barang", "Metode Pembayaran",  "Seleksi"
//    	};
        tableModel.setRowCount(0);
        if( !selectedItems.isEmpty() && tableTransaksi != null){
            for(Transaksi b : tableTransaksi) {
                if(isInArray(b, selectedItems)){
                    System.out.println("in here");
                    Vector<Object> tableVector = new Vector<>();
                    tableVector.add(b.getId_transaksi());
                    tableVector.add(b.getBarang().getId_barang());
                    tableVector.add(String.valueOf(b.getTanggal())); 
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
                    tableVector.add(String.valueOf(b.getTanggal())); 
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
                    tableVector.add(String.valueOf(b.getTanggal())); 
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
