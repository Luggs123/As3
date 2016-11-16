package pack_friend_cegep;

public class ClsFriend {

	static private int counter;
	private int FriendID; // must be unique integer
	private String Name;
	private int Age;
	private ClsCEGEP School_Name;

	public ClsFriend(String Name, int Age, ClsCEGEP School_Name) {
		this.FriendID = counter++;
		this.Name = Name;
		this.Age = Age;
		this.School_Name = School_Name;
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
}
