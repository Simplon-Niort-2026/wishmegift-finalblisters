package co.simplon.wishmegift.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.jspecify.annotations.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "wish_list")
public class WishListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
    private java.sql.Time createdAt;

    @Basic
    @Nonnull
    @Column(name="event_date", nullable = false)
    private java.sql.Time eventDate;

    @Basic
    @Column(name="is_active", columnDefinition = "boolean default true")
    private Boolean active = true;

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

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(java.sql.@NonNull Time eventDate) {
        this.eventDate = eventDate;
    }

    public Boolean isActive() {
        return this.active;
    }

    public void toggleActive() {
        this.active = !this.active;
    }

}
