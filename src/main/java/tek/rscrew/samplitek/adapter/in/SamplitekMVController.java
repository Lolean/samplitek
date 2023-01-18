package tek.rscrew.samplitek.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import tek.rscrew.samplitek.model.Sample;
import tek.rscrew.samplitek.port.in.SampleContract;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class SamplitekMVController  {

    private final SampleContract sampleContract;

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){

        return "index";
    }

    @GetMapping("/samples")
    public String samples(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal != null) {
            boolean admin = sampleContract.isAllowed(principal.getEmail());
            List<Sample> samples = sampleContract.getSamples();
            model.addAttribute("samplelist", samples);
            model.addAttribute("allowed",admin);
            return "samples";
        }
        else return "index";
    }

    @GetMapping("/sample/{id}")
    public String singleSample(@PathVariable("id") Long id,@AuthenticationPrincipal OidcUser principal,Model model){
        if(sampleContract.isAllowed(principal.getEmail())) {
            Sample sample = sampleContract.singleSample(id);
            model.addAttribute(sample);
            return "sample";
        }
        else return "index";
    }


    @GetMapping("/createSample")
    public String createSampleForm(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal != null){
            model.addAttribute("sampleid",0);
            model.addAttribute("state",false);
            return "sampleform";
        }
        else return "index";
    }

    @PostMapping("/createSample")
    public RedirectView createSample(@ModelAttribute Sample sample,@AuthenticationPrincipal OidcUser principal ,Model model){
        if(principal != null) {
            Sample sample1 = new Sample(sample.getId(), sample.getName(), sample.getGenre(), sample.getInstrument(), sample.getCreator(), sample.getBpm(), sample.getHidden());
            sampleContract.createSample(sample1);
            return new RedirectView("/samples");


        }
        else return new RedirectView("/");

    }

    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal != null) {
            model.addAttribute("profile", principal.getClaims());
            return "profile";
        }
        else{
            return "index";
        }
    }

    @PostMapping("/updateSample")
    public RedirectView modify(@RequestParam("delete") String delete,@ModelAttribute Sample sample,Model model,@AuthenticationPrincipal OidcUser principal){
        if(sampleContract.isAllowed(principal.getEmail())){
            System.out.println("Delete = "+delete);
            if(delete.equals("no")) {
                Sample modified = new Sample(sample.getId(), sample.getName(), sample.getGenre(),
                        sample.getInstrument(), sample.getCreator(), sample.getBpm(), false);
                sampleContract.updateSample(modified);
                return new RedirectView("/samples");
            }
            else{
                Long id = sample.getId();
                sampleContract.deleteSample(id);
                return new RedirectView("/samples");
            }


        }else return new RedirectView("/");
    }

}
