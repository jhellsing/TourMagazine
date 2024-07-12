package com.example.dvijenieproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.function.ToIntFunction;

public class HelloController {
    @FXML
    private AnchorPane mainScreen, tourForm, viyvereniButton, viyvereniButton111;
    //mainScreen
    @FXML
    private Button hotButton1, hotButton2, hotButton3, nextButton, searchButton, tourName1, tourName2;
    @FXML
    private Label infoLabel1, infoLabel2;
    @FXML
    private TextField searchField;
    @FXML
    private ImageView tourPhoto1, tourPhoto2;
    //mainScreen

    //tourForm
    @FXML
    private Button backButton1, buyOld, buyTeen, yesButton, noButton, noBuyButton, noButton1, yesButton1, noBuyButton1;
    @FXML
    private ImageView tourPhoto;
    @FXML
    private Label tourName, tourText, zametkaField, xdFielf;
    //tourForm

    //other
    @FXML
    private Button startButton;
    @FXML
    private Connection connection;
    @FXML
    private ResultSet resultSet;
    @FXML
    private int currentRow;
    //other

    String url = "jdbc:mysql://213.167.223.109:3306/dvijenie";
    String user = "isaeva";
    String password = "julia092004";

    static int str0 = -2;
    static int str1 = -1;
    static int str2 = 0;

