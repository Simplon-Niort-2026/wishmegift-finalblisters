package co.simplon.wishmegift.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "list")
public class List {

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
    @Column(name="date", nullable = false)
    private java.sql.Time CreatedAt;

    @Basic
    @Nonnull
    @Column(name="event_date", nullable = false)
    private java.sql.Time EventDate;

    @Basic
    @Column(name="is_active", columnDefinition = "boolean default true")
    private Boolean active;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return this.CreatedAt;
    }

    public Date getEventDate() {
        return this.EventDate;
    }

    public void setEventDate(java.sql.Time eventDate) {
        this.EventDate = eventDate;
    }

    public Boolean isActive() {
        return this.active;
    }

    public void toggleActive() {
        this.active = !this.active;
    }

}
