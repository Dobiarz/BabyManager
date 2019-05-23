package pl.coderslab.app.feeding;

import pl.coderslab.app.baby.Baby;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Feedings")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Feeding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime beginning;

    @ManyToOne
    private Baby baby;


    @PrePersist
    public void prePersist() {
        beginning = LocalDateTime.now();
    }

    public LocalDateTime getBeginning() {
        return beginning;
    }

    public Feeding() {
    }

    public Feeding(LocalDateTime startTime, Baby baby) {
        this.beginning = startTime;
        this.baby = baby;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
