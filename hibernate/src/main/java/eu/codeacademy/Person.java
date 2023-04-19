package eu.codeacademy;

import java.util.StringJoiner;

public class Person {
    private int id;
    private String name;
    private String surname;

    private int age;

    public Person(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("surname='" + surname + "'")
                .add("age=" + age) + "\n"
                .toString();
    }
}
