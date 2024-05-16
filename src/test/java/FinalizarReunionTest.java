import tarea2.*;

import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import org.junit.jupiter.api.*;

public class FinalizarReunionTest {

    @Test
    @DisplayName("Test finalizar una reunion")
    public void testFinalizarReunion() throws Exception {


        Departamento Dev = new Departamento(8);
        ReunionPresencial rp = new ReunionPresencial(Instant.parse("2024-05-13T23:05:55.088Z"), Duration.ofHours(1), 3, true);


        Dev.invitar(rp);

        rp.iniciar();

        rp.finalizar();

        assertNotNull(rp.getHoraFin());
        assertNotNull(rp.obtenerAusencias());
        assertNotNull(rp.obtenerRetrasos());
    }
    
}
