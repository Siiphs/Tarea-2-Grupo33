import tarea2.*;

import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import org.junit.jupiter.api.*;

public class IniciarReunionTest {

    @Test
    @DisplayName("Test iniciar una reunion")
    public void testIniciarReunion() throws Exception {
        
        ReunionVirtual rv = new ReunionVirtual(Instant.parse("2024-07-14T20:05:55.088Z"), Duration.ofHours(5), 2, false);
        
        rv.iniciar();

        Thread.sleep(1000 * 3);

        assertTrue((Duration.between(rv.getHoraInicio(),Instant.now()).getSeconds())!=0);
    }
}
