package courseproject.courseprojectjavabd;

public class Keys {
    private  int idUser;
    private String loginUser;
    private String passwordUser;
    private String roleUser;
    private Boolean permissionTableClient;
    private Boolean permissionTablePublication;
    private Boolean permissionTableAuthor;
    private Boolean permissionTablePrintingHouse;
    private Boolean permissionQueries;
    private Boolean permissionAddUser;


    public Keys(int idUser, String loginUser, String passwordUser, String roleUser) {
        this.idUser = idUser;
        this.loginUser = loginUser;
        this.passwordUser = passwordUser;
        this.roleUser = roleUser;
    }

    public Keys(String loginUser, String passwordUser) {
        this.loginUser = loginUser;
        this.passwordUser = passwordUser;
    }

    public Keys(int idUser, String loginUser, String passwordUser, String roleUser, Boolean permissionTableClient, Boolean permissionTablePublication, Boolean permissionTableAuthor, Boolean permissionTablePrintingHouse, Boolean permissionQueries, Boolean permissionAddUser) {
        this.idUser = idUser;
        this.loginUser = loginUser;
        this.passwordUser = passwordUser;
        this.roleUser = roleUser;
        this.permissionTableClient = permissionTableClient;
        this.permissionTablePublication = permissionTablePublication;
        this.permissionTableAuthor = permissionTableAuthor;
        this.permissionTablePrintingHouse = permissionTablePrintingHouse;
        this.permissionQueries = permissionQueries;
        this.permissionAddUser = permissionAddUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public String getRoleUser() {
        return roleUser;
    }

    public Boolean getPermissionTableClient() {
        return permissionTableClient;
    }

    public Boolean getPermissionTablePublication() {
        return permissionTablePublication;
    }

    public Boolean getPermissionTableAuthor() {
        return permissionTableAuthor;
    }

    public Boolean getPermissionTablePrintingHouse() {
        return permissionTablePrintingHouse;
    }

    public Boolean getPermissionQueries() {
        return permissionQueries;
    }

    public Boolean getPermissionAddUser() {
        return permissionAddUser;
    }

}
