package tek.rscrew.samplitek;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SamplitekController {
    @GetMapping("/")
    public String index(){
        return "SMAPLETOUK";
    }
}
