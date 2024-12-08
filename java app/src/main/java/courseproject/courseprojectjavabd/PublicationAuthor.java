package courseproject.courseprojectjavabd;

public class PublicationAuthor {
    private int idPublicationAuthor;
    private String IDPublicationPA;
    private String IDAuthorPA;

    public PublicationAuthor(int idPublicationAuthor, String IDPublicationPA, String IDAuthorPA) {
        this.idPublicationAuthor = idPublicationAuthor;
        this.IDPublicationPA = IDPublicationPA;
        this.IDAuthorPA = IDAuthorPA;
    }

    public int getIdPublicationAuthor() {
        return idPublicationAuthor;
    }

    public String getIDPublicationPA() {
        return IDPublicationPA;
    }

    public String getIDAuthorPA() {
        return IDAuthorPA;
    }
}
