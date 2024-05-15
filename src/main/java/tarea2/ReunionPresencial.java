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
     * @param tipoReunion      tematica de la reunion (tecnica, de marketing u
     *                         otra).
     * @param esPresencial     revisa si la reunion es presencial, o en caso
     *                         contrario, que sea virtual.
     */
    public ReunionPresencial(Instant horaPrevista, Duration duracionPrevista, int tipoReunion, boolean esPresencial) {
        super(horaPrevista, duracionPrevista, tipoReunion, esPresencial);

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