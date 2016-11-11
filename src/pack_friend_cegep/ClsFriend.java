package pack_friend_cegep;


public class ClsFriend {
    int FriendID; // must be unique integer
    String Name;
    int Age;
    ClsCEGEP School_Name;
    
    public ClsFriend(int FriendID, String Name, int Age) {
        this.FriendID = FriendID;
        this.Name = Name;
        this.Age = Age; 
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

    public void setSchool_Name(ClsCEGEP School_Name) {
        this.School_Name = School_Name;
    }
    
}
