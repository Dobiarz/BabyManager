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

}
