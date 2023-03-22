package eu.codeacademy.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.codeacademy.pojo.Category;
import eu.codeacademy.pojo.Pet;

import java.io.*;
import java.util.List;

public class PetService {
    final ObjectMapper objectMapper = new ObjectMapper();

    private static final String JSON_PATH = "\\src\\main\\java\\eu\\codeacademy\\new.json";
    private static final String JSON_OUTPUT_FORMAT = "\"pet\":{\n" +
            "\"id\": %d \n" +
            "     \"category\": {\n" +
            "     } \n" +
            "     \"name\": %s" +
            "     \"photoUrls\" { %s" +
            "     }" +
            "     \"tags\": { %s " +
            "     }" +
            "     \"status\": %s" +
            "}\n";



    public static void printJsonFormat(Pet[] pets){
        for (Pet pet : pets){
            System.out.printf(JSON_OUTPUT_FORMAT,
                    pet.getId(),
                    pet.getCategory(),
                    pet.getName(),
                    pet.getPhotoUrls(),
                    pet.getTags(),
                    pet.getStatus()
                    );
        }

    }

    private Pet[] objToList(Pet[] pets){

        return pets;

    }



    public void saveToFile(Pet[] pets) {
        try (FileOutputStream out = new FileOutputStream("new2.json");
             ObjectOutputStream outputStream = new ObjectOutputStream(out)){
            outputStream.writeObject(pets);
        } catch (IOException e){
            new Error("Error! " + e.getMessage());
        }


    }

    public void saveToFile2(Pet[] pets){

        try (BufferedWriter bfWriter = new BufferedWriter(new FileWriter("new3.json"))) {

            for (Pet pet : pets){
                bfWriter.write(pet.toJsonFormat());

            }
            System.out.println("File successfully created");
        } catch (IOException e){
            new Error("Error! " + e.getMessage());
        }
    }


//    public void writeJson(Pet[] pets) {
////        Person person = new Person("Petras", 25);
//
//        Pet pet = new Pet();
//
//        File personJsonFile = new File(JSON_PATH);
//        try {
//            objectMapper.writeValue(personJsonFile, pet);
//            Pet petDeserialized = objectMapper.readValue(personJsonFile, Pet.class);
//            System.out.println(petDeserialized);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public Pet transformFormTo(Pet pet){
//        return new
//
//    }

}
