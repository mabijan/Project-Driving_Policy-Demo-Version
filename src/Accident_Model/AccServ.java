package Accident_Model;

import Acc_Inquiry_Model.AccInqEnti;

public class AccServ {

    public static AccServ accServ = new AccServ();

    public static AccServ getInstance() {

        return accServ;
    }

    public void Save(AccEnti accEnti) throws Exception {

        try (AccRepo accRepo = new AccRepo()) {

            accRepo.Insert(accEnti);
            accRepo.Commit();
        }
    }
}
