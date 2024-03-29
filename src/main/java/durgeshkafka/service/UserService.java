package durgeshkafka.service;

import durgeshkafka.entity.User;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Integer userId);

    User createUser(User user);

    User updateUser(Integer userId, User user);

    void deleteUser(Integer userId);

}