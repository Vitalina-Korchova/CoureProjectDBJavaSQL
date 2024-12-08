package courseproject.courseprojectjavabd;

public class PrintingHouse {
    private int idPrintingHouse;
    private String namePrintingHouse;
    private String addressPrintingHouse;
    private String numbPhonePrintingHouse;
    private String emailPrintingHouse;

    public PrintingHouse(int idPrintingHouse, String namePrintingHouse, String addressPrintingHouse, String numbPhonePrintingHouse, String emailPrintingHouse) {
        this.idPrintingHouse = idPrintingHouse;
        this.namePrintingHouse = namePrintingHouse;
        this.addressPrintingHouse = addressPrintingHouse;
        this.numbPhonePrintingHouse = numbPhonePrintingHouse;
        this.emailPrintingHouse = emailPrintingHouse;
    }

    public int getIdPrintingHouse() {
        return idPrintingHouse;
    }

    public String getNamePrintingHouse() {
        return namePrintingHouse;
    }

    public String getAddressPrintingHouse() {
        return addressPrintingHouse;
    }

    public String getNumbPhonePrintingHouse() {
        return numbPhonePrintingHouse;
    }

    public String getEmailPrintingHouse() {
        return emailPrintingHouse;
    }

}
