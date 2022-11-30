package tek.rscrew.samplitek.port.in;


import tek.rscrew.samplitek.model.Sample;

import java.util.List;

public interface SampleContract {

    List<Sample> getSamples();

    Sample singleSample(final long id);

    Sample createSample(Sample sa);

    void deleteSample(final long id);

    void updateSample();
}
