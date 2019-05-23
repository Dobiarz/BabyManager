package pl.coderslab.app.feeding;


import javax.persistence.Entity;

@Entity
public class Pump extends Feeding {
    private int volume;

    private String breast;

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
