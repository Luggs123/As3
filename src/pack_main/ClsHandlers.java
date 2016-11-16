package pack_main;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import pack_friend_cegep.ClsCEGEP;
import pack_friend_cegep.ClsFriend;

public class ClsHandlers implements EventHandler<Event>, IntConstants {

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
		else if (source == ClsFriendsList.btnAdd) { // Display the add friend form.
			ClsMain.winPictSound.setVisible(true);
		}

		else if (source == ClsFriendsList.btnEdit) { // Search for and edit friends list.
			ClsFriend foundedFriend = searchFriendsList(Integer.parseInt(ClsFriendsList.idField.getText()));
			if (foundedFriend == null) {
				// No friend was found on the current friends list.
				ClsFriendsList.errLabel.setText("The \"School Name\" parameter is empty.");
				return;
			}
			
			// Otherwise it found one.
			ClsFriendsList.idField.setText(Integer.toString(foundedFriend.getFriendID()));
			ClsFriendsList.nameField.setText(foundedFriend.getName());
			ClsFriendsList.ageField.setText(Integer.toString(foundedFriend.getAge()));
			ClsFriendsList.schoolField.setText(foundedFriend.getSchool_Name().getCegepName());
		}
		
		else if (source == ClsFriendsList.btnSave) { // Save the friend input data, assuming it is valid.
			// Checking if the inputs are valid.
			if (ClsMain.catchNumberFormatError(ClsFriendsList.idField, "Please enter a valid \"Student ID\" parameter.")
					|| ClsMain.catchNumberFormatError(ClsFriendsList.ageField, "Please enter a valid \"Age\" parameter.")) {
				return;
			} else if (ClsFriendsList.nameField.getText().isEmpty()) {
				ClsFriendsList.errLabel.setText("The \"Name\" parameter is empty.");
				return;
			} else if (ClsFriendsList.schoolField.getText().isEmpty()) {
				ClsFriendsList.errLabel.setText("The \"School Name\" parameter is empty.");
				return;
			}
			
			// Check if the friend is in the database.
			else {
				Boolean doesExist = false;
				for (int i = 0; i < ClsMain.friendsDatabase.length; i++) {
					if (ClsMain.friendsDatabase[i] == ClsFriendsList.nameField.getText()) {
						doesExist = true;
						break;
					}
				}
				
				if (!doesExist) {
					ClsFriendsList.errLabel.setText("The specified friend does not exist in the database.");
					return;
				}
			}
			
			// Check if the CEGEP already exists use that object.
			String schoolName = ClsFriendsList.schoolField.getText();
			for (ClsCEGEP list : ClsMain.cegepList) {
				if (list.getCegepName() == schoolName) {
					// If the CEGEP object already exists then use that object instead.
					ClsMain.friendsList.add(new ClsFriend(ClsFriendsList.idField.getText(),
							Integer.parseInt(ClsFriendsList.ageField.getText()), list));
					
					// Clear all the labels of any previous information.
					ClsFriendsList.idField.setText(EMP_STR);
					ClsFriendsList.nameField.setText(EMP_STR);
					ClsFriendsList.ageField.setText(EMP_STR);
					ClsFriendsList.schoolField.setText(EMP_STR);
					ClsFriendsList.errLabel.setText(EMP_STR);
					return;
				}
			}
			
			// Otherwise create a new CEGEP object.
			ClsCEGEP newCEGEP = new ClsCEGEP(schoolName, "Montreal");
			ClsMain.friendsList.add(new ClsFriend(ClsFriendsList.idField.getText(),
					Integer.parseInt(ClsFriendsList.ageField.getText()), newCEGEP));
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
			if (list.getFriendID() == friendID) {
				return list;
			}
		}
		return null;
	}

	// Clears the windows inside the main container and replaces them with the desired panes.
	public static void updateVBoxes(Pane winButtons, Pane winPictSound) {
		// Restore main panes to their defaults.
		ClsMain.winButtons.getChildren().clear();
		ClsMain.winPictSound.getChildren().clear();
		ClsMain.winButtons.setAlignment(null);
		ClsMain.winPictSound.setAlignment(null);
		ClsMain.winButtons.setPrefWidth(300);
		ClsMain.winPictSound.setPrefWidth(500);

		// Add the specified panes.
		ClsMain.winButtons.getChildren().add(winButtons);
		ClsMain.winPictSound.getChildren().add(winPictSound);
	}
}
