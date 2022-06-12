package View;

import EnterTicketModel.EnterTicketEnti;
import EnterTicketModel.EnterTicketRepo;
import EnterTicketModel.EnterTicketServ;
import InterOfficerView.InterOfficerView;
import TicketCont.EnterTicketCont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.RSAOtherPrimeInfo;

public class Swing_EnterTickets extends JFrame {

    JFrame frameInterTicket;
    JLabel lblOfficerName,lblOfficerCode,lblOfficerPassword,lblDriverName,lblCarNumber,lblLicenseNumber,lblCarCardNumber,lblInsuranceNumber,lblInfractions,lblNegativePoint,lblTotalOffenses;
    JTextField txtOfficerName,txtOfficerCode,txtDriverName,txtCar_Tag1, txtCar_Tag2, txtCar_Tag3,txtLicenseNumber,txtCarCardNumber,txtInsuranceNumber,txtInfractions,txtNegativePoint,txtTotalOffenses;
    JPasswordField passOfficerPassword;
    JButton btnBack,btnOk;

    public Swing_EnterTickets() throws HeadlessException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        createUI();

    }
    private void createUI() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        frameInterTicket=new JFrame("Inter ticket");
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        int wScreen=(int)screenSize.getWidth();
        int hScreen=(int)screenSize.getHeight();
        int wFrame=550;
        int hFrame=700;
        frameInterTicket.setBounds(wScreen/2-wFrame/2,hScreen/2-hFrame/2,wFrame,hFrame);
        frameInterTicket.setIconImage(Toolkit.getDefaultToolkit().createImage("Images/Icons/ticket.png"));
        frameInterTicket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lblOfficerName=new JLabel("نام افسر : ");
        lblOfficerName.setBounds(455,15,200,70);
        txtOfficerName=new JTextField();
        txtOfficerName.setBounds(165,35,220,30);
        lblOfficerCode=new JLabel("کد افسر :");
        lblOfficerCode.setBounds(460,60,200,70);
        txtOfficerCode=new JTextField();
        txtOfficerCode.setBounds(165,80,220,30);
        lblOfficerPassword=new JLabel("رمز ورود : ");
        lblOfficerPassword.setBounds(455,105,200,70);
        passOfficerPassword=new JPasswordField();
        passOfficerPassword.setBounds(165,125,220,30);
        lblDriverName=new JLabel("نام راننده : ");
        lblDriverName.setBounds(455,150,200,70);
        txtDriverName=new JTextField();
        txtDriverName.setBounds(165,170,220,30);
        lblCarNumber=new JLabel("شماره پلاک ماشین : ");
        lblCarNumber.setBounds(420,195,200,70);
        txtCar_Tag1=new JTextField();
        txtCar_Tag1.setBounds(165,215,80,30);
        txtCar_Tag2=new JTextField();
        txtCar_Tag2.setBounds(252, 215, 50, 30);
        txtCar_Tag3=new JTextField();
        txtCar_Tag3.setBounds(310, 215, 75, 30);
        lblLicenseNumber=new JLabel("شماره گواهی نامه :");
        lblLicenseNumber.setBounds(427,240,200,70);
        txtLicenseNumber=new JTextField();
        txtLicenseNumber.setBounds(165,260,220,30);
        lblCarCardNumber=new JLabel("شماره کارت ماشین : ");
        lblCarCardNumber.setBounds(420,285,200,70);
        txtCarCardNumber=new JTextField();
        txtCarCardNumber.setBounds(165,305,220,30);
        lblInsuranceNumber=new JLabel("شماره بیمه نامه : ");
        lblInsuranceNumber.setBounds(427,330,200,70);
        txtInsuranceNumber=new JTextField();
        txtInsuranceNumber.setBounds(165,350,220,30);
        lblInfractions=new JLabel("تخلفات : ");
        lblInfractions.setBounds(460,375,200,70);
        txtInfractions=new JTextField();
        txtInfractions.setBounds(165,395,220,30);
        lblNegativePoint=new JLabel("نمره منفی : ");
        lblNegativePoint.setBounds(455,420,200,70);
        txtNegativePoint=new JTextField();
        txtNegativePoint.setBounds(165,440,220,30);
        lblTotalOffenses=new JLabel("مجموع جرایم : ");
        lblTotalOffenses.setBounds(445,465,200,70);
        txtTotalOffenses=new JTextField();
        txtTotalOffenses.setBounds(165,485,220,30);
        btnBack=new JButton("بازگشت");
        btnBack.setBounds(175,580,90,40);
        btnOk=new JButton("ثبت");
        btnOk.setBounds(275,580,90,40);



        frameInterTicket.add(lblOfficerName);
        frameInterTicket.add(txtOfficerName);
        frameInterTicket.add(lblOfficerCode);
        frameInterTicket.add(txtOfficerCode);
        frameInterTicket.add(lblOfficerPassword);
        frameInterTicket.add(passOfficerPassword);
        frameInterTicket.add(lblDriverName);
        frameInterTicket.add(txtDriverName);
        frameInterTicket.add(lblCarNumber);
        frameInterTicket.add(txtCar_Tag1);
        frameInterTicket.add(txtCar_Tag2);
        frameInterTicket.add(txtCar_Tag3);
        frameInterTicket.add(lblLicenseNumber);
        frameInterTicket.add(txtLicenseNumber);
        frameInterTicket.add(lblCarCardNumber);
        frameInterTicket.add(txtCarCardNumber);
        frameInterTicket.add(lblInsuranceNumber);
        frameInterTicket.add(txtInsuranceNumber);
        frameInterTicket.add(lblInfractions);
        frameInterTicket.add(txtInfractions);
        frameInterTicket.add(lblNegativePoint);
        frameInterTicket.add(txtNegativePoint);
        frameInterTicket.add(lblTotalOffenses);
        frameInterTicket.add(txtTotalOffenses);
        frameInterTicket.add(btnBack);
        frameInterTicket.add(btnOk);
        frameInterTicket.setLayout(null);
        frameInterTicket.setVisible(true);

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String OFNAME = txtOfficerName.getText();
                String OFCODE = txtOfficerCode.getText();
                String OFPASS = passOfficerPassword.getText();
                String DName = txtDriverName.getText();
                String Car_Tag1 = txtCar_Tag1.getText();
                String Car_Tag2 = txtCar_Tag2.getText();
                String Car_Tag3 = txtCar_Tag3.getText();
                String LicenseNum = txtLicenseNumber.getText();
                String CarCardCode = txtCarCardNumber.getText();
                String InsuCode = txtInsuranceNumber.getText();
                String Fee = txtInfractions.getText();
                String NegativePoints = txtNegativePoint.getText();
                String TotalValue = txtTotalOffenses.getText();

                System.out.println("Car_Tag1:" + Car_Tag1 + "" + "Car_Tag2:" + Car_Tag2 + "" + "Car_Tag3:" + Car_Tag3);

                EnterTicketCont STEP3 = new EnterTicketCont(DName, Car_Tag1, Car_Tag2, Car_Tag3, LicenseNum, CarCardCode, InsuCode, Fee, NegativePoints, TotalValue);

                boolean KEY = STEP3.ContData();

                if (KEY == true) {

                    try{

                        System.out.println("Car_Tag1:" + Car_Tag1 + "" + "Car_Tag2:" + Car_Tag2 + "" + "Car_Tag3:" + Car_Tag3);

                        EnterTicketEnti enterTicketEnti = new EnterTicketEnti(OFNAME, OFCODE, OFPASS, DName, Car_Tag1, Car_Tag2, Car_Tag3, LicenseNum, CarCardCode, InsuCode, Fee, NegativePoints, TotalValue);
                        EnterTicketRepo enterTicketRepo = new EnterTicketRepo();
                        EnterTicketServ.getInstance().Save(enterTicketEnti);
                        enterTicketRepo.Commit();

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
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new InterOfficerView();
                frameInterTicket.dispose();
            }
        });
    }

    private void createUIComponents() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // TODO: place custom component creation code here

        UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        JOptionPane.showMessageDialog (frameInterTicket,"INVALID DATA!","ENTER DENIED",JOptionPane.ERROR_MESSAGE);
    }

}
