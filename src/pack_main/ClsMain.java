// TODO: CHECK PROGRAM FUNCTION
/*** Program Function; To create and display a list of given friends.
 *** Creator; Paul Gaudnik, Mark Jarjour, Michael Luger
 *** Submission Date; November 15th, 2016
 *** Date Last Modified; October 19th, 2016
 ***/

package pack_main;

import pack_friend_cegep.*;

import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ClsMain extends Application implements IntConstants {
	
	protected static List<ClsFriend> friendsList = new LinkedList<ClsFriend>();
	
	static Button btnDisplay = new Button("Display Friends");
	static Button btnFriendsList = new Button("View Friends List");
	static Button btnExit = new Button("Exit");
	
	@Override
	public void start(Stage stage) {
		VBox mainMenuVBox = new VBox(15);
		Scene scene = new Scene(mainMenuVBox, 300, 250);

		// Buttons. 
		btnDisplay.setPrefWidth(btnWidth);
		btnDisplay.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());
		
		btnFriendsList.setPrefWidth(btnWidth);
		btnFriendsList.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());

		btnExit.setPrefWidth(btnWidth);
		btnExit.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());

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
