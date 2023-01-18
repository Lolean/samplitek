package tek.rscrew.samplitek.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import tek.rscrew.samplitek.model.Sample;
import tek.rscrew.samplitek.port.in.SampleContract;
import tek.rscrew.samplitek.port.out.SampleAccess;

import java.util.List;
@RequiredArgsConstructor
public class sampleService implements SampleContract {

    private final SampleAccess sampleAccess;

    @Override
    public List<Sample> getSamples() {
        return sampleAccess.getSamples();

    }

    @Override
    public Sample singleSample(long id) {
        return sampleAccess.singleSample(id);
    }

    @Override
    public Sample createSample(Sample sa) {
        return sampleAccess.createSample(sa);
    }

    @Override
    public Sample updateSample(Sample sa) {
        return sampleAccess.updateSample(sa);
    }

    @Override
    public void deleteSample(Long id) {
        sampleAccess.deleteSample(id);

    }

    @Override
    public boolean isAllowed(String email){
        List<String> allowed = List.of();
    }
}


