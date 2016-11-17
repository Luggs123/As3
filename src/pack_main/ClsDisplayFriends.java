package pack_main;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ClsDisplayFriends implements IntConstants {

	// True: Manual
	// False: Automatic
	static protected Boolean displayMode;
	
	static protected int counter = 0;
	
	static protected Button btnMan = new Button("Manual");
	static protected Button btnAuto = new Button("Automatic");
	static protected Button btnPrev = new Button("Previous");
	static protected Button btnNext = new Button("Next");
	static protected Button btnSound = new Button("Save Friend Data");
	static protected Button btnDone = new Button("Done");
	
	protected static Pane createWinButtons() {
		VBox buttonsVBox = new VBox(10);

		// Buttons
		btnMan.setPrefWidth(btnWidth);
		btnMan.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());
		
		btnAuto.setPrefWidth(btnWidth);
		btnAuto.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());
		
		btnPrev.setPrefWidth(btnWidth / 2);
		btnPrev.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());
		btnPrev.setVisible(false);
		
		btnNext.setPrefWidth(btnWidth / 2);
		btnNext.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());
		btnNext.setVisible(false);
		
		btnSound.setPrefWidth(btnWidth / 2);
		btnSound.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClsHandlers());
		btnSound.setVisible(false);
		
		HBox manualButtons = new HBox();
		manualButtons.getChildren().addAll(btnPrev, btnNext);

		buttonsVBox.getChildren().addAll(btnMan, btnAuto, manualButtons);

		return buttonsVBox;
	}
	
	protected static Pane updateWinPictSound() {
		HBox manualButtons = new HBox();

		return manualButtons;
	}
}
