package PayTaxView;

import PayTaxControl.PayTaxControl;
import PayTaxModel.PayTaxEnti;
import PayTaxModel.PayTaxRepo;
import PayTaxModel.PayTaxServ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayTaxSwing extends JFrame {

    JFrame framePay;
    JLabel lblCardNumber, lblCvv2, lblMonth, lblYear, lblPassword, lblExpire, lblDname;
    JButton btnOK;
    JTextField txtCardNumber, txtCvv2, txtMonth, txtYear, txtDname;
    JPasswordField passPassword;
    JCheckBox chkRemember;

    public PayTaxSwing() throws HeadlessException {
        createUI();
    }

    private void createUI() {
        framePay = new JFrame("Pay");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int wScreen = (int) screenSize.getWidth();
        int hScreen = (int) screenSize.getHeight();
        int wFrame = 500;
        int hFrame = 400;
        framePay.setBounds(wScreen / 2 - wFrame / 2, hScreen / 2 - hFrame / 2, wFrame, hFrame);
        framePay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePay.setIconImage(Toolkit.getDefaultToolkit().createImage("IMages/Icons/pay.png"));
        lblCardNumber = new JLabel(": شماره کارت");
        lblCardNumber.setBounds(20, 15, 200, 70);
        JTextField txtCardNum = new JTextField();
        txtCardNum.setBounds(120, 40, 220, 30);
        lblCvv2 = new JLabel("CVV2 :");
        lblCvv2.setBounds(25, 60, 200, 70);
        JTextField txtCvv2 = new JTextField();
        txtCvv2.setBounds(120, 85, 220, 30);
        lblExpire = new JLabel(": تاریخ انقضا");
        lblExpire.setBounds(25, 105, 200, 70);
        lblYear = new JLabel(": سال");
        lblYear.setBounds(120, 105, 200, 70);
        JTextField txtEXPyear = new JTextField();
        txtEXPyear.setBounds(155, 125, 90, 30);
        lblMonth = new JLabel(": ماه");
        lblMonth.setBounds(270, 105, 200, 70);
        JTextField txtEXPmonth = new JTextField();
        txtEXPmonth.setBounds(305, 125, 90, 30);
        lblPassword = new JLabel(": رمز دوم");
        lblPassword.setBounds(25, 150, 200, 70);
        JTextField txtSecondPass = new JPasswordField();
        txtSecondPass.setBounds(120, 170, 220, 30);
        lblDname = new JLabel(": نام راننده");
        lblDname.setBounds(25, 200, 200, 70);
        JTextField txtDname = new JTextField();
        txtDname.setBounds(120, 225, 220, 30);
        chkRemember = new JCheckBox("ذخیره ی کارت");
        chkRemember.setBounds(15, 260, 150, 30);
        JButton btnEnter = new JButton("ثبت");
        btnEnter.setBounds(190, 300, 90, 40);

        framePay.add(lblCardNumber);
        framePay.add(txtCardNum);
        framePay.add(lblCvv2);
        framePay.add(txtCvv2);
        framePay.add(lblExpire);
        framePay.add(lblYear);
        framePay.add(txtEXPyear);
        framePay.add(lblMonth);
        framePay.add(txtEXPmonth);
        framePay.add(lblPassword);
        framePay.add(txtSecondPass);
        framePay.add(lblDname);
        framePay.add(txtDname);
        framePay.add(chkRemember);
        framePay.add(btnEnter);
        framePay.setLayout(null);
        framePay.setVisible(true);

        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Boolean KEY1 = true;
                Boolean KEY2 = true;

                String CardNum = txtCardNum.getText();
                String CVV2 = txtCvv2.getText();
                String EXPyear = txtEXPyear.getText();
                String EXPmonth = txtEXPmonth.getText();
                String SecondPass = txtSecondPass.getText();
                String Dname = txtDname.getText();

                try {
                    PayTaxControl payTaxControl = new PayTaxControl(CardNum, CVV2, EXPyear, EXPmonth, SecondPass, Dname);
                    KEY1 = payTaxControl.PayCont();
                    KEY2 = payTaxControl.ValidKey();
                } catch (Exception ex) { ex.printStackTrace(); }

                if (KEY1 && KEY2) {

                    try {
                        PayTaxEnti payTaxEnti = new PayTaxEnti(CardNum, CVV2, EXPmonth, EXPyear, SecondPass, Dname);

                        PayTaxRepo payTaxRepo = new PayTaxRepo();

                        PayTaxServ.getInstance().PayTax(payTaxEnti);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (KEY1 && KEY2 == false) {

                    try {
                        UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (InstantiationException ex) {
                        ex.printStackTrace();
                    } catch (IllegalAccessException ex) {
                        ex.printStackTrace();
                    } catch (UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog (framePay,"BALANCE IS NOT ENOUGH OR " +
                            "INVALID CARD DATA!","PAYMENT ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
