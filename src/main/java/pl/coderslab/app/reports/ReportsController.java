package pl.coderslab.app.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/reports")

public class ReportsController {

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

    @ModelAttribute("babies")
    public List<Baby> getBabies() {
        return babyService.findAll();
    }


    @ModelAttribute("intList")
    public List<Integer> getintList() {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        intList.add(7);
        return intList;
    }

    public List<Integer> getNumberOfFeedingsLastWeekByBaby(String name) {
        List<Integer> numberOfFeedingsLastWeek = new ArrayList<>();
        for (int i = 6; i >= 0; i--) {
            int finalI = i;
            int numberOfFeedings = (int) feedingService.findAll().stream()
                    .filter(f -> f.getBeginning().toLocalDate().equals(LocalDate.now().minusDays(finalI)))
                    .filter(f -> f.getBaby().getName().equals(name))
                    .count();
            numberOfFeedingsLastWeek.add(numberOfFeedings);
        }
        return numberOfFeedingsLastWeek;
    }

    public List<Integer> getNumberOfNapsLastWeekByBaby(String name) {
        List<Integer> numberOfNapsLastWeek = new ArrayList<>();
        for (int i = 6; i >= 0; i--) {
            int finalI = i;
            int numberOfNaps = (int) napService.findAll().stream()
                    .filter(f -> f.getBeginning().toLocalDate().equals(LocalDate.now().minusDays(finalI)))
                    .filter(f -> f.getBaby().getName().equals(name))
                    .count();
            numberOfNapsLastWeek.add(numberOfNaps);
        }
        return numberOfNapsLastWeek;
    }

    public List<Integer> getNumberOfDiapersLastWeekByBaby(String name) {
        List<Integer> numberOfdiapersLastWeek = new ArrayList<>();
        for (int i = 6; i >= 0; i--) {
            int finalI = i;
            int numberOfdiapers = (int) diaperService.findAll().stream()
                    .filter(f -> f.getBeginning().toLocalDate().equals(LocalDate.now().minusDays(finalI)))
                    .filter(f -> f.getBaby().getName().equals(name))
                    .count();
            numberOfdiapersLastWeek.add(numberOfdiapers);
        }
        return numberOfdiapersLastWeek;
    }


    @GetMapping("feeding")
    public String reportFeedingForm() {
        return "reportFeeding";
    }

    @PostMapping("feeding")
    public String reportFeedingFromForm(@RequestParam String baby, Model model) {
        model.addAttribute("numberOfFeedingsLastWeekByBaby", getNumberOfFeedingsLastWeekByBaby(baby));
        model.addAttribute("babyName", baby);
        return "reportFeeding";
    }

    @GetMapping("nap")
    public String reportNapForm() {
        return "reportNap";
    }

    @PostMapping("nap")
    public String reportNapFromForm(@RequestParam String baby, Model model) {
        model.addAttribute("numberOfNapsLastWeekByBaby", getNumberOfNapsLastWeekByBaby(baby));
        model.addAttribute("babyName", baby);
        return "reportNap";
    }

    @GetMapping("diaper")
    public String reportDiaperForm() {
        return "reportDiaper";
    }

    @PostMapping("diaper")
    public String reportDiaperFromForm(@RequestParam String baby, Model model) {
        model.addAttribute("numberOfdiapersLastWeekByBaby", getNumberOfDiapersLastWeekByBaby(baby));
        model.addAttribute("babyName", baby);
        return "reportDiaper";
    }
}
