package EnterTicketModel;

public class EnterTicketEnti {

    private String OFNAME;
    private String OFCODE;
    private String OFPASS;
    private String DNAME;
    private String LICENSECODE;
    private String CARCARDCODE;
    private String INSURANCE;
    private String FEE;
    private String NEGATIVEPOINTS;
    private String TOTALPRICE;
    private String CAR_TAG1;
    private String CAR_TAG2;
    private String CAR_TAG3;

    public EnterTicketEnti(String ofname, String ofcode, String ofpass, String dname, String car_tag1, String car_tag2, String car_tag3, String licensecode, String carcardcode, String insurance, String fee, String negativepoints, String totalprice) {
        OFNAME = ofname;
        OFCODE = ofcode;
        OFPASS = ofpass;
        DNAME = dname;
        CAR_TAG1 = car_tag1;
        CAR_TAG2 = car_tag2;
        CAR_TAG3 = car_tag3;
        LICENSECODE = licensecode;
        CARCARDCODE = carcardcode;
        INSURANCE = insurance;
        FEE = fee;
        NEGATIVEPOINTS = negativepoints;
        TOTALPRICE = totalprice;
    }

    public String getOFNAME() {
        return OFNAME;
    }

    public EnterTicketEnti setOFNAME(String OFNAME) {
        this.OFNAME = OFNAME;
        return this;
    }

    public String getOFCODE() {
        return OFCODE;
    }

    public EnterTicketEnti setOFCODE(String OFCODE) {
        this.OFCODE = OFCODE;
        return this;
    }

    public String getOFPASS() {
        return OFPASS;
    }

    public EnterTicketEnti setOFPASS(String OFPASS) {
        this.OFPASS = OFPASS;
        return this;
    }

    public String getDNAME() {
        return DNAME;
    }

    public EnterTicketEnti setDNAME(String DNAME) {
        this.DNAME = DNAME;
        return this;
    }

    public String getCAR_TAG1() {
        return CAR_TAG1;
    }

    public void setCAR_TAG1(String CAR_TAG1) {
        this.CAR_TAG1 = CAR_TAG1;
    }

    public String getCAR_TAG2() {
        return CAR_TAG2;
    }

    public void setCAR_TAG2(String CAR_TAG2) {
        this.CAR_TAG2 = CAR_TAG2;
    }

    public String getCAR_TAG3() {
        return CAR_TAG3;
    }

    public void setCAR_TAG3(String CAR_TAG3) {
        this.CAR_TAG3 = CAR_TAG3;
    }

    public String getLICENSECODE() {
        return LICENSECODE;
    }

    public EnterTicketEnti setLICENSECODE(String LICENSECODE) {
        this.LICENSECODE = LICENSECODE;
        return this;
    }

    public String getCARCARDCODE() {
        return CARCARDCODE;
    }

    public EnterTicketEnti setCARCARDCODE(String CARCARDCODE) {
        this.CARCARDCODE = CARCARDCODE;
        return this;
    }

    public String getINSURANCE() {
        return INSURANCE;
    }

    public EnterTicketEnti setINSURANCE(String INSURANCE) {
        this.INSURANCE = INSURANCE;
        return this;
    }

    public String getFEE() {
        return FEE;
    }

    public EnterTicketEnti setFEE(String FEE) {
        this.FEE = FEE;
        return this;
    }

    public String getNEGATIVEPOINTS() {
        return NEGATIVEPOINTS;
    }

    public EnterTicketEnti setNEGATIVEPOINTS(String NEGATIVEPOINTS) {
        this.NEGATIVEPOINTS = NEGATIVEPOINTS;
        return this;
    }

    public String getTOTALPRICE() {
        return TOTALPRICE;
    }

    public EnterTicketEnti setTOTALPRICE(String TOTALPRICE) {
        this.TOTALPRICE = TOTALPRICE;
        return this;
    }
}
