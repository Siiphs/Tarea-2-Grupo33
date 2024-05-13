package tarea2;

import java.util.*;
import java.time.*;

public class Invitacion {
    
    private Instant hora;
    private Date fecha;
    private String lugar;

    public Invitacion(Reunion r){
        this.hora = r.getHoraPrevista();
        this.fecha = r.getFecha();
        this.lugar = r.getLugar();
        /*if(r.getClass()==ReunionPresencial.class){
            this.lugar = r.getSala();
        }*/
        
    }

}
