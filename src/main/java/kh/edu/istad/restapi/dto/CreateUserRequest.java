package kh.edu.istad.restapi.dto;

public record CreateUserRequest(
        String role,
        String name,
        String username,
        String password
) {
}
