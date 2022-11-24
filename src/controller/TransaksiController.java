/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.DatabaseHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model.Barang;
import model.MetodePembayaranEnum;
import model.StatusPengirimanEnum;
import model.Transaksi;

/**
 *
 * @author acer
 */
public class TransaksiController {

    private static DatabaseHandler aa = new DatabaseHandler();
    private Transaksi transaksi;
    private static TransaksiController controller = null;

    public static TransaksiController getInstance() {
        if (controller == null) {
            controller = new TransaksiController();
        }
        return controller;
    }
    
    private TransaksiController() {
        transaksi = new Transaksi(0, null, 0, null, null, null, null, 0, 0);
    }
    
    public void reset() {
        transaksi = new Transaksi();
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }
    
    public Transaksi getTransaksi() {
        return this.transaksi;
    }

    public Transaksi getTrans(int id_trans) {
        aa.connect();
        ArrayList<Transaksi> transList = new ArrayList<>();
        try {
                java.sql.Statement stat = aa.con.createStatement();
                ResultSet result = stat.executeQuery("SELECT * FROM transaksi WHERE id_transaksi='" + id_trans + "'");
                if(result.next()) {
                Transaksi trans = map(result);
                return trans;
                }
        } catch (SQLException e) {
                // TODO: handle exception
        }
        return null;
    }
    
    private static Transaksi map(ResultSet rs) {
        int id_transaksi;
        int jumlahBarang;
        Date tanggal;
        String pesan_review;
        double rating;

        Barang barang;
        StatusPengirimanEnum status = null;
        MetodePembayaranEnum metodePembayaran = null;

        try {
            id_transaksi = rs.getInt("id_transaksi");
            jumlahBarang = rs.getInt("jumlah_barang");
            tanggal = rs.getDate("tanggal");
            pesan_review = rs.getString("pesan_review");
            rating = rs.getDouble("rating");
            int id_barang = rs.getInt("id_barang");
            barang = SingletonBarang.getInstance().getProductDetails(id_barang);
            int statuss = rs.getInt("status");
            int id_user = SingletonProfile.getInstance().getUser().getId();
            for (StatusPengirimanEnum x : StatusPengirimanEnum.values()) {
                if (x.getValue() == statuss) {
                    status = x;
                }
            }
            int metodePembayarann = rs.getInt("metode_pembayaran");
            for (MetodePembayaranEnum x : MetodePembayaranEnum.values()) {
                if (x.getValue() == metodePembayarann) {
                    metodePembayaran = x;
                }
            }
            return new Transaksi(id_transaksi, barang, jumlahBarang, tanggal, status, metodePembayaran, pesan_review, rating, id_user);
        } catch (Exception e) {

        }
        return null;
    }

    public void insertTransaksi(Barang barang, int jumlahBarang, StatusPengirimanEnum status, MetodePembayaranEnum metodePembayaran, String pesan_review, double rating) {
        aa.connect();
        int id_user = SingletonProfile.getInstance().getUser().getId();
        int id_barang = barang.getId_barang();
        int statuss = status.getValue();
        int metode_pembayaran = metodePembayaran.getValue();
        try {
            String query = "INSERT INTO transaksi (id_user, id_barang, status, pesan_review, rating, jumlah_barang, metode_pembayaran) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement state = aa.con.prepareStatement(query);
            state.setInt(1, id_user);
            state.setInt(2, id_barang);
            state.setInt(3, statuss);
            state.setString(4, pesan_review);
            state.setDouble(5, rating);
            state.setInt(6, jumlahBarang);
            state.setInt(7, metode_pembayaran);
            state.executeUpdate();
//            sout "insert berhasill..";
        } catch (Exception e) {
            e.printStackTrace();
//            return "insert gagal!";
        }
    }

    public static ArrayList<Transaksi> getTransaksi(int id_user) {
        ArrayList<Transaksi> listTrans = new ArrayList<>();
        aa.connect();
        try {
            String que = "Select * from transaksi where id_user = '" + id_user + "'";
            PreparedStatement state = aa.con.prepareStatement(que);
            ResultSet res = state.executeQuery(que);
            StatusPengirimanEnum status = null;

            MetodePembayaranEnum metodePembayaran = null;
            while (res.next()) {
                Transaksi trans = map(res);
                listTrans.add(trans);
                System.out.println("database aman");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTrans;
    }
    
    public static ArrayList<Transaksi> getTransaksiToko(int id_toko) {
        ArrayList<Transaksi> listTrans = new ArrayList<>();
        aa.connect();
        try {
            String que = "SELECT * FROM transaksi\n" +
                        "WHERE id_barang IN (SELECT id_barang FROM barang WHERE id_toko = "+id_toko+");";
            PreparedStatement state = aa.con.prepareStatement(que);
            ResultSet res = state.executeQuery(que);
            StatusPengirimanEnum status = null;

            MetodePembayaranEnum metodePembayaran = null;
            while (res.next()) {
                Transaksi trans = map(res);
                listTrans.add(trans);
                System.out.println("database aman");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTrans;
    }
    
    public ArrayList<Transaksi> konfirmasiTransaksi() {
        ArrayList<Transaksi> listTrans = new ArrayList<>();
        aa.connect();
        int id_transaksi = TransaksiController.getInstance().getTransaksi().getId_transaksi();
        try {
            String que = "UPDATE transaksi SET status = 1 WHERE id_transaksi = " + id_transaksi;
            PreparedStatement state = aa.con.prepareStatement(que);
            state.executeUpdate(que);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTrans;
    }
    
    public ArrayList<Transaksi> batalkanTransaksi() {
        ArrayList<Transaksi> listTrans = new ArrayList<>();
        aa.connect();
        int id_transaksi = TransaksiController.getInstance().getTransaksi().getId_transaksi();
        try {
            String que = "UPDATE transaksi SET status = 5 WHERE id_transaksi = " + id_transaksi;
            PreparedStatement state = aa.con.prepareStatement(que);
            state.executeUpdate(que);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTrans;
    }
    
  
    
}
