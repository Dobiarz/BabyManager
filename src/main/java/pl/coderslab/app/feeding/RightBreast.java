package pl.coderslab.app.feeding;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class RightBreast extends Feeding {

    private LocalDateTime end;

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
