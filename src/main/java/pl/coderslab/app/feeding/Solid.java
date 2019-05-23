package pl.coderslab.app.feeding;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Solid extends Feeding {

    private String[] foods;

    public String[] getFoods() {
        return foods;
    }

    public void setFoods(String[] foods) {
        this.foods = foods;
    }
}
