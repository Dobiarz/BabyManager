package pl.coderslab.app.feeding;


import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Entity
public class Pump extends Feeding {

    private int volume;
    private String breast;

    @PrePersist
//    @PreUpdate
    public void prePersist() {
        super.setBeginning(LocalDateTime.now());
    }

    public String getBreast() {
        return breast;
    }

    public void setBreast(String breast) {
        this.breast = breast;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