    @FXML
    public void initialize() {
        //screenSize();
        nextButton_Click();
    }
    @FXML
    private void gg_Click(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "";
            Statement statement = connection.createStatement();
            statement.execute(sql);
           // searchField.setText("Подключение к базе данных успешно установлено!");
        } catch (SQLException e) {
           // searchField.setText("Ошибка при подключении к базе данных:\n" + e);

        }
        catch (ClassNotFoundException e){
           // searchField.setText("Ошибка драйвера:\n" + e);
        }
        catch (Exception e){
            searchField.setText(e.toString());
        }
    }

    @FXML
    private void setTourName1_Click(){
        tourForm.setVisible(true);
        mainScreen.setVisible(false);
        String getNameTour1 = tourName1.getText();
        String getInfoTour1 = infoLabel1.getText();
        tourName.setText(getNameTour1);
        tourText.setText(getInfoTour1);
    }
    @FXML
    private void setTourName2_Click(){
        tourForm.setVisible(true);
        mainScreen.setVisible(false);
        String getNameTour2 = tourName2.getText();
        String getInfoTour2 = infoLabel2.getText();
        tourName.setText(getNameTour2);
        tourText.setText(getInfoTour2);
    }

    @FXML
    private void backButton1_Click(){
        tourForm.setVisible(false);
        mainScreen.setVisible(true);
        tourName.setText("");
        tourText.setText("");
    }

    @FXML
    private void buyOld_Click(){
        viyvereniButton.setVisible(true);
        viyvereniButton111.setVisible(false);
    }
    @FXML
    private void buyTeen_Click(){
        viyvereniButton111.setVisible(true);
        viyvereniButton.setVisible(false);
    }
    @FXML
    private void cancelButton_Clik(){
        viyvereniButton.setVisible(false);
        viyvereniButton111.setVisible(false);
    }
    @FXML
    private void noBuyButton(){
        viyvereniButton.setVisible(false);
        viyvereniButton111.setVisible(false);
    }
    @FXML
    private void noBuyButton1(){
        viyvereniButton.setVisible(false);
        viyvereniButton111.setVisible(false);
    }

    @FXML
    private void yesButton_Click() throws ClassNotFoundException, SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "insert into buyed_tours (название_тура, количество, тип_тура) values ('"+tourName.getText()+"','1','взрослый')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        viyvereniButton.setVisible(false);
        viyvereniButton111.setVisible(false);
    }

    @FXML
    private void yesButton1_Click() throws ClassNotFoundException, SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "insert into buyed_tours (название_тура, количество, тип_тура) values ('"+tourName.getText()+"','1','льготный')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        viyvereniButton.setVisible(false);
        viyvereniButton111.setVisible(false);
    }

    @FXML
    private void xdField_onMouseEntered(){
        zametkaField.setVisible(true);
    }
    @FXML
    private void xdField_onMouseExited(){
        zametkaField.setVisible(false);
    }

    @FXML
       private void nextButton_Click()
        {
            try {
                str0 += 2;
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                Connection connection = DriverManager.getConnection(url, user, password);
                String sql = "select название_тура, описание_тура from tours where id = "+str0+";";
                Statement statement = connection.createStatement();
                ResultSet answ = statement.executeQuery(sql);
                answ.next();
                String a = answ.getString(1);
                tourName1.setText(a);
                a = answ.getString(2);
                infoLabel1.setText(a);

                str1 += 2;
                sql = "select название_тура, описание_тура from tours where id = "+str1+";";
                statement = connection.createStatement();
                answ = statement.executeQuery(sql);
                answ.next();
                a = answ.getString(1);
                tourName2.setText(a);
                a = answ.getString(2);
                infoLabel2.setText(a);
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
                error0();
            }
        }

        public void error0(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                Connection connection = DriverManager.getConnection(url, user, password);
                String sql = "select название_тура, описание_тура from tours where id = "+str0+";";
                Statement statement = connection.createStatement();
                ResultSet answ = statement.executeQuery(sql);
                answ.next();
                String a = answ.getString(1);
                tourName1.setText(a);
                tourName2.setText("");
                tourName2.setVisible(false);
                infoLabel2.setText("");
                infoLabel2.setVisible(false);
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
                str0 = -2;
                str1 = -1;
                tourName2.setVisible(true);
                infoLabel2.setVisible(true);
                try {
                    str0 += 2;
                    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                    Connection connection = DriverManager.getConnection(url, user, password);
                    String sql = "select название_тура, описание_тура from tours where id = "+str0+";";
                    Statement statement = connection.createStatement();
                    ResultSet answ = statement.executeQuery(sql);
                    answ.next();
                    String a = answ.getString(1);
                    tourName1.setText(a);
                    a = answ.getString(2);
                    infoLabel1.setText(a);

                    str1 += 2;
                    sql = "select название_тура, описание_тура from tours where id = "+str1+";";
                    statement = connection.createStatement();
                    answ = statement.executeQuery(sql);
                    answ.next();
                    a = answ.getString(1);
                    tourName2.setText(a);
                    a = answ.getString(2);
                    infoLabel2.setText(a);
                } catch (InstantiationException ex) {
                    throw new RuntimeException(ex);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                } catch (InvocationTargetException ex) {
                    throw new RuntimeException(ex);
                } catch (NoSuchMethodException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
    public void error1(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "select название_тура, описание_тура from tours where id = "+(str2)+";";
            Statement statement = connection.createStatement();
            ResultSet answ = statement.executeQuery(sql);
            answ.next();
            String a = answ.getString(1);
            tourName1.setText(a);
            a = answ.getString(2);
            infoLabel1.setText(a);
            tourName2.setText("");
            tourName2.setVisible(false);
            infoLabel2.setText("");
            infoLabel2.setVisible(false);
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
            throw new RuntimeException(e);
        }
    }

    @FXML
       private void backButton_Click()
    {
        try {
            tourName2.setVisible(true);
            infoLabel2.setVisible(true);
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "select count(*) from tours;";
            Statement statement = connection.createStatement();
            ResultSet answ = statement.executeQuery(sql);
            answ.next();
            String a = answ.getString(1);
            str2 = Integer.parseInt(a) - 1;
            if (str0 == 0 || str0 == -2){
                if ((str2%2==0)&&(str0==0||str0==-2)){
                    str0 = str2;
                    str1 = str2 +1;
                    error1();
                }
                else {
                    try {
                        str0 = str2-1;
                        str1 = str2;
                        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                        connection = DriverManager.getConnection(url, user, password);
                        sql = "select название_тура, описание_тура from tours where id = "+str0+";";
                        statement = connection.createStatement();
                        answ = statement.executeQuery(sql);
                        answ.next();
                        a = answ.getString(1);
                        tourName1.setText(a);
                        a = answ.getString(2);
                        infoLabel1.setText(a);

                        sql = "select название_тура, описание_тура from tours where id = "+str1+";";
                        statement = connection.createStatement();
                        answ = statement.executeQuery(sql);
                        answ.next();
                        a = answ.getString(1);
                        tourName2.setText(a);
                        a = answ.getString(2);
                        infoLabel2.setText(a);
                    } catch (InstantiationException ex) {
                        throw new RuntimeException(ex);
                    } catch (IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    } catch (InvocationTargetException ex) {
                        throw new RuntimeException(ex);
                    } catch (NoSuchMethodException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (SQLException ex) {
                        error1();
                    }
                }

            }
            else{
                try {
                    str0 -=2;
                    str1 -=2;
                    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                    connection = DriverManager.getConnection(url, user, password);
                    sql = "select название_тура, описание_тура from tours where id = "+str0+";";
                    statement = connection.createStatement();
                    answ = statement.executeQuery(sql);
                    answ.next();
                    a = answ.getString(1);
                    tourName1.setText(a);
                    a = answ.getString(2);
                    infoLabel1.setText(a);

                    sql = "select название_тура, описание_тура from tours where id = "+str1+";";
                    statement = connection.createStatement();
                    answ = statement.executeQuery(sql);
                    answ.next();
                    a = answ.getString(1);
                    tourName2.setText(a);
                    a = answ.getString(2);
                    infoLabel2.setText(a);
                } catch (InstantiationException ex) {
                    throw new RuntimeException(ex);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                } catch (InvocationTargetException ex) {
                    throw new RuntimeException(ex);
                } catch (NoSuchMethodException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
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
            error0();
        }
    }
    @FXML
    private void searchButton_Click(){
        String b = searchField.getText();
        try{
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                Connection connection = DriverManager.getConnection(url, user, password);
                String sql = "SELECT название_тура, описание_тура FROM tours WHERE название_тура LIKE '%"+b+"%'";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                tourName1.setText( resultSet.getString("название_тура"));
                infoLabel1.setText( resultSet.getString("описание_тура"));
                sql = "SELECT count(*) FROM tours WHERE название_тура LIKE '%"+b+"%'";
                PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                resultSet1.next();
                if (resultSet1.getInt(1)>1){
                    resultSet.next();
                    tourName2.setText( resultSet.getString("название_тура"));
                    infoLabel2.setText( resultSet.getString("описание_тура"));
                }
                else{
                    tourName2.setText("Не удалось найти тур");
                    infoLabel2.setText("");
                }
                resultSet.close();
                preparedStatement.close();

        } catch (SQLException ex) {
            tourName1.setText("Не удалось найти тур");
            tourName2.setText("Не удалось найти тур");
            searchField.setStyle("-fx-background-color:#CD5C5C;");
            searchField.setStyle("-fx-border-color: #cdd5df;");
            infoLabel1.setText("");
            infoLabel2.setText("");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        } catch (InstantiationException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
    }
    @FXML
    private void searchFieldCancel(){
        String getStyle = searchField.getStyle();
        String getText = searchField.getText();
        if(getText.equals("Не удалось найти тур")){
            searchField.setText("");
            searchField.setStyle("-fx-background-color:#FFFF;");
            searchField.setStyle("-fx-border-color: #cdd5df;");
        }
    }
}

