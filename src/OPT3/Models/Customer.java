package OPT3.Models;

public class Customer {
    public int ID;
    public String name;
    public String email_address;
    public String telephone_number;
    public String type;

    public Customer(int ID, String name, String email_address, String telephone_number, String type) {
        this.ID = ID;
        this.name = name;
        this.email_address = email_address;
        this.telephone_number = telephone_number;
        this.type = type;
    }

    public Customer()   {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
