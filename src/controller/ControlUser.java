package controller;

import database.DatabaseHandler;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.User;
import static view.LihatProfille.tampilProfille;

/**
 *
 * @author acer
 */
public class ControlUser {
    static User user;
    static boolean search = false;
    public static User searchUser(int index) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM user WHERE id_user='" + index + "'");
            if (result.next()) {
                int idUser = result.getInt("id_user");
                String nama = result.getString("nama_lengkap_pembeli");
                String tglLahir = result.getString("tanggal_lahir");
                String jenisKelamin = result.getString("jenis_kelamin");
                String noTlp = result.getString("no_telepon");
                String email = result.getString("email");
                String username = result.getString("username");
                String password = result.getString("password");

                user = new User(nama, tglLahir, jenisKelamin, noTlp, email, idUser, username, password);
                search = true;
            } else {
                JOptionPane.showMessageDialog(null, "User not found.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error occured when connecting to database.");
        }
        conn.disconnect();
        return user;
    }
    
    public static void mengubahData(int user_id, String nama_lengkap_pembeli, String tanggal_lahir, String jenis_kelamin, String no_telepon, String email, String username, String password) throws SQLException {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try {
            PreparedStatement stat = conn.con.prepareStatement("UPDATE user SET nama_lengkap_pembeli = ?,tanggal_lahir = ?,jenis_kelamin = ?,no_telepon = ?,email = ?,username = ?,password = ? WHERE id_user ='"+user_id+"'");
            stat.setString(1, nama_lengkap_pembeli);
            stat.setString(2, tanggal_lahir);
            stat.setString(3, jenis_kelamin);
            stat.setString(4, no_telepon);
            stat.setString(5, email);
            stat.setString(6, username);
            stat.setString(7, password);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil update profille");

        } catch (SQLException e) {
            if (e.getMessage().contains("'email'")) {
                JOptionPane.showMessageDialog(null, "email sudah digunakan");
            } else if (e.getMessage().contains("'password'")) {
                JOptionPane.showMessageDialog(null, "password sudah digunakan");
            } else {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error fatal pusing!");
            }
        }
    }
}
