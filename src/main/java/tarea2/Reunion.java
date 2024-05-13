package tarea2;

import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.time.*;

abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio, horaFin;

    public ArrayList<Integer> listaInvitados = new ArrayList<Integer>();

    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, int tipoReunion, boolean esPresencial){
        if(esPresencial){
            ReunionPresencial rp = new ReunionPresencial(fecha,horaPrevista,duracionPrevista, tipoReunion, esPresencial);
            rp.setSala("nombre de sala");
            Invitacion invitacion = new Invitacion(rp);


        }
        else{
            ReunionVirtual rv = new ReunionVirtual();
            rv.setEnlace("nombre de enlace");
        }
    }
    //private Nota n = new Nota;
    //private Asistencia as = new Asistencia;
    //
    public List obtenerAsistencias(){

    }

    public List obtenerAusencias(){

    }
    public List obtenerRetrasos(){

    }

    public int obtenerTotalAsistencia(){

    }
    public float obtenerPorcentajeAsistencia(){

    }

    public float calcularTiempoReal(){

    }

    public void iniciar(){

    }

    public void finalizar(){

    }

}