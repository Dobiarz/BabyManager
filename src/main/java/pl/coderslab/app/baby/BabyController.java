package pl.coderslab.app.baby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.measurement.Measurement;
import pl.coderslab.app.measurement.MeasurementService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/baby")
public class BabyController {

    @Autowired
    MeasurementService measurementService;

    @Autowired
    BabyService babyService;

    @ModelAttribute("measurements")
    public List<Measurement> getMeasurements() {
        return measurementService.findAll();
    }

    @ModelAttribute("babies")
    public List<Baby> getBabies() {
        return babyService.findAll();
    }

    @ModelAttribute("babiesWithActualMeasurement")
    public List<Baby> getBabiesWithActualMeasurement() {

        List<Baby> babiesWithActualMeasurement = new ArrayList<>();

        for (Baby baby : babyService.findAll()) {

            Measurement measurement = measurementService.findFirstByBabyIdOrderByBeginningDesc(baby.getId());

            if (measurement != null) {
                Baby updatedBaby = new Baby();
                updatedBaby.setId(baby.getId());
                updatedBaby.setName(baby.getName());
                updatedBaby.setBirthDate(baby.getBirthDate());
                updatedBaby.setWeight(measurement.getWeight());
                updatedBaby.setHeight(measurement.getHeight());
                updatedBaby.setHeadCircumference(measurement.getHeadCircumference());

                babiesWithActualMeasurement.add(updatedBaby);
            } else {
                babiesWithActualMeasurement.add(baby);
            }
        }

        return babiesWithActualMeasurement;
    }

    @ModelAttribute("genders")
    public List<String> getGenders() {
        List<String> genders = new ArrayList<>();
        genders.add("Female");
        genders.add("Male");
        return genders;
    }

    @RequestMapping("/list")
    public String baby() {
        return "baby";
    }

    @GetMapping("add")
    public String addBabyForm(Model model) {
        model.addAttribute("baby", new Baby());
        return "addBaby";
    }

    @PostMapping("add")
    public String addBabyFromForm(@Valid Baby baby, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addBaby";
        } else {
            babyService.create(baby);
            return "redirect:/baby/list";
        }
    }

    @GetMapping("update/{id}")
    public String updateBabytForm(@PathVariable Long id, Model model) {
        Baby baby = babyService.read(id);
        model.addAttribute("baby", baby);
        return "addBaby";
    }

    @PostMapping("update/{id}")
    public String updateBabyFromForm(@ModelAttribute @Valid Baby baby, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addBaby";
        }
        babyService.update(baby);
        return "redirect:../list";
    }

    @GetMapping("delete/{id}")
    public String deleteBaby(@PathVariable Long id) {
        babyService.delete(id);
        return "redirect:../list";
    }
}
