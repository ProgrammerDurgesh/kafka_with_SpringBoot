package durgeshkafka.controller;

import durgeshkafka.configuration.SecurityConfig;
import durgeshkafka.configuration.kafka.Producers;
import durgeshkafka.entity.User;
import durgeshkafka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final Producers producers;
    private final UserService userService;
    private SecurityConfig securityConfig;

    @Autowired
    public UserController(Producers producers, SecurityConfig securityConfig, UserService userService) {
        this.producers = producers;
        this.securityConfig = securityConfig;
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        User userSaved = userService.createUser(user);
        if (!ObjectUtils.isEmpty(userSaved)) {
            producers.sendMessage("", "Welcome To Kafka Project", "user created");
        }
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Integer userId, @RequestBody User user) {
        User user1 = userService.updateUser(userId, user);
        if (!ObjectUtils.isEmpty(user1)) {
            producers.sendMessage("", "Welcome To Kafka Project", "user updated");
        }
        return user1;
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        User user = userService.getUserById(userId);
        if (ObjectUtils.isEmpty(user)) {
            producers.sendMessage("", "Welcome To Kafka Project", "user deleted");
        }
    }
}
