package eu.codeacademy.model;

import java.util.StringJoiner;

public class Car {
    public String name;
    public int year;
    public int wheelCount;
    public int doorCount;

    public Car() {
    }

    public Car(String name, int year, int wheelCount, int doorCount) {
        this.name = name;
        this.year = year;
        this.wheelCount = wheelCount;
        this.doorCount = doorCount;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public int getDoorCount() {
        return doorCount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("year=" + year)
                .add("wheelCount=" + wheelCount)
                .add("doorCount=" + doorCount)
                .toString();
    }


}
