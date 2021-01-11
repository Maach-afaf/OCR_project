package com.ocr.card;

/*import com.ocr.card.controller.CardOCRController;
import com.ocr.card.ui.CardFrame;*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Paths;

import static javafx.application.Application.launch;

public class CardApplication extends Application {

	/*public static void main(String[] args) {
		new CardFrame();
		//new CardChooser().getPath();
		CardOCRController obj = new CardOCRController();
		System.out.println("Testing 1 - Send Http GET request");
		obj.uploadCardTransferFile();
	}*/
	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
		primaryStage.setTitle("Scanner Application ");
		primaryStage.setScene(new Scene(root, 1000, 600));
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}
}