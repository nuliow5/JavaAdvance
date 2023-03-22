package eu.codeacademy.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.StringJoiner;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {


    private long id;
    private Category category;
    private String name;
//    @JsonProperty("photoUrls")
    private String[] photoUrls;

    private Tag[] tags;
    private Status status;
//    private String status;

    public Pet() {
    }

    public long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public Tag[] getTags() {
        return tags;
    }
    @JsonValue
    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pet.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("category=" + category)
                .add("name='" + name + "'")
                .add("photoUrls=" + Arrays.toString(photoUrls))
                .add("tags=" + Arrays.toString(tags))
                .add("status=" + status)
                .toString();
    }

    public String toJsonFormat(){
        return "[\n" +
                "     {\n" +
                "     \"id\":" + id + "\n" +
                "";
    }
}
