package pack_main;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClsFriendsList extends Application implements IntConstants {

	static boolean showWinPictSound = true;
	static Button btnAdd = new Button("Add Friend");
	static Button btnEdit = new Button("Edit Friend");
	static Button btnDelete = new Button("Remove Friend");
	static Button btnSearch = new Button("Search for Friend");
	static Button btnSave = new Button("Save Friend Data");
	static Button btnDone = new Button("Done");
	
	@Override
	public void start(Stage primaryStage) {
		/*** WinPictSound ***/
		// Separate VBoxes for labels and text fields.
		VBox pictSoundVBoxLabels = new VBox(18);
		VBox pictSoundVBoxField = new VBox(10);
		HBox pictSoundHBox = new HBox(10);
		pictSoundHBox.setPadding(new Insets(20));
		Scene scenePictSound = new Scene(pictSoundHBox, 500, 300);
		
		// Labels and text fields.
		Label idLabel = new Label("Student ID: ");
		TextField idField = new TextField();
		
		Label nameLabel = new Label("Name: ");
		TextField nameField = new TextField();

		pictSoundVBoxLabels.getChildren().addAll(idLabel, nameLabel);
		pictSoundVBoxField.getChildren().addAll(idField, nameField);
		
		pictSoundHBox.getChildren().addAll(pictSoundVBoxLabels, pictSoundVBoxField);
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

		btnEdit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>()
		{
			@Override
			public void handle(Event event) {

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
