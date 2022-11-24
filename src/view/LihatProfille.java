package view;

import database.DatabaseHandler;
import controller.ControlUser;
import controller.SingletonProfile;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.User;

/**
 *
 * @author acer
 */
public class LihatProfille {
    static User user;
    
    public LihatProfille(){
        tampilProfille();
    }
    
    public static void tampilProfille(){
        JFrame view = new JFrame();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(600, 500);
        
        JLabel title = new JLabel("Your Profille");
        title.setFont(new Font("Serif", Font.PLAIN, 34));
        title.setBounds(80, 40, 200, 50);
        JLabel []labels = new JLabel[7];
        labels[0] = new JLabel("Nama");
        labels[0].setBounds(80, 100, 120, 25);
        view.add(labels[0]);
        labels[1] = new JLabel("Tanggal lahir");
        labels[1].setBounds(80, 135, 120, 25);
        view.add(labels[1]);
        labels[2] = new JLabel("Jenis Kelamin");
        labels[2].setBounds(80, 170, 120, 25);
        view.add(labels[2]);
        labels[3] = new JLabel("No Telepon");
        labels[3].setBounds(80, 205, 120, 25);
        view.add(labels[3]);
        labels[4] = new JLabel("Email");
        labels[4].setBounds(80, 240, 120, 25);
        view.add(labels[4]);
        labels[5] = new JLabel("Username");
        labels[5].setBounds(80, 275, 120, 25);
        view.add(labels[5]);
//        labels[6] = new JLabel("Password");
//        labels[6].setBounds(80, 310, 120, 25);
//        view.add(labels[6]);
        
        String nama, tanggalLahir, jenisKelamin, noTelp, email, username, password;
        nama = SingletonProfile.getInstance().getUser().getNama_lengkap();
        tanggalLahir = SingletonProfile.getInstance().getUser().getTanggal_lahir();
        jenisKelamin = SingletonProfile.getInstance().getUser().getJenis_kelamin();
        noTelp = SingletonProfile.getInstance().getUser().getNo_telepon();
        username = SingletonProfile.getInstance().getUser().getUsername();
        password = SingletonProfile.getInstance().getUser().getPassword();
        email = SingletonProfile.getInstance().getUser().getEmail();
        
        JLabel[] valueLabel = new JLabel[labels.length];
        valueLabel[0] = new JLabel(nama);
        valueLabel[0].setBounds(210, 100, 250, 25);
        valueLabel[1] = new JLabel(tanggalLahir);
        valueLabel[1].setBounds(210, 135, 250, 25);
        valueLabel[2] = new JLabel(jenisKelamin);
        valueLabel[2].setBounds(210, 170, 250, 25);
        valueLabel[3] = new JLabel(noTelp);
        valueLabel[3].setBounds(210, 205, 250, 25);
        valueLabel[4] = new JLabel(email);
        valueLabel[4].setBounds(210, 240, 250, 25);
        valueLabel[5] = new JLabel(username);
        valueLabel[5].setBounds(210, 275, 250, 25);
//        valueLabel[6] = new JLabel(password);
//        valueLabel[6].setBounds(210, 310, 250, 25);
        view.add(valueLabel[0]);
        view.add(valueLabel[1]);
        view.add(valueLabel[2]);
        view.add(valueLabel[3]);
        view.add(valueLabel[4]);
        view.add(valueLabel[5]);
//        view.add(valueLabel[6]);
//        JCheckBox showPassword = new JCheckBox("Show Password");
//        showPassword.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(showPassword.isSelected()){
//                    valueLabel[6].setEchoChar((char)0);
//                }
//                else{
//                    valueLabel[6].setEchoChar('•');
//                }
//            }
//        });
//        String pw = "";
//        for(int i=0; i<user.getPassword().length(); i++){
//            pw += "*"; 
//        }
//        valueLabel[6] = new JLabel(pw);
//        valueLabel[6].setBounds(210, 310, 250, 25);
        JButton kembali = new JButton("Kembali");
        kembali.setEnabled(true);
        kembali.setBounds(80, 350, 120, 30);
        JButton edit = new JButton("Ubah Profile");
        edit.setEnabled(true);
        edit.setBounds(250, 350, 120, 30);
        
        kembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                new HomeScreen();
            }
        });
        edit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditProfille();
                view.dispose();
            }
        });
        
        view.add(title);
        view.add(kembali);
        view.add(edit);
        view.getContentPane().setLayout(null);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
