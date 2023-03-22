package eu.codeacademy;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import eu.codeacademy.pojo.Pet;
import eu.codeacademy.service.PetService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class App {
    public static void main( String[] args ) throws IOException {
        ObjectMapper mapper = JsonMapper.builder()
                .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
                .build();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://petstore.swagger.io/v2/pet/findByStatus?status=sold")
                .build();

        Response response = client.newCall(request).execute();

        //print object
//        System.out.println(response.body().string());


        Pet[] pets = mapper.readValue(response.body().byteStream(), Pet[].class);
//        new PetService().printJsonFormat(pets);

        new PetService().saveToFile2(pets);


    }
}
