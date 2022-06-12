package Acc_Inquiry_Model;

public class AccInqServ {

    public static AccInqServ accInqServ = new AccInqServ();

    public static AccInqServ getInstance() {

        return accInqServ;
    }


    public void Inq(AccInqEnti accInqEnti) throws Exception {

        try (AccInqRepo accInqRepo = new AccInqRepo()){

            accInqRepo.AccInq(accInqEnti);
            accInqRepo.Commit();
        }

    }
}
