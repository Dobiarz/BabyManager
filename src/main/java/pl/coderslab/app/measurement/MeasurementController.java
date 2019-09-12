package pl.coderslab.app.measurement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.baby.Baby;
import pl.coderslab.app.baby.BabyService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/measurement")
public class MeasurementController {

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

    @RequestMapping("/list")
    public String measurement() {
        return "measurement";
    }

    @GetMapping("add")
    public String addMeasurementForm(Model model) {
        model.addAttribute("measurement", new Measurement());
        return "addMeasurement";
    }

    @PostMapping("add")
    public String addMeasurementFromForm(@Valid Measurement measurement, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addMeasurement";
        } else {
            measurementService.create(measurement);
            return "redirect:/measurement/list";
        }
    }

    @GetMapping("update/{id}")
    public String updateMeasurementForm(@PathVariable Long id, Model model) {
        Measurement measurement = measurementService.read(id);
        model.addAttribute("measurement", measurement);
        return "updateMeasurement";
    }

    @PostMapping("update/{id}")
    public String updateMeasurementFromForm(@ModelAttribute @Valid Measurement measurement, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateMeasurement";
        }
        measurementService.update(measurement);
        return "redirect:../list";
    }

    @GetMapping("delete/{id}")
    public String deleteMeasurement(@PathVariable Long id) {
        measurementService.delete(id);
        return "redirect:../list";
    }
}
