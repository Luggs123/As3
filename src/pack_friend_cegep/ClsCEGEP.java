package pack_friend_cegep;

public class ClsCEGEP {
    
    int CEGEPID; // must be unique integer
    String cegepName;
    String City;
    
    public ClsCEGEP(int CEGEPID, String cegepName, String City) { 
        this.CEGEPID = CEGEPID;
        this.cegepName = cegepName;
        this.City = City;
    }

    public int getCEGEPID() {
        return CEGEPID;
    }

    public void setCEGEPID(int CEGEPID) {
        this.CEGEPID = CEGEPID;
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

