package com.ocr.card.ui;

import com.ocr.card.model.Card;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ResultController {

   @FXML
   public TextField txtlastname;
   @FXML
    public TextField txtcardnumber;
   @FXML
    public TextField txtfirstname;

    public void setData(Card data) {
        txtlastname.setText(data.getLastName());
        txtfirstname.setText(data.getFirstName());
        txtcardnumber.setText(data.getCardNumber());
    }
}
