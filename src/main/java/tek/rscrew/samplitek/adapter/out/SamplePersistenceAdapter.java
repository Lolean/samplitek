package tek.rscrew.samplitek.adapter.out;

import lombok.RequiredArgsConstructor;
import tek.rscrew.samplitek.model.Sample;
import tek.rscrew.samplitek.port.out.SampleAccess;


import javax.websocket.OnError;
import java.util.List;

@RequiredArgsConstructor
public class SamplePersistenceAdapter implements SampleAccess {

    private final SampleRepository sampleRepository;
    private final SampleMapper sampleMapper;
    private List<Sample> samples;

    @Override
    public List<Sample> getSamples(){
        List<SampleJPA> sampleJPAS = sampleRepository.findAll();
        return sampleMapper.mapToSample(sampleJPAS);
    }

    @Override
    public Sample singleSample(Long id) {

    }
    @Override
    public Sample createSample(Sample sa){
        return null;
    }

    @Override
    public void deleteSample(){

    }

    @Override
    public Sample updateSample(Sample sa){
        return null;
    }

}
