/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.LaporanToko;
import model.StatusLaporanInterface;

/**
 *
 * @author acer
 */
public class BlokirToko implements StatusLaporanInterface {

    public BlokirToko() {
        menampilkanLaporanToko();
    }

    private int status_toko = WAITING;
    private DefaultTableModel tableModel;
    private JTable jTable;
    private Vector<Object> table;

    public void menampilkanLaporanToko() {
        ArrayList<LaporanToko> listLaporan = new ArrayList<>();
        listLaporan = controller.LaporController.getLaporToko();

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
                    int stat_toko;
                    int lapor_id = Integer.valueOf(jTable.getValueAt(selectedRow, 0).toString());
                    if (JOptionPane.showConfirmDialog(null, "APPROVE?", "REJECT",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        stat_toko = 1;
                        JOptionPane.showMessageDialog(null, "Approve Berhasil!");
                    } else {
                        stat_toko = 2;
                        JOptionPane.showMessageDialog(jTable, "Reject Berhasil!");
                    }
                    controller.LaporController.approveLaporanToko(lapor_id, stat_toko);
                }
            }
        });

        String[] column = {"ID Laporan", "ID Toko", "ID User", "Tanggal", "Isi Pesan", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);
        for (int i = 0; i < listLaporan.size(); i++) {
            int id_laporan = listLaporan.get(i).getId_laporan();
            int id_barang = listLaporan.get(i).getToko();
            int id_user = listLaporan.get(i).getUser();
            Date tanggal = listLaporan.get(i).getTanggal();
            String isi_pesan = listLaporan.get(i).getKomentar();
            int status = listLaporan.get(i).getStatus();
            String statusName = "";
            switch (status) {
                case 1:
                    statusName = "ACCEPTED";
                    break;
                case 2:
                    statusName = "REJECTED";
                    break;
                default :
                    statusName = "WAITING";
                    break;
            }
            
            tableModel.addRow(new Object[]{id_barang, id_laporan, id_user, tanggal, isi_pesan, statusName});
        }

        JButton kembali = new JButton("Kembali");
        kembali.setBounds(10, 10, 100, 40);
        kembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuAdmin();
                view.dispose();
            }
        });

        view.add(kembali);
        jTable.setModel(tableModel);

        view.setVisible(true);
    }

    public static void main(String[] args) {
        new BlokirToko();
    }
}
