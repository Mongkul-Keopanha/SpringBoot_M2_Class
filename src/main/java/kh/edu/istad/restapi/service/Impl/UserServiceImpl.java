package kh.edu.istad.restapi.service.Impl;

import kh.edu.istad.restapi.dto.CreateUserRequest;
import kh.edu.istad.restapi.dto.UserResponse;
import kh.edu.istad.restapi.mapper.UserMapper;
import kh.edu.istad.restapi.model.User;
import kh.edu.istad.restapi.repository.UserRepository;
import kh.edu.istad.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::mapUserToUserResponse)
                .toList();
    }

    @Override
    public User getById(UUID id) {
        return userRepository.findById(id).orElseThrow(null);
    }

    @Override
    public User create(CreateUserRequest request) {
        User user = new User();
        user.setName(request.name());
        user.setUsername(request.username());
        user.setPassword(request.password());
        return null;
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
}
