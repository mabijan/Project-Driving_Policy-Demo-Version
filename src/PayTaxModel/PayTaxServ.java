package PayTaxModel;

public class PayTaxServ {

    private static PayTaxServ payTaxServ = new PayTaxServ();

    public static PayTaxServ getInstance() {

        return payTaxServ;
    }

    public void PayTax(PayTaxEnti payTaxEnti) throws Exception {

        try (PayTaxRepo payTaxRepo = new PayTaxRepo()) {

            payTaxRepo.PayTax(payTaxEnti);
            payTaxRepo.Commit();
        }
    }

    public void PayTaxClose() throws Exception {

        try (PayTaxRepo payTaxRepo = new PayTaxRepo()) {

            payTaxRepo.Rollback();
        }
    }
}
