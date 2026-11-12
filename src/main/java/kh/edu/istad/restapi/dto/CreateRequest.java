package kh.edu.istad.restapi.dto;

public record CreateRequest(
        String role,
        String username,
        String password
) {
}
