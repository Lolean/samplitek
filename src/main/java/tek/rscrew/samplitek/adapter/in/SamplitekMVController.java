package tek.rscrew.samplitek.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tek.rscrew.samplitek.model.Sample;
import tek.rscrew.samplitek.port.in.SampleContract;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class SamplitekMVController  {

    private final SampleContract sampleContract;

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/samples")
    public String samples(Model model){
        List<Sample> samples = sampleContract.getSamples();
        model.addAttribute("samplelist",samples);
        return "samples.html";
    }


}
