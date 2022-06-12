package Accident_Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccRepo implements AutoCloseable {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public AccRepo() throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String URL = "jdbc:oracle:thin:@localhost:1521:xe";

        connection = DriverManager.getConnection(URL, "admin1", "java1234");

        connection.setAutoCommit(false);
    }

    public void Insert(AccEnti accEnti) throws Exception {

        preparedStatement =
                connection.prepareStatement("INSERT INTO ACC_CARS(DNAME, CAR_TAG, STATUS) VALUES(?, ?, ?)");

        preparedStatement.setString(1, accEnti.getDname());
        preparedStatement.setString(2, accEnti.getCar_Tag());
        preparedStatement.setString(3, accEnti.getStatus());

        preparedStatement.executeUpdate();
    }

    public void Commit() throws SQLException {

        connection.commit();
    }

    public void RollBack() throws SQLException {

        connection.rollback();
    }

    @Override
    public void close() throws Exception {

        preparedStatement.close();
        connection.close();
    }
}
