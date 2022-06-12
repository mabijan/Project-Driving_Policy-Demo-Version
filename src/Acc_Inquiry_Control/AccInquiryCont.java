package Acc_Inquiry_Control;

public class AccInquiryCont {

    private String Car_Tage1;
    private String Car_Tage2;
    private String Car_Tage3;

    public AccInquiryCont(String car_Tage1, String car_Tage2, String car_Tage3) {
        Car_Tage1 = car_Tage1;
        Car_Tage2 = car_Tage2;
        Car_Tage3 = car_Tage3;
    }

    public String getCar_Tage1() {
        return Car_Tage1;
    }

    public void setCar_Tage1(String car_Tage1) {
        Car_Tage1 = car_Tage1;
    }

    public String getCar_Tage2() {
        return Car_Tage2;
    }

    public void setCar_Tage2(String car_Tage2) {
        Car_Tage2 = car_Tage2;
    }

    public String getCar_Tage3() {
        return Car_Tage3;
    }

    public void setCar_Tage3(String car_Tage3) {
        Car_Tage3 = car_Tage3;
    }

    public Boolean AccInqCont() {

        Boolean KEY = true;
        Boolean key1 = true;
        Boolean key2 = true;
        Boolean key3 = true;

        for (int i = 0;i < 2;i++) {

            if (Car_Tage1.length() != 2 || Character.isDigit(Car_Tage1.charAt(i)) == false) { key1 = false; }

            if (key1 == false) break;
        }

        if (Car_Tage2.length() != 1 || Character.isDigit(Car_Tage2.charAt(0))) { key2 = false; }

        for (int i = 0;i < 5;i++) {

            if (Car_Tage3.length() != 5 || Character.isDigit(Car_Tage3.charAt(i)) == false) { key3 = false; }

            if (key3 == false) break;
        }

        KEY = key1 && key2 && key3;

        return KEY;
    }
}
