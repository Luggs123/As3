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

	// Text fields.
	static protected TextField idField = new TextField();
	static protected TextField nameField = new TextField();
	static protected TextField ageField = new TextField();
	static protected TextField schoolField = new TextField();

	static protected Button btnAdd = new Button("Add Friend");
	static protected Button btnEdit = new Button("Edit Friend");
	static protected Button btnDelete = new Button("Remove Friend");
	static protected Button btnSearch = new Button("Search for Friend");
	static protected Button btnSave = new Button("Save Friend Data");
	static protected Button btnDone = new Button("Done");

	static protected Label errLabel = new Label(); // For displaying user input
													// errors.

	protected static Pane createWinPictSound() {
		// Separate VBoxes for labels and text fields.
		VBox pictSoundVBoxLabels = new VBox(18);
		VBox pictSoundVBoxField = new VBox(10);

		HBox pictSoundHBox = new HBox(10);
		pictSoundHBox.setPadding(new Insets(20));
		
		// Labels
		Label idLabel = new Label("Student ID: ");
		Label nameLabel = new Label("Name: ");
		Label ageLabel = new Label("Age: ");
		Label schoolLabel = new Label("School Name: ");
		
		pictSoundVBoxLabels.getChildren().addAll(idLabel, nameLabel, ageLabel, schoolLabel);
		pictSoundVBoxField.getChildren().addAll(idField, nameField, ageField, schoolField);

		pictSoundHBox.getChildren().addAll(pictSoundVBoxLabels, pictSoundVBoxField);

		return pictSoundHBox;
	}

	protected static Pane createWinButtons() {
		VBox buttonsVBox = new VBox(10);

		// Buttons
		btnAdd.setPrefWidth(btnWidth);
		btnAdd.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());

		buttonsVBox.getChildren().addAll(btnAdd);

		return buttonsVBox;
	}
}
