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

		} else if (source == ClsMain.btnFriendsList) { // Open friends list.
			updateVBoxes(ClsFriendsList.createWinButtons(), ClsFriendsList.createWinPictSound());
			ClsMain.winPictSound.setVisible(false);
		} else if (source == ClsMain.btnExit) { // Close the application.
			Platform.exit();
		}
		/*** ClsFriendsList ***/
		else if (source == ClsFriendsList.btnAdd) { // Add friend.
			ClsMain.winPictSound.setVisible(true);
		}

		else if (source == ClsFriendsList.btnEdit) { // Search for and edit friends list.
			//if (!searchFriendsList(0/*edit ID form*/));
		}
                else if (source == ClsFriendsList.btnSave) {
                    if (catchNumberFormatError(ClsFriendsList.IdField, "Please enter a valid \"Unit ID\" parameter.")) { return; }
                    if (catchNumberFormatError(ClsFriendsList.nameField, "Please enter a valid \"Unit ID\" parameter.")) { return; }
                    if (catchNumberFormatError(ClsFriendsList.ageField, "Please enter a valid \"Unit ID\" parameter.")) { return; }
                    if (catchNumberFormatError(ClsFriendsList.schoolField, "Please enter a valid \"Unit ID\" parameter.")) { return; } 
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
	// Accepts a pane so that HBoxes don't have to be raped in a redundant VBox.
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
