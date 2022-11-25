/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.KeranjangController;
import controller.TransaksiController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Transaksi;
import model.User;
import controller.SingletonProfile;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import model.Keranjang;
import model.StatusPengirimanEnum;
import model.MetodePembayaranEnum;

/**
 *
 * @author shyen
 */
public class TransactionScreen extends JFrame {

    private DefaultTableModel kolom;
    private JTable tabel;


    public TransactionScreen() {
        transScreen();

    }

    private void transScreen() {
        JFrame frame = new JFrame("Transaksi");
        frame.setSize(1080, 720);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        //font 
        Font font1 = new Font("SansSerif", Font.PLAIN, 15);
        Font font2 = new Font("SansSerif", Font.PLAIN, 25);
        //panel add
        PanelMenu menu = new PanelMenu();
        JPanel panelMenu = menu.getPanel(frame);
        frame.add(panelMenu);

        printTable(frame);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void printTable(JFrame frame) {
        
        kolom = new DefaultTableModel();
        kolom.setColumnIdentifiers(new Object[]{
            "Id Transaksi", "Nama Barang", "Tanggal", "Rating", "Jumlah Barang", "Status", "Metode Pembayaran", "Review"
        });
        tabel = new JTable();
        tabel.setModel(kolom);
        tabel.setVisible(true);
        ArrayList<Transaksi> aa = TransaksiController.getTransaksi(SingletonProfile.getInstance().getUser().getId());
        for (int i = 0; i < aa.size(); i++) {

            int idTrnas = aa.get(i).getId_transaksi();
            String namaBarang = aa.get(i).getBarang().getNama_barang();
            Date tgl = aa.get(i).getTanggal();
            int rate = aa.get(i).getRating();
            int qty = aa.get(i).getJumlahBarang();
            StatusPengirimanEnum stats = aa.get(i).getStatus();
            MetodePembayaranEnum met = aa.get(i).getMetodePembayaran();
            String pesan = aa.get(i).getPesan_review();
            kolom.addRow(new Object[]{idTrnas, namaBarang, tgl, rate, qty, stats, met, pesan});
        }
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(tabel);
        scroll.setBounds(10, 80, 1050, 190);
        frame.getContentPane().add(scroll);

        tabel.addMouseListener(new MouseListener() {
            Date pressedTime;
            long timeClicked;

            @Override
            public void mouseReleased(MouseEvent e) {
                timeClicked = new Date().getTime() - pressedTime.getTime();
                if (timeClicked >= 500) {
                    
                    int selectedRow;
                    selectedRow = tabel.getSelectedRow();
                    int transId = Integer.valueOf(tabel.getValueAt(selectedRow, 0).toString());
                    int rate = Integer.valueOf(tabel.getValueAt(selectedRow, 3).toString());
                    String status =tabel.getValueAt(selectedRow, 5).toString();
                    if (status.equals("SELESAI")) {
                        frame.dispose();
                        new ReviewRatingProdukScreen(transId,rate);
                    } else {
                        JOptionPane.showMessageDialog(null, "Pesanan Belum Selesai !");
                    }

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                pressedTime = new Date();
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

            }
        });

    }
}
