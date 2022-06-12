package InquiryModel;

import PayModel.PayEnti;
import PayModel.PayRepo;

import java.sql.*;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class InquiryRepo implements AutoCloseable {

    private Connection connection;
    private PreparedStatement preparedStatement1;
    private PreparedStatement preparedStatement2;
    private String NEGATIVEPOINTS;
    private String TOTAL_PRICE;

    public String getNEGATIVEPOINTS() { return NEGATIVEPOINTS; }

    public String getTOTAL_PRICE() { return TOTAL_PRICE; }

    public InquiryRepo setNEGATIVEPOINTS(String NEGATIVEPOINTS) {
        this.NEGATIVEPOINTS = NEGATIVEPOINTS;
        return this;
    }

    public InquiryRepo setTOTAL_PRICE(String TOTAL_PRICE) {
        this.TOTAL_PRICE = TOTAL_PRICE;
        return this;
    }

    public InquiryRepo() throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String URL = "jdbc:oracle:thin:@localhost:1521:xe";

        connection = DriverManager.getConnection(URL, "admin1", "java1234");

        connection.setAutoCommit(false);
    }

    public void Inquiry(InquiryEnti inquiryEnti) throws Exception {

        System.out.println(inquiryEnti.getDName());

        preparedStatement1 =
                connection.prepareStatement("SELECT NEGATIVEPOINTS FROM TICKETS WHERE DNAME = ?");

        preparedStatement2 =
                connection.prepareStatement("SELECT TOTALPRICE FROM TICKETS WHERE DNAME = ?");

        preparedStatement1.setString(1, inquiryEnti.getDName());
        preparedStatement2.setString(1, inquiryEnti.getDName());

        ResultSet resultSet1 = preparedStatement1.executeQuery();
        ResultSet resultSet2 = preparedStatement2.executeQuery();

        Set<Long> re1 = new TreeSet<>();
        Set<Long> re2 = new TreeSet<>();


        while (resultSet1.next() && resultSet2.next()) {

            System.out.println(resultSet1.getString("NEGATIVEPOINTS"));
            System.out.println(resultSet2.getString("TOTALPRICE"));

            re1.add(Long.valueOf(resultSet1.getString("NEGATIVEPOINTS")));
            re2.add(Long.valueOf(resultSet2.getString("TOTALPRICE")));

        }

        Long n = re2.stream().count();

        System.out.println("((((((((" + n + ")))))))))");

        List<Long> NEGAPointList = re1.stream().toList();
        List<Long> PriceList = re2.stream().toList();

        double Totalprice = 0;
        double Negapoints = 0;

        for (int i = 0;i < n; i++) { Totalprice += PriceList.get(i); Negapoints += NEGAPointList.get(i); }

        System.out.println(Totalprice + "00000" + Negapoints);

        inquiryEnti.setNegativePoints(String.valueOf(Negapoints));
        inquiryEnti.setTotalPrice(String.valueOf(Totalprice));

        System.out.println(NEGATIVEPOINTS + "========" + TOTAL_PRICE);
    }

    public String return_NE() {
        System.out.println("NEGATIVEPOINTS:" + NEGATIVEPOINTS);

        return NEGATIVEPOINTS;
    }

    public String return_TO() {
        System.out.println("TOTAL_PRICE:" + TOTAL_PRICE);

        return TOTAL_PRICE;
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
        connection.close();
    }
}
