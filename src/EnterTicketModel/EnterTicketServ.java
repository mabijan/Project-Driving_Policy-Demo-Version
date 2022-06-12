package EnterTicketModel;

public class EnterTicketServ {

    private static EnterTicketServ enterTicketServ = new EnterTicketServ();

    public static EnterTicketServ getInstance() {

        return enterTicketServ;
    }

    public void Save(EnterTicketEnti enterTicketEnti) throws Exception {

        try (EnterTicketRepo enterTicketRepo = new EnterTicketRepo()) {

            enterTicketEnti.setTOTALPRICE(String.valueOf(Long.parseLong(enterTicketEnti.getTOTALPRICE()) +
                    Long.parseLong(enterTicketEnti.getTOTALPRICE()) * 10/100));

            enterTicketRepo.insert(enterTicketEnti);
            enterTicketRepo.Commit();
        }
    }
}
