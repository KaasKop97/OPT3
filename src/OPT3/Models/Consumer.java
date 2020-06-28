package OPT3.Models;

public class Consumer extends Customer {
    public int ID;
    public String teamviewer_id;
    public String teamviewer_password;

    public Consumer(int ID, String name, String email_address, String telephone_number, String type, Address address, String teamviewer_id, String teamviewer_password) {
        super(ID, name, email_address, telephone_number, type, address);
        this.teamviewer_id = teamviewer_id;
        this.teamviewer_password = teamviewer_password;
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
