package tarea2;

import java.util.*;
import java.time.*;

public class ReunionVirtual extends Reunion{
    private String enlace;

    public ReunionVirtual(Instant horaPrevista, Duration duracionPrevista, int tipoReunion, boolean esPresencial){
        super(horaPrevista,duracionPrevista,tipoReunion,esPresencial);
        this.enlace = "https://meet.google.com/" + new Random().nextInt(1000000)+ 100000;
    }

    public String getLugar(){
        return enlace;
    }
    public void setEnlace(String enlace){
        this.enlace = enlace;
    }

    
}