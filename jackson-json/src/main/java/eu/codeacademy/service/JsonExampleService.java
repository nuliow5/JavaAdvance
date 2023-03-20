package eu.codeacademy.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.codeacademy.model.Car;
import eu.codeacademy.model.Person;
import eu.codeacademy.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class JsonExampleService {
    final ObjectMapper objectMapper = new ObjectMapper();

    public void basicSerializeAndDeserializeExample() {
        Person person = new Person("Petras", 25);

        File personJsonFile = new File("target/person.json");
        try {
            objectMapper.writeValue(personJsonFile, person);
            Person personDeserialized = objectMapper.readValue(personJsonFile, Person.class);
            System.out.println(personDeserialized);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void basicDeserializationFromResources() {
        File carJsonFile = null;
        try {
            carJsonFile = FileUtils.getFileFromResource("car.json");
            Car carDeserialized = objectMapper.readValue(carJsonFile, Car.class);
            System.out.println(carDeserialized);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void basicCompositionExample() {
        File json = null;
        try {
            json = FileUtils.getFileFromResource("personCar.json");

            Person person = objectMapper.readValue(json, Person.class);
            System.out.println(person);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void missingClassVariableByJsonProperty() {
        File json = null;
        try {
            json = FileUtils.getFileFromResource("personCar.json");
//            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);  //TODO: investigate why this doesn't work
            Person person = objectMapper.readValue(json, Person.class);
            System.out.println(person);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void compositionWithEnumTypeExample() {
        File json = null;
        try {
            json = FileUtils.getFileFromResource("personAddress.json");

            Person person = objectMapper.readValue(json, Person.class);
            System.out.println(person);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }


}
