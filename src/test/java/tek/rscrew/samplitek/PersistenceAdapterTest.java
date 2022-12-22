package tek.rscrew.samplitek;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;
import tek.rscrew.samplitek.adapter.out.SampleMapper;
import tek.rscrew.samplitek.adapter.out.SamplePersistenceAdapter;
import tek.rscrew.samplitek.adapter.out.SampleRepository;
import tek.rscrew.samplitek.model.Sample;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PersistenceAdapterTest extends PostgresDockerTest {

    @Autowired
    private SampleRepository sampleRepository;

    private SampleMapper sampleMapper;

    private SamplePersistenceAdapter samplePersistenceAdapter;

    @Test
    @Sql({"init.sql","fill.sql"})
    void getSamples(){
        sampleMapper = new SampleMapper();

        samplePersistenceAdapter = new SamplePersistenceAdapter(sampleRepository,sampleMapper);

        List<Sample> samples;

        samples = samplePersistenceAdapter.getSamples();

        assertEquals("amen break",samples.get(0).getName());
        assertEquals("test",samples.get(1).getInstrument());
    }

}
