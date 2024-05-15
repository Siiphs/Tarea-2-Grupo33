import tarea2.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;

import org.junit.jupiter.api.*;

public class CrearDepartamentoTest {

    @Test
    @DisplayName("Test crear un Departamento")
    public void testCrearUnDepartamento() throws Exception {
        Departamento Qa = new Departamento(3);
        assertNotNull(Qa);
    }

    @Test
    @DisplayName("Test de excepcion al tener departamento vacio")
    public void testCrearDepartamentoVacio() throws Exception {
        Exception exception = assertThrows(Exception.class,()->{
            Departamento Marketing = new Departamento(0);
            assertNull(Marketing);
        });
    }

    @Test
    @DisplayName("Test de excepcion al tener departamento con cantidad negativa de empleados")
    public void testCrearDepartamentoNegativo() throws Exception {
        Exception exception = assertThrows(Exception.class,()->{
            Departamento Dev = new Departamento(-10);
            assertNull(Dev);
        });
    }
}
