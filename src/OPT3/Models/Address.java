package OPT3.Models;

public class Address {
    public Integer id;
    public String street_name;
    public String street_number;
    public String city;
    public String postal_code;
    public String province;

    public Address(Integer id, String street_name, String street_number, String city, String postal_code, String province) {
        this.id = id;
        this.street_name = street_name;
        this.street_number = street_number;
        this.city = city;
        this.postal_code = postal_code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.postal_code = postal_code;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
