package co.simplon.wishmegift.entity;

import co.simplon.wishmegift.service.HasherService;
import co.simplon.wishmegift.service.RegexService;
import jakarta.persistence.*;
import org.jspecify.annotations.NonNull;

import java.util.UUID;


@Entity
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Basic
    @NonNull
    @Column(unique=true)
    private String email;

    @Basic
    @NonNull
    private String password;

    public UserEntity() {}


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(RegexService.isValidEmail(email)) {
            this.email = email;
        }else{
            throw new RuntimeException("Email invalide.");
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(RegexService.isValidPassword(password)) {
            this.password = HasherService.hash(password);
        }else{
            throw new RuntimeException("Password invalide. Minimum 12 caractères comprenant des majuscules, des minuscules, des chiffres et des caractères spéciaux");
        }


    }


}
