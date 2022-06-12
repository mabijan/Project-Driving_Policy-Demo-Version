package InquiryModel;

public class InquiryEnti {

    private String DName;
    private String Car_Tag1;
    private String Car_Tag2;
    private String Car_Tag3;
    private String NegativePoints;
    private String TotalPrice;

    public InquiryEnti(String DName, String car_Tag1, String car_Tag2, String car_Tag3) {
        this.DName = DName;
        this.Car_Tag1 = car_Tag1;
        this.Car_Tag2 = car_Tag2;
        this.Car_Tag3 = car_Tag3;
    }

    public InquiryEnti(String negativePoints, String totalPrice) {

        this.NegativePoints = negativePoints;
        this.TotalPrice = totalPrice;
    }

    public String getDName() {
        return DName;
    }

    public InquiryEnti setDName(String DName) {
        this.DName = DName;
        return this;
    }

    public String getCar_Tag1() { return Car_Tag1; }

    public InquiryEnti setCar_Tag1(String car_Tag1) {
        Car_Tag1 = car_Tag1;
        return this;
    }

    public String getCar_Tag2() { return Car_Tag2; }

    public InquiryEnti setCar_Tag2(String car_Tag2) {
        Car_Tag2 = car_Tag2;
        return this;
    }

    public String getCar_Tag3() { return Car_Tag3; }

    public InquiryEnti setCar_Tag3(String car_Tag3) {
        Car_Tag3 = car_Tag3;
        return this;
    }

    public String getNegativePoints() {
        return NegativePoints;
    }

    public InquiryEnti setNegativePoints(String negativePoints) {
        NegativePoints = negativePoints;
        return this;
    }

    public String getTotalPrice() {
        return TotalPrice;
    }

    public InquiryEnti setTotalPrice(String totalPrice) {
        TotalPrice = totalPrice;
        return this;
    }
}
