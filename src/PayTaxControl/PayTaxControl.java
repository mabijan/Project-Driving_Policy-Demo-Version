package PayTaxControl;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class PayTaxControl {

    String CardNum;
    String CVV2;
    String EXPyear;
    String EXPmonth;
    String SecondPass;
    String Dname;

    public PayTaxControl(String cardNum, String CVV2, String EXPyear, String EXPmonth, String secondPass, String DName) {
        CardNum = cardNum;
        this.CVV2 = CVV2;
        this.EXPyear = EXPyear;
        this.EXPmonth = EXPmonth;
        SecondPass = secondPass;
        this.Dname = DName;
    }

    public String getCardNum() { return CardNum; }

    public void setCardNum(String cardNum) { CardNum = cardNum; }

    public String getCVV2() { return CVV2; }

    public void setCVV2(String CVV2) { this.CVV2 = CVV2; }

    public String getEXPyear() { return EXPyear; }

    public void setEXPyear(String EXPyear) { this.EXPyear = EXPyear; }

    public String getEXPmonth() { return EXPmonth; }

    public void setEXPmonth(String EXPmonth) { this.EXPmonth = EXPmonth; }

    public String getSecondPass() { return SecondPass; }

    public void setSecondPass(String secondPass) { SecondPass = secondPass; }

    public Boolean ValidKey() throws ClassNotFoundException, SQLException {

        Boolean VKEY = false;

        String KEYCARDNUM  = null;
        String KEYCVV2 = null;
        String KEYEXP_M = null;
        String KEYEXP_Y = null;
        String KEYPASS = null;

        Connection connection;
        PreparedStatement preparedStatement1; //CADNUM
        PreparedStatement preparedStatement2; //CCV2
        PreparedStatement preparedStatement3; //EXP_DATE_M
        PreparedStatement preparedStatement4; //EXP_DATE_Y
        PreparedStatement preparedStatement5; //SECOND_PASS

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String URL = "jdbc:oracle:thin:@localhost:1521:xe";

        connection = DriverManager.getConnection(URL, "admin1", "java1234");

        preparedStatement1 =
                connection.prepareStatement("SELECT CARDNUM FROM CARDS WHERE DNAME = ?");

        preparedStatement2 =
                connection.prepareStatement("SELECT CVV2 FROM CARDS WHERE DNAME = ? ");

        preparedStatement3 =
                connection.prepareStatement("SELECT EXP_DATE_M FROM CARDS WHERE DNAME = ? ");

        preparedStatement4 =
                connection.prepareStatement("SELECT EXP_DATE_Y FROM CARDS WHERE DNAME = ? ");

        preparedStatement5 =
                connection.prepareStatement("SELECT SECOND_PASS FROM CARDS WHERE DNAME = ? ");

        preparedStatement1.setString(1, Dname);
        preparedStatement2.setString(1, Dname);
        preparedStatement3.setString(1, Dname);
        preparedStatement4.setString(1, Dname);
        preparedStatement5.setString(1, Dname);

        ResultSet resultSet1 = preparedStatement1.executeQuery();
        ResultSet resultSet2 = preparedStatement2.executeQuery();
        ResultSet resultSet3 = preparedStatement3.executeQuery();
        ResultSet resultSet4 = preparedStatement4.executeQuery();
        ResultSet resultSet5 = preparedStatement5.executeQuery();

        while (resultSet1.next() && resultSet2.next() && resultSet3.next() && resultSet4.next() && resultSet5.next()) {

            KEYCARDNUM = resultSet1.getString("CARDNUM");
            KEYCVV2 = resultSet2.getString("CVV2");
            KEYEXP_M = resultSet3.getString("EXP_DATE_M");
            KEYEXP_Y = resultSet4.getString("EXP_DATE_Y");
            KEYPASS =  resultSet5.getString("SECOND_PASS");
        }

        if (KEYCARDNUM.equals(CardNum) && KEYCVV2.equals(CVV2) && KEYEXP_M.equals(EXPmonth) &&
                KEYEXP_Y.equals(EXPyear) && KEYPASS.equals(SecondPass)) { VKEY = true; }

        return VKEY;
    }

    public Boolean PayCont() {

        int len = SecondPass.length();

        Boolean key1 = true;
        Boolean key2 = true;
        Boolean key3 = true;
        Boolean key4 = true;
        Boolean key5 = true;
        Boolean Key6 = true;

        Set<Integer> Nums_set = new HashSet<Integer>();

        for (int i = 0; i < 10; i++) {

            Nums_set.add(i);
        }

        for (int num : Nums_set) {

            String CheckNum = String.valueOf(num);

            if (Dname.contains(CheckNum)) key1 = false;
        }

        System.out.println("Key1:" + key1);

        for (int i = 0;i < 12;i++) {

            if (Character.isDigit(CardNum.charAt(i)) == false && CardNum.length() != 12) { key2 = false; }

            if (key2 == false) break;
        }

        System.out.println("Key2:" + key2);

        for (int i = 0;i < 3;i++) {

            if (Character.isDigit(CVV2.charAt(i)) && CVV2.length() != 3) { key3 = false; }

            if (key3 == false) break;
        }

        System.out.println("Key3:" + key3);

        if (EXPmonth.length() > 2 && EXPyear.length() > 2) { key4 = false; }

        System.out.println("Key4:" + key4);

        for (int i = 0;i < 2;i++) {

            if (Character.isDigit(EXPyear.charAt(i)) == false && Character.isDigit(EXPmonth.charAt(i))) { key5 = false; }

            if (key5 == false) break;
        }

        System.out.println("Key5:" + key5);

        for (int i = 0;i < len;i++) {

            if(Character.isDigit(SecondPass.charAt(i)) == false) { Key6 = false; }

            if (Key6 == false) break;
        }

        System.out.println("Key6:" + Key6);

        Boolean KEY = key1 && key2 && key3 && key4 && key5 && Key6;

        return KEY;
    }
}
