package tarea2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InformeTest {
    @BeforeEach
    Departamento Qa = new Departamento(3);
    Departamento Dev = new Departamento(8);
    Departamento Marketing = new Departamento(5);

    @Test
    @DisplayName("Test generar un informe de la reunion")
    public void testInforme() throws Exception {

    }
}
