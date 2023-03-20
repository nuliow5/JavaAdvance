package eu.codeacademy.model;

import java.util.StringJoiner;

public class Address {
    private CountyType country;
    private String city;

    public Address() {
    }

    public CountyType getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Address.class.getSimpleName() + "[", "]")
                .add("country=" + country)
                .add("city='" + city + "'")
                .toString();
    }
}
