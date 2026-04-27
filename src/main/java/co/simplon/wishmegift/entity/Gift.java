package co.simplon.wishmegift.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Gift")
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT", nullable = true)
    private String description;

    @Column(name = "link", length = 255)
    private String link;

    @Column(name = "desire_level")
    private Integer desire_level;

    @Column(name = "price", columnDefinition = "DECIMAL")
    private Float price;

    @Column(name = "reserved", columnDefinition = "false")
    private Boolean reserved = false;

    @Column(name = "reservedBy", nullable = true)
    private UUID reservedBy;

    public Gift() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

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

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getDesire_level() {
        return desire_level;
    }

    public void setDesire_level(Integer desire_level) {
        if(desire_level < 0 || desire_level > 5) {
            throw new IllegalArgumentException("Desire level must be between 1 and 5");
        }
        this.desire_level = desire_level;
    }

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
}
