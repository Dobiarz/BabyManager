package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.baby.Baby;
import pl.coderslab.app.baby.BabyRepository;
import pl.coderslab.app.baby.BabyService;
import pl.coderslab.app.diaper.Diaper;
import pl.coderslab.app.diaper.DiaperService;
import pl.coderslab.app.feeding.*;
import pl.coderslab.app.nap.Nap;
import pl.coderslab.app.nap.NapService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    BabyRepository babyRepository;

    @Autowired
    BabyService babyService;

    @Autowired
    FeedingRepository feedingRepository;

    @Autowired
    FeedingService feedingService;

    @Autowired
    NapService napService;

    @Autowired
    DiaperService diaperService;

    @ModelAttribute("feedings")
    public List<Feeding> getFeedings() {
        return feedingService.findAll();
    }

    @ModelAttribute("todayFeedings")
    public List<Feeding> getTodayFeedings() {
        return feedingService.findAll().stream()
                .filter(f -> f.getBeginning().toLocalDate().equals(LocalDate.now()))
                .sorted((o1, o2) -> o1.getBeginning().compareTo(o2.getBeginning()))
                .collect(Collectors.toList());
    }

    @ModelAttribute("todayNaps")
    public List<Nap> getTodayNaps() {
        return napService.findAll().stream()
                .filter(f -> f.getBeginning().toLocalDate().equals(LocalDate.now()))
                .sorted((o1, o2) -> o1.getBeginning().compareTo(o2.getBeginning()))
                .collect(Collectors.toList());
    }

    @ModelAttribute("todayDiapers")
    public List<Diaper> getTodayDiapers() {
        return diaperService.findAll().stream()
                .filter(f -> f.getBeginning().toLocalDate().equals(LocalDate.now()))
                .sorted((o1, o2) -> o1.getBeginning().compareTo(o2.getBeginning()))
                .collect(Collectors.toList());
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }

//    @RequestMapping("/reports")
//    public String reports() {
//        return "reports";
//    }

    @RequestMapping("/addTest")
    @ResponseBody
    public String test() {
        Baby baby = new Baby();
        baby.setName("Ola");
        baby.setHeight(58);
        baby.setWeight(3.660);
        baby.setBirthDate(LocalDate.now());

        babyService.create(baby);

        Bottle bottle = new Bottle();
        bottle.setBaby(baby);
        bottle.setVolume(50);
        bottle.setMilkType("momy");

        feedingService.create(bottle);

        Solid meal = new Solid();
        String[] m = new String[]{"kaszka", "słoiczek"};
        meal.setFoods(m);

        feedingRepository.save(meal);

//        Long id = 2L;
//
//        Feeding meal1 = feedingService.read(id);

        Nap nap = new Nap();
        String now = "2016-11-09 10:30:52";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
// formater definiuje jaka skłądnie/wygląd ma miec string , którego będzie przerabiał
        LocalDateTime formatDateTime = LocalDateTime.parse(now, formatter);
        nap.setEnd(formatDateTime);
        nap.setBaby(baby);

        napService.create(nap);

        Diaper diaper = new Diaper();
        diaper.setContent(new String[]{"pee", "poo"});
        diaper.setBaby(baby);

        diaperService.create(diaper);

        LeftBreast leftBreast = new LeftBreast();
        leftBreast.setEnd(formatDateTime);

        feedingService.create(leftBreast);

        RightBreast rightBreast = new RightBreast();
        rightBreast.setEnd(formatDateTime);

        feedingService.create(rightBreast);

        Pump pump = new Pump();
        pump.setBreast("Right");
        pump.setVolume(90);

        feedingService.create(pump);

        Baby uniquebaby = babyRepository.findFirstByName("Ada");
        return "Dodano  "
                + baby.getName() + " "
                + bottle.getMilkType() + " "
                + Arrays.toString(meal.getFoods()) + " "
                + "Znaleziono:" + uniquebaby.getName()
//                + Arrays.toString(((Solid) meal1).getFoods())
                ;
    }

    @RequestMapping("/uniqueTest")
    @ResponseBody
    public String uniquetest() {
        Baby uniquebaby = babyRepository.findFirstByName("Ada");
        boolean isNameAlreadyInUse = babyService.isNameAlreadyInUse("Ada");
        return "Znaleziono Baby:" + uniquebaby + "\n"
                + "IsNamealreadyInUse: " + isNameAlreadyInUse;
    }
}
