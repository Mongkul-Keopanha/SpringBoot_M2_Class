package kh.edu.istad.restapi.init;

import jakarta.annotation.PostConstruct;
import kh.edu.istad.restapi.model.User;
import kh.edu.istad.restapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserInitialization {
    private final UserRepository userRepository;

    @PostConstruct
    void init(){
        log.info("Initializing user data...");

        // 1. Create entity object
        User user1 = new User();
        user1.setName("Sanford");
        user1.setUsername("@alex.sanford11");
        user1.setRole("Software Developer");
        user1.setPassword("!@#5678");
        user1.setActive(true);

        User user2 = new User();
        user2.setName("Panha");
        user2.setUsername("@keo11panha");
        user2.setRole("Administrator");
        user2.setPassword("!@#Nha123");
        user2.setActive(true);

        User user3 = new User();
        user3.setName("Phearak");
        user3.setUsername("@rakzz");
        user3.setRole("Customer");
        user3.setPassword("1234rakzz");
        user3.setActive(true);

        // 2. Start saving user in database
        if (userRepository.count() == 0) {
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
        }

    }
}
