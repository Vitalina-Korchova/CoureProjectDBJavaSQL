package courseproject.courseprojectjavabd;

public class Client {
    private int idClient;
    private String typeClient;
    private String nameClient;
    private String addressClient;
    private String numbPhoneClient;
    private String emailClient;

    public Client(int idClient, String typeClient, String nameClient, String addressClient, String numbPhoneClient, String emailClient) {
        this.idClient = idClient;
        this.typeClient = typeClient;
        this.nameClient = nameClient;
        this.addressClient = addressClient;
        this.numbPhoneClient = numbPhoneClient;
        this.emailClient = emailClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getTypeClient() {
        return typeClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public String getAddressClient() {
        return addressClient;
    }

    public String getNumbPhoneClient() {
        return numbPhoneClient;
    }

    public String getEmailClient() {
        return emailClient;
    }



}
