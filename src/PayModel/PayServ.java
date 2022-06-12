package PayModel;

public class PayServ {

    private static  PayServ payServ = new PayServ();

    public static PayServ getInstance() {

        return payServ;
    }

    public void Pay(PayEnti payEnti) throws Exception {

        try (PayRepo payRepo = new PayRepo()) {




        }
    }
}
