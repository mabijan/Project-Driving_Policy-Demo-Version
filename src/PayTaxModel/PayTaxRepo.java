package PayTaxModel;

import java.sql.*;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PayTaxRepo implements AutoCloseable {

    Boolean Key;

    private Connection connection;
    private PreparedStatement preparedStatement1;
    private PreparedStatement preparedStatement2;
    private PreparedStatement preparedStatement3;

    public PayTaxRepo() throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String URL = "jdbc:oracle:thin:@localhost:1521:xe";

        connection = DriverManager.getConnection(URL, "admin1", "java1234");

        connection.setAutoCommit(false);
    }

    public Boolean PayTax(PayTaxEnti payTaxEnti) throws Exception {

        preparedStatement1 =
                connection.prepareStatement("SELECT BALANCE FROM CARDS WHERE CARDNUM = ?");

        preparedStatement1.setString(1, payTaxEnti.getCARDNUM());

        ResultSet resultSet = preparedStatement1.executeQuery();

        Set<Long> SetBalance = new TreeSet<>();

        while (resultSet.next()) { SetBalance.add(Long.valueOf(resultSet.getString("Balance"))); }

        List<Long> BalanceList = SetBalance.stream().toList();

        double Balance = BalanceList.get(0).doubleValue();

        if (Balance < 50000) { Key = false; }

        else if (Balance >= 50000) {

            String NewBalance = String.valueOf((int) Balance - 50000);

            preparedStatement2 =
                    connection.prepareStatement("UPDATE CARDS SET BALANCE = ? WHERE CARDNUM = ?");

            preparedStatement2.setString(1, NewBalance);
            preparedStatement2.setString(2, payTaxEnti.getCARDNUM());

            preparedStatement2.executeUpdate();

            preparedStatement3 =
                    connection.prepareStatement("INSERT INTO T_TAX (DNAME, T_STATUS) VALUES (?, ?)");

            preparedStatement3.setString(1, payTaxEnti.getDname());
            preparedStatement3.setString(2, "YES");

            preparedStatement3.executeUpdate();
        }

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
