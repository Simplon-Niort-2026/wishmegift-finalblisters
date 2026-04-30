package co.simplon.wishmegift.service;


import co.simplon.wishmegift.entity.UserEntity;
import co.simplon.wishmegift.errorsHandler.BadRequestException;
import co.simplon.wishmegift.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity save(UserEntity user) {
        String password = user.getPassword();
        if (RegexService.isValidPassword(password)) {
            String passwordHashed = HasherService.hash(password);
            user.setPassword(passwordHashed);
            return userRepository.save(user);
        } else {
            throw new RuntimeException("Password invalide. Minimum 12 caractères comprenant des majuscules, des minuscules, des chiffres et des caractères spéciaux");
        }

    }

    public UserEntity find(UserEntity user) {
        String userEmail = user.getEmail();
        String userPassword = user.getPassword();
        UserEntity userFound = userRepository.findByEmail(userEmail);

        if (userFound == null) {
            throw new BadRequestException("Email invalide.");
        }

        if (!HasherService.isGoodPassword(userPassword, userFound.getPassword())) {
            throw  new BadRequestException("Password invalide.");
        }

        return userFound;
    }
}
