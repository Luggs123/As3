package pack_main;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import pack_friend_cegep.ClsFriend;

public class ClsHandlers implements EventHandler<Event> {

	// Listener for main menu buttons.
	@Override
	public void handle(Event event) {
		Object source = event.getSource();
		/*** ClsMain ***/
		if (source == ClsMain.btnDisplay) { // Open friends display.

		} else if (source == ClsMain.btnFriendsList) { // Open friends list.
			
		} else if (source == ClsMain.btnExit) { // Close application.
			Platform.exit();
		}
		/*** ClsFriendsList ***/
		else if (source == ClsFriendsList.btnAdd) { // Add friend.
			
		}

		else if (source == ClsFriendsList.btnEdit) { // Search for and edit friends list.
			if (!searchFriendsList(0/*edit ID form*/));
		}
	}
	
	class checkBoolChange implements ChangeListener<Boolean> {

		@Override
		public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
			
		}
		
	}
	
	// Search for a friend ID inside the database and return true if one is found.
	public static Boolean searchFriendsList(int friendID) {
		for (ClsFriend list : ClsMain.friendsList) {
			if (list.getFriendID() == friendID) { return true; }
		}
		return false;
	}

}
