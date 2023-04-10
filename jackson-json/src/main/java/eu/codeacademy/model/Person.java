package eu.codeacademy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.StringJoiner;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person implements Serializable {
    private String name;
    private int age;
    private boolean gender;
    private Car car;
    @JsonProperty("address2")
    private Address address;


    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public Car getCar() {
        return car;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("gender=" + gender)
                .add("car=" + car)
                .add("address=" + address)
                .toString();
    }

}
