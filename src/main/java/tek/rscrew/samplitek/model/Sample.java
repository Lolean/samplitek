package tek.rscrew.samplitek.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Sample {


    private final Long id;

    private final String name;

    private final String genre;

    private final String instrument;

    private final String creator;

    private final int bpm;

    private final Boolean hidden;
}
