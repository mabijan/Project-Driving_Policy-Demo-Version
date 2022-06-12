package View;

import EnterTicketModel.EnterTicketEnti;
import EnterTicketModel.EnterTicketRepo;
import TicketCont.EnterTicketCont;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Enter_Tickets extends JFrame{

    private JPanel TicketsPanel;
    private JButton btnEnter;
    private JTextField txtName;
    private JTextField txtCode;
    private JTextField txtDName;
    private JTextField txtCarTag;
    private JTextField txtLicenseCodeNum;
    private JTextField txtCarCardCode;
    private JTextField txtInsuCode;
    private JTextField txtFee;
    private JTextField txtNegativePoints;
    private JTextField txtTotalValue;
    private JPasswordField txtPassword;
    private JButton btnBack;
    private JButton button1;
    private String KEY;

    private void createUIComponents() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // TODO: place custom component creation code here

        UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        JOptionPane.showMessageDialog (TicketsPanel,"INVALID DATA!","ENTER DENIED",JOptionPane.ERROR_MESSAGE);
    }

    public Enter_Tickets() {

        setContentPane(TicketsPanel);
        setTitle("ENTER TICKETS");
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String OFNAME = txtName.getText();
                String OFCODE = txtCode.getText();
                String OFPASS = txtPassword.getText();
                String DName = txtDName.getText();
                String Car_Tag = txtCarTag.getText();
                String LicenseNum = txtLicenseCodeNum.getText();
                String CarCardCode = txtCarCardCode.getText();
                String InsuCode = txtInsuCode.getText();
                String Fee = txtFee.getText();
                String NegativePoints = txtNegativePoints.getText();
                String TotalValue = txtTotalValue.getText();


               // EnterTicketCont STEP3 = new EnterTicketCont(DName, Car_Tag, LicenseNum, CarCardCode, InsuCode, Fee, NegativePoints, TotalValue);

                boolean KEY = true; //STEP3.ContData();

                if (KEY == true) {

                    try{

                 //  EnterTicketEnti enterTicketEnti = new EnterTicketEnti(OFNAME, OFCODE, OFPASS, DName, LicenseNum, CarCardCode, InsuCode, Fee, NegativePoints, TotalValue, Car_Tag);
                 //  EnterTicketRepo enterTicketRepo = new EnterTicketRepo();
                 //  enterTicketRepo.insert(enterTicketEnti);
                 //  enterTicketRepo.Commit();
                 //  enterTicketRepo.close();

                    } catch (Exception ex) {

                        ex.printStackTrace();
                    }
                }

                else if (KEY == false) {

                    try {

                        createUIComponents();

                    } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {

                        ex.printStackTrace();

                    }
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


}
