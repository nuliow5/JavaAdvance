package lt.codeacademy.socialmediaRESTAPI.dto;

public record PostDTO(
        Long id,
        Long authorId,
        String title,
        String message
) {


}
