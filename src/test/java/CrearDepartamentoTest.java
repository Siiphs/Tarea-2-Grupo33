import tarea2.*;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.*;

public class CrearDepartamentoTest {

    @Test
    @DisplayName("Test crear un Departamento")
    public void testCrearUnDepartamento() throws Exception {
        Departamento Qa = new Departamento(3);
        assertNotNull(Qa);
    }

}
