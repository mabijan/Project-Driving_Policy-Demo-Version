package PayModel;

public class PayEnti {

    private String CARDNUM;
    private String CVV2;
    private String EXP_DATE_M;
    private String EXP_DATE_Y;
    private String SECOND_PASS;
    private String Dname;

    public PayEnti(String CARDNUM, String CVV2, String EXP_DATE_M, String EXP_DATE_Y, String SECOND_PASS, String Dname) {
        this.CARDNUM = CARDNUM;
        this.CVV2 = CVV2;
        this.EXP_DATE_M = EXP_DATE_M;
        this.EXP_DATE_Y = EXP_DATE_Y;
        this.SECOND_PASS = SECOND_PASS;
        this.Dname = Dname;
    }

    public String getCARDNUM() {
        return CARDNUM;
    }

    public PayEnti setCARDNUM(String CARDNUM) {
        this.CARDNUM = CARDNUM;
        return this;
    }

    public String getCVV2() {
        return CVV2;
    }

    public PayEnti setCVV2(String CVV2) {
        this.CVV2 = CVV2;
        return this;
    }

    public String getEXP_DATE_M() {
        return EXP_DATE_M;
    }

    public PayEnti setEXP_DATE_M(String EXP_DATE_M) {
        this.EXP_DATE_M = EXP_DATE_M;
        return this;
    }

    public String getEXP_DATE_Y() {
        return EXP_DATE_Y;
    }

    public PayEnti setEXP_DATE_Y(String EXP_DATE_Y) {
        this.EXP_DATE_Y = EXP_DATE_Y;
        return this;
    }

    public String getSECOND_PASS() {
        return SECOND_PASS;
    }

    public PayEnti setSECOND_PASS(String SECOND_PASS) {
        this.SECOND_PASS = SECOND_PASS;
        return this;
    }

    public String getDname() {
        return Dname;
    }

    public PayEnti setDname(String dname) {
        Dname = dname;
        return this;
    }
}
