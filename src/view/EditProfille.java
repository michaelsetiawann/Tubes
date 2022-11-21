package view;

import controller.ControlUser;
import controller.DateLabelFormatter;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import model.User;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
//import static view.LihatProfille.searchUser;

/**
 *
 * @author acer
 */
public class EditProfille {

    public EditProfille(User user, int user_id) {
        user = controller.ControlUser.searchUser(user_id);
        mengeditProfille(user, user_id);
    }

    public static void mengeditProfille(User user, int user_id) {
        ControlUser cu = new ControlUser();

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
        txtNama.setText(user.getNama_lengkap());
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl tglLahir = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        tglLahir.setBounds(200, 135, 150, 25);
        JRadioButton pria = new JRadioButton("Laki-laki");
        pria.setBounds(200, 170, 100, 25);
        JRadioButton wanita = new JRadioButton("Perempuan");
        wanita.setBounds(280, 170, 100, 25);
        ButtonGroup grupJenisKelamin = new ButtonGroup();
        grupJenisKelamin.add(pria);
        grupJenisKelamin.add(wanita);
        JTextField txtNoTelepon = new JTextField();
        txtNoTelepon.setBounds(200, 205, 150, 25);
        txtNoTelepon.setText(user.getNo_telepon());
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(200, 240, 150, 25);
        txtEmail.setText(user.getEmail());
        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(200, 275, 150, 25);
        txtUsername.setText(user.getUsername());
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(200, 310, 150, 25);
        txtPassword.setText(user.getPassword());

        JButton kembali = new JButton("Kembali");
        kembali.setEnabled(true);
        kembali.setBounds(80, 350, 120, 30);
        JButton save = new JButton("Save");
        save.setEnabled(true);
        save.setBounds(250, 350, 120, 30);

        kembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatProfille(user_id);
                view.dispose();
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtNama.getText().isEmpty() || tglLahir.getJFormattedTextField().getText().isEmpty() || controller.UserController.findJK(pria, wanita).isEmpty() || txtNoTelepon.getText().isEmpty() || txtEmail.getText().isEmpty() || txtUsername.getText().isEmpty() || txtPassword.getPassword().equals("")) {
                    JOptionPane.showMessageDialog(null, "Semua kolom wajib diisi!");
                } else {
                    cu.mengubahData(user_id, txtNama.getText(), tglLahir.getJFormattedTextField().getText(), controller.UserController.findJK(pria, wanita), txtNoTelepon.getText(), txtEmail.getText(), txtUsername.getText(), txtPassword.getText());
                    new LihatProfille(user_id);
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
        view.add(pria);
        view.add(wanita);
        view.add(txtNoTelepon);
        view.add(txtEmail);
        view.add(txtUsername);
        view.add(txtPassword);
        view.add(kembali);
        view.add(save);
        view.setVisible(true);
    }
}
