package pl.coderslab.app.measurement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.nap.Nap;
import pl.coderslab.app.nap.NapService;

import java.util.List;

@Controller
@RequestMapping("/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    @ModelAttribute("measurements")
    public List<Measurement> getMeasurements(){return measurementService.findAll();}

    @RequestMapping("/list")
    public String measurement() {
        return "measurement";
    }
}
