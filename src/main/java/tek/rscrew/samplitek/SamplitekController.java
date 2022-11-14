package tek.rscrew.samplitek;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@RestController
public class SamplitekController {
    @GetMapping("/")
    public String index(Model model){
        return "index";
    }
}
