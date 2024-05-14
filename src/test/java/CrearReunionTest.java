import tarea2.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class CrearReunionTest {
    @BeforeEach
    void setUp(){
        Departamento Qa = new Departamento(3);
        Departamento Dev = new Departamento(8);
        Departamento Marketing = new Departamento(5);
    }
    

    @Test
    @DisplayName("Test crear una reunion")
    public void testCrearUnaReunion() throws Exception {

    }
}
