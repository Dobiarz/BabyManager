package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.baby.Baby;
import pl.coderslab.app.baby.BabyRepository;
import pl.coderslab.app.feeding.Bottle;
import pl.coderslab.app.feeding.Feeding;
import pl.coderslab.app.feeding.FeedingRepository;
import pl.coderslab.app.feeding.Solid;

import java.time.LocalDate;
import java.util.Arrays;

@Controller
public class HomeController {

    @Autowired
    BabyRepository babyRepository;

    @Autowired
    FeedingRepository feedingRepository;

    @RequestMapping("/addBabyTest")
    @ResponseBody
    public String test(){
        Baby baby = new Baby();
        baby.setName("Ola");
        baby.setHeight(58);
        baby.setWeight(3660);
        baby.setBirthday(LocalDate.now());

        babyRepository.save(baby);

        Bottle bottle = new Bottle();
        bottle.setBaby(baby);
        bottle.setVolume(50);
        bottle.setMilkType("momy");

        feedingRepository.save(bottle);

        Solid meal = new Solid();
        String[] m = new String[]{"kaszka", "słoiczek"};
        meal.setFoods(m);

        feedingRepository.save(meal);
        Feeding meal1= feedingRepository.findById(2);


        return "Dodano  " + baby.getName() + " " + bottle.getMilkType() + " "
                + Arrays.toString(meal.getFoods()) +" "+ Arrays.toString(((Solid) meal1).getFoods());
    }


    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
