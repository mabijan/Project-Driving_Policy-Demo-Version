package ViewInquiry;

import InquiryCont.InquiryCont;
import InquiryModel.InquiryEnti;
import InquiryModel.InquiryRepo;
import InquiryModel.InquiryServ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Swing_Inquiry extends JFrame {

    JFrame frameinquiry;
    JLabel lblDriverName, lblCarNumber, lblNegativePoint, lblPenalty;
    JTextField txtDriverName, txtCar_Tag1, txtCar_Tag2, txtCar_Tag3, txtNegativePoint, txtPenalty;
    JButton btnOk, btnPay;

    public Swing_Inquiry() throws HeadlessException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        createUI();
    }

    private void createUI() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        frameinquiry = new JFrame("Inquiry");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int wScreen = (int) screenSize.getWidth();
        int hScreen = (int) screenSize.getHeight();
        int wFrame = 500;
        int hFrame = 400;
        frameinquiry.setBounds(wScreen / 2 - wFrame / 2, hScreen / 2 - hFrame / 2, wFrame, hFrame);
        frameinquiry.setIconImage(Toolkit.getDefaultToolkit().createImage("Images/Icons/inquiry.png"));
        frameinquiry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lblDriverName = new JLabel("نام راننده : ");
        lblDriverName.setBounds(430, 15, 200, 70);
        txtDriverName = new JTextField();
        txtDriverName.setBounds(195, 35, 220, 30);
        lblCarNumber = new JLabel("شماره پلاک :");
        lblCarNumber.setBounds(423, 60, 200, 70);
        txtCar_Tag1 = new JTextField();
        txtCar_Tag2 = new JTextField();
        txtCar_Tag3 = new JTextField();
        txtCar_Tag1.setBounds(195, 80, 80, 30);
        txtCar_Tag2.setBounds(285, 80, 40, 30);
        txtCar_Tag3.setBounds(335, 80, 80, 30);
        btnOk = new JButton("ثبت");
        btnOk.setBounds(205, 150, 90, 40);
        lblNegativePoint = new JLabel("نمره منفی :");
        lblNegativePoint.setBounds(423, 210, 200, 70);
        txtNegativePoint = new JTextField();
        txtNegativePoint.setBounds(195, 230, 220, 30);
        lblPenalty = new JLabel("چریمه : ");
        lblPenalty.setBounds(420, 255, 200, 70);
        txtPenalty = new JTextField();
        txtPenalty.setBounds(195, 275, 220, 30);
        btnPay = new JButton("پرداخت");
        btnPay.setBounds(205, 315, 90, 40);


        frameinquiry.add(lblDriverName);
        frameinquiry.add(txtDriverName);
        frameinquiry.add(lblCarNumber);
        frameinquiry.add(txtCar_Tag1);
        frameinquiry.add(txtCar_Tag2);
        frameinquiry.add(txtCar_Tag3);
        frameinquiry.add(btnOk);
        frameinquiry.add(lblNegativePoint);
        frameinquiry.add(txtNegativePoint);
        frameinquiry.add(lblPenalty);
        frameinquiry.add(txtPenalty);
        frameinquiry.add(btnPay);
        frameinquiry.setLayout(null);
        frameinquiry.setVisible(true);

        btnOk.addActionListener(new ActionListener() {

            private String negative_points;
            private String total_price;

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    String DName = txtDriverName.getText();
                    String Car_Tag1 = txtCar_Tag1.getText();
                    String Car_Tag2 = txtCar_Tag2.getText();
                    String Car_Tag3 = txtCar_Tag3.getText();

                    InquiryCont inquiryCont = new InquiryCont(DName, Car_Tag1, Car_Tag2, Car_Tag3);
                    boolean KEY = inquiryCont.InquiryCont();

                    if (KEY == true) {

                        InquiryEnti inquiryEnti = new InquiryEnti(DName, Car_Tag1, Car_Tag2, Car_Tag3);

                        InquiryServ.getInstance().Inquiry(inquiryEnti);

                        InquiryRepo inquiryRepo = new InquiryRepo();
                        //inquiryRepo.Inquiry(inquiryEnti);
                        negative_points = inquiryEnti.getNegativePoints();
                        total_price = inquiryEnti.getTotalPrice();
                        //inquiryRepo.close();

                        System.out.print(negative_points + "*****" + total_price);

                        txtNegativePoint.setText(negative_points);
                        txtPenalty.setText(total_price);

                    } else if (KEY == false) {

                        createUIComponents();
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        btnPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new PayView.Swing();
                frameinquiry.dispose();

            }
        });
    }

    private void createUIComponents () throws
            UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // TODO: place custom component creation code here

        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        JOptionPane.showMessageDialog(frameinquiry, "INVALID DATA!", "ENTER DENIED", JOptionPane.ERROR_MESSAGE);
    }
}