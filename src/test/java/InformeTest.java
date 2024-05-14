import tarea2.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class InformeTest {
    void setUp(){
        Departamento Qa = new Departamento(3);
        Departamento Dev = new Departamento(8);
        Departamento Marketing = new Departamento(5);
    }

    @Test
    @DisplayName("Test generar un informe de la reunion")
    public void testInforme() throws Exception {

    }
}
