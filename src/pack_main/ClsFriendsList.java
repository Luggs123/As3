package pack_main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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

	// Label for displaying user input errors.
	static protected Label errLabel = new Label();

	protected static Pane createWinPictSound() {
		// Separate VBoxes for labels and text fields.
		VBox pictSoundVBoxLabels = new VBox(20);
		pictSoundVBoxLabels.setPadding(new Insets(24));
		
		VBox pictSoundVBoxField = new VBox(10);
		pictSoundVBoxField.setPadding(new Insets(24));

		HBox pictSoundHBox = new HBox(10);
		VBox pictSoundVBox = new VBox();
		pictSoundHBox.setPadding(new Insets(24));
		pictSoundHBox.setAlignment(Pos.BASELINE_CENTER);
		
		// Labels
		Label idLabel = new Label("Student ID: ");
		Label nameLabel = new Label("Name: ");
		Label ageLabel = new Label("Age: ");
		Label schoolLabel = new Label("School Name: ");
		errLabel.setTextFill(Color.RED);
		errLabel.setPadding(new Insets(0, 0, 0, 90));
		
		pictSoundVBoxLabels.getChildren().addAll(idLabel, nameLabel, ageLabel, schoolLabel);
		pictSoundVBoxField.getChildren().addAll(idField, nameField, ageField, schoolField);

		pictSoundHBox.getChildren().addAll(pictSoundVBoxLabels, pictSoundVBoxField);
		pictSoundVBox.getChildren().addAll(pictSoundHBox, errLabel);

		return pictSoundVBox;
	}

	protected static Pane createWinButtons() {
		VBox buttonsVBox = new VBox(10);

		// Buttons
		btnAdd.setPrefWidth(btnWidth);
		btnAdd.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());
		
		btnEdit.setPrefWidth(btnWidth);
		btnEdit.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());
		
		btnDelete.setPrefWidth(btnWidth);
		btnDelete.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());
		
		btnSearch.setPrefWidth(btnWidth);
		btnSearch.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());
		
		btnSave.setPrefWidth(btnWidth);
		btnSave.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());
		
		btnDone.setPrefWidth(btnWidth);
		btnDone.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());

		buttonsVBox.getChildren().addAll(btnAdd, btnEdit, btnDelete, btnSearch, btnSave, btnDone);

		return buttonsVBox;
	}
}
