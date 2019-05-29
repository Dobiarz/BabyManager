package pl.coderslab.app.feeding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.baby.Baby;
import pl.coderslab.app.baby.BabyRepository;
import pl.coderslab.app.baby.BabyService;

import javax.validation.Valid;
import java.awt.print.Book;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/feeding")
public class FeedingController {

    @Autowired
    FeedingService feedingService;

    @Autowired
    BabyService babyService;

    @ModelAttribute("feedings")
    public List<Feeding> getFeedings() {
        return feedingService.findAll();
    }

    @ModelAttribute("babies")
    public List<Baby> getBabies() {
        return babyService.findAll();
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

    @PostMapping("leftBreast/add")
    public String addLeftBreastFromform(@Valid LeftBreast leftBreast, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "leftBreast";
        } else {
            feedingService.create(leftBreast);
            return "redirect:/feeding/list";
        }
    }

    @GetMapping("LeftBreast/update/{id}")
    public String updateLeftBreastForm(@PathVariable Long id, Model model) {

        LeftBreast leftBreast = (LeftBreast) feedingService.read(id);
        model.addAttribute("leftBreast", leftBreast);

        return "leftBreast";

    }

    @PostMapping("LeftBreast/update/{id}")
    public String updateLeftBreastfromForm(@ModelAttribute @Valid LeftBreast leftBreast, BindingResult result) {

        if (result.hasErrors()) {
            return "leftBreast";
        }

        feedingService.update(leftBreast);

        return "redirect:../../list";
    }


//    @GetMapping("/update/{id}")
//    public String updateFeedingForm(@PathVariable Long id, Model model) {
//
//        Feeding feeding = feedingService.read(id);
//
//        String view = null;
//        switch (feeding.getClass().getSimpleName()) {
//            case "Bottle":
//                view = "bottle";
//                break;
//            case "LeftBreast":
//                LeftBreast leftBreast = (LeftBreast) feeding;
//                model.addAttribute("leftBreast", leftBreast);
//                view = "leftBreast";
//                break;
//            case "Pump":
//                view = "pump";
//                break;
//            case "RightBreast":
//                view = "rightBreast";
//                break;
//            case "Solid":
//                view = "solid";
//                break;
//
//        }
//        return view;
//
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateFeedingfromForm(@ModelAttribute @Valid LeftBreast leftBreast, BindingResult result) {
//        if (result.hasErrors()) {
//            String view = null;
//            switch (leftBreast.getClass().getSimpleName()) {
//                case "Bottle":
//                    view = "bottle";
//                    break;
//                case "LeftBreast":
//                    view = "leftBreast";
//                    break;
//                case "Pump":
//                    view = "pump";
//                    break;
//                case "RightBreast":
//                    view = "rightBreast";
//                    break;
//                case "Solid":
//                    view = "solid";
//                    break;
//
//            }
//            return view;
//        }
//        feedingService.update(leftBreast);
//        return "redirect:../list";
//    }
}
