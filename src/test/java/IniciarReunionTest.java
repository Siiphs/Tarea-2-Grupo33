import tarea2.*;

import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import org.junit.jupiter.api.*;

public class IniciarReunionTest {

    @Test
    @DisplayName("Test iniciar una reunion")
    public void testIniciarReunion() throws Exception {
        
        Departamento Dev = new Departamento(8);
        ReunionPresencial rp = new ReunionPresencial(Instant.parse("2024-05-13T23:05:55.088Z"), Duration.ofHours(1), 3, true);


        Dev.invitar(rp);

        rp.iniciar();

        assertNotNull(rp.getHoraInicio());
        assertNotNull(rp.obtenerRetrasos());
    }
}
