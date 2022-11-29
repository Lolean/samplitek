package tek.rscrew.samplitek.port.in;


import tek.rscrew.samplitek.model.Sample;

import java.util.List;

public interface SampleContract {

    List<Sample> getSamples();

    Sample singleSample();

    void addSample();

    void updateSample();
}
