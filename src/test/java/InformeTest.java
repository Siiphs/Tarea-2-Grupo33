import tarea2.*;

import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import org.junit.jupiter.api.*;

import java.io.*;

public class InformeTest {

    @Test
    @DisplayName("Test crear archivo")
    public void testCrearArchivo() throws Exception {
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
    public void testVaciarArchivo() throws Exception{
        GenerarTxt.crearArchivo();
        GenerarTxt.escribirArchivo("Contenido de prueba");
        GenerarTxt.vaciarArchivo();
        File archivo = new File("/workspaces/Tarea-2-Grupo33/Informes/Informe.txt");
        assertTrue(archivo.exists());
        assertEquals(0, archivo.length());
    }

    @Test
    @DisplayName("Test crear informe")
    public void testCrearInforme() throws Exception{
        ReunionVirtual rv = new ReunionVirtual(Instant.parse("2024-07-14T20:05:55.088Z"), Duration.ofHours(5), 3, false);
        Invitacion invitacion = new Invitacion(rv);
        rv.iniciar();
        rv.finalizar();

        GenerarTxt.crearInforme(invitacion, rv);
        File archivo = new File("/workspaces/Tarea-2-Grupo33/Informes/Informe.txt");
        assertTrue(archivo.exists());
    }
}