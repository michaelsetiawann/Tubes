/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.DatabaseHandler;
import java.sql.PreparedStatement;
import java.util.Date;

/**
 *
 * @author shyen
 */
public class LaporController {

    static DatabaseHandler aa = new DatabaseHandler();

    public static String insertLaporToko(int id_toko, int id_user,String pesan, int status) {
        aa.connect();
        try {
            String que = "INSERT INTO laporan_toko (id_toko,id_user,tanggal,pesan,status) VALUES (?,?,NOW(),?,?)";
            PreparedStatement state = aa.con.prepareStatement(que);
            state.setString(3, pesan);
            state.setInt(2, id_user);
            state.setInt(1, id_toko);
            state.setInt(4, status);
            state.executeUpdate();
            return "insert berhasill..";
        } catch (Exception e) {
            e.printStackTrace();
            return "insert gagal!";
        }
    }
}
