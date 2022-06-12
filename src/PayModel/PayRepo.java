package PayModel;

import java.sql.*;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PayRepo implements AutoCloseable {

    Boolean Key = true;

    private Connection connection;
    private PreparedStatement preparedStatement1;
    private PreparedStatement preparedStatement2;
    private PreparedStatement preparedStatement3;
    private PreparedStatement preparedStatement4;

    public PayRepo() throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String URL = "jdbc:oracle:thin:@localhost:1521:xe";

        connection = DriverManager.getConnection(URL, "admin1", "java1234");

        connection.setAutoCommit(false);
    }

    public Boolean PayTick(PayEnti payEnti) throws Exception {

        System.out.format("""
                Cardnum=%s
                Dname=%s
                """, payEnti.getCARDNUM(), payEnti.getDname());

        preparedStatement1 =
                connection.prepareStatement("SELECT BALANCE FROM CARDS WHERE CARDNUM = ?");

        preparedStatement2 =
                connection.prepareStatement("SELECT TOTALPRICE FROM TICKETS WHERE DNAME = ?");

        preparedStatement1.setString(1, payEnti.getCARDNUM());
        preparedStatement2.setString(1, payEnti.getDname());

        ResultSet resultSet1 = preparedStatement1.executeQuery();
        ResultSet resultSet2 = preparedStatement2.executeQuery();

        Set<Long> SetBalance = new TreeSet<>();
        Set<Long> SetTotalPrice = new TreeSet<>();


        while (resultSet1.next()) {

            System.out.println("Count!");
            SetBalance.add(Long.valueOf(resultSet1.getString("BALANCE")));
        }

        while (resultSet2.next()) {

            System.out.println("Count!!");
            SetTotalPrice.add(Long.valueOf(resultSet2.getString("TOTALPRICE")));
        }

        int n = SetTotalPrice.size();
        System.out.println("n:" + n);

        List<Long> BalanceList = SetBalance.stream().toList();
        List<Long> TotalPriceList  = SetTotalPrice.stream().toList();

        double Totalprice = 0;
        double Balance = BalanceList.get(0).doubleValue();

        System.out.println("=9999=" + Balance + "=9999=");

        for (int i = 0;i < n; i++) { Totalprice += TotalPriceList.get(i); }

        System.out.println("Totalprice:" + Totalprice);

        if (Balance < Totalprice) { Key = false; }

        else if (Balance >= Totalprice) {

            String NewBalance = String.valueOf((int) Balance - (int)Totalprice);

            System.out.println("NewBalance:" + NewBalance);

            preparedStatement3 =
                    connection.prepareStatement("UPDATE CARDS SET BALANCE = ? WHERE CARDNUM = ?");

            preparedStatement3.setString(1, NewBalance);
            preparedStatement3.setString(2, payEnti.getCARDNUM());

            preparedStatement3.executeUpdate();

            preparedStatement4 =
                    connection.prepareStatement("DELETE FROM TICKETS WHERE DNAME = ?");

            preparedStatement4.setString(1, payEnti.getDname());

            preparedStatement4.executeUpdate();
        }

        System.out.println("key:" + Key);
        return Key;
    }

    public void Commit() throws SQLException {

        connection.commit();
    }

    public void Rollback() throws SQLException {

        connection.rollback();
    }

    @Override
    public void close() throws Exception {

        preparedStatement1.close();
        preparedStatement2.close();
        preparedStatement3.close();
        connection.close();
    }
}
