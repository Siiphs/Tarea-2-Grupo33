package tarea2;

import java.util.*;
import java.time.*;

public class ReunionPresencial extends Reunion{
    private String sala;

    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, int tipoReunion, boolean esPresencial){
        
        super(fecha,horaPrevista,duracionPrevista,tipoReunion,esPresencial);
    }

    public String getLugar(){
        return sala;
    }
    public void setSala(String sala){
        this.sala = sala;
    }

    
}