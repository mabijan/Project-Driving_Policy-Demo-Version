package InterOfficerView;

import Accident_View.Acc_View;
import View.Swing_EnterTickets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterOfficerView extends JFrame {

    JFrame frameIN;
    JButton btnTIC, btnACC;

    public InterOfficerView() throws HeadlessException {
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

        JButton btnTIC = new JButton("ثبت جریمه");
        btnTIC.setBounds(190, 100, 100, 70);

        JButton btnACC = new JButton("ثبت تصادف");
        btnACC.setBounds(190, 200, 100, 70);

        frameIN.add(btnACC);
        frameIN.add(btnTIC);

        frameIN.setLayout(null);
        frameIN.setVisible(true);

        btnACC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Acc_View();
                frameIN.dispose();
            }
        });

        btnTIC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    new Swing_EnterTickets();
                    frameIN.dispose();
                } catch (UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (InstantiationException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
