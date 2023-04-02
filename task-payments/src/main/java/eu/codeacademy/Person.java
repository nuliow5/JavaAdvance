package eu.codeacademy;

import java.util.StringJoiner;

public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private int receivedMoney;
    private int sentMoney;

    public Person(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("receivedMoney=" + receivedMoney)
                .add("sentMoney=" + sentMoney)
                .toString();
    }

    public String toJson() {
        return new StringJoiner("", Person.class.getSimpleName() + "{", "}")
                .add("\n     \"id\":"              + "\"" + id + "\",\n" )
                .add("     \"firstName\":"       + "\"" + firstName + "\",\n" )
                .add("     \"lastName\":"        + "\"" + lastName + "\",\n" )
                .add("     \"receivedMoney\":"   + "\"" + receivedMoney + "\",\n" )
                .add("     \"sentMoney\":"       + "\"" + sentMoney + "\"\n" )
                .toString();
    }

    public int getReceivedMoney() {
        return receivedMoney;
    }

    public void setReceivedMoney(int receivedMoney) {
        this.receivedMoney += receivedMoney;
    }

    public int getSentMoney() {
        return sentMoney;
    }

    public void setSentMoney(int sentMoney) {
        this.sentMoney += sentMoney;
    }


}
