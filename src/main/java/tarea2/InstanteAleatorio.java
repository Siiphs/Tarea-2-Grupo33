package tarea2;

import java.time.*;
import java.util.*;

/**
 * Una hora aleatoria, usada para simular que un empleado llegue en este momento
 * a la reunion.
 * 
 * @author Felipe Tilleria
 * @since 12 de mayo de 2024
 */
public class InstanteAleatorio {

    public InstanteAleatorio() {
    }

    /**
     * Para crear una hora de llegada aleatoria a la reunion se necesitan como
     * parametros la hora en que inicio y la duracion prevista, para estimar una
     * hora de fin.
     * 
     * @param horaInicio       el momento en que la reunion realmente comienza.
     * 
     * @param duracionPrevista el tiempo estimado que deberia durar la reunion, con
     *                         esto tambien se obtiene su hora de termino estimada
     * 
     * @return la hora a la que el empleado llega.
     * 
     */
    public Instant getRandInstant(Instant horainicio, Duration duracionPrevista) {
        /**
         * Se estima la hora en que la reunion va a terminar sumando su duracion a la
         * hora de inicio.
         */
        Instant horafin = horainicio.plus(duracionPrevista);

        /**
         * Para la simulacion los empleados pueden llegar hasta una hora antes de que la
         * reunion empiece.
         */
        long inicio = horainicio.toEpochMilli() - 1000 * 60 * 60 * 1;

        /**
         * Tambien pueden llegar hasta media hora despues de que finalice, en este caso
         * habrian quedado como ausentes al haber llegado tan tarde.
         */
        long fin = horafin.toEpochMilli() + 1000 * 60 * 30;

        /** Crea una instancia de un objeto random */
        Random r = new Random();

        /**
         * Obtiene un numero aleatorio de milisegundos que luego convierte a formato
         * epoch, el cual es usado en el resto del programa.
         */
        long randomMillis = inicio + (long) (r.nextDouble() * (fin - inicio));
        Instant randomInstant = Instant.ofEpochMilli(randomMillis);
        return randomInstant;
    }
}