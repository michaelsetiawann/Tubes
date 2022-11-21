/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.Barang;

/**
 *
 * @author Lenovo
 */
public class SingletonBarang {

    private DatabaseHandler conn = new DatabaseHandler();
    private Barang barang;
    private static SingletonBarang controller = null;

    public static SingletonBarang getInstance() {
        if (controller == null) {
            controller = new SingletonBarang();
        }
        return controller;
    }

    public SingletonBarang() {
        barang = new Barang(0, null, 0, 0, null, 0, 0, 0);
    }
    
    public void reset(){
        barang = new Barang();
    }

    public Vector<Barang> getAllBarang() {
        conn.connect();

        Vector<Barang> barangVector = new Vector<>();
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM barang");
            while (result.next()) {
                int id_barang = result.getInt("id_barang");
                String nama_barang = result.getString("nama_barang");
                int stok_barang = result.getInt("stok_barang");
                double harga_barang = result.getDouble("harga_barang");
                String deskripsi_barang = result.getString("deskripsi_barang");
                int jumlah_pengunjung = result.getInt("jumlah_pengunjung");
                int status = result.getInt("status");

                Barang barang = new Barang(id_barang, nama_barang, stok_barang, harga_barang, deskripsi_barang, jumlah_pengunjung,
                        status);
                barangVector.add(barang);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error occured when connecting to database.");
        }
        return barangVector;
    }

    public Vector<Barang> getBarangByName(String nama) {
        conn.connect();
        Vector<Barang> barangVector = new Vector<>();

        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM barang WHERE nama_barang like'%" + nama + "%'");

            while (result.next()) {
                int id_barang = result.getInt("id_barang");
                String nama_barang = result.getString("nama_barang");
                int stok_barang = result.getInt("stok_barang");
                double harga_barang = result.getDouble("harga_barang");
                String deskripsi_barang = result.getString("deskripsi_barang");
                int jumlah_pengunjung = result.getInt("jumlah_pengunjung");
                int status = result.getInt("status");

                Barang barang = new Barang(id_barang, nama_barang, stok_barang, harga_barang, deskripsi_barang, jumlah_pengunjung,
                        status);
                barangVector.add(barang);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error occured when connecting to database.");
        }
        return barangVector;
    }

    public Barang getProductDetails(int productId) {
        conn.connect();

        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM barang WHERE id_barang ='" + productId + "'");
            if (result.next()) {
                int id_barang = result.getInt("id_barang");
                String nama_barang = result.getString("nama_barang");
                int stok_barang = result.getInt("stok_barang");
                double harga_barang = result.getDouble("harga_barang");
                String deskripsi_barang = result.getString("deskripsi_barang");
                int jumlah_pengunjung = result.getInt("jumlah_pengunjung");
                int status = result.getInt("status");

                Barang barang = new Barang(id_barang, nama_barang, stok_barang, harga_barang, deskripsi_barang, jumlah_pengunjung,
                        status);
                return barang;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error occured when connecting to database.");
        }
        return null;

    }

    public double getAverage(int productId) {
        conn.connect();
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM transaksi WHERE id_barang ='" + productId + "'");
            double ratingTotal = 0;
            int counter = 0;
            while(result.next()) {
                Double rating = result.getDouble("rating");
                ratingTotal += rating;
                counter++;
            }
            return ratingTotal/counter;

        } catch (SQLException e) {
                // TODO: handle exception
        }
        return 0;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }
    
}
