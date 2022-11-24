/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SingletonBarang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Barang;
import model.LaporanBarang;
import model.StatusLaporanInterface;

/**
 *
 * @author acer
 */
public class BlokirBarang implements StatusLaporanInterface {

    public BlokirBarang() {
        menampilkanLaporanBarang();
    }
    private int status_barang = WAITING;
    private DefaultTableModel tableModel;
    private JTable jTable;
    private Vector<Object> table;

    public void menampilkanLaporanBarang() {

        ArrayList<LaporanBarang> listLaporan = new ArrayList<>();
        listLaporan = controller.LaporController.getLaporBarang();
        JFrame view = new JFrame();
        view.setSize(1100, 800);
        view.setLocationRelativeTo(null);
        view.getContentPane().setLayout(null);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 80, 1050, 500);
        view.getContentPane().add(scrollPane);

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
                    int selectedRow = jTable.getSelectedRow();
                    int lapor_id = Integer.valueOf(jTable.getValueAt(selectedRow, 0).toString());
                    if (JOptionPane.showConfirmDialog(null, "APPROVE?", "REJECT",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        status_barang = ACCEPTED;
                        JOptionPane.showMessageDialog(null, "Approve Berhasil!");
                    } else {
                        status_barang = REJECTED;
                        JOptionPane.showMessageDialog(jTable, "Reject Berhasil!");
                    }
                    controller.LaporController.approveLaporanBarang(lapor_id, status_barang);
                }
            }
        });

        String[] column = {"ID Laporan", "ID Barang", "ID User", "Tanggal", "Isi Pesan", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);
        for (int i = 0; i < listLaporan.size(); i++) {
            int id_laporan = listLaporan.get(i).getId_laporan();
            int id_barang = listLaporan.get(i).getBarang();
            int id_user = listLaporan.get(i).getUser();
            Date tanggal = listLaporan.get(i).getTanggal();
            String isi_pesan = listLaporan.get(i).getKomentar();
            int status = listLaporan.get(i).getStatus();
            tableModel.addRow(new Object[]{id_barang, id_laporan, id_user, tanggal, isi_pesan, status});
        }
        
        JButton kembali = new JButton("Kembali");
        kembali.setBounds(10, 10, 100, 40);
        kembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
        
        view.add(kembali);
        jTable.setModel(tableModel);

        view.setVisible(true);
    }

    public static void main(String[] args) {
        new BlokirBarang();
    }
}
