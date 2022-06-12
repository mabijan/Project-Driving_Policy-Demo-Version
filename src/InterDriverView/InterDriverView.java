package InterDriverView;

import Acc_Inquiry_View.SwingAcc_Inquiry;
import FirstTaskView.SwingFirstTask;
import PayTaxView.PayTaxSwing;
import ViewInquiry.Swing_Inquiry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterDriverView extends JFrame {

    JFrame frameIN;
    JButton btnPAY_TIC, btnACC_INQ, btnPAY_TAX;

    public InterDriverView() throws HeadlessException {
        creatUI();
    }

    private void creatUI() {

        frameIN = new JFrame("IntOfficer");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int wScreen = (int) screenSize.getWidth();
        int hScreen = (int) screenSize.getHeight();

        int wFrame = 500;
        int hFrame = 400;

        frameIN.setBounds(wScreen / 2 - wFrame / 2, hScreen / 2 - hFrame / 2, wFrame, hFrame);
        frameIN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnPay_TIC = new JButton("استعلام و پرداخت جرایم");
        btnPay_TIC.setBounds(170, 10, 150, 60);

        JButton btnACC_INQ = new JButton("استعلام تصادفات");
        btnACC_INQ.setBounds(170, 100, 150, 60);

        JButton btnPAY_TAX = new JButton("خرید عوارض");
        btnPAY_TAX.setBounds(170, 190, 150, 60);

        JButton btnRE_TRAFFIC = new JButton("استعلام طرح ترافیک");
        btnRE_TRAFFIC.setBounds(170, 280, 150, 60);

        frameIN.add(btnACC_INQ);
        frameIN.add(btnPay_TIC);
        frameIN.add(btnPAY_TAX);
        frameIN.add(btnRE_TRAFFIC);

        frameIN.setLayout(null);
        frameIN.setVisible(true);

        btnPay_TIC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    new Swing_Inquiry();
                } catch (UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (InstantiationException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
                frameIN.dispose();
            }
        });

        btnACC_INQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new SwingAcc_Inquiry();
                frameIN.dispose();
            }
        });

        btnPAY_TAX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new PayTaxSwing();
                frameIN.dispose();
            }
        });

        btnRE_TRAFFIC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new SwingFirstTask();
                frameIN.dispose();
            }
        });

    }
}