package co.simplon.wishmegift.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "list")
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Basic
    @Column(name="name", length = 50)
    private String name;

    @Basic
    @Column(name="theme")
    @Enumerated(EnumType.STRING)
    private Theme theme;

    @Basic
    @Column(name="description", columnDefinition = "text")
    private String description;

    @Basic
    @Column(name="date")
    private java.sql.Time CreatedAt;

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

    public Boolean isActive() {
        return this.active;
    }

    public void toggleActive() {
        this.active = !this.active;
    }

}
