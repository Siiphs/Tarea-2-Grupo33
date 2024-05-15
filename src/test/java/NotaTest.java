import tarea2.*;

import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import org.junit.jupiter.api.*;

public class NotaTest {

    Departamento Qa = new Departamento(3);
    Departamento Dev = new Departamento(8);
    Departamento Marketing = new Departamento(5);


    @Test
    @DisplayName("Test crear una nota")
    public void testCrearUnaNota() throws Exception {
        Departamento Dev = new Departamento(8);
        ReunionPresencial rp = new ReunionPresencial(Instant.parse("2024-05-13T23:05:55.088Z"), Duration.ofHours(1), 3, true);

        Dev.invitar(rp);
        rp.iniciar();

        rp.agregarNota("Nota escrita en la reunión");
        rp.agregarNota("otra nota");

        assertNotNull(rp.obtenerNotas());
        assertEquals("Nota escrita en la reunión", rp.obtenerNotas().get(0).getContenido());
        assertEquals("otra nota", rp.obtenerNotas().get(1).getContenido());
    }
}
