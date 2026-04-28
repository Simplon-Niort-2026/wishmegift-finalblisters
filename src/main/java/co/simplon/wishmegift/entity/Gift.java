package co.simplon.wishmegift.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "gift")
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", length = 50, nullable = false)
    @Nonnull
    private String name;

    @Column(name = "description", columnDefinition = "TEXT", nullable = true)
    private String description;

    @Column(name = "link", length = 255,nullable = false)
    @Nonnull
    private String link;

    @Column(name = "desire_level", nullable = false)
    @Nonnull
    private Integer desire_level;

    @Column(name = "price", columnDefinition = "DECIMAL", nullable = false)
    @Nonnull
    private Float price;

    @Column(name = "reserved", columnDefinition = "false")
    private Boolean reserved = false;

    @Column(name = "reservedBy", nullable = true)
    private UUID reservedBy;

    @Column
    @Nonnull
    @CreatedDate
    private LocalDateTime createdAt;

    @Column
    @Nonnull
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Gift() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Nonnull
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    @Nonnull
    public void setLink(String link) {
        this.link = link;
    }

    public Integer getDesire_level() {
        return desire_level;
    }

    @Nonnull
    public void setDesire_level(Integer desire_level) {
        if(desire_level < 0 || desire_level > 5) {
            throw new IllegalArgumentException("Desire level must be between 1 and 5");
        }
        this.desire_level = desire_level;
    }

    @Nonnull
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public UUID getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(UUID reservedBy) {
        this.reservedBy = reservedBy;
    }

    @Nonnull
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Nonnull
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
