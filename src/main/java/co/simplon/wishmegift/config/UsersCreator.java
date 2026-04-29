package co.simplon.wishmegift.config;

import co.simplon.wishmegift.entity.UserEntity;
import co.simplon.wishmegift.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UsersCreator implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        List<UserEntity> users = userRepository.findAll();
        if (users.isEmpty()) {
            UserEntity user1 = new UserEntity();
            user1.setEmail("christophe@gmail.com");
            user1.setPassword("CHpassword@1");
            UserEntity user1Created = userRepository.save(user1);
            System.out.println();
            System.out.println();
            System.out.println("**********    USER 1    **********");
            System.out.println("ID => " + user1Created.getId());
            System.out.println("EMAIL => " + user1Created.getEmail());
            System.out.println("PASSWORD => " + user1Created.getPassword());

            UserEntity user2 = new UserEntity();
            user2.setEmail("rodolphe@gmail.com");
            user2.setPassword("ROpassword@1");
            UserEntity user2Created = userRepository.save(user2);
            System.out.println();
            System.out.println();
            System.out.println("**********    USER 2    **********");
            System.out.println("ID => " + user2Created.getId());
            System.out.println("EMAIL => " + user2Created.getEmail());
            System.out.println("PASSWORD => " + user2Created.getPassword());

            UserEntity user3 = new UserEntity();
            user3.setEmail("pierre@gmail.com");
            user3.setPassword("PIpassword@1");
            UserEntity user3Created = userRepository.save(user3);
            System.out.println();
            System.out.println();
            System.out.println("**********    USER 3    **********");
            System.out.println("ID => " + user3Created.getId());
            System.out.println("EMAIL => " + user3Created.getEmail());
            System.out.println("PASSWORD => " + user3Created.getPassword());
        }

    }
}
