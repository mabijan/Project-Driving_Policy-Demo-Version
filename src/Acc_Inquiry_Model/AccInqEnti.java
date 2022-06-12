package Acc_Inquiry_Model;

public class AccInqEnti {

    String Car_Tag;

    public AccInqEnti(String car_Tag) {
        Car_Tag = car_Tag;
    }

    public String getCar_Tag() {
        return Car_Tag;
    }

    public AccInqEnti setCar_Tag(String car_Tag) {
        Car_Tag = car_Tag;
        return this;
    }
}
