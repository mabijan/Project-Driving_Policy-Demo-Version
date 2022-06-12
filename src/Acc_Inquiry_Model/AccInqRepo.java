package Acc_Inquiry_Model;

import java.sql.*;

public class AccInqRepo implements AutoCloseable {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public AccInqRepo() throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String URL = "jdbc:oracle:thin:@localhost:1521:xe";

        connection = DriverManager.getConnection(URL, "admin1", "java1234");

        connection.setAutoCommit(false);
    }

    public String AccInq(AccInqEnti accInqEnti) throws Exception {

        String Result = null;

        preparedStatement =
                connection.prepareStatement("SELECT STATUS FROM ACC_CARS WHERE CAR_TAG = ?");

        preparedStatement.setString(1, accInqEnti.getCar_Tag());

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            Result = resultSet.getString("STATUS");
        }

        return Result;
    }

    public void Commit() throws SQLException {

        connection.commit();
    }

    public void Rollback() throws SQLException {

        connection.rollback();
    }

    @Override
    public void close() throws Exception {

        preparedStatement.close();
        connection.close();
    }
}
