package tarea2;

import java.util.*;
import java.time.*;

/**
 * Una invitacion a la reunion de trabajo creada.
 * 
 * @author Dario Sepulveda
 * @since 11 de mayo de 2024
 */

public class Invitacion {
    /**
     * Datos relevantes de la invitacion para que el empleado o departamento sepa
     * como llegar.
     * 
     * @param hora  hora en la que se va a realizar.
     * 
     * @param fecha dia de la reunion.
     * 
     * @param lugar enlace a la reunion o la oficina en que se va a efectuar,
     *              dependiendo de si esta es una reunion virtual o una presencial.
     */

    private Instant hora;
    private Date fecha;
    private String lugar;

    /**
     * El metodo constructor de invitacion recibe la reunion a la cual se invita y
     * de esta obtiene la informacion de contacto.
     * 
     * @param r reunion correspondiente a la invitacion.
     */
    public Invitacion(Reunion r) {
        this.hora = r.getHoraPrevista();
        this.fecha = r.getFecha();
        this.lugar = r.getLugar();

    }

    /**
     * Metodos getter de los datos de la invitacion.
     * 
     * @return hora, dia y lugar en los que se va a realizar la reunion.
     * 
     */
    public Instant getHora() {
        return hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    @Override
    public String toString() {
        return "Invitacion{" +
                "hora=" + hora +
                ", fecha=" + fecha +
                ", lugar='" + lugar + '\'' +
                '}';
    }

}   