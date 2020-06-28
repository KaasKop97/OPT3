package OPT3.Models;

public class Address {
    public String street_name;
    public String street_number;
    public String city;
    public String postal_code;
    public String province;

    public Address(String street_name, String street_number, String city, String postal_code, String province) {
        this.street_name = street_name;
        this.street_number = street_number;
        this.city = city;
        this.postal_code = postal_code;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        if(postal_code.length() != 6)   {
            System.out.println("Nothing changed since the postal code does not meet specification.");
        }
        this.postal_code = postal_code;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
