package pl.coderslab.app.feeding;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Entity
public class Solid extends Feeding {

    private String[] foods;

    @PrePersist
//    @PreUpdate
    public void prePersist() {
        super.setBeginning(LocalDateTime.now());
    }

    public String[] getFoods() {
        return foods;
    }

    public void setFoods(String[] foods) {
        this.foods = foods;
    }
}
