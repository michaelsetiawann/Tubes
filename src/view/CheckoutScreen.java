/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.AlamatController;
import controller.SingletonProfile;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Alamat;
import model.Barang;
import model.Keranjang;
import static view.LihatKeranjangScreen.frame;

/**
 *
 * @author acer
 */
public class CheckoutScreen extends JFrame implements ActionListener{
    private DefaultTableModel tableModel;
    private JTable tableData;
    private Vector<Object> tableVector;
    static JFrame frame = new JFrame("Checkout");
    private ArrayList<Keranjang> listKeranjang;
    JLabel labelTotal = new JLabel();
    double total;
    
    public CheckoutScreen(ArrayList<Keranjang> keranjangList){
        listKeranjang = keranjangList;
        checkoutScreen();
    }
    private void checkoutScreen(){
        //font 
        Font font1 = new Font("SansSerif", Font.PLAIN, 15);
        Font font2 = new Font("SansSerif", Font.PLAIN, 25);
        //panel
        
        JLabel title = new JLabel("Checkout");
        title.setFont(font2);
        title.setBounds(470, 80, 300, 30);
        frame.add(title);
        //panel add
        PanelMenu menu = new PanelMenu();
        JPanel panelMenu = menu.getPanel(frame);
        frame.add(panelMenu);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10,120,1050,190);
        frame.getContentPane().add(scrollPane);

        tableData = new JTable(tableModel) {
            public boolean isCellEditable(int row, int column) {
                    return false;
            }
        };
        scrollPane.setViewportView(tableData);
        
        
        
        loadData();
        
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
        
    	tableModel = new DefaultTableModel(headerTitle, 0);
        
        for(Keranjang b : listKeranjang) {
            Vector<Object> tableVector = new Vector<>();
            tableVector.add(b.getId_keranjang());
            tableVector.add(b.getBarang().getNama_barang());
            tableVector.add(b.getBarang().getStok_barang()); 
            tableVector.add(b.getBarang().getHarga_barang());
            tableVector.add(b.getJumlah_barang());
            tableModel.addRow(tableVector);
        }
        tableData.setModel(tableModel);
    	
        total = 0;
        for (Keranjang c : listKeranjang) {
            Barang barang = c.getBarang();
            int jumlah = c.getJumlah_barang();
            double harga = barang.getHarga_barang();
            total += jumlah*harga;
        }
        
        Font font2 = new Font("SansSerif", Font.PLAIN, 25);
        labelTotal.setFont(font2);
        labelTotal.setBounds(800, 580, 300, 100);
        labelTotal.setText("Total Harga : " + total);
        System.out.println("total = " + total);
        
        int id_user = SingletonProfile.getInstance().getUser().getId();
        ArrayList<Alamat> listAlamat = new AlamatController().getAll(id_user);
        
        if(listAlamat == null){
            JButton addAlamat = new JButton("Tambah Alamat");
            addAlamat.setBounds(800, 550, 130, 30);
            frame.add(addAlamat);
            addAlamat.addActionListener(this);
            //add alamat
        }
        else{
            Alamat[] alamatArray = new Alamat[listAlamat.size()];
            System.out.println("list alamat : " + listAlamat);
            for (int i = 0; i < listAlamat.size(); i++) {
                alamatArray[i] = listAlamat.get(i);
            }
            JComboBox alamatComboBox = new JComboBox(alamatArray);
            alamatComboBox.setBounds(800, 550, 130, 30);
            frame.add(alamatComboBox);
        }
        
        frame.add(labelTotal);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
