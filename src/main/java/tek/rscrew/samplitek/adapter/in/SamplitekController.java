package tek.rscrew.samplitek.adapter.in;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import tek.rscrew.samplitek.model.Sample;
import tek.rscrew.samplitek.port.in.SampleContract;

@RestController
public class SamplitekController {

    private SampleContract sampleContract;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @GetMapping("/getSamples")
    public Iterable<Sample> getSamples(){

    }

    @GetMapping("/sample/{id}")
    public Sample singleSample(@PathVariable("id") final int id, @RequestBody Sample sample){

    }

    public



}
