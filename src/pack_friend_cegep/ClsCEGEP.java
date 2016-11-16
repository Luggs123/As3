package pack_friend_cegep;

public class ClsCEGEP {
    
	static private int counter;
    private int CEGEPID; // must be unique integer
	private String cegepName;
	private  String City;
    
    public ClsCEGEP(String cegepName, String City) { 
        this.CEGEPID = counter++;
        this.cegepName = cegepName;
        this.City = City;
    }

    public int getCEGEPID() {
        return CEGEPID;
    }

    public String getCegepName() {
        return cegepName;
    }

    public void setCegepName(String cegepName) {
        this.cegepName = cegepName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }
    
    
}

