package kh.edu.istad.restapi.service;

import kh.edu.istad.restapi.dto.CreateUserRequest;
import kh.edu.istad.restapi.model.User;
import kh.edu.istad.restapi.repository.UserRepository;

import java.util.List;
import java.util.UUID;

public interface UserService {

//    List<User> getAll();
    List<UserRepository> getAll();
    User getById(UUID id);
    User create(CreateUserRequest request);
    void deleteById(UUID id);
}
