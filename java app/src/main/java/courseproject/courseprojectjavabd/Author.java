package courseproject.courseprojectjavabd;

public class Author {

    private int idAuthor;
    private String nameAuthor;
    private String addressAuthor;
    private String numbPhoneAuthor;
    private String emailAuthor;
    private String additionalInfoAuthor;

    public Author(int idAuthor, String nameAuthor, String addressAuthor, String numbPhoneAuthor, String emailAuthor, String additionalInfoAuthor) {
        this.idAuthor = idAuthor;
        this.nameAuthor = nameAuthor;
        this.addressAuthor = addressAuthor;
        this.numbPhoneAuthor = numbPhoneAuthor;
        this.emailAuthor = emailAuthor;
        this.additionalInfoAuthor = additionalInfoAuthor;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public String getAddressAuthor() {
        return addressAuthor;
    }

    public String getNumbPhoneAuthor() {
        return numbPhoneAuthor;
    }

    public String getEmailAuthor() {
        return emailAuthor;
    }

    public String getAdditionalInfoAuthor() {
        return additionalInfoAuthor;
    }

}
