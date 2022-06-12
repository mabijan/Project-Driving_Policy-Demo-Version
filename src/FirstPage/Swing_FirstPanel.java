package FirstPage;

import InterDriverView.InterDriverView;
import InterOfficerView.InterOfficerView;
import View.Swing_Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing_FirstPanel extends JFrame {

    JFrame frameUserType;
    JButton btnOfficer,btnDriver;
    JLabel lbl;

    public Swing_FirstPanel() throws HeadlessException {
        createSwing();
    }
    private void createSwing() {
        frameUserType = new JFrame("user type");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int wScreen = (int) screenSize.getWidth();
        int hScreen = (int) screenSize.getHeight();
        int wFrame = 300;
        int hFrame = 230;
        frameUserType.setBounds(wScreen / 2 - wFrame / 2, hScreen / 2 - hFrame / 2, wFrame, hFrame);
        frameUserType.setIconImage(Toolkit.getDefaultToolkit().createImage("Images/Icons/user type.png"));
        frameUserType.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lbl = new JLabel("please choose your service . ");
        lbl.setBounds(10, 20, 200, 33);
        btnDriver = new JButton("راننده");
        btnDriver.setBounds(85, 80, 120, 40);
        btnOfficer = new JButton("افسر");
        btnOfficer.setBounds(85, 130, 120, 40);


        frameUserType.setLayout(null);
        frameUserType.add(lbl);
        frameUserType.add(btnDriver);
        frameUserType.add(btnOfficer);
        frameUserType.setVisible(true);

        btnDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    new InterDriverView();
                    frameUserType.dispose();
            }
        });

        btnOfficer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    new Swing_Login();
                } catch (UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (InstantiationException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
                frameUserType.dispose();
            }
        });
    }

    public static void main(String[] args) {

        new Swing_FirstPanel();
    }
}


