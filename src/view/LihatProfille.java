package view;

import database.DatabaseHandler;
import controller.ControlUser;
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
    
    public LihatProfille(int user_id){
        user = controller.ControlUser.searchUser(user_id);
        tampilProfille(user, 1);
    }
    
    public static void tampilProfille(User user, int user_id){
        ControlUser cu = new ControlUser();
        user = cu.searchUser(user_id);
        JFrame view = new JFrame();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(600, 500);
        
        JLabel title = new JLabel("Your Profille");
        title.setFont(new Font("Serif", Font.PLAIN, 34));
        title.setBounds(80, 40, 200, 50);
        JLabel []labels = new JLabel[7];
        labels[0] = new JLabel("Nama");
        labels[0].setBounds(80, 100, 120, 25);
        labels[1] = new JLabel("Tanggal lahir");
        labels[1].setBounds(80, 135, 120, 25);
        labels[2] = new JLabel("Jenis Kelamin");
        labels[2].setBounds(80, 170, 120, 25);
        labels[3] = new JLabel("No Telepon");
        labels[3].setBounds(80, 205, 120, 25);
        labels[4] = new JLabel("Email");
        labels[4].setBounds(80, 240, 120, 25);
        labels[5] = new JLabel("Username");
        labels[5].setBounds(80, 275, 120, 25);
        labels[6] = new JLabel("Password");
        labels[6].setBounds(80, 310, 120, 25);
        
        JLabel[] valueLabel = new JLabel[labels.length];
        valueLabel[0] = new JLabel(user.getNama_lengkap());
        valueLabel[0].setBounds(210, 100, 250, 25);
        valueLabel[1] = new JLabel(user.getTanggal_lahir());
        valueLabel[1].setBounds(210, 135, 250, 25);
        valueLabel[2] = new JLabel(user.isJenis_kelamin());
        valueLabel[2].setBounds(210, 170, 250, 25);
        valueLabel[3] = new JLabel(user.getNo_telepon());
        valueLabel[3].setBounds(210, 205, 250, 25);
        valueLabel[4] = new JLabel(user.getEmail());
        valueLabel[4].setBounds(210, 240, 250, 25);
        valueLabel[5] = new JLabel(user.getUsername());
        valueLabel[5].setBounds(210, 275, 250, 25);
        String pw = "";
        for(int i=0; i<user.getPassword().length(); i++){
            pw += "*"; 
        }
        valueLabel[6] = new JLabel(pw);
        valueLabel[6].setBounds(210, 310, 250, 25);
        JButton kembali = new JButton("Kembali");
        kembali.setEnabled(true);
        kembali.setBounds(80, 350, 120, 30);
        JButton edit = new JButton("Ubah Profille");
        edit.setEnabled(true);
        edit.setBounds(250, 350, 120, 30);
        
        kembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeScreen();
            }
        });
        edit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = cu.searchUser(user_id);
                new EditProfille(user, user_id);
                view.dispose();
            }
        });
        
        view.add(title);
        for (JLabel label : labels) {
            view.add(label);
        }
        for(JLabel value : valueLabel){
            view.add(value);
        }
        view.add(kembali);
        view.add(edit);
        view.getContentPane().setLayout(null);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
