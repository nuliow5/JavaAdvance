package eu.codeacademy;

import eu.codeacademy.service.JsonExampleService;
import java.io.IOException;
import java.net.URISyntaxException;


public class App {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        JsonExampleService jsonExampleService = new JsonExampleService();

        jsonExampleService.basicSerializeAndDeserializeExample();
        jsonExampleService.basicDeserializationFromResources();
        jsonExampleService.basicCompositionExample();
        jsonExampleService.missingClassVariableByJsonProperty();
        jsonExampleService.compositionWithEnumTypeExample();

    }
}
