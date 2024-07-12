package com.example.dvijenieprojectadmin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.Console;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.util.ResourceBundle;

public class HelloController implements initialize {

    @FXML
    private Button checkButton, choiceButton, createButton;
    @FXML
    private TextArea showField;
    @FXML
    private AnchorPane createForm, mainForm;
    @FXML
    private TextField nameTour, moneyTour, twoMoneyTour;
    @FXML
    private TextArea infoTour;


    String url = "jdbc:mysql://213.167.223.109:3306/dvijenie";
    String user = "isaeva";
    String password = "julia092004";
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "";
            Statement statement = connection.createStatement();
            statement.execute(sql);
           // searchField.setText("Подключение к базе данных успешно установлено!");
        } catch (SQLException e) {
          //  searchField.setText("Ошибка при подключении к базе данных:\n" + e);

        }
        catch (ClassNotFoundException e){
           // searchField.setText("Ошибка драйвера:\n" + e);
        }
        catch (Exception e){
           // searchField.setText(e.toString());
        }
    }
    @FXML
    private void checkButton_Click() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        showField.setText("");
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "select название_тура from buyed_tours;";
        Statement statement = connection.createStatement();
        ResultSet answ = statement.executeQuery(sql);
        String result = "";
        while (answ.next()){
            result += answ.getString("название_тура")+"\n";
        }
        showField.setText(result);
    }
    @FXML
    private void createButton_Click(){
        createForm.setVisible(true);
    }
    @FXML
    private void dontSaveTour_Click(){
        createForm.setVisible(false);
    }
    @FXML
    private void saveTour_Click(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "select count(*) as rowCount from tours;";
            Statement statement = connection.createStatement();
            ResultSet answ = statement.executeQuery(sql);
            answ.next();
            int a = answ.getInt("rowCount");
            sql = "insert into tours(id, название_тура, описание_тура, цена, льготная_цена) values ('"+a+"','"+nameTour.getText()+"','"+infoTour.getText()+"','"+moneyTour.getText().replace(',', '.')+"','"+twoMoneyTour.getText().replace(',', '.')+"')";
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            createForm.setVisible(false);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            showField.setText(String.valueOf(e));
        } catch (NumberFormatException e){
            showField.setText(String.valueOf(e));
        }
    }
    @FXML
    private void sortingButton_Click() throws ClassNotFoundException, SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        showField.setText("");
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = " select название_тура from buyed_tours where тип_тура = 'льготный'";
        Statement statement = connection.createStatement();
        ResultSet answ = statement.executeQuery(sql);
        String result = "";
        while (answ.next()){
            result += answ.getString("название_тура")+"\n";
        }
        showField.setText(result);
    }
}