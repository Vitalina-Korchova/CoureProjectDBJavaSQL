module courseproject.courseprojectjavabd {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens courseproject.courseprojectjavabd to javafx.fxml;
    exports courseproject.courseprojectjavabd;
}