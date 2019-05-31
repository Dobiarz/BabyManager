package pl.coderslab.app.reports;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    @RequestMapping("")
    public String reports() {
        return "reports";
    }
}
