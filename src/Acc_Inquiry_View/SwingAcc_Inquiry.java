package Acc_Inquiry_View;

import Acc_Inquiry_Control.AccInquiryCont;
import Acc_Inquiry_Model.AccInqEnti;
import Acc_Inquiry_Model.AccInqRepo;
import Acc_Inquiry_Model.AccInqServ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarEntry;

public class SwingAcc_Inquiry extends JFrame {

    JFrame SwingAcc_Inquiry;
    JLabel lblCar_Tag;
    JTextField txtCar_Tag1;
    JTextField txtCar_Tag2;
    JTextField txtCar_Tag3;
    JTextField Result;
    JButton btnEnter;

    public SwingAcc_Inquiry() throws HeadlessException {

        creatUI();
    }

    private void creatUI() {

        SwingAcc_Inquiry = new JFrame("Acc_Inquiry");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int wScreen = (int) screenSize.getWidth();
        int hScreen=(int)screenSize.getHeight();
        int wFrame=500;
        int hFrame=400;
        SwingAcc_Inquiry.setBounds(wScreen/2-wFrame/2,hScreen/2-hFrame/2,wFrame,hFrame);
        SwingAcc_Inquiry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SwingAcc_Inquiry.setIconImage(Toolkit.getDefaultToolkit().createImage("IMages/Icons/pay.png"));
        lblCar_Tag = new JLabel(": شماره پلاک خودرو");
        lblCar_Tag.setBounds(20, 15, 200, 70);
        JTextField txtCar_Tag1 = new JTextField();
        JTextField txtCar_Tag2 = new JTextField();
        JTextField txtCar_Tag3 = new JTextField();
        txtCar_Tag1.setBounds(120, 40, 100, 30);
        txtCar_Tag2.setBounds(230, 40, 50, 30);
        txtCar_Tag3.setBounds(290, 40, 100, 30);
        JButton btnEnter = new JButton("استعلام");
        btnEnter.setBounds(210, 100, 90, 40);
        JTextField txtResult = new JTextField();
        txtResult.setBounds(230, 150, 50, 30);

        SwingAcc_Inquiry.add(lblCar_Tag);
        SwingAcc_Inquiry.add(txtCar_Tag1);
        SwingAcc_Inquiry.add(txtCar_Tag2);
        SwingAcc_Inquiry.add(txtCar_Tag3);
        SwingAcc_Inquiry.add(btnEnter);
        SwingAcc_Inquiry.add(txtResult);

        SwingAcc_Inquiry.setLayout(null);
        SwingAcc_Inquiry.setVisible(true);

        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String Car_Tag1 = txtCar_Tag1.getText();
                    String Car_Tag2 = txtCar_Tag2.getText();
                    String Car_Tag3 = txtCar_Tag3.getText();

                    String Car_Tag = Car_Tag1 + Car_Tag2 + Car_Tag3;

                    System.out.println("((((((" + Car_Tag + ")))))");

                    AccInquiryCont accInquiryCont = new AccInquiryCont(Car_Tag1, Car_Tag2, Car_Tag3);
                    Boolean KEY = accInquiryCont.AccInqCont();

                    if (KEY == true) {

                        AccInqEnti accInqEnti = new AccInqEnti(Car_Tag);

                        AccInqServ.getInstance().Inq(accInqEnti);
                        AccInqRepo accInqRepo = new AccInqRepo();
                        String Result = accInqRepo.AccInq(accInqEnti);
                        accInqRepo.Commit();
                        accInqRepo.close();

                        txtResult.setText(Result);

                        if (Result == null) { createUIComponents(); }

                    } else if (KEY == false) {

                        createUIComponents();
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void createUIComponents() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // TODO: place custom component creation code here

        UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        JOptionPane.showMessageDialog (SwingAcc_Inquiry,"INVALID DATA!","Inquiry Denied",JOptionPane.ERROR_MESSAGE);
    }
}
