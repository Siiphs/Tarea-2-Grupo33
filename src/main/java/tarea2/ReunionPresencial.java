package tarea2;

import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.time.*;

public class ReunionPresencial extends Reunion{
    private String sala;

    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, int tipoReunion, boolean esPresencial){
        
        super(fecha,horaPrevista,duracionPrevista,tipoReunion,esPresencial);
    }

    public String getSala(){
        return sala;
    }
    public void setSala(String sala){
        this.sala = sala;
    }

    
}