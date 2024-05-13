package tarea2;

import java.util.*;
import java.time.*;

abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio, horaFin;
    static int indice = 1;



    public Duration duracionReal;



    public Date getFecha(){
        return fecha;
    }
    public Instant getHoraPrevista(){
        return horaPrevista;
    }

    public ArrayList<Integer> listaInvitados = new ArrayList<Integer>();

    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, int tipoReunion, boolean esPresencial){
        if(esPresencial){
            ReunionPresencial rp = new ReunionPresencial(fecha,horaPrevista,duracionPrevista, tipoReunion, esPresencial);
            rp.setSala("Reunion " + indice);
            indice++;
            Invitacion invitacion = new Invitacion(rp);
        }
        else{
            ReunionVirtual rv = new ReunionVirtual(fecha, horaPrevista,duracionPrevista, tipoReunion, esPresencial);
            rv.setEnlace("https://meet.google.com/" + new Random().nextInt(1000000)+ 100000);
        }
    }

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
        this.horaInicio = Instant.now();

    }

    public void finalizar(){
        duracionReal = Duration.between(horaInicio,Instant.now());

    }

    abstract String getLugar();

}