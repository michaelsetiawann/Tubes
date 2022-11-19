/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Keranjang;
import model.User;

/**
 *
 * @author acer
 */
public class LihatKeranjangScreen extends JFrame implements ActionListener{
    private DefaultTableModel tableModel;
    private JTable tableData;
    private Vector<Object> tableVector;
    static JFrame frame = new JFrame("Product Details");

    public LihatKeranjangScreen() {
        lihatKeranjangScreen();
    }
    
    private void lihatKeranjangScreen() {
        //font 
        Font font1 = new Font("SansSerif", Font.PLAIN, 15);
        Font font2 = new Font("SansSerif", Font.PLAIN, 25);
        
        //panel
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(Color.GREEN);

        panelMenu.setBounds(0, 0, 1080, 75);
        panelMenu.setLayout(null);
        JButton namaApp = new JButton("TOKOMEDIA");
        namaApp.setFont(font2);
        namaApp.setBackground(null);
        namaApp.setBorderPainted(false);

        namaApp.setBounds(0, 0, 200, 75);
        panelMenu.add(namaApp);

        JButton transaksi = new JButton("Transaksi");
        transaksi.setBounds(215, 25, 100, 25);
        transaksi.setFont(font1);
        transaksi.setBackground(null);
        transaksi.setBorderPainted(false);
        panelMenu.add(transaksi);

        JLabel label = new JLabel();
        label.setText("Cari Produk");
        label.setBounds(350, 33, 110, 10);
        panelMenu.add(label);

        JTextField namaBarang = new JTextField();
        namaBarang.setBounds(425, 27, 150, 30);
        panelMenu.add(namaBarang);

        JButton btnCari = new JButton("Klik Cari");
        btnCari.setBounds(580, 20, 150, 40);
        panelMenu.add(btnCari);
        btnCari.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                new CariProdukJtable(namaBarang.getText());
            }
        });
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10,80,1050,190);
        frame.getContentPane().add(scrollPane);
        
        tableModel = new DefaultTableModel();	
        tableData = new JTable(tableModel) {
        	public boolean isCellEditable(int row, int column) {
        		return false;
        	}
        };
        scrollPane.setViewportView(tableData);
        
        loadData();
        
        //frame
        frame.setSize(1080, 720);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(panelMenu);

    }
    
    private void loadData() {
    	String headerTitle[] = {
    			"ID Keranjang", "Nama Barang", "Stock Barang", "Harga Barang", "Jumlah Barang"
    	};
    	DefaultTableModel tableModel = new DefaultTableModel(headerTitle, 0);
    	Vector<Keranjang> tableKeranjang = new Keranjang().getAll(id_user);//somehow get from somewhere
    	for(Keranjang b : tableKeranjang) {
    		Vector<Object> tableVector = new Vector<>();
    		tableVector.add(b.getId_keranjang());
    		tableVector.add(b.getBarang().getNama_barang());
    		tableVector.add(b.getBarang().getStok_barang()); 
    		tableVector.add(b.getBarang().getHarga_barang());
    		tableVector.add(b.getJumlah_barang());
    		tableModel.addRow(tableVector);
    	}
    	tableData.setModel(tableModel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
