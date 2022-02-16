package com.example.demo.services;

import com.example.demo.models.user.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if( userOptional.isPresent()){
            throw new IllegalStateException("email taken");
        } else {
            userRepository.save(user);
        }
    }

    public void deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            throw new IllegalStateException("user with id " + userId + " does not exists");
        }
    }

    @Transactional
    public void updateUser(Long userId, String username, String email) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("user with id " + userId + " does not exists")
        );

        if (username!= null && username.length() > 0 && !Objects.equals(user.getUsername(),username)) {
            user.setUsername(username);
        }

        if (email!= null && email.length() > 0 && !Objects.equals(user.getEmail(),email)) {
            user.setEmail(email);
        }
    }
}
