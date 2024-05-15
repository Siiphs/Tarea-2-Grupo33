import tarea2.*;

import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import org.junit.jupiter.api.*;

public class FinalizarReunionTest {

    @Test
    @DisplayName("Test finalizar una reunion")
    public void testFinalizarReunion() throws Exception {
        ReunionVirtual rv = new ReunionVirtual(Instant.parse("2024-07-14T20:05:55.088Z"), Duration.ofHours(5), 2, false);
        

        rv.iniciar();

        Thread.sleep(1000 * 3);

        rv.finalizar();
        assertNotNull(rv.getHoraFin());
        assertNotNull(rv.getDuracionReal());
        assertNotNull(rv.obtenerAusencias());

    }
    @Test
    @DisplayName("Test de excepcion al finalizar antes de iniciar")
    public void testFinalizarSinIiniciar() throws Exception{
        Exception exception = assertThrows(Exception.class,()->{
            ReunionVirtual rv = new ReunionVirtual(Instant.parse("2024-07-14T20:05:55.088Z"), Duration.ofHours(5), 2, false);
            rv.finalizar();
        });
    }
    
}
