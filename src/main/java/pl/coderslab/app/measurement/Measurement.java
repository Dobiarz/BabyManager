package pl.coderslab.app.measurement;

import pl.coderslab.app.baby.Baby;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name="Measurements")
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime beginning;

    @ManyToOne
    private Baby baby;

    private Double weight;
    private int height;
    private int headCircumference;


    @PrePersist
    @PreUpdate
    public void prePersist() {
        beginning = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getBeginning() {
        return beginning;
    }

    public void setBeginning(LocalDateTime beginning) {
        this.beginning = beginning;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public int getHeadCircumference() {
        return headCircumference;
    }

    public void setHeadCircumference(int headCircumference) {
        this.headCircumference = headCircumference;
    }
}
