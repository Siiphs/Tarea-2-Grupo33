package tarea2;

import java.time.*;
import java.util.ArrayList;

/**
 * La asistencia toma nota de que empleado llega a la reunion y si este llega
 * tarde en sus listas correspondientes.
 * 
 * @author Dario Sepulveda
 * @since 11 de mayo de 2024
 * 
 * @param listaAsistencia es un ArrayList de cada empleado que llego a la
 *                        reunion, ya sea a la hora o con un retraso.
 * @param listaAtrasos    en un ArrayList de cada empleado que si llego tarde a
 *                        la reunion.
 */
class Asistencia {
    public ArrayList<Integer> listaAsistencia = new ArrayList<Integer>();
    public ArrayList<Integer> listaAtrasos = new ArrayList<Integer>();

    /**
     * @param hora es correspondiente a la hora en la que la reunion verdaderamente
     *             inicia, para poder revisar si el empleado realmente llego tarde o
     *             no.
     */
    private long hora;

    public Asistencia(long hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "listaAsistencia=" + listaAsistencia +
                ", listaAtrasos=" + listaAtrasos +
                '}';
    }

}