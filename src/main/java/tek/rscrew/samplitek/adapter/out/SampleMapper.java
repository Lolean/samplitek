package tek.rscrew.samplitek.adapter.out;

import tek.rscrew.samplitek.model.Sample;

import java.util.List;
import java.util.ArrayList;


public class SampleMapper {

    List<Sample> mapToSample(List<SampleJPA> dbSamples){

        List<Sample> samples = new ArrayList<Sample>();

        for(SampleJPA sJPA: dbSamples){

            samples.add(new Sample(sJPA.getId(), sJPA.getName(),
                    sJPA.getGenre(), sJPA.getInstrument(), sJPA.getCreator(), sJPA.getBpm(),sJPA.isHidden()));

        }
        return samples;

    }

    Sample mapToSample(SampleJPA sampleJPA) {

        Sample sample = new Sample(sampleJPA.getId(), sampleJPA.getName(), sampleJPA.getGenre(), sampleJPA.getInstrument(),
                sampleJPA.getCreator(), sampleJPA.getBpm(),sampleJPA.isHidden());

        return sample;
    }

    SampleJPA mapToJPA(Sample sample){
        SampleJPA sampleJPA = new SampleJPA(sample.getName(),sample.getGenre(),
                sample.getInstrument(),sample.getCreator(),sample.getBpm());

        return sampleJPA;

    }

    SampleJPA maptoJPAid(Sample sample,Long sampleid){
        SampleJPA sampleJPA = new SampleJPA(sampleid,sample.getName(),sample.getGenre(),
                sample.getInstrument(),sample.getCreator(),sample.getBpm(),sample.getHidden());

        return sampleJPA;

    }



}


