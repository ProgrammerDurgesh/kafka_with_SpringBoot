package durgeshkafka.service.impl;

import durgeshkafka.entity.User;
import durgeshkafka.repo.UserRepository;
import durgeshkafka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer userId, User user) {
        if (userRepository.existsById(userId)) {
            user.setId(userId);
            return this.createUser(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

}
