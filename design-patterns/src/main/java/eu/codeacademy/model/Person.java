package eu.codeacademy.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder  //pilnai subildino objekto, musu uzkomentuoto kodo nebereikia :D
public class Person {
    private String name;
    private String surname;

//    public Person(Builder builder) {
//        this.name = builder.name;
//        this.surname = builder.surname;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public static class Builder{
//        private String name;
//        private String surname;
//
//
//
//
//        public Builder name(String name){
//            this.name = name;
//            return this;
//        }
//
//        public Builder surname(String surname){
//            this.surname = surname;
//            return this;
//        }
//
//        public Person build(){
//            return new Person(this);
//        }
//
//    }
}
