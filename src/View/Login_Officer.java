package View;

import EnterTicketModel.EnterTicketRepo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login_Officer extends JFrame{

    private JButton btnLogin;
    private JTextField txtName;
    private JTextField txtCode;
    private JPasswordField txtPassword;
    private JPanel LoginPanel;

    public Login_Officer() {

        setContentPane(LoginPanel);
        setTitle("Login");
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnLogin.addActionListener(new ActionListener() {

            private String key_pass;
            private String key_code;

            @Override
            public void actionPerformed(ActionEvent e) {

                String Name = txtName.getText();
                String Code = txtCode.getText();
                String Pass = txtPassword.getText();

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

                } catch (SQLException | ClassNotFoundException ex) { ex.printStackTrace(); }

                if (Code.equals(key_code) && Pass.equals(key_pass)) {

                    Enter_Tickets STEP2 = new Enter_Tickets();

                } else {

                    try {

                        createUIComponents();

                    } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {

                        ex.printStackTrace();

                    }
                }
            }
        });
    }

    private void createUIComponents() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // TODO: place custom component creation code here

        UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        JOptionPane.showMessageDialog (LoginPanel,"INVALID DATA!","LOGIN DENIED",JOptionPane.ERROR_MESSAGE);

    }

    public static void main(String[] args) {

        Login_Officer START = new Login_Officer();

    }
}