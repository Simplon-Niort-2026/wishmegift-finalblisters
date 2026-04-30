package co.simplon.wishmegift.service;


import co.simplon.wishmegift.entity.UserEntity;
import co.simplon.wishmegift.errorsHandler.BadRequestException;
import co.simplon.wishmegift.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HasherService hasherService;

    public UserEntity save(UserEntity user) {
        String password = user.getPassword();
        if (RegexService.isValidPassword(password)) {
            String passwordHashed = hasherService.hash(password);
            user.setPassword(passwordHashed);
            return userRepository.save(user);
        } else {
            throw new BadRequestException("Password invalide. Minimum 12 caractères comprenant des majuscules, des minuscules, des chiffres et des caractères spéciaux");
        }

    }

    public UserEntity find(UserEntity user) {
        String userEmail = user.getEmail();
        String userPassword = user.getPassword();
        UserEntity userFound = userRepository.findByEmail(userEmail);

        if (userFound == null) {
            throw new BadRequestException("Email invalide.");
        }

        if (hasherService.isGoodUserPassword(userPassword, userFound.getPassword())) {
            throw  new BadRequestException("Password invalide.");
        }

        return userFound;
    }

    public UserEntity update(UserEntity userReceived) {
        UUID userId = userReceived.getId();
        Optional<UserEntity> userFound = userRepository.findById(userId);

        if (userFound.isEmpty()) {
            throw new BadRequestException("Id invalide.");
        }

        UserEntity userToUpdate = userFound.get();
        String userToUpdateEmail = userToUpdate.getEmail();
        String userReceivedEmail = userReceived.getEmail();
        String userToUpdatePassword = userToUpdate.getPassword();
        String userReceivedPassword = userReceived.getPassword();


        if (userReceivedEmail != null && !userToUpdateEmail.equals(userReceivedEmail)) {
            if (!RegexService.isValidEmail(userReceivedEmail)) {
                throw  new BadRequestException("Email invalide.");
            }

            UserEntity userAlreadyExist =  userRepository.findByEmail(userReceivedEmail);
            if (userAlreadyExist != null) {
                throw  new BadRequestException("Email déjà utilisée.");
            }
            userToUpdate.setEmail(userReceivedEmail);
        }

        if (userReceivedPassword != null ) {
            if(!RegexService.isValidPassword(userReceivedPassword)) {
                throw  new BadRequestException("Password invalide.");
            }

            userToUpdate.setPassword(hasherService.hash(userReceivedPassword));
        }

        return userRepository.save(userToUpdate);
    }

    public void delete(UserEntity user) {
        UUID userId = user.getId();
        Optional<UserEntity> userFound = userRepository.findById(userId);
        if(userFound.isEmpty()) {
            throw new BadRequestException("Id invalide.");
        }
        userRepository.delete(user);
    }
}
