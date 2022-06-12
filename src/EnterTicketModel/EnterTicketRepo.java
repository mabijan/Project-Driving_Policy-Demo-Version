package EnterTicketModel;

import java.sql.*;

public class EnterTicketRepo implements AutoCloseable {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public EnterTicketRepo() throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String URL = "jdbc:oracle:thin:@localhost:1521:xe";

        connection = DriverManager.getConnection(URL, "admin1", "java1234");

        connection.setAutoCommit(false);
    }

    public void insert(EnterTicketEnti enterTicketEnti) throws Exception {

        System.out.println("car_tag1:" + enterTicketEnti.getCAR_TAG1());
        System.out.println("car_tag2:" + enterTicketEnti.getCAR_TAG2());
        System.out.println("car_tag3:" + enterTicketEnti.getCAR_TAG3());

        String Car_Tag = enterTicketEnti.getCAR_TAG1() + enterTicketEnti.getCAR_TAG2() + enterTicketEnti.getCAR_TAG3();

        preparedStatement =
                connection.prepareStatement("INSERT INTO TICKETS(OFNAME, OFCODE, OFPASS, DNAME, CAR_TAG, LICENSECODE, CARCARDCODE, INSURANCE, FEE, NEGATIVEPOINTS, TOTALPRICE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        preparedStatement.setString(1, enterTicketEnti.getOFNAME());
        preparedStatement.setString(2, enterTicketEnti.getOFCODE());
        preparedStatement.setString(3, enterTicketEnti.getOFPASS());
        preparedStatement.setString(4, enterTicketEnti.getDNAME());
        preparedStatement.setString(5, Car_Tag);
        preparedStatement.setString(6, enterTicketEnti.getLICENSECODE());
        preparedStatement.setString(7, enterTicketEnti.getCARCARDCODE());
        preparedStatement.setString(8, enterTicketEnti.getINSURANCE());
        preparedStatement.setString(9, enterTicketEnti.getFEE());
        preparedStatement.setString(10, enterTicketEnti.getNEGATIVEPOINTS());
        preparedStatement.setString(11, enterTicketEnti.getTOTALPRICE());

        preparedStatement.executeUpdate();
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
