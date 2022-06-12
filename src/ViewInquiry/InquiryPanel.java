package ViewInquiry;

import InquiryCont.InquiryCont;
import InquiryModel.InquiryEnti;
import InquiryModel.InquiryRepo;
import PayModel.PayRepo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class InquiryPanel extends JFrame{

    private JPanel InquiryPanel;
    private JButton btnEnter;
    private JTextField txtDName;
    private JTextField txtCar_Tag;
    private JTextField textField1;
    private JTextField textField2;
    private JButton btn_pay;
    private JLabel LAnegative;
    private JLabel LAtotal;

    public InquiryPanel() {

        setContentPane(InquiryPanel);
        setTitle("INQUIRY PANEL");
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnEnter.addActionListener(new ActionListener() {

            private String negative_points;
            private String total_price;

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    String DName = txtDName.getText();
                    String Car_Tag = txtCar_Tag.getText();

                   // InquiryCont inquiryCont = new InquiryCont(DName, Car_Tag);

               //     boolean KEY = inquiryCont.InquiryCont();

                ///    if (KEY == true) {

          //       InquiryEnti inquiryEnti = new InquiryEnti(DName, Car_Tag);

          //       InquiryRepo inquiryRepo = new InquiryRepo();
          //       inquiryRepo.Inquiry(inquiryEnti);
          //       negative_points = inquiryRepo.return_NE();
          //       total_price = inquiryRepo.return_TO();
          //       inquiryRepo.Commit();
          //       inquiryRepo.close();

          //       System.out.println(negative_points + "=====" + total_price);

                        textField1.addFocusListener(new FocusAdapter() {
                            @Override
                            public void focusGained(FocusEvent e) {

                                textField1.setText(negative_points);
                            }
                        });

                        textField2.addFocusListener(new FocusAdapter() {
                            @Override
                            public void focusGained(FocusEvent e) {

                                textField2.setText(total_price);
                            }
                        });

                 //   } else if (KEY == false) {

                 //       createUIComponents();
                //    }

                } catch (Exception ex) { ex.printStackTrace(); }
            }
        });
        txtCar_Tag.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {


            }
        });
        btn_pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new PayView.Swing();

            }
        });
    }

    private void createUIComponents() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // TODO: place custom component creation code here

        UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        JOptionPane.showMessageDialog (InquiryPanel,"INVALID DATA!","ENTER DENIED",JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {

        ViewInquiry.InquiryPanel START = new InquiryPanel();
    }
}


