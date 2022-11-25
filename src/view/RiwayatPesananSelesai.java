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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.MetodePembayaranEnum;
import model.StatusPengirimanEnum;
import model.Transaksi;

/**
 *
 * @author William
 */
public class RiwayatPesananSelesai {
    private DefaultTableModel kolom;
    private JTable tabel;
    private static JFrame frame = new JFrame("Riwayat Pesanan");

    public RiwayatPesananSelesai() {
        transScreen();

    }

    private void transScreen() {

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

        printTable();
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void printTable() {
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
            Double rate = aa.get(i).getRating();
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
                    if (timeClicked >= 500){
                        int selectedRow;
                        selectedRow = tabel.getSelectedRow();
                        int transId = Integer.valueOf(tabel.getValueAt(selectedRow, 0).toString());
                        double rate = Double.valueOf(tabel.getValueAt(selectedRow, 3).toString());
                        
                        JFrame f = new JFrame();
                        f.setSize(500, 500);
                        
                        JSpinner spinner = new JSpinner();
                        spinner.setValue(Double.valueOf(rate));
                        spinner.setBounds(60, 100, 60, 40);
                        f.add(spinner);
                        
                        JButton update = new JButton("Update");
                        update.setBounds(140, 105, 100, 30);
                        f.add(update);
                        f.setLayout(null);
                        f.setVisible(true);
                        update.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                if (ae.getSource() == update){
                                    int rateBaru = (Integer) spinner.getValue();
                                    if(rateBaru <=5){
//                                        Keranjang keranjangA = KeranjangController.getInstance().getKeranjang(transId);
//                                        KeranjangController.getInstance().updateKeranjang(transId, rateBaru);
//                                        Keranjang keranjangB = KeranjangController.getInstance().getKeranjang(transId);
                                        Transaksi trans = TransaksiController.getInstance().getTrans(transId);
                                        trans.setRating(rateBaru);
//                                        int counter = 0;
//                                        for (Keranjang temp : selectedItems) {                                        
//                                            if(temp.getId_keranjang() == keranjangA.getId_keranjang()){
//                                                selectedItems.set(counter, keranjangB);
//                                            }
//                                            counter++;
//                                        }
                                        f.setVisible(false);
                                        printTable();
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Bintang maksimal 5");
                                    }
                                } 
                            }
                        });
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
                    //select/deselect product
//                    if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
//                        int selectedRow;
//                        selectedRow = tabel.getSelectedRow();
//                        int keranjangId = Integer.valueOf(tableData.getValueAt(selectedRow, 0).toString());
//                        //check if in selected
//                        boolean isThere = false;
//                        Keranjang keranjang = KeranjangController.getInstance().getKeranjang(keranjangId);
//                        for (Keranjang c : selectedItems) {
//                            if(c.getId_keranjang() == keranjangId){
//                                isThere = true;
//                                keranjang = c;
//                            }
//                        }
//                        if(isThere){
//                            selectedItems.remove(keranjang);
//                        }
//                        else{
//                            selectedItems.add(keranjang);
//                        }
//                        //alter selected
//                        tableData.setModel(tableModel);
//                        loadData();
//                    }
                }
        });
        
    }
}
