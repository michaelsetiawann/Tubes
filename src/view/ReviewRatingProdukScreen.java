/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author shyen
 */
public class ReviewRatingProdukScreen {

    public ReviewRatingProdukScreen(int transId,int rate) {
        review(transId,rate);
    }

    private void review(int transId,int rate) {
        JFrame f = new JFrame();
        f.setSize(500, 500);

        JLabel rating = new JLabel("Rating");
        rating.setBounds(20, 20, 200, 50);
        f.add(rating);

        JSpinner spinner = new JSpinner();
        spinner.setValue(rate);
        spinner.setBounds(70, 100, 60, 40);
        f.add(spinner);

        JButton update = new JButton("Update");
        update.setBounds(150, 105, 100, 30);

        JLabel rev = new JLabel("Review");
        rev.setBounds(20, 180, 200, 50);
        f.add(rev);
        
        JTextField review = new JTextField();
        review.setBounds(70, 180, 200, 50);
        f.add(review);

        f.add(update);
        f.setLayout(null);
        f.setVisible(true);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == update) {
                    int rateBaru = (Integer)spinner.getValue();
                    if (rateBaru <= 5) {
                        controller.TransaksiController.updateRatingReview(rateBaru, transId,review.getText());
                        f.dispose();
                        new TransactionScreen();
                    } else {
                        JOptionPane.showMessageDialog(null, "Bintang maksimal 5");
                    }
                }
            }
        });
    }
}
