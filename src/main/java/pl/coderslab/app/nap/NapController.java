package pl.coderslab.app.nap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.baby.Baby;
import pl.coderslab.app.baby.BabyService;
import pl.coderslab.app.feeding.Feeding;
import pl.coderslab.app.feeding.FeedingRepository;
import pl.coderslab.app.feeding.LeftBreast;
import pl.coderslab.app.feeding.Solid;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/nap")
public class NapController {

    @Autowired
    NapService napService;
    @Autowired
    BabyService babyService;

    @ModelAttribute("naps")
    public List<Nap> getNaps(){return napService.findAll();}

    @ModelAttribute("babies")
    public List<Baby> getBabies() {
        return babyService.findAll();
    }

    @RequestMapping("/list")
    public String nap() {
        return "nap";
    }

    @GetMapping("add")
    public String addNapForm(Model model) {
        model.addAttribute("nap", new Nap());
        return "addNap";
    }

    @PostMapping("add")
    public String addNapFromForm(@Valid Nap nap, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addNap";
        } else {
            napService.create(nap);
            return "redirect:/nap/list";
        }
    }

    @GetMapping("update/{id}")
    public String updateNapForm(@PathVariable Long id, Model model) {
        Nap nap = napService.read(id);
        model.addAttribute("nap", nap);
        return "addNap";
    }

    @PostMapping("update/{id}")
    public String updateNapFromForm(@ModelAttribute @Valid Nap nap, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addNap";
        }
        napService.update(nap);
        return "redirect:../list";
    }

    @GetMapping("delete/{id}")
    public String deleteNap(@PathVariable Long id) {
        napService.delete(id);
        return "redirect:../list";
    }
}
