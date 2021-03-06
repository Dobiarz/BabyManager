package pl.coderslab.app.feeding;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Max;
import java.time.LocalDateTime;

@Entity
public class Bottle extends Feeding {
    private int volume;
    private String milkType;

    @PrePersist
    public void prePersist() {
        super.setBeginning(LocalDateTime.now());
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getMilkType() {
        return milkType;
    }

    public void setMilkType(String milkType) {
        this.milkType = milkType;
    }
}
