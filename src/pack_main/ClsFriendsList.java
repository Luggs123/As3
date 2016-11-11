package pack_main;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClsFriendsList extends Application implements IntConstants {

	static Button btnAdd = new Button("Add Friend");
	static Button btnEdit = new Button("Edit Friend");
	static Button btnDelete = new Button("Remove Friend");
	static Button btnSearch = new Button("Search for Friend");
	static Button btnSave = new Button("Save Friend Data");
	static Button btnDone = new Button("Done");
	
	@Override
	public void start(Stage primaryStage) {
		VBox pictSoundVBox = new VBox(15);
		Scene scenePictSound = new Scene(pictSoundVBox, 500, 300);

		primaryStage.setTitle("WinPictSound");
		primaryStage.setScene(scenePictSound);
		primaryStage.hide();
		
		/*** WinButtons ***/
		Stage secondaryStage = new Stage();
		VBox buttonsVBox = new VBox(10);
		Scene sceneButtons = new Scene(buttonsVBox, 300, 500);
		
		// Buttons
		btnAdd.setPrefWidth(btnWidth);
		// TODO: Does this have to be inline?
		btnAdd.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>()
				{
					@Override
					public void handle(Event event) {
						primaryStage.show();
					}
			
				});

		buttonsVBox.getChildren().addAll(btnAdd);
		
		secondaryStage.setTitle("WinButtons");
		secondaryStage.setScene(sceneButtons);
		secondaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
