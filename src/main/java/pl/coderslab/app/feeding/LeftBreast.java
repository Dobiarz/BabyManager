package pl.coderslab.app.feeding;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.app.baby.Baby;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
public class LeftBreast extends Feeding {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime end;

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }


}
