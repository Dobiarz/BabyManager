package pl.coderslab.app.nap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.feeding.Feeding;
import pl.coderslab.app.feeding.FeedingRepository;

import java.util.List;

@Controller
@RequestMapping("/nap")
public class NapController {

    @Autowired
    NapService napService;

    @ModelAttribute("naps")
    public List<Nap> getNaps(){return napService.findAll();}

    @RequestMapping("/list")
    public String nap() {
        return "nap";
    }
}
