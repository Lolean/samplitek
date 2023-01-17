/*package tek.rscrew.samplitek.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tek.rscrew.samplitek.model.Sample;
import tek.rscrew.samplitek.port.in.SampleContract;

import javax.persistence.PostUpdate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SamplitekController {

    private final SampleContract sampleContract;

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/samples")
    public Iterable<Sample> getSamples(){
        return sampleContract.getSamples();

    }

    @GetMapping("/sample/{id}")
    public Sample singleSample(@PathVariable("id") final long id){
        return sampleContract.singleSample(id);
    }

    @PostMapping("/sample")
    public Sample createSample(@RequestBody Sample sa){
        return sampleContract.createSample(sa);

    }

    @PostMapping("/updateSample")
    public Sample updateSample(@RequestBody Sample sa){
        return sampleContract.updateSample(sa);

    }


    @PostMapping("/deleteSample")
    public void deleteSample(@RequestBody Sample sa){
        sampleContract.deleteSample(sa);

    }



}
*/