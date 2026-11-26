package kh.edu.istad.restapi.dto;

public record UserResponse(
        int id,
        String name,
        String email,
        String role
) {}
