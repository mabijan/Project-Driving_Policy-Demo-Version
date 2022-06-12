package View;

import InterOfficerView.InterOfficerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Swing_Login {

    JFrame frameLogin;
    JLabel lblOfficerName, lblOfficerCode, lblOfficerPassword;
    JTextField txtOfficerName, txtOfficerCode;
    JPasswordField passOfficerPassword;
    JButton btnLogin;
    JCheckBox chkRemember;

    public Swing_Login() throws HeadlessException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        createSwing();
    }

    private void createSwing() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        frameLogin = new JFrame("Login");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int wScreen = (int) screenSize.getWidth();
        int hScreen = (int) screenSize.getHeight();
        int wFrame = 500;
        int hFrame = 400;
        frameLogin.setBounds(wScreen / 2 - wFrame / 2, hScreen / 2 - hFrame / 2, wFrame, hFrame);
        frameLogin.setIconImage(Toolkit.getDefaultToolkit().createImage("Images/Icons/login.png"));
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lblOfficerName = new JLabel("نام افسر : ");
        lblOfficerName.setBounds(425, 15, 200, 70);
        txtOfficerName = new JTextField();
        txtOfficerName.setBounds(195, 35, 220, 30);
        lblOfficerCode = new JLabel("کد افسر :");
        lblOfficerCode.setBounds(430, 60, 200, 70);
        txtOfficerCode = new JTextField();
        txtOfficerCode.setBounds(195, 80, 220, 30);
        lblOfficerPassword = new JLabel("رمز ورود : ");
        lblOfficerPassword.setBounds(425, 105, 200, 70);
        passOfficerPassword = new JPasswordField();
        passOfficerPassword.setBounds(195, 125, 220, 30);
        chkRemember = new JCheckBox("مرا به خاطر بسپار");
        chkRemember.setBounds(380, 200, 100, 30);
        btnLogin = new JButton("ورود");
        btnLogin.setBounds(197, 280, 90, 40);


        frameLogin.add(lblOfficerName);
        frameLogin.add(txtOfficerName);
        frameLogin.add(lblOfficerCode);
        frameLogin.add(txtOfficerCode);
        frameLogin.add(lblOfficerPassword);
        frameLogin.add(passOfficerPassword);
        frameLogin.add(chkRemember);
        frameLogin.add(btnLogin);
        frameLogin.setLayout(null);
        frameLogin.setVisible(true);

        btnLogin.addActionListener(new ActionListener() {

            private String key_pass;
            private String key_code;

            @Override
            public void actionPerformed(ActionEvent e) {

                String Name = txtOfficerName.getText();
                String Code = txtOfficerCode.getText();
                String Pass = passOfficerPassword.getText();

                try {

                    Class.forName("oracle.jdbc.driver.OracleDriver");

                    String URL = "jdbc:oracle:thin:@localhost:1521:XE";

                    Connection connection = DriverManager.getConnection(URL, "admin1", "java1234");

                    PreparedStatement preparedStatement1 =
                            connection.prepareStatement("SELECT CODE FROM OFFICER WHERE NAME = ?");

                    PreparedStatement preparedStatement2 =
                            connection.prepareStatement("SELECT PASS FROM OFFICER WHERE NAME = ?");

                    preparedStatement1.setString(1, Name);

                    preparedStatement2.setString(1, Name);

                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    ResultSet resultSet2 = preparedStatement2.executeQuery();

                    while (resultSet1.next() && resultSet2.next()) {

                        String key_code = resultSet1.getString("CODE");
                        this.key_code = key_code;

                        String key_pass = resultSet2.getString("PASS");
                        this.key_pass = key_pass;

                    }

                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

                if (Code.equals(key_code) && Pass.equals(key_pass)) {

                        new InterOfficerView();
                        frameLogin.dispose();

                } else {

                    try {

                        UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                        JOptionPane.showMessageDialog (frameLogin,"INVALID DATA!","LOGIN DENIED",JOptionPane.ERROR_MESSAGE);

                    } catch (Exception ex) {

                        ex.printStackTrace();

                    }
                }
            }       });
    }
}