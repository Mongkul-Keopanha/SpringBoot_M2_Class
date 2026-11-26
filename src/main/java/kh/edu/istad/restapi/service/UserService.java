package kh.edu.istad.restapi.service;

import kh.edu.istad.restapi.dto.CreateUserRequest;
import kh.edu.istad.restapi.dto.UserResponse;
import kh.edu.istad.restapi.model.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface UserService {

//    List<User> getAll();
    List<UserResponse> getAll();
    UserResponse getById(UUID id);
    Page<UserResponse> getAllUserWithPaging(int pageNumber, int sizeNumber);

    User create(CreateUserRequest request);
    void deleteById(UUID id);

}
