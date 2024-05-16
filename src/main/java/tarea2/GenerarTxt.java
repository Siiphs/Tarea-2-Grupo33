package tarea2;

import java.io.*;

/**
 * GenerarTxt es la clase responsable de crear un archivo de texto con la informacion de la reunion.
 * 
 * @author Felipe Tilleria
 * @since 13 de mayo de 2024
 * 
 */
public class GenerarTxt {
    static File archivo;
    static String texto;

    /**
     * El constructor de la clase no necesita propiedades iniciales, por lo tanto, va vacío.
     */
    public GenerarTxt() {
    }

    /**
     *  Crea un nuevo archivo de texto para el informe de la reunión.
     */
    public static void crearArchivo() {
        /**
        *  intenta crear un archivo de texto en la ruta especificada si no existe y si existe
        *  lo vacia para escribir en el.
        */
        try {
            archivo = new File("/workspaces/Tarea-2-Grupo33/Informes/Informe.txt");
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("Archivo sobreescrito.");
                GenerarTxt.vaciarArchivo();
            }
        /**
        * si ocurre un error en la creacion del archivo, se imprime un mensaje de error. 
        */
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }
    }

    /**
     * Escribe el String equivalente de @texto en el archivo de texto.
     *
     * @param texto el texto a escribir en el archivo
     */
    public static void escribirArchivo(Object texto) {
        /**
        *   se intenta escribir el texto en el archivo de texto, si ocurre un error se imprime
        *   un mensaje de error. 
        */
        try {
            GenerarTxt.texto = texto.toString();
            FileWriter escritor = new FileWriter(archivo, true);
            escritor.write(texto + "\n");
            escritor.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }
    }

    /**
     * Limpia el contenido del archivo de texto.
     */
    public static void vaciarArchivo() {
        /**
        *  se intenta vaciar el archivo de texto, si ocurre un error se imprime un mensaje de error. 
        */
        try {
            FileWriter escritor = new FileWriter(archivo);
            escritor.write("");
            escritor.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();

        }
    }

    /**
     * Crea el informe de la reunión generando el archivo de texto y escribiendo la información necesaria.
     *
     * @param invitacion la lista de invitacion
     * @param r la reunion  
     *
     */
    public static void crearInforme(Invitacion invitacion, Reunion r) {
        /*
         * Crea el archivo con el metodo crear archivo de esta misma clase
         */
        GenerarTxt.crearArchivo();
        /*
         * Escribe en lo necesario con el metodo escribirArchivo de esta misma clase
         */
        GenerarTxt.escribirArchivo("Fecha de la reunion:  " + invitacion.getFecha());
        GenerarTxt.escribirArchivo("Hora prevista de la reunion:  " + invitacion.getHora() + "\n");
        GenerarTxt.escribirArchivo("Hora de inicio de la reunion:  " + r.getHoraInicio());
        GenerarTxt.escribirArchivo("Hora de finalizacion de la reunion:  " + r.getHoraFin());
        GenerarTxt.escribirArchivo("Duracion de la reunion:  " + r.calcularTiempoReal() + " minutos" + "\n");
        GenerarTxt.escribirArchivo("Tipo de reunion:  " + tipoReunion.values()[r.getTipoReunion() - 1] + "\n");
        GenerarTxt.escribirArchivo("Enlace/Sala de la reunion:  " + r.getLugar() + "\n\n" + "lista de asistentes: " + "\n");
        for (int i = 0; i < r.obtenerAsistencias().size(); i++) {
                GenerarTxt.escribirArchivo((i + 1) + ".  id: " + r.obtenerAsistencias().get(i) + ", Asistente: " + Departamento.listaGeneral.get(r.obtenerAsistencias().get(i)).getNombre() + " " + Departamento.listaGeneral.get(r.obtenerAsistencias().get(i)).getApellidos());
        }
        GenerarTxt.escribirArchivo("\n" +"notas:" + "\n");
        for (int i = 0; i < r.obtenerNotas().size(); i++) {
                GenerarTxt.escribirArchivo(r.obtenerNotas().get(i).getContenido());
        }
    }
} 
    

