package pl.coderslab.app.diaper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.baby.Baby;
import pl.coderslab.app.baby.BabyService;
import pl.coderslab.app.measurement.Measurement;
import pl.coderslab.app.nap.Nap;
import pl.coderslab.app.nap.NapService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/diaper")
public class DiaperController {

    @Autowired
    DiaperService diaperService;

    @Autowired
    BabyService babyService;

    @ModelAttribute("diapers")
    public List<Diaper> getDiapers(){return diaperService.findAll();}

    @ModelAttribute("content")
    public List<String> getContent() {
        List<String> content = new ArrayList<>();
        content.add("Pee");
        content.add("Poo");
        return content;
    }

    @ModelAttribute("babies")
    public List<Baby> getBabies() {
        return babyService.findAll();
    }

    @RequestMapping("/list")
    public String diaper() {
        return "diaper";
    }

    @GetMapping("add")
    public String addDiaperForm(Model model) {
        model.addAttribute("diaper", new Diaper());
        return "addDiaper";
    }

    @PostMapping("add")
    public String addDiaperFromForm(@Valid Diaper diaper, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addDiaper";
        } else {
            diaperService.create(diaper);
            return "redirect:/diaper/list";
        }
    }

    @GetMapping("update/{id}")
    public String updateDiaperForm(@PathVariable Long id, Model model) {
        Diaper diaper = diaperService.read(id);
        model.addAttribute("diaper", diaper);
        return "updateDiaper";
    }

    @PostMapping("update/{id}")
    public String updateDiaperFromForm(@ModelAttribute @Valid Diaper diaper, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateDiaper";
        }
        diaperService.update(diaper);
        return "redirect:../list";
    }

    @GetMapping("delete/{id}")
    public String deleteDiaper(@PathVariable Long id) {
        diaperService.delete(id);
        return "redirect:../list";
    }
}
