/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.KeranjangController;
import controller.SingletonProfile;
import java.awt.Color;
import java.awt.Font;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.Point;
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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Barang;
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
    static JFrame frame = new JFrame("Keranjang");
    ArrayList<Keranjang> tableKeranjang;
    ArrayList<Keranjang> selectedItems = new ArrayList<>();
    Font font2 = new Font("SansSerif", Font.PLAIN, 25);
    double total = 0;
    JLabel labelTotal = new JLabel("Total Harga : " + total);
    JButton checkout;
    
    public LihatKeranjangScreen() {
        User user = SingletonProfile.getInstance().getUser();
        tableKeranjang = null;
    	tableKeranjang = KeranjangController.getInstance().getAll(user.getId());
        lihatKeranjang();
    }
    
    private void lihatKeranjang() {
        
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
            "ID Keranjang", "Nama Barang", "Stock Barang", "Harga Barang", "Jumlah Barang", "Seleksi"
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
        
        tableData.addMouseListener(new MouseListener() {
                Date pressedTime;
                long timeClicked;
			
                @Override
                public void mouseReleased(MouseEvent e) {
                    timeClicked = new Date().getTime() - pressedTime.getTime();
                    if (timeClicked >= 500){
                        int selectedRow;
                        selectedRow = tableData.getSelectedRow();
                        int keranjangId = Integer.valueOf(tableData.getValueAt(selectedRow, 0).toString());
                        int jumlah = Integer.valueOf(tableData.getValueAt(selectedRow, 4).toString());
                        
                        JFrame f = new JFrame();
                        f.setSize(300, 300);
                        
                        JSpinner spinner = new JSpinner();
                        spinner.setValue(Integer.valueOf(jumlah));
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
                                    int jumlahBarangBaru = (Integer) spinner.getValue();
                                    if(jumlahBarangBaru <= KeranjangController.getInstance().getKeranjang(keranjangId).getBarang().getStok_barang()){
                                        Keranjang keranjangA = KeranjangController.getInstance().getKeranjang(keranjangId);
                                        KeranjangController.getInstance().updateKeranjang(keranjangId, jumlahBarangBaru);
                                        Keranjang keranjangB = KeranjangController.getInstance().getKeranjang(keranjangId);
                                        int counter = 0;
                                        for (Keranjang temp : selectedItems) {                                        
                                            if(temp.getId_keranjang() == keranjangA.getId_keranjang()){
                                                selectedItems.set(counter, keranjangB);
                                            }
                                            counter++;
                                        }
                                        f.setVisible(false);
                                        loadData();
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Kuantitas melebihi stok barang!");
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
                    if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                        int selectedRow;
                        selectedRow = tableData.getSelectedRow();
                        int keranjangId = Integer.valueOf(tableData.getValueAt(selectedRow, 0).toString());
                        //check if in selected
                        boolean isThere = false;
                        Keranjang keranjang = KeranjangController.getInstance().getKeranjang(keranjangId);
                        for (Keranjang c : selectedItems) {
                            if(c.getId_keranjang() == keranjangId){
                                isThere = true;
                                keranjang = c;
                            }
                        }
                        if(isThere){
                            selectedItems.remove(keranjang);
                        }
                        else{
                            selectedItems.add(keranjang);
                        }
                        //alter selected
                        tableData.setModel(tableModel);
                        loadData();
                    }
                }
        });
        
        
        JButton delete = new JButton("Delete");
        delete.setBounds(940,290,80,20);
        frame.add(delete);
        delete.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if(!selectedItems.isEmpty()){
                            for (Keranjang k : selectedItems) {
                                KeranjangController.getInstance().deleteKeranjang(k.getId_keranjang());
                                loadData();

                            }
                        }
                        loadData();
                    }
                });
        
        checkout = new JButton("Checkout");
        checkout.setBounds(800, 580, 100, 30);
        checkout.addActionListener(this);
        frame.add(checkout);
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
        tableKeranjang = null;
    	tableKeranjang = KeranjangController.getInstance().getAll(user.getId());
        
    	
        
        System.out.println(tableKeranjang);
        System.out.println("====================================================");
        if( !selectedItems.isEmpty() && tableKeranjang != null){

            for(Keranjang b : tableKeranjang) {
                for (Keranjang c : selectedItems) {
                    if(b.getId_keranjang() == c.getId_keranjang()){
                        Vector<Object> tableVector = new Vector<>();
                        tableVector.add(b.getId_keranjang());
                        tableVector.add(b.getBarang().getNama_barang());
                        tableVector.add(b.getBarang().getStok_barang()); 
                        tableVector.add(b.getBarang().getHarga_barang());
                        tableVector.add(b.getJumlah_barang());
                        tableVector.add("SELECTED");
                        tableModel.addRow(tableVector);
                    }
                    else{

                        Vector<Object> tableVector = new Vector<>();
                        tableVector.add(b.getId_keranjang());
                        tableVector.add(b.getBarang().getNama_barang());
                        tableVector.add(b.getBarang().getStok_barang()); 
                        tableVector.add(b.getBarang().getHarga_barang());
                        tableVector.add(b.getJumlah_barang());
                        tableVector.add("UNSELECTED");
                        tableModel.addRow(tableVector);
                    }
                }
            }
    	}
        else{
            if(tableKeranjang != null){
                for(Keranjang b : tableKeranjang) {
                    Vector<Object> tableVector = new Vector<>();
                    tableVector.add(b.getId_keranjang());
                    tableVector.add(b.getBarang().getNama_barang());
                    tableVector.add(b.getBarang().getStok_barang()); 
                    tableVector.add(b.getBarang().getHarga_barang());
                    tableVector.add(b.getJumlah_barang());
                    tableVector.add("UNSELECTED");
                    tableModel.addRow(tableVector);
                }
            }
        }
        tableData.setModel(tableModel);
    	
        total = 0;
        if(tableKeranjang != null){
            for (Keranjang c : selectedItems) {
                Barang barang = c.getBarang();
                int jumlah = c.getJumlah_barang();
                double harga = barang.getHarga_barang();
                total += jumlah*harga;
            }
        }
        
        
        labelTotal.setFont(font2);
        labelTotal.setBounds(800, 580, 300, 100);
        labelTotal.setText("Total Harga : " + total);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == checkout){
            if(!selectedItems.isEmpty()){
                frame.setVisible(false);
                new CheckoutScreen(selectedItems);
            }
            else{
                JOptionPane.showMessageDialog(null, "Keranjang anda masih kosong... Yuk belanja~~");
            }
        }
    }
}
