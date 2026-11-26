package kh.edu.istad.restapi.controller;

import kh.edu.istad.restapi.dto.CreateUserRequest;
import kh.edu.istad.restapi.model.User;
import kh.edu.istad.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// @RestController, this annotation is for working with API
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable UUID id) {
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(
            @RequestBody CreateUserRequest createRequest)
    {
       return userService.create( createRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteUser(@PathVariable UUID id) {
        userService.deleteById(id);
        return "User ID: "+ id +" is successfully deleted.";
    }

}
