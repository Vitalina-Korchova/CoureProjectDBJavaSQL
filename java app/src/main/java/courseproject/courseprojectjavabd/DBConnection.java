package courseproject.courseprojectjavabd;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "publishing_house";
        String databaseUser = "root";
        String databasePassword = "Vitalina2431";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }

        return databaseLink;
    }
}
