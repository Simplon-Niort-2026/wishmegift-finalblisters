package co.simplon.wishmegift.entity;

import co.simplon.wishmegift.service.HasherService;
import co.simplon.wishmegift.service.RegexService;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="user_id")
    private UUID id;

    @Basic
    @Nonnull
    @Column(nullable = false, unique = true)
    private String email;

    @Basic
    @Nonnull
    @Column(nullable = false)
    private String password;

    @OneToMany
    private List<WishListEntity> whishlists = new ArrayList<>();

    @ManyToMany
    @JoinTable(name="share",
            joinColumns = @JoinColumn(name="users_id"),
            inverseJoinColumns = @JoinColumn(name="wish_list_id")
    )
    private List<WishListEntity> wishlistsShared = new ArrayList<>();

    public UserEntity() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (RegexService.isValidEmail(email)) {
            this.email = email;
        } else {
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

    public void setPassword(String password) throws RuntimeException {
        if (RegexService.isValidPassword(password)) {
            this.password = HasherService.hash(password);
        } else {
            throw new RuntimeException("Password invalide. Minimum 12 caractères comprenant des majuscules, des minuscules, des chiffres et des caractères spéciaux");
        }


    }


}
