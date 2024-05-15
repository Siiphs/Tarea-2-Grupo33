package tarea2;

import java.time.*;

/**
 * La clase Retraso tiene como unico funcionamiento guardar y devolver la
 * cantidad de tiempo, en minutos, en la que llego tarde el empleado.
 * 
 * @author Joseph Matamala
 * @since 12 de mayo 2024
 */
public class Retraso extends Asistencia {
    private Long hora;

    /**
     * La clase Retraso hereda la hora de la Asistencia de la reunion.
     * 
     * @param hora cantidad, en milisegundos, en que el empleado llega tarde.
     * 
     * @see Asistencia
     */
    public Retraso(Long hora) {
        super(hora);
    }

    /**
     * Devuelve la cantidad de minutos que el empleado llego tarde a la reunion.
     * 
     * @return el tiempo, en minutos, de tardanza.
     */
    public Long getMinutos() {
        return hora / 1000 / 60;
    }
}