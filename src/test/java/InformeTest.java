import tarea2.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.time.*;
import org.junit.jupiter.api.*;

public class InformeTest {

    @Test
    @DisplayName("Test crear archivo")
    public void testCrearArchivo() {
        GenerarTxt.crearArchivo();
        File archivo = new File("/workspaces/Tarea-2-Grupo33/Informes/Informe.txt");
        assertTrue(archivo.exists());
    }

    @Test
    @DisplayName("Test escribir en archivo")
    public void testEscribirArchivo() throws Exception {
        Departamento Dev = new Departamento(8);
        Object texto = Dev.getLista().get(0).getCorreo().toString();
        GenerarTxt.crearArchivo();
        GenerarTxt.escribirArchivo(texto);
        File archivo = new File("/workspaces/Tarea-2-Grupo33/Informes/Informe.txt");
        assertTrue(archivo.exists());
        @SuppressWarnings("resource")
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        assertEquals(br.readLine(), texto.toString());
    }

    @Test
    @DisplayName("Test vaciar archivo")
    public void testVaciarArchivo() {
        GenerarTxt.crearArchivo();
        GenerarTxt.escribirArchivo("Contenido de prueba");
        GenerarTxt.vaciarArchivo();
        File archivo = new File("/workspaces/Tarea-2-Grupo33/Informes/Informe.txt");
        assertTrue(archivo.exists());
        assertEquals(0, archivo.length());
    }

    @Test
    @DisplayName("Test crear informe")
    public void testCrearInforme() {
        ReunionVirtual rv = new ReunionVirtual(Instant.now(), Duration.ofHours(1), 2, true);
        Invitacion invitacion = new Invitacion(rv);
        rv.iniciar();
        rv.finalizar();

        GenerarTxt.crearInforme(invitacion, rv);
        File archivo = new File("/workspaces/Tarea-2-Grupo33/Informes/Informe.txt");
        assertTrue(archivo.exists());
    }
}