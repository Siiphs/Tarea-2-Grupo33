import tarea2.*;

import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import org.junit.jupiter.api.*;

public class NotaTest {
    void setUp(){
        Departamento Qa = new Departamento(3);
        Departamento Dev = new Departamento(8);
        Departamento Marketing = new Departamento(5);
    }

    @Test
    @DisplayName("Test crear una nota")
    public void testCrearUnaNota() throws Exception {

    }
}