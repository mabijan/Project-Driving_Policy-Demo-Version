package PayTaxModel;

public class PayTaxEnti {

    private String CARDNUM;
    private String CVV2;
    private String EXP_DATE_M;
    private String EXP_DATE_Y;
    private String SECOND_PASS;
    private String Dname;

    public PayTaxEnti(String CARDNUM, String CVV2, String EXP_DATE_M, String EXP_DATE_Y, String SECOND_PASS, String dname) {
        this.CARDNUM = CARDNUM;
        this.CVV2 = CVV2;
        this.EXP_DATE_M = EXP_DATE_M;
        this.EXP_DATE_Y = EXP_DATE_Y;
        this.SECOND_PASS = SECOND_PASS;
        Dname = dname;
    }

    public String getCARDNUM() {
        return CARDNUM;
    }

    public PayTaxEnti setCARDNUM(String CARDNUM) {
        this.CARDNUM = CARDNUM;
        return this;
    }

    public String getCVV2() {
        return CVV2;
    }

    public PayTaxEnti setCVV2(String CVV2) {
        this.CVV2 = CVV2;
        return this;
    }

    public String getEXP_DATE_M() {
        return EXP_DATE_M;
    }

    public PayTaxEnti setEXP_DATE_M(String EXP_DATE_M) {
        this.EXP_DATE_M = EXP_DATE_M;
        return this;
    }

    public String getEXP_DATE_Y() {
        return EXP_DATE_Y;
    }

    public PayTaxEnti setEXP_DATE_Y(String EXP_DATE_Y) {
        this.EXP_DATE_Y = EXP_DATE_Y;
        return this;
    }

    public String getSECOND_PASS() {
        return SECOND_PASS;
    }

    public PayTaxEnti setSECOND_PASS(String SECOND_PASS) {
        this.SECOND_PASS = SECOND_PASS;
        return this;
    }

    public String getDname() {
        return Dname;
    }

    public PayTaxEnti setDname(String dname) {
        Dname = dname;
        return this;
    }
}
