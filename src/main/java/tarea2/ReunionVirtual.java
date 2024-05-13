package tarea2;

import java.util.*;
import java.time.*;

public class ReunionVirtual extends Reunion{
    private String enlace;

    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, int tipoReunion, boolean esPresencial){
        
        super(fecha,horaPrevista,duracionPrevista,tipoReunion,esPresencial);
    }

    public String getLugar(){
        return enlace;
    }
    public void setEnlace(String enlace){
        this.enlace = enlace;
    }

    
}