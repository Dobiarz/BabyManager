package pl.coderslab.app.nap;

import pl.coderslab.app.baby.Baby;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Naps")
public class Nap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Baby baby;

    private LocalDateTime beginning;

    private LocalDateTime end;

    @PrePersist
    public void prePersist() {
        beginning = LocalDateTime.now();
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
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
}
