package tek.rscrew.samplitek;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import tek.rscrew.samplitek.model.Sample;
import tek.rscrew.samplitek.port.in.SampleContract;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SampleContract sa;

    private List<Sample> samples = new ArrayList<>();

    @Test
    public void getSamplesTest() throws Exception{

        samples.add(new Sample((long) 1,"amen break","breakbeat","drum","amens brothers",170));
        samples.add(new Sample((long) 2, "test","test","test","test",120));
        System.out.println(samples);

        Mockito.when(sa.getSamples()).thenReturn(samples);

        mockMvc.perform(get("/samples")).andExpect(status().isOk()).andExpect(jsonPath("$[0].name",is("amen break")));

    }
}
