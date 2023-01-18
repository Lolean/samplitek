package tek.rscrew.samplitek.port.in;


import tek.rscrew.samplitek.model.Sample;

import java.util.List;

public interface SampleContract {

    List<Sample> getSamples();

    Sample singleSample(final long id);

    Sample createSample(Sample sa);

    void deleteSample(Long id);

    Sample updateSample(Sample sa);

    boolean isAllowed(String email);
}
