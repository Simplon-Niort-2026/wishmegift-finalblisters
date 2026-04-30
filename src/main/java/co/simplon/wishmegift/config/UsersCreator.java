package co.simplon.wishmegift.config;

import co.simplon.wishmegift.entity.UserEntity;
import co.simplon.wishmegift.repository.UserRepository;
import co.simplon.wishmegift.service.HasherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UsersCreator implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HasherService hesherService;

    @Override
    public void run(String... args) throws Exception {

        List<UserEntity> users = userRepository.findAll();
        if (users.isEmpty()) {
            UserEntity user1 = new UserEntity();
            user1.setEmail("christophe@gmail.com");
            user1.setPassword(hesherService.hash("CHpassword@1"));
            UserEntity user1Created = userRepository.save(user1);
            System.out.println();
            System.out.println();
            System.out.println("**********    USER 1    **********");
            System.out.println("ID => " + user1Created.getId());
            System.out.println("EMAIL => " + user1Created.getEmail());
            System.out.println("PASSWORD => " + "CHpassword@1");
            System.out.println("PASSWORD HASHED => " + user1Created.getPassword());

            UserEntity user2 = new UserEntity();
            user2.setEmail("rodolphe@gmail.com");
            user2.setPassword(hesherService.hash("ROpassword@1"));
            UserEntity user2Created = userRepository.save(user2);
            System.out.println();
            System.out.println();
            System.out.println("**********    USER 2    **********");
            System.out.println("ID => " + user2Created.getId());
            System.out.println("EMAIL => " + user2Created.getEmail());
            System.out.println("PASSWORD => " + "ROpassword@1");
            System.out.println("PASSWORD HASHED => " + user2Created.getPassword());

            UserEntity user3 = new UserEntity();
            user3.setEmail("pierre@gmail.com");
            user3.setPassword(hesherService.hash("PIpassword@1"));
            UserEntity user3Created = userRepository.save(user3);
            System.out.println();
            System.out.println();
            System.out.println("**********    USER 3    **********");
            System.out.println("ID => " + user3Created.getId());
            System.out.println("EMAIL => " + user3Created.getEmail());
            System.out.println("PASSWORD => " + "PIpassword@1");
            System.out.println("PASSWORD HASHED => " + user3Created.getPassword());
        }

    }
}
