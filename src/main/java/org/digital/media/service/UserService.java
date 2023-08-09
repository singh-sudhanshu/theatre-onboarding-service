package org.digital.media.service;

import org.digital.media.connector.UserRepository;
import org.digital.media.model.entity.User;
import org.digital.media.model.request.UserRequest;
import org.digital.media.model.response.UserResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserResponse save(UserRequest request) {
        User user = User.builder().name(request.name()).contactNumber(request.contactNumber()).creationDate(LocalDateTime.now()).dateOfBirth(request.dateOfBirth()).emailId(request.emailId()).build();
        var savedUser = userRepository.save(user);
        return new UserResponse(savedUser.getUserId(), 201, "Success");
    }
}
