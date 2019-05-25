package pl.coderslab.app.diaper;

import pl.coderslab.app.baby.Baby;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Diaper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime beginning;

    private String[] content;

    @ManyToOne
    private Baby baby;

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

    public String[] getContent() {
        return content;
    }

    public void setContent(String[] content) {
        this.content = content;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }
}
