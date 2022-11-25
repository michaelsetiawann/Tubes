/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.SingletonProfile;
import controller.UserController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author William
 */
public class UpdateProduk {
    public UpdateProduk() {
        updateProduk();

    }

    public void updateProduk() {
        String nama, tanggalLahir, jenisKelamin, noTelp, email, username, password;
        nama = SingletonProfile.getInstance().getUser().getNama_lengkap();
        tanggalLahir = SingletonProfile.getInstance().getUser().getTanggal_lahir();
        jenisKelamin = SingletonProfile.getInstance().getUser().getJenis_kelamin();
        noTelp = SingletonProfile.getInstance().getUser().getNo_telepon();
        username = SingletonProfile.getInstance().getUser().getUsername();
        email = SingletonProfile.getInstance().getUser().getEmail();

        JFrame view = new JFrame();
        view.setSize(600, 500);
        view.setLocationRelativeTo(null);
        view.getContentPane().setLayout(null);

        JLabel title = new JLabel("Your Profille");
        title.setFont(new Font("Serif", Font.PLAIN, 34));
        title.setBounds(80, 40, 200, 50);
        JLabel[] labels = new JLabel[7];
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

        JTextField txtNama = new JTextField();
        txtNama.setBounds(200, 100, 150, 25);
        txtNama.setText(nama);
//        UtilDateModel model = new UtilDateModel();
//        Properties p = new Properties();
//        p.put("text.today", "Today");
//        p.put("text.month", "Month");
//        p.put("text.year", "Year");
//        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
//        JDatePickerImpl tglLahir = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        JLabel tglLahir = new JLabel(tanggalLahir);
        tglLahir.setBounds(200, 135, 150, 25);
        JLabel jk = new JLabel(jenisKelamin);
        jk.setBounds(200, 170, 100, 25);
//        ButtonGroup grupJenisKelamin = new ButtonGroup();
//        grupJenisKelamin.add(pria);
//        grupJenisKelamin.add(wanita);
        JTextField txtNoTelepon = new JTextField();
        txtNoTelepon.setBounds(200, 205, 150, 25);
        txtNoTelepon.setText(noTelp);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(200, 240, 150, 25);
        txtEmail.setText(email);
        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(200, 275, 150, 25);
        txtUsername.setText(username);
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(200, 310, 150, 25);
        JCheckBox showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(360, 310, 150, 25);
        showPassword.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(showPassword.isSelected()){
                    txtPassword.setEchoChar((char)0);
                }
                else{
                    txtPassword.setEchoChar('•');
                }
            }
        });
        view.add(showPassword);

        JButton kembali = new JButton("Back");
        kembali.setEnabled(true);
        kembali.setBounds(80, 350, 120, 30);
        JButton save = new JButton("Save");
        save.setEnabled(true);
        save.setBounds(250, 350, 120, 30);

        kembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatProfille();
                view.dispose();
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtNama.getText().isEmpty() || txtNoTelepon.getText().isEmpty() || txtEmail.getText().isEmpty() || txtUsername.getText().isEmpty() || String.valueOf(txtPassword.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom wajib diisi!");
                } else {
                    new UserController().updateUser(txtNama.getText(), txtNoTelepon.getText(), txtUsername.getText(), String.valueOf(txtPassword.getPassword()), txtEmail.getText());
                    new LihatProfille();
                    view.dispose();
                }
            }
        });

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.add(title);
        for (JLabel label : labels) {
            view.add(label);
        }
        view.add(txtNama);
        view.add(tglLahir);
        view.add(txtNoTelepon);
        view.add(txtEmail);
        view.add(txtUsername);
        view.add(txtPassword);
        view.add(jk);
        view.add(kembali);
        view.add(save);
        view.setVisible(true);
    }
}
