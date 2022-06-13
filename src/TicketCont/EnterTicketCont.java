package TicketCont;

import java.util.*;

public class EnterTicketCont {

    private String DName;
    private String Car_Tag1;
    private String Car_Tag2;
    private String Car_Tag3;
    private String LicenseNum;
    private String CarCardCode;
    private String InsuCode;
    private String Fee;
    private String NegativePoints;
    private String TotalValue;

    public EnterTicketCont(String DName, String car_Tag1, String car_Tag2, String car_Tag3, String licenseNum, String carCardCode, String insuCode, String fee, String negativePoints, String totalValue) {
        this.DName = DName;
        Car_Tag1 = car_Tag1;
        Car_Tag2 = car_Tag2;
        Car_Tag3 = car_Tag3;
        LicenseNum = licenseNum;
        CarCardCode = carCardCode;
        InsuCode = insuCode;
        Fee = fee;
        NegativePoints = negativePoints;
        TotalValue = totalValue;
    }

    public String getDName() { return DName; }

    public void setDName(String DName) { this.DName = DName;}

    public String getCar_Tag1() { return Car_Tag1; }

    public void setCar_Tag1(String car_Tag1) { Car_Tag1 = car_Tag1; }

    public String getCar_Tag2() { return Car_Tag2; }

    public void setCar_Tag2(String car_Tag2) { Car_Tag2 = car_Tag2; }

    public String getCar_Tag3() { return Car_Tag3; }

    public void setCar_Tag3(String car_Tag3) { Car_Tag3 = car_Tag3; }

    public String getLicenseNum() { return LicenseNum; }

    public void setLicenseNum(String licenseNum) { LicenseNum = licenseNum; }

    public String getCarCardCode() { return CarCardCode; }

    public void setCarCardCode(String carCardCode) { CarCardCode = carCardCode; }

    public String getInsuCode() { return InsuCode; }

    public void setInsuCode(String insuCode) { InsuCode = insuCode; }

    public String getFee() { return Fee; }

    public void setFee(String fee) { Fee = fee; }

    public String getNegativePoints() { return NegativePoints; }

    public void setNegativePoints(String negativePoints) { NegativePoints = negativePoints; }

    public String getTotalValue() { return TotalValue; }

    public void setTotalValue(String totalValue) { TotalValue = totalValue; }

    public boolean ContData() {

        int n1 = LicenseNum.length();
        int n2 = InsuCode.length();
        int n3 = NegativePoints.length();
        int n4 = TotalValue.length();

        boolean key1 = true;
        boolean key2 = true;
        boolean key3 = true;
        boolean key4 = true;
        boolean key5 = true;
        boolean key6 = true;
        boolean key7 = true;
        boolean key8 = true;
        boolean key9 = true;

        Set<Integer> Nums_set = new HashSet<>();

        for (int i = 0;i < 10;i++) {

            Nums_set.add(i);
        }

        for (int num : Nums_set) {
            int sw = 0;

            String CheckNum = String.valueOf(num);
            if (DName.contains(CheckNum) || Fee.contains(CheckNum)) {
                sw = 1;
            }

            if (sw == 1) { key1 = false;
                break;}
        }

        System.out.println("key1:" + key1);

        for (int i = 0;i < n1;i++) {
            int sw = 0;

            if (Character.isDigit(LicenseNum.charAt(i)) == false) { sw = 1; }

            if (sw == 1) { key2 = false;
                break; }
        }

        System.out.println("key2:" + key2);

        for (int i = 0;i < n2;i++) {
            int sw = 0;

            if (Character.isDigit(InsuCode.charAt(i)) == false ) { sw = 1; }

            if (sw == 1) { key3 = false;
                break;}
        }

        System.out.println("key3:" + key3);

        for (int i = 0;i < n4;i++) {
            int sw = 0;

            if (Character.isDigit(TotalValue.charAt(i)) == false) { sw = 1; }

            if (sw == 1) { key4 = false;
                break; }
        }

        System.out.println("key4:" + key4);

        for (int i = 0;i < n3;i++) {
            int sw = 0;

            if (Character.isDigit(NegativePoints.charAt(i)) == false) { sw = 1; }

            if (sw == 1) { key5 = false;
                break; }
        }

        System.out.println("key5:" + key5);

        for (int i = 2;i < n3;i++) {

            String w1 = String.valueOf(CarCardCode.charAt(0));
            String w2 = String.valueOf(CarCardCode.charAt(1));

            if (Character.isDigit(CarCardCode.charAt(i)) && (w1.equals("I")) == false && (w2.equals("R")) == false)
            { key6 = false; }
            
            if (key6 == false) break;
        }

        System.out.println("key6:" + key6);

        for (int i = 0;i < 2;i++) {

            if (Car_Tag1.length() != 2 || Character.isDigit(Car_Tag1.charAt(i)) == false) { key7 = false; }

            if (key7 == false) break;
        }

        System.out.println("key7:" + key7);

        if (Car_Tag2.length() != 1 || Character.isDigit(Car_Tag2.charAt(0))) { key8 = false; }

        System.out.println("key8:" + key8);

        for (int i = 0;i < 5;i++) {

            if (Car_Tag3.length() != 5 || Character.isDigit(Car_Tag3.charAt(i)) == false) { key9 = false; }

            if (key9 == false) break;
        }

        System.out.println("key9:" + key9);

        boolean KEY = key1 && key2 && key3 && key4 && key5 && key6 && key7 && key8 && key9;

        return KEY;
    }
}
