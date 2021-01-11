package com.ocr.card.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.ocr.card.Dbconnection.Connectiondb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sampleController {

    @FXML private JFXButton login_btn;
    @FXML private JFXTextField user;
    @FXML private JFXPasswordField pass;
    PreparedStatement prepared = null;
    ResultSet result = null;





    @FXML
    public void login(ActionEvent action) throws IOException {
        Connectiondb connectiondb = new Connectiondb();
        Connection connection = connectiondb.connectdb();
        String username = user.getText().toString();
        String password = pass.getText().toString();
        System.out.println(username+":"+password);
        Parent root = FXMLLoader.load(getClass().getResource("/Dash.fxml"));
        Scene scene = new Scene(root);
        Stage window =(Stage)((Node) action.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        /*String sql = "SELECT username , password  FROM admins ";
      
        try {
            prepared = connection.prepareStatement(sql);
            result = prepared.executeQuery();
            while (result.next()) {
                String username1 = result.getString("username");
                String password1 = result.getString("password");

                if (!username1.equals(username) || !password1.equals(password)) {

                    System.out.println("erreur");

                } else {
                    //System.out.println("connexion reussite");
                    //Stage stage =new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("../../../../resources/Dash.fxml"));
                         Scene scene = new Scene(root);
                         Stage window =(Stage)((Node) action.getSource()).getScene().getWindow();
                         window.setScene(scene);
                         window.show();
                        //stage.setScene(new Scene(root, 1000, 600));
                        //stage.setTitle("Acceuil");
                        //stage.show();
                    }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }



















}



