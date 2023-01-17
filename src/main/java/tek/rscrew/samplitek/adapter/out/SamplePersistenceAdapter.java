package tek.rscrew.samplitek.adapter.out;

import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Example;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tek.rscrew.samplitek.model.Sample;
import tek.rscrew.samplitek.port.out.SampleAccess;


import javax.websocket.OnError;
import java.util.List;
import java.util.Optional;

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
        Optional<SampleJPA> sample = sampleRepository.findById(id);
        return sampleMapper.mapToSample(sample.get());

    }
    @Override
    public Sample createSample(Sample sa){
        SampleJPA sampleToCreate = sampleMapper.mapToJPA(sa);
        SampleJPA sampleCreated = sampleRepository.save(sampleToCreate);
        return sampleMapper.mapToSample(sampleCreated);

    }

    @Override
    public void deleteSample(Sample sa){
        Optional<SampleJPA> sampleTodelete = sampleRepository.findById(sa.getId());
        if(sampleMapper.mapToSample(sampleTodelete.get()) == sa){
            SampleJPA sampleToHide = sampleTodelete.get();
            sampleToHide.setHidden(true);
            sampleRepository.save(sampleToHide);
        }

    }

    public Sample updateSample(Sample sa){
        SampleJPA sampleToModify = sampleMapper.maptoJPAid(sa,sa.getId());
        sampleRepository.save(sampleToModify);
        return sampleMapper.mapToSample(sampleToModify);

    }

}
