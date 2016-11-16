package pack_friend_cegep;

public class ClsFriend {

	int FriendID; // must be unique integer
	String Name;
	int Age;
	ClsCEGEP School_Name;

	public ClsFriend(int FriendID, String Name, int Age, ClsCEGEP School_Name) {
		this.FriendID = FriendID;
		this.Name = Name;
		this.Age = Age;
		this.School_Name = School_Name;
	}

	public ClsFriend(int FriendID, String Name, int Age, int School_ID, String School_Name, String School_City) {
		this.FriendID = FriendID;
		this.Name = Name;
		this.Age = Age;
		this.School_Name = new ClsCEGEP(School_ID, School_Name, School_City);
	}

	public int getFriendID() {
		return FriendID;
	}

	public void setFriendID(int FriendID) {
		this.FriendID = FriendID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int Age) {
		this.Age = Age;
	}

	public ClsCEGEP getSchool_Name() {
		return School_Name;
	}

	public void setSchool_Name(String School_Name) {
		this.School_Name = new ClsCEGEP(Age, School_Name, School_Name);
	}

}
