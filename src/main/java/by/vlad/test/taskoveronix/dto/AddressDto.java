package by.vlad.test.taskoveronix.dto;

import by.vlad.test.taskoveronix.model.Address;
import by.vlad.test.taskoveronix.model.Coordinates;

public class AddressDto {

    private Address address;
    private String lat;
    private String lon;

    public AddressDto() {
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
