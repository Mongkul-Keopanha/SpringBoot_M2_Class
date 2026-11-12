package kh.edu.istad.restapi.repository;

import kh.edu.istad.restapi.dto.CreateRequest;
import kh.edu.istad.restapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {
    private List<User> users;

    public UserRepository() {
        users = new ArrayList<User>();
        User userAdmin = new User(UUID.randomUUID(), "Alexander Sanford", "!@#12345", "Administrator", true);
        User userCustomer = new User(UUID.randomUUID(), "Bin Soksambath", "$82!@#51", "Customer", false);
        User userEditor = new User(UUID.randomUUID(), "Touch Phearak", "!5u@rak4!", "Editor", true);

        users.add(userAdmin);
        users.add(userCustomer);
        users.add(userEditor);
    }

    public List<User> selectAll() {
        return users;
    }

    public Optional<User> selectById(UUID id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

//    public void insert(User user) {
//        users.add(user);
//    }

    public User createNew(CreateRequest createRequest) {
        User newUser = new User();
        newUser.setId(UUID.randomUUID());
        newUser.setRole(createRequest.role());
        newUser.setUsername(createRequest.username());
        newUser.setPassword(createRequest.password());
        newUser.setActive(true);

        users.add(newUser);

        return newUser;
    }

    public void deleteById(UUID id) {
        users.removeIf(user -> user.getId().equals(id));
    }

}
