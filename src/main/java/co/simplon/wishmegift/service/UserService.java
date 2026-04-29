package co.simplon.wishmegift.service;


import co.simplon.wishmegift.entity.UserEntity;
import co.simplon.wishmegift.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }
}
