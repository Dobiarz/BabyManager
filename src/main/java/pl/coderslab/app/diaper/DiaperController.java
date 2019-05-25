package pl.coderslab.app.diaper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.nap.Nap;
import pl.coderslab.app.nap.NapService;

import java.util.List;

@Controller
@RequestMapping("/diaper")
public class DiaperController {

    @Autowired
    DiaperService diaperService;

    @ModelAttribute("diapers")
    public List<Diaper> getDiapers(){return diaperService.findAll();}

    @RequestMapping("/list")
    public String diaper() {
        return "diaper";
    }
}
