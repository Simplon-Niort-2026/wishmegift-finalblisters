package co.simplon.wishmegift.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "gift")
public class GiftEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="gift_id")
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

    @Column(name = "reserved", columnDefinition = " Boolean default false")
    private Boolean reserved = false;

    @Column
    @Nonnull
    @CreatedDate
    private LocalDateTime createdAt;

    @Column
    @Nonnull
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @OneToOne
    private WishListEntity wishList;

    @ManyToOne
    private UserEntity userWhoHaveReserved ;

    public GiftEntity() {
    }

    public GiftEntity(@Nonnull Integer desire_level, @Nonnull String link, @Nonnull String name, @Nonnull Float price) {
        this.desire_level = desire_level;
        this.link = link;
        this.name = name;
        this.price = price;
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

    @Override
    public String toString() {
        return "GiftEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", desire_level=" + desire_level +
                ", price=" + price +
                ", reserved=" + reserved +
                ", userWhoHaveReserved=" + userWhoHaveReserved +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
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

    public UserEntity getUserWhoHaveReserved() {
        return userWhoHaveReserved;
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
