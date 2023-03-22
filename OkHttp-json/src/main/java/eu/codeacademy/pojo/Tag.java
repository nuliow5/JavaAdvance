package eu.codeacademy.pojo;

import java.util.StringJoiner;

public class Tag {
    private long id;
    private String  name;

    public Tag() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tag.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .toString();
    }
}
