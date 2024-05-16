package tarea2;

import java.util.*;
import java.time.*;

/**
 * Una reunion de trabajo en formato presencial con su respectiva oficina.
 * 
 * @author Joseph Matamala, Felipe Tilleria
 * @since 11 de mayo de 2024
 * 
 *        la clase ReunionPresencial hereda aspectos de Reunion, ya que esta es
 *        una forma mas especifica de esta ultima.
 * @see Reunion
 * 
 */
public class ReunionPresencial extends Reunion {
    /**
     * @param sala es la oficina a la que los trabajadores tendran que ir para
     *             asistir la reunion.
     */
    private String sala;

    /**
     * 
     * @param horaPrevista     hora sugerida para que los empleados lleguen.
     * 
     * @param duracionPrevista tiempo estimado que durara la reunion.
     * 
     * @param tipoDeReunion    tematica de la reunion (tecnica, de marketing u
     *                         otra).
     * @param esPresencial     revisa si la reunion es presencial, o en caso
     *                         contrario, que sea virtual.
     */
    public ReunionPresencial(Instant horaPrevista, Duration duracionPrevista, int tipoDeReunion, boolean esPresencial)
            throws Exception {
        super(horaPrevista, duracionPrevista, tipoDeReunion, esPresencial);

        /**
         * Excepciones de la reunión, en caso de que tenga un tipo de reunión que no
         * coincida con los establecidos o si tiene una duración negativa.
         */
        if (tipoDeReunion > tipoReunion.cantidadDeTipos || tipoDeReunion <= 0) {
            throw new Exception("\033[0;31m" + "Tipo de reunión no identificado" + "\033[0;31m");
        }
        if (duracionPrevista.toMillis() <= 0) {
            throw new Exception("\033[0;31m" + "Error en duracion de la reunion, esta tiene que ser positiva" + "\033[0;31m");
        }
        /**
         * Asignacion del nombre de la sala con su respectivo formato.
         */
        this.sala = "Sala " + indice;
        indice++;
    }

    /**
     * Metodos getter y setter de la sala en la que se va a realizar la reunion.
     */
    public String getLugar() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}