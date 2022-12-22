package tek.rscrew.samplitek.adapter.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import tek.rscrew.samplitek.model.Sample;

import javax.persistence.*;


@Entity
@Data
@Table(name="samples")
public class SampleJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String genre;

    private String instrument;

    private String creator;

    private int bpm;

    public SampleJPA() {

    }

    public SampleJPA(String name, String genre, String inst, String creator, int bpm){
        this.id = null;
        this.name = name;
        this.genre = genre;
        this.instrument = inst;
        this.bpm = bpm;
    }


}
