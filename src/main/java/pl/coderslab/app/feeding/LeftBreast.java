package pl.coderslab.app.feeding;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.app.baby.Baby;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
public class LeftBreast extends Feeding {

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
//    @Pattern(regexp = "[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) (2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime end;

//    @PrePersist
//    public void prePersist() {
//        end = LocalDateTime.now();
//    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }


}
