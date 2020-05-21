package OPT3.Models;

public class Company extends Customer {

    public String id;
    public String name;
    public String kvk_number;
    public String contact_person;

    public Company(String id, String name, String kvk_number, String contact_person) {
        super();
        this.id = id;
        this.name = name;
        this.kvk_number = kvk_number;
        this.contact_person = contact_person;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getKvk_number() {
        return kvk_number;
    }

    public void setKvk_number(String kvk_number) {
        this.kvk_number = kvk_number;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }
}
