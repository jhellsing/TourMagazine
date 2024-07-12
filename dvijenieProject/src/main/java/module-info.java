module com.example.dvijenieproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.j;

    opens com.example.dvijenieproject to javafx.fxml;
    exports com.example.dvijenieproject;
}