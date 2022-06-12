package InquiryModel;

public class InquiryServ {

    public static InquiryServ inquiryServ = new InquiryServ();

    public static InquiryServ getInstance() {

        return inquiryServ;
    }

    public void Inquiry(InquiryEnti inquiryEnti) throws Exception {

        try (InquiryRepo inquiryRepo = new InquiryRepo()) {

            inquiryRepo.Inquiry(inquiryEnti);
            inquiryRepo.Commit();
        }
    }

    public String Return_NE() throws Exception {

        try (InquiryRepo inquiryRepo = new InquiryRepo()) {

            return inquiryRepo.return_NE();
        }
    }

    public String Return_To() throws Exception {

        try (InquiryRepo inquiryRepo = new InquiryRepo()) {

            return inquiryRepo.return_TO();
        }
    }
}
