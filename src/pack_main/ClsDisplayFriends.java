package pack_main;

import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import pack_friend_cegep.ClsFriend;

public class ClsDisplayFriends implements IntConstants {

	// True: Manual
	// False: Automatic
	static protected Boolean displayMode;
	static protected Boolean soundToggle = true;

	static protected int counter = 0;

	static protected Button btnMan = new Button("Manual");
	static protected Button btnAuto = new Button("Automatic");
	static protected Button btnPrev = new Button("Previous");
	static protected Button btnNext = new Button("Next");
	static protected Button btnSound = new Button("Save Friend Data");
	static protected Button btnDone = new Button("Done");
	static protected Timer autoTimer = new Timer();


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
		HBox displayPane = new HBox();

		ClsFriend currentFriend = ClsMain.friendsList.get(counter);
		String friendName = currentFriend.getName();

		Image friendImage = new Image("Resources/gfx/" + friendName + ".png");
		ImageView friendIcon = new ImageView(friendImage);
		displayPane.getChildren().add(friendIcon);

		// Disable btnPrev or btnNext based on where the counter is.
		if (counter == 0) {
			btnPrev.setDisable(true);
		} else {
			btnPrev.setDisable(false);
		}

		if (counter == ClsMain.friendsList.size() - 1) {
			btnNext.setDisable(true);
		} else {
			btnNext.setDisable(false);
		}

		// If sound is on then play a file.
		if (soundToggle) {
			AudioClip audioSample = new AudioClip(ClsDisplayFriends.class.getResource("/Resources/sfx/" + friendName + ".wav").toString());
			audioSample.play();
		}
		
		if (!soundToggle) {
			autoTimer.schedule(
					new TimerTask() {

						@Override
						public void run() {
							if (ClsDisplayFriends.counter < ClsMain.friendsList.size() - 1) {
								++ClsDisplayFriends.counter;
								ClsDisplayFriends.updateWinPictSound();
							}
						}
					}, 0, 5000);
		}

		return displayPane;
	}
}