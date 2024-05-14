package tarea2;

import java.util.*;
import java.time.*;

public class ReunionPresencial extends Reunion{
    private String sala;

    public ReunionPresencial(Instant horaPrevista, Duration duracionPrevista, int tipoReunion, boolean esPresencial){
        super(horaPrevista,duracionPrevista,tipoReunion,esPresencial);
        
        this.sala = "Sala " + indice;
        indice++;
    }

    public String getLugar(){
        return sala;
    }
    public void setSala(String sala){
        this.sala = sala;
    }

    
}