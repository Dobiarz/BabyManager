package pl.coderslab.app.measurement;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.app.baby.Baby;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "Measurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginning;

    @NotNull(message = "May not be null. Add Baby first")
    @ManyToOne
    private Baby baby;

    private Double weight;
    private int height;
    private int headCircumference;

    @PrePersist
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
