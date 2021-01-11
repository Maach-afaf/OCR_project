package com.ocr.card.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashController {
    public void operation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/CardFrame.fxml"));
        Scene scene = new Scene(root, 1000, 600);
        Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
