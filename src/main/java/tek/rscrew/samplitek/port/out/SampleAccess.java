package tek.rscrew.samplitek.port.out;

import tek.rscrew.samplitek.model.Sample;

import java.util.List;

public interface SampleAccess {

    List<Sample> getSamples();

    Sample singleSample(Long id);

    Sample createSample(Sample sa);

    void deleteSample(Long id);

    Sample updateSample(Sample sa);

}
