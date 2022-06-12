package FirstPage;

import View.Login_Officer;
import ViewInquiry.InquiryPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPanel extends JFrame{

    private JPanel FirstPanel;
    private JButton btnDriver;
    private JButton btnOfficer;

    public FirstPanel() {

        setContentPane(FirstPanel);
        setTitle("First Panel");
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnOfficer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Login_Officer OBJECT = new Login_Officer();
                dispose();



            }
        });

        btnDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                InquiryPanel OBJECT = new InquiryPanel();



            }
        });
    }
}
