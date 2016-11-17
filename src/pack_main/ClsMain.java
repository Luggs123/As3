// TODO: CHECK PROGRAM FUNCTION
/*** Program Function; To create and display a list of given friends.
 *** Creator; Paul Gaudnik, Mark Jarjour, Michael Luger
 *** Submission Date; November 15th, 2016
 *** Date Last Modified; October 19th, 2016
 ***/

package pack_main;

import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pack_friend_cegep.ClsCEGEP;
import pack_friend_cegep.ClsFriend;

public class ClsMain extends Application implements IntConstants {
	
	static protected List<ClsCEGEP> cegepList = new LinkedList<ClsCEGEP>();
	static protected List<ClsFriend> friendsList = new LinkedList<ClsFriend>();
	
	static protected String[] friendsDatabase = new String[]{ "Mark", "Michael", "Paul", "Juan", "Syphen", "JavaMM" };

	static protected Scene scene; // Main Scene
	static protected HBox winMain = new HBox(); // Main HBox used to place WinButtons and WinPictSound.
	static protected VBox winButtons = new VBox();
	static protected VBox winPictSound = new VBox();

	static protected Button btnDisplay = new Button("Display Friends");
	static protected Button btnFriendsList = new Button("View Friends List");
	static protected Button btnExit = new Button("Exit");

	@Override
	public void start(Stage stage) {
		// Scenes.
		winButtons = new VBox();
		winButtons = (VBox) createWinButtons();
		
		winPictSound.setVisible(false);
		winMain.getChildren().addAll(winButtons, winPictSound);
		scene = new Scene(winMain, 800, 400);
		
		winButtons.setPrefWidth(800);
		winButtons.setPadding(new Insets(50, 5, 5, 10));

		stage.setTitle("Assignment 3");
		stage.setScene(scene);
		stage.show();
	}
	
	protected static Pane createWinButtons() {
		VBox mainMenuVBox = new VBox(15);
		mainMenuVBox.setAlignment(Pos.TOP_CENTER);
		mainMenuVBox.setPadding(new Insets(50, 5, 5, 10));

		// Buttons.
		btnDisplay.setPrefWidth(btnWidth);
		btnDisplay.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());
		
		if (friendsList.isEmpty()) {
			btnDisplay.setDisable(true);
		} else {
			btnDisplay.setDisable(false);
		}

		btnFriendsList.setPrefWidth(btnWidth);
		btnFriendsList.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());

		btnExit.setPrefWidth(btnWidth);
		btnExit.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());

		mainMenuVBox.getChildren().addAll(btnDisplay, btnFriendsList, btnExit);

		return mainMenuVBox;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static Boolean catchNumberFormatError(TextField textfield, String errMsg) {
		try {
			// Parse text field.
			Integer.parseInt(textfield.getText());
		}

		catch (NumberFormatException nfe) {
			// If an error is caught then throw an error message.
			ClsFriendsList.errLabel.setText(errMsg);
			return true;
		}

		return false;
	}
}
