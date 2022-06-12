package Accident_Control;

import java.util.HashSet;
import java.util.Set;

public class AccCont {

    private String Car_Tag1;
    private String Car_Tag2;
    private String Car_Tag3;
    private String Dname;
    private String Status;

    public AccCont(String car_Tag1, String car_Tag2, String car_Tag3, String dname, String status) {
        Car_Tag1 = car_Tag1;
        Car_Tag2 = car_Tag2;
        Car_Tag3 = car_Tag3;
        Dname = dname;
        Status = status;
    }

    public String getCar_Tag1() {
        return Car_Tag1;
    }

    public void setCar_Tag1(String car_Tag1) {
        Car_Tag1 = car_Tag1;
    }

    public String getCar_Tag2() {
        return Car_Tag2;
    }

    public void setCar_Tag2(String car_Tag2) {
        Car_Tag2 = car_Tag2;
    }

    public String getCar_Tag3() {
        return Car_Tag3;
    }

    public void setCar_Tag3(String car_Tag3) {
        Car_Tag3 = car_Tag3;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Boolean AccCont() {

        int n1 = Dname.length();
        int n2 = Status.length();

        Boolean KEY = true;
        Boolean key1 = true;
        Boolean key2 = true;
        Boolean key3 = true;
        Boolean key4 = true;
        Boolean key5 = true;

        Set<Integer> Nums_set = new HashSet<Integer>();

        for (int i = 0;i < 10;i++) {

            Nums_set.add(i);
        }

        for (int i = 0;i < 2;i++) {

            if (Car_Tag1.length() != 2 || Character.isDigit(Car_Tag1.charAt(i)) == false) { key1 = false; }

            if (key1 == false) break;
        }

        System.out.println("key1:" + key1);

        if (Car_Tag2.length() != 1 || Character.isDigit(Car_Tag2.charAt(0))) { key2 = false; }

        System.out.println("key2:" + key2);

        for (int i = 0;i < 5;i++) {

            if (Car_Tag3.length() != 5 || Character.isDigit(Car_Tag3.charAt(i)) == false) { key3 = false; }

            if (key3 == false) break;
        }

        System.out.println("key3:" + key3);
        System.out.println("Dname:" + Dname);

        for (int num : Nums_set) {

            String CheckNum = String.valueOf(num);

            if (Dname.contains(CheckNum)) key4 = false;
        }


            System.out.println("key4:" + key4);

        for (int i = 0;i < n2;i++) {

            if (Character.isDigit(Status.charAt(i)) == true) { key4 = false; }
        }

        System.out.println("key5:" + key5);

        KEY = key1 && key2 && key3 && key4 && key5;

        return KEY;
    }
}
