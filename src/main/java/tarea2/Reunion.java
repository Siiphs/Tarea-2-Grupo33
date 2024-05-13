package tarea2;

import java.util.*;
import java.time.*;

abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio, horaFin = null;
    static int indice = 1;



    public Duration duracionReal;
    Asistencia asistencia = new Asistencia(horaPrevista);


    public Date getFecha(){
        return fecha;
    }
    public Instant getHoraPrevista(){
        return horaPrevista;
    }

    public ArrayList<Integer> listaInvitados = new ArrayList<Integer>();
    public ArrayList<Integer> listaAusencias = new ArrayList<Integer>();
    

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
            Invitacion invitacion = new Invitacion(rv);
        }
    }
    
    public void entraEmpleado(Empleado e){
        if(horaFin==null){
            asistencia.listaAsistencia.add(e);
            if(horaInicio.compareTo(Instant.now())<0){
                asistencia.listaAtrasos.add(e);
            }
        }
    }

    public List obtenerAsistencias(){
        return asistencia.listaAsistencia;
    }

    public void crearListaAusencias(){
        ArrayList<Integer> listaAsistenciaId = new ArrayList<Integer>();

        for(int i=0 ; i<listaInvitados.size() ; i++){
            for(int j=0; j<asistencia.listaAsistencia.size() ; j++){
                if(listaInvitados.get(i).intValue() == asistencia.listaAsistencia.get(j).getId()){
                    listaAsistenciaId.add(asistencia.listaAsistencia.get(j).getId());
                }
            }
        }
        for(int i=0 ; i<listaInvitados.size() ; i++){
            if(!listaAsistenciaId.contains(listaInvitados.get(i))){
                listaAusencias.add(listaInvitados.get(i));
            }
        }
    }
    
    public List obtenerAusencias(){
        return listaAusencias;
    }

    public List obtenerRetrasos(){
        return asistencia.listaAtrasos;
    }

    public int obtenerTotalAsistencia(){
        return asistencia.listaAsistencia.size();
    }
    public float obtenerPorcentajeAsistencia(){
        return (float) (asistencia.listaAsistencia.size()/listaInvitados.size());
    }

    public float calcularTiempoReal(){
        return (float) duracionReal.toMinutes();
    }

    public void iniciar(){
        this.horaInicio = Instant.now();

    }

    public void finalizar(){
        horaFin = Instant.now();
        duracionReal = Duration.between(horaInicio,horaFin);

    }

    abstract String getLugar();

}