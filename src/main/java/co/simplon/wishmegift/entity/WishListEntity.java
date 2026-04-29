package co.simplon.wishmegift.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.jspecify.annotations.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "wish_list")
public class WishListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="wish_list_id")
    private UUID id;

    @Basic
    @Nonnull
    @Column(name="name", length = 50, nullable = false)
    private String name;

    @Basic
    @Nonnull
    @Column(name="theme", nullable = false)
    @Enumerated(EnumType.STRING)
    private Theme theme;

    @Basic
    @Column(name="description", columnDefinition = "text", nullable = true)
    private String description;

    @Basic
    @Nonnull
    @CreatedDate
    @Column(name="date", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Basic
    @Nonnull
    @JsonProperty("event_date")
    @Column(name="event_date", nullable = false)
    private LocalDate eventDate;

    @Basic
    @Column(name="is_active", columnDefinition = "boolean default true")
    private Boolean active = true;

    @OneToMany
    private List<GiftEntity> gifts = new ArrayList<>();

    @ManyToMany(mappedBy="wishlistsShared")
    private List<UserEntity> users = new ArrayList<>();
    
    @ManyToOne
    private UserEntity user;

    public WishListEntity() {}

    public UUID getId() {
        return id;
    }

    public @NonNull String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public @NonNull Theme getTheme() {
        return theme;
    }

    public void setTheme(@NonNull Theme theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDate getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public Boolean isActive() {
        return this.active;
    }

    public void toggleActive() {
        this.active = !this.active;
    }

    public List<GiftEntity> getGifts() {
        return gifts;
    }

    public void setGifts(List<GiftEntity> gifts) {
        this.gifts = gifts;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
