package tarea2;

import java.util.*;
import java.time.*;

/**
 * Una reunion de trabajo en formato virtual con su respectivo enlace de acceso.
 * @author Joseph Matamala, Felipe Tilleria
 * @since 11 de mayo de 2024
 * 
 * la clase ReunionVirtual hereda aspectos de Reunion, ya que esta es una forma mas especifica de esta ultima.
 * @see Reunion
 * 
 */

public class ReunionVirtual extends Reunion{
    /**
     * @param enlace es el link de Google Meet al que los empleados ingresaran.
     */
    private String enlace;

     /**
     * 
     * @param horaPrevista hora sugerida para que los empleados lleguen.
     * @param duracionPrevista tiempo estimado que durara la reunion.
     * @param tipoReunion tematica de la reunion (tecnica, de marketing u otra).
     * @param esPresencial revisa que la reunion no sea presencial.
     */
    public ReunionVirtual(Instant horaPrevista, Duration duracionPrevista, int tipoReunion, boolean esPresencial){
        super(horaPrevista,duracionPrevista,tipoReunion,esPresencial);

        /**
         * Asignacion del enlace al que los empleados ingresaran, asignando un codigo aleatorio a este.
         */
        this.enlace = "https://meet.google.com/" + new Random().nextInt(1000000)+ 100000;
    }


    /**
     * Metodos getter y setter de la sala en la que se va a realizar la reunion.
     */
    public String getLugar(){
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}