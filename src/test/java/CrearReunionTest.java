import tarea2.*;

import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import org.junit.jupiter.api.*;


public class CrearReunionTest {

    @Test
    @DisplayName("Test crear una reunion presencial")
    public void testCrearUnaReunionPresencial() throws Exception {
        ReunionPresencial rp = new ReunionPresencial(Instant.parse("2024-05-13T23:05:55.088Z"), Duration.ofHours(1), 3, true);
        assertNotNull(rp);
    }

    @Test
    @DisplayName("Test crear una reunion virtual")
    public void testCrearUnaReunionVirtual() throws Exception {
        ReunionVirtual rv = new ReunionVirtual(Instant.parse("2024-07-14T20:05:55.088Z"), Duration.ofHours(5), 2, false);
        assertNotNull(rv);
    }

    
}
