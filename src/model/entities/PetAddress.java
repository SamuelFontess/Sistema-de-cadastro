package model.entities;

public class PetAddress {
    int Number;
    String city;
    String street;

    public PetAddress(){
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int houseNumber) {
        this.Number = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "PetAddress{" +
                "city='" + city + '\'' +
                ", Number=" + Number +
                ", street='" + street + '\'' +
                '}';
    }
}