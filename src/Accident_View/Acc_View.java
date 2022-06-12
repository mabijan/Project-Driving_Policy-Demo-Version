package Accident_View;

import Accident_Control.AccCont;
import Accident_Model.AccEnti;
import Accident_Model.AccRepo;
import Accident_Model.AccServ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Acc_View extends JFrame {

    JFrame FramAcc;
    JLabel lblDname, lblCar_Tag, lblStatus;
    JTextField txtDname, txtCar_Tag1, txtCar_Tag2, txtCar_Tag3, txtStatus;
    JButton btnEnter;

    public Acc_View() throws HeadlessException {

        createUI();
    }

    private void createUI() {

        FramAcc = new JFrame("Accident status");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int wScreen = (int) screenSize.getWidth();
        int hScreen = (int) screenSize.getHeight();
        int wFrame = 500;
        int hFrame = 400;
        FramAcc.setBounds(wScreen/2-wFrame/2, hScreen/2-hFrame/2, wFrame, hFrame);
        FramAcc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lblDname = new JLabel(": نام راننده");
        lblDname.setBounds(25, 15, 200, 70);
        JTextField txtDname = new JTextField();
        txtDname.setBounds(120, 40, 220, 30);
        lblCar_Tag = new JLabel(": پلاک خودرو");
        lblCar_Tag.setBounds(25, 60, 200, 70);
        JTextField txtCar_Tag1 = new JTextField();
        JTextField txtCar_Tag2 = new JTextField();
        JTextField txtCar_Tag3 = new JTextField();
        txtCar_Tag1.setBounds(120, 85, 80, 30);
        txtCar_Tag2.setBounds(210, 85, 50, 30);
        txtCar_Tag3.setBounds(270, 85, 80, 30);
        lblStatus = new JLabel(": وضعیت تصادف");
        lblStatus.setBounds(25, 105, 200, 70);
        JTextField txtStatus = new JTextField();
        txtStatus.setBounds(120, 130, 220, 30);
        JButton btnEnter = new JButton("ثبت");
        btnEnter.setBounds(200, 300,90, 40);

        FramAcc.add(lblDname);
        FramAcc.add(txtDname);
        FramAcc.add(lblCar_Tag);
        FramAcc.add(txtCar_Tag1);
        FramAcc.add(txtCar_Tag2);
        FramAcc.add(txtCar_Tag3);
        FramAcc.add(lblStatus);
        FramAcc.add(txtStatus);
        FramAcc.add(btnEnter);

        FramAcc.setLayout(null);
        FramAcc.setVisible(true);

        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Dname = txtDname.getText();
                String Car_Tag = txtCar_Tag1.getText() + txtCar_Tag2.getText() + txtCar_Tag3.getText();
                String Status = txtStatus.getText();

                AccCont accCont = new AccCont(txtCar_Tag1.getText(), txtCar_Tag2.getText(), txtCar_Tag3.getText(), Dname, Status);
                Boolean KEY = accCont.AccCont();

                if (KEY == true) {

                    try {

                        AccEnti accEnti = new AccEnti(Dname, Car_Tag, Status);

                        AccServ.getInstance().Save(accEnti);

                        AccRepo accRepo = new AccRepo();
                        accRepo.Commit();

                        txtDname.setText("");
                        txtCar_Tag1.setText("");
                        txtStatus.setText("");

                    } catch (Exception z) {

                        z.printStackTrace();
                    }

                } else {

                    try {

                        createUIComponents();
                    } catch (Exception e1) { e1.printStackTrace(); }
                }
            }
        });
    }

    private void createUIComponents() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // TODO: place custom component creation code here

        UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        JOptionPane.showMessageDialog (FramAcc,"INVALID DATA!","ENTER DENIED",JOptionPane.ERROR_MESSAGE);
    }
}
