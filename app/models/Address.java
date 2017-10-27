package models;

public class Address {

    private String street1;
    private String street2;
    private String city;
    private String state;
    private int zip;
    private String country;

    public Address(String street1, String street2, String city, String state, int zip, String country) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }
}
