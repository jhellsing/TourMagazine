package com.example.dvijenieproject;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface Initialize {
    void initialize(URL location, ResourceBundle resources) throws IOException, SQLException;



    void start(Stage primaryStage) throws Exception;
}
