package Accident_Model;

public class AccEnti {

    String Dname;
    String Car_Tag;
    String Status;

    public AccEnti(String dname, String car_Tag, String status) {
        Dname = dname;
        Car_Tag = car_Tag;
        Status = status;
    }

    public String getDname() {
        return Dname;
    }

    public AccEnti setDname(String dname) {
        Dname = dname;
        return this;
    }

    public String getCar_Tag() {
        return Car_Tag;
    }

    public AccEnti setCar_Tag(String car_Tag) {
        Car_Tag = car_Tag;
        return this;
    }

    public String getStatus() {
        return Status;
    }

    public AccEnti setStatus(String status) {
        Status = status;
        return this;
    }
}
