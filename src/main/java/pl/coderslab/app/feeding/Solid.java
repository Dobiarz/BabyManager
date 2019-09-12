package pl.coderslab.app.feeding;

import com.fasterxml.jackson.annotation.JsonValue;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Entity
public class Solid extends Feeding {
    @NotEmpty
    private String[] foods;

    @PrePersist
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
