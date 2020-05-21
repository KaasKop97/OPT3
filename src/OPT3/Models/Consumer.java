package OPT3.Models;

public class Consumer extends Customer {
    public int ID;
    public String teamviewer_id;
    public String teamviewer_password;

    public Consumer(int ID, String name, String email_address, String telephone_number, String type, int ID1, String teamviewer_id, String teamviewer_password) {
        super(ID, name, email_address, telephone_number, type);
        this.ID = ID1;
        this.teamviewer_id = teamviewer_id;
        this.teamviewer_password = teamviewer_password;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTeamviewer_id() {
        return teamviewer_id;
    }

    public void setTeamviewer_id(String teamviewer_id) {
        this.teamviewer_id = teamviewer_id;
    }

    public String getTeamviewer_password() {
        return teamviewer_password;
    }

    public void setTeamviewer_password(String teamviewer_password) {
        this.teamviewer_password = teamviewer_password;
    }
}
