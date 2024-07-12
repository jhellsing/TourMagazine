module com.example.dvijenieprojectadmin {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.dvijenieprojectadmin to javafx.fxml;
    exports com.example.dvijenieprojectadmin;
}