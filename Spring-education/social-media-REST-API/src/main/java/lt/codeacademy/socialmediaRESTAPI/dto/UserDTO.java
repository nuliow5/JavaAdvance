package lt.codeacademy.socialmediaRESTAPI.dto;

public record UserDTO(
        Long id,
        String nickName,
        String name,
        String surName
) {
}
