package pack_main;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ClsFriendsList implements IntConstants {

	static protected Button btnAdd = new Button("Add Friend");
	static protected Button btnEdit = new Button("Edit Friend");
	static protected Button btnDelete = new Button("Remove Friend");
	static protected Button btnSearch = new Button("Search for Friend");
	static protected Button btnSave = new Button("Save Friend Data");
	static protected Button btnDone = new Button("Done");

	public static Pane createWinPictSound() {
		// Separate VBoxes for labels and text fields.
		VBox pictSoundVBoxLabels = new VBox(18);
		VBox pictSoundVBoxField = new VBox(10);

		HBox pictSoundHBox = new HBox(10);
		pictSoundHBox.setPadding(new Insets(20));

		// Labels and text fields.
		Label idLabel = new Label("Student ID: ");
		TextField idField = new TextField();

		Label nameLabel = new Label("Name: ");
		TextField nameField = new TextField();

		pictSoundVBoxLabels.getChildren().addAll(idLabel, nameLabel);
		pictSoundVBoxField.getChildren().addAll(idField, nameField);

		pictSoundHBox.getChildren().addAll(pictSoundVBoxLabels, pictSoundVBoxField);

		return pictSoundHBox;
	}

	public static Pane createWinButtons() {
		VBox buttonsVBox = new VBox(10);

		// Buttons
		btnAdd.setPrefWidth(btnWidth);
		btnAdd.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());

		buttonsVBox.getChildren().addAll(btnAdd);

		return buttonsVBox;
	}
}
