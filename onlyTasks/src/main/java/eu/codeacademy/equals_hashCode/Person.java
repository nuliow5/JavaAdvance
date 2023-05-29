package eu.codeacademy.equals_hashCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public class Person {
    private String name;
    private int age;
//    private String id;



//        if (this.name.equals(person.name) && (this.age == person.age)){
//            return true;
//        } else {
//            return false;
//        }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return age == person.age && name.equals(person.name);
//    }
//
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


}
