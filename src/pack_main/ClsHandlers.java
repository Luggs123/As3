package pack_main;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import pack_friend_cegep.ClsFriend;

public class ClsHandlers implements EventHandler<Event> {

	@Override
	public void handle(Event event) {
		Object source = event.getSource();
		/*** ClsMain ***/
		if (source == ClsMain.btnDisplay) { // Open friends display.
			updateVBoxes(ClsDisplayFriends.createWinButtons(), ClsDisplayFriends.updateWinPictSound());
			
			// Hide these buttons by default.
			ClsDisplayFriends.btnPrev.setVisible(false);
			ClsDisplayFriends.btnNext.setVisible(false);
		}
		
		else if (source == ClsMain.btnFriendsList) { // Open friends list.
			updateVBoxes(ClsFriendsList.createWinButtons(), ClsFriendsList.createWinPictSound());
			
			// Hide WinPictSound by default.
			ClsMain.winPictSound.setVisible(false);
		}
		
		else if (source == ClsMain.btnExit) { // Close the application.
			Platform.exit();
		}
		
		/*** ClsFriendsList ***/
		else if (source == ClsFriendsList.btnAdd) { // Add friend.
			ClsMain.winPictSound.setVisible(true);
		}

		else if (source == ClsFriendsList.btnEdit) { // Search for and edit friends list.
//			if (!searchFriendsList(0/*edit ID form*/));
		}
		
		/*** ClsDisplayFriends ***/
		else if (source == ClsDisplayFriends.btnMan) { // Displays the previous and next buttons.
			ClsDisplayFriends.btnPrev.setVisible(true);
			ClsDisplayFriends.btnNext.setVisible(true);
		}
	}
	
	// Search for a friend ID inside the database and return true if one is found.
	public static ClsFriend searchFriendsList(int friendID) {
		for (ClsFriend list : ClsMain.friendsList) {
			if (list.getFriendID() == friendID) { return list; }
		}
		return null;
	}
	
	// Clears the windows inside the main container and replaces them with the desired panes.
	// Accepts a Pane object so that HBoxes don't have to be wrapped in a redundant VBox.
	public static void updateVBoxes(Pane winButtons, Pane winPictSound) {
		// Restore main panes to their defaults.
		ClsMain.winButtons.getChildren().clear();
		ClsMain.winPictSound.getChildren().clear();
		ClsMain.winButtons.setAlignment(null);
		ClsMain.winPictSound.setAlignment(null);
		ClsMain.winButtons.setPrefWidth(400);
		ClsMain.winPictSound.setPrefWidth(400);
		
		ClsMain.winButtons.getChildren().add(winButtons);
		ClsMain.winPictSound.getChildren().add(winPictSound);
	}
}
