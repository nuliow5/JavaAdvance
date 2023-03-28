package eu.codeacademy.pattern.builder;

import eu.codeacademy.model.Person;

public class BuilderPattern {
    public Person createPerson(String name, String surname){
        //1 variantas, kuriant builderi rankutemis
//        return new Person.Builder()
//                .name(name)
//                .surname(surname)
//                .build();

        //2 variantas su Lamboko anotacija
        return Person.builder()
                .name(name)
                .surname(surname)
                .build();

    }
}
