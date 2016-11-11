package pack_main;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ClsHandlers implements EventHandler<Event> {

	// Listener for main menu buttons.
	@Override
	public void handle(Event event) {
		Object source = event.getSource();
		if (source == ClsMain.btnDisplay) { // Open friends display.

		} else if (source == ClsMain.btnFriendsList) { // Open friends list.
//			ClsFriendsList.start(Stage);
		} else if (source == ClsMain.btnExit) { // Close application.
			Platform.exit();
		}
	}

}
