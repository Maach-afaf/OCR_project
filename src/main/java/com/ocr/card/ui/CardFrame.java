package com.ocr.card.ui;

import com.ocr.card.model.Card;
import com.ocr.card.service.CardOCRService;
import com.ocr.card.service.ICardOCRService;
import com.ocr.card.ui.ResultController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;

public class CardFrame {
    public  String My_image;

    @FXML private ImageView imageview;
    @FXML

    public void browse(ActionEvent event) throws FileNotFoundException {
        FileChooser cardChooser = new FileChooser();
        cardChooser.setInitialDirectory(new File("src/main/resources/data/card"));
        File FileSelected =cardChooser.showOpenDialog(null);

  //Filtrer les fichier selectionnees
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        Image image = new Image(new FileInputStream(FileSelected.getAbsolutePath()));
        if (FileSelected !=null){
            imageview.setImage(image);
            My_image =FileSelected.getAbsolutePath();
            System.out.println("Chemin de l'mage" + My_image);
        }else
            System.out.println("erreur");
    }

    public void scannerOperation(ActionEvent event) throws IOException {
        Card cardData = new Card();
        try {
            String selectedCard = My_image;
            File imageFile = new File(selectedCard);
            byte[] image = Files.readAllBytes(imageFile.toPath());

            // Get a BufferedImage object from a byte array
            InputStream imageStream = new ByteArrayInputStream(image);
            BufferedImage originalImage = ImageIO.read(imageStream);

            ICardOCRService cardStorageService = new CardOCRService();
            cardData = cardStorageService.getCardData(originalImage);
            /*jTextFieldLastName.setText(card.getLastName());
            jTextFieldFirstName.setText(card.getFirstName());
            jTextFieldReference.setText(String.valueOf(card.getReference()));
            jTextFieldCardNumber.setText(card.getCardNumber());*/
        } catch (IOException e) {
            e.printStackTrace();
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Result.fxml"));
        Parent root = loader.load();
        ResultController controller = loader.<ResultController>getController();
        controller.setData(cardData);

        Scene scene = new Scene(root, 1000, 600);
        Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
