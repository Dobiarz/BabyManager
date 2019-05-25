package pl.coderslab.app.feeding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.baby.Baby;
import pl.coderslab.app.baby.BabyRepository;
import pl.coderslab.app.baby.BabyService;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/feeding")
public class FeedingController {

    @Autowired
    FeedingService feedingService;

    @ModelAttribute("feedings")
    public List<Feeding> getFeedings() {
        return feedingService.findAll();
    }

    @RequestMapping("/list")
    public String feeding() {
        return "feeding";
    }

    @GetMapping("leftBreast/add")
    public String addLeftBreast(Model model) {
        model.addAttribute("leftBreast", new LeftBreast());
        return "leftBreast";
    }
}
