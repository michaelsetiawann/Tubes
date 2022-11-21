/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import model.LaporanBarang;

/**
 *
 * @author acer
 */
public class BlokirBarang {
    
    public BlokirBarang(){
        menampilkanLaporanBarang();
    }
    
    public static void menampilkanLaporanBarang(){
        ArrayList<LaporanBarang> listLaporan  = new ArrayList<>();
        listLaporan = controller.LaporController.getLaporBarang();
        
        JFrame view = new JFrame();
        view.setSize(1100, 800);
        view.setLocationRelativeTo(null);
        view.getContentPane().setLayout(null);
        
        JLabel judulLaporanId = new JLabel("Laporan ID");
        judulLaporanId.setBounds(20, 20, 150, 50);
        JLabel judulIdBarang = new JLabel("ID Barang");
        judulIdBarang.setBounds(180, 20, 150, 50);
        JLabel judulIdUser = new JLabel("ID User");
        judulIdUser.setBounds(340, 20, 150, 50);
        JLabel judulTanggal = new JLabel("Tanggal");
        judulTanggal.setBounds(500, 20, 150, 50);
        JLabel judulPesan = new JLabel("Isi Pesan");
        judulPesan.setBounds(660, 20, 150, 50);
        JLabel judulStatus = new JLabel("Status");
        judulStatus.setBounds(820, 20, 150, 50);
        
        JLabel[] labelsLaporanId = new JLabel[listLaporan.size()];
        JLabel[] labelsIdBarang = new JLabel[listLaporan.size()];
        JLabel[] labelsIdUser = new JLabel[listLaporan.size()];
        JLabel[] labelsTanggal = new JLabel[listLaporan.size()];
        JLabel[] labelsPesan = new JLabel[listLaporan.size()];
        JLabel[] labelsStatus = new JLabel[listLaporan.size()];
        int panjang = 150;
        int lebar = 100;
        int y=80;
        for(int i=0; i<listLaporan.size(); i++){
            labelsLaporanId[i] = new JLabel(""+listLaporan.get(i).getId_laporan());
            labelsIdBarang[i] = new JLabel(""+listLaporan.get(i).getBarang());
            labelsIdUser[i] = new JLabel(""+listLaporan.get(i).getUser());
            labelsTanggal[i] = new JLabel(""+listLaporan.get(i).getTanggal());
            labelsPesan[i] = new JLabel(listLaporan.get(i).getKomentar());
            labelsStatus[i] = new JLabel(""+listLaporan.get(i).getStatus());
            int x=20;
            labelsLaporanId[i].setBounds(x, y, panjang, lebar);
            x += panjang + 10;
            labelsIdBarang[i].setBounds(x, y, panjang, lebar);
            x += panjang+10;
            labelsIdUser[i].setBounds(x, y, panjang, lebar);
            x += panjang + 10;
            labelsTanggal[i].setBounds(x, y, panjang, lebar);
            x += panjang + 10;
            labelsPesan[i].setBounds(x, y, panjang, lebar);
            x += panjang + 10;
            labelsStatus[i].setBounds(x, y, panjang, lebar);
            y += lebar + 10;
            view.add(labelsLaporanId[i]);
            view.add(labelsIdBarang[i]);
            view.add(labelsIdUser[i]);
            view.add(labelsTanggal[i]);
            view.add(labelsPesan[i]);
            view.add(labelsStatus[i]);
        }
        JButton[] buttonApprove = new JButton[listLaporan.size()];
        for(int i=0; i<listLaporan.size(); i++){
            buttonApprove[i] = new JButton("Approve");
            buttonApprove[i].setBounds(980, y, 100, lebar);
            y += lebar + 10;
            view.add(buttonApprove[i]);
        }
        for(int i=0; i<buttonApprove.length; i++){
            buttonApprove[i].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    int index = listLaporan.get(i).getId_laporan();
                    controller.LaporController.approveLaporanBarang(index);
                    view.dispose();
                }
            });
        }
        view.add(judulLaporanId);
        view.add(judulIdBarang);
        view.add(judulIdUser);
        view.add(judulTanggal);
        view.add(judulPesan);
        view.add(judulStatus);
        view.setVisible(true);
    }
}
