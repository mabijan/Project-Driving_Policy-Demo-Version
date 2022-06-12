package InquiryCont;

import java.util.HashSet;
import java.util.Set;

public class InquiryCont {

    String DNAme;
    String Car_Tag1;
    String Car_Tag2;
    String Car_Tag3;

    public InquiryCont(String DNAme, String car_Tag1, String car_Tag2, String car_Tag3) {
        this.DNAme = DNAme;
        Car_Tag1 = car_Tag1;
        Car_Tag2 = car_Tag2;
        Car_Tag3 = car_Tag3;
    }

    public String getCar_Tag1() {
        return Car_Tag1;
    }

    public InquiryCont setCar_Tag1(String car_Tag1) {
        Car_Tag1 = car_Tag1;
        return this;
    }

    public String getCar_Tag2() {
        return Car_Tag2;
    }

    public InquiryCont setCar_Tag2(String car_Tag2) {
        Car_Tag2 = car_Tag2;
        return this;
    }

    public String getCar_Tag3() {
        return Car_Tag3;
    }

    public InquiryCont setCar_Tag3(String car_Tag3) {
        Car_Tag3 = car_Tag3;
        return this;
    }

    public boolean InquiryCont() {

        boolean key1 = true;
        boolean key2 = true;
        boolean key3 = true;
        boolean key4 = true;

        Set<Integer> Nums_set = new HashSet<Integer>();

        for (int i = 0; i < 10; i++) {

            Nums_set.add(i);
        }

        for (int num : Nums_set) {
            int sw = 0;

            String CheckNum = String.valueOf(num);

            if (DNAme.contains(CheckNum)) {
                sw = 1;
            }

            if (sw == 1) { key1 = false;
                break; }
        }

        System.out.println("key1:" + key1);

        for (int i = 0;i < 2;i++) {

            if (Car_Tag1.length() != 2 || Character.isDigit(Car_Tag1.charAt(i)) == false) { key2 = false; }

            if (key2 == false) break;
        }

        System.out.println("key2:" + key2);

        if (Car_Tag2.length() != 1 || Character.isDigit(Car_Tag2.charAt(0))) { key2 = false; }

        System.out.println("key3:" + key3);

        for (int i = 0;i < 5;i++) {

            if (Car_Tag3.length() != 5 || Character.isDigit(Car_Tag3.charAt(i)) == false) { key3 = false; }

            if (key3 == false) break;
        }

        System.out.println("key4:" + key4);

        boolean KEY = key1 && key2 && key3 && key4;

        return KEY;
    }
}
