package pack_main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ClsMain extends Application {
	final int btnWidth = 270;

	@Override
	public void start(Stage stage) {

		VBox mainMenuVBox = new VBox(15);
		Scene scene = new Scene(mainMenuVBox, 300, 250);

		// Buttons. 
		Button btnDisplay = new Button("Display Friends");
		btnDisplay.setPrefWidth(btnWidth);
		//		btnDisplay.setOnAction(); 

		Button btnFriendsList = new Button("View Friends List");
		btnFriendsList.setPrefWidth(btnWidth);

		Button btnExit = new Button("Exit");
		btnExit.setPrefWidth(btnWidth);

		mainMenuVBox.getChildren().addAll(btnDisplay, btnFriendsList, btnExit);
		mainMenuVBox.setPadding(new Insets(50, 5, 5, 10));

		stage.setTitle("Main Menu");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
