package pl.coderslab.app.feeding;

import javax.persistence.Entity;

@Entity
public class Bottle extends Feeding {
    private int volume;
    private String milkType;


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
