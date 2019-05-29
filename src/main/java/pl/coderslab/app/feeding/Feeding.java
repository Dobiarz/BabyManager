package pl.coderslab.app.feeding;

import org.springframework.format.annotation.DateTimeFormat;
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

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime beginning;

    @ManyToOne
    private Baby baby;

//    @Column(name="DTYPE", insertable = false, updatable = false)
//    private String DTYPE;
//
//    public String getDTYPE() {
//        return DTYPE;
//    }

//    @Column(name="milkType", insertable = false, updatable = false)
//    private String milkType;
//
//    public String getMilkType() {
//        return milkType;
//    }

//    @Transient
//    public String getDecriminatorValue() {
//        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
//    }


//    @PrePersist
//    public void prePersist() {
//        beginning = LocalDateTime.now();
//    }

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
