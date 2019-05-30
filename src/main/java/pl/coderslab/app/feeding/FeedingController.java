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
import java.util.ArrayList;
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

    @ModelAttribute("milkTypes")
    public List<String> getMilkTypes() {
        List<String> milktypes = new ArrayList<>();
        milktypes.add("Formula");
        milktypes.add("Breast");
        return milktypes;
    }

    @ModelAttribute("breasts")
    public List<String> getBreasts() {
        List<String> breasts = new ArrayList<>();
        breasts.add("Right");
        breasts.add("Left");
        return breasts;
    }

    @ModelAttribute("solidFoods")
    public List<String> getSolidFoods() {
        List<String> solidFoods = new ArrayList<>();
        solidFoods.add("Jar");
        solidFoods.add("Cereal");
        solidFoods.add("Veg");
        solidFoods.add("Fruits");
        solidFoods.add("Juice");
        solidFoods.add("Dairy");
        solidFoods.add("Carbohydrates");
        solidFoods.add("Meat");
        return solidFoods;
    }

    @RequestMapping("/list")
    public String feeding() {
        return "feeding";
    }

    @GetMapping("leftBreast/add")
    public String addLeftBreastForm(Model model) {
        model.addAttribute("leftBreast", new LeftBreast());
        return "leftBreast";
    }

    @PostMapping("leftBreast/add")
    public String addLeftBreastFromForm(@Valid LeftBreast leftBreast, BindingResult bindingResult) {
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
    public String updateLeftBreastFromForm(@ModelAttribute @Valid LeftBreast leftBreast, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "leftBreast";
        }
        feedingService.update(leftBreast);
        return "redirect:../../list";
    }

    @GetMapping("rightBreast/add")
    public String addRightBreastForm(Model model) {
        model.addAttribute("rightBreast", new RightBreast());
        return "rightBreast";
    }

    @PostMapping("rightBreast/add")
    public String addRightBreastFromForm(@Valid RightBreast rightBreast, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "rightBreast";
        } else {
            feedingService.create(rightBreast);
            return "redirect:/feeding/list";
        }
    }

    @GetMapping("RightBreast/update/{id}")
    public String updateRightBreastForm(@PathVariable Long id, Model model) {
        RightBreast rightBreast = (RightBreast) feedingService.read(id);
        model.addAttribute("rightBreast", rightBreast);
        return "rightBreast";
    }

    @PostMapping("RightBreast/update/{id}")
    public String updateRightBreastFromForm(@ModelAttribute @Valid RightBreast rightBreast, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "rightBreast";
        }
        feedingService.update(rightBreast);
        return "redirect:../../list";
    }

    @GetMapping("bottle/add")
    public String addBottleForm(Model model) {
        model.addAttribute("bottle", new Bottle());
        return "bottle";
    }

    @PostMapping("bottle/add")
    public String addBottleFromForm(@Valid Bottle bottle, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "bottle";
        } else {
            feedingService.create(bottle);
            return "redirect:/feeding/list";
        }
    }

    @GetMapping("Bottle/update/{id}")
    public String updateBottleForm(@PathVariable Long id, Model model) {
        Bottle bottle = (Bottle) feedingService.read(id);
        model.addAttribute("bottle", bottle);
        return "bottle";
    }

    @PostMapping("Bottle/update/{id}")
    public String updateBottleFromForm(@ModelAttribute @Valid Bottle bottle, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "bottle";
        }
        feedingService.update(bottle);
        return "redirect:../../list";
    }

    @GetMapping("pump/add")
    public String addPumpForm(Model model) {
        model.addAttribute("pump", new Pump());
        return "pump";
    }

    @PostMapping("pump/add")
    public String addPumpFromForm(@Valid Pump pump, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pump";
        } else {
            feedingService.create(pump);
            return "redirect:/feeding/list";
        }
    }

    @GetMapping("Pump/update/{id}")
    public String updatePumpForm(@PathVariable Long id, Model model) {
        Pump pump = (Pump) feedingService.read(id);
        model.addAttribute("pump", pump);
        return "pump";
    }

    @PostMapping("Pump/update/{id}")
    public String updatePumpFromForm(@ModelAttribute @Valid Pump pump, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pump";
        }
        feedingService.update(pump);
        return "redirect:../../list";
    }

    @GetMapping("solid/add")
    public String addSolidForm(Model model) {
        model.addAttribute("solid", new Solid());
        return "solid";
    }

    @PostMapping("solid/add")
    public String addSolidFromForm(@Valid Solid solid, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "solid";
        } else {
            feedingService.create(solid);
            return "redirect:/feeding/list";
        }
    }

    @GetMapping("Solid/update/{id}")
    public String updateSolidForm(@PathVariable Long id, Model model) {
        Solid solid = (Solid) feedingService.read(id);
        model.addAttribute("solid", solid);
        return "solid";
    }

    @PostMapping("Solid/update/{id}")
    public String updateSolidFromForm(@ModelAttribute @Valid Solid solid, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "solid";
        }
        feedingService.update(solid);
        return "redirect:../../list";
    }

    @GetMapping("delete/{id}")
    public String deleteFeeding(@PathVariable Long id) {
        feedingService.delete(id);
        return "redirect:../list";
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
