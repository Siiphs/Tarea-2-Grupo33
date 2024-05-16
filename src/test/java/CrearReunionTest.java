import tarea2.*;

import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import org.junit.jupiter.api.*;


public class CrearReunionTest {

    @Test
    @DisplayName("Test crear una reunion presencial")
    public void testCrearUnaReunionPresencial() throws Exception {
        ReunionPresencial rp = new ReunionPresencial(Instant.parse("2024-05-13T23:05:55.088Z"), Duration.ofHours(1), 2, true);
        assertNotNull(rp);
    }

    @Test
    @DisplayName("Test crear una reunion virtual")
    public void testCrearUnaReunionVirtual() throws Exception {
        ReunionVirtual rv = new ReunionVirtual(Instant.parse("2024-07-14T20:05:55.088Z"), Duration.ofHours(5), 3, false);
        assertNotNull(rv);
    }

    @Test
    @DisplayName("Test tipo de Reunion no identificada")
    public void testReunionNoIdentificada() throws Exception {
        Exception e = assertThrows(Exception.class,()->{ReunionVirtual rv = new ReunionVirtual(Instant.parse("2024-07-14T20:05:55.088Z"), Duration.ofHours(5), 9, false);});
    }

    @Test
    @DisplayName("Test Duracion de reunión negativa")
    public void testDuracionNegativa() throws Exception {
        Exception e = assertThrows(Exception.class,()->{ReunionVirtual rv = new ReunionVirtual(Instant.parse("2024-07-14T20:05:55.088Z"), Duration.ofHours(-15), 1, false);});
    }
    
}
