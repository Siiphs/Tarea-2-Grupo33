import tarea2.*;

import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import org.junit.jupiter.api.*;

public class PorcentajeAsistenciaTest {

    @Test
    @DisplayName("Test calcular porcentaje de asistencia")
    public void testPorcentajeReunion() throws Exception {


        Departamento Dev = new Departamento(8);
        ReunionPresencial rp = new ReunionPresencial(Instant.parse("2024-05-13T23:05:55.088Z"), Duration.ofHours(1), 3, true);


        Dev.invitar(rp);

        rp.iniciar();

        rp.finalizar();

        assertNotNull(rp.obtenerTotalAsistencia());
        if(rp.obtenerTotalAsistencia()!=0){
            assertNotEquals(rp.obtenerPorcentajeAsistencia(), 0);
        }
    }
    
}
