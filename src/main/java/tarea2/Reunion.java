package tarea2;

import java.util.*;
import java.time.*;

abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista, duracionReal;
    private Instant horaInicio, horaFin = null;
    private Asistencia asistencia;

    
    
    public ArrayList<Integer> listaInvitados, listaAusencias;
    // public Object listaAsistencia;

    static long indice = 1;

    public Date getFecha() {
        return fecha;
    }

    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    public Reunion(Instant horaPrevista, Duration duracionPrevista, int tipoReunion, boolean esPresencial) {
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.fecha = Date.from(horaPrevista);

        listaInvitados = new ArrayList<Integer>();
        asistencia = new Asistencia(horaPrevista.toEpochMilli());
    }

    public void simularLlegada(ArrayList<Integer> listaInvitados) {
        listaAusencias = new ArrayList<Integer>(listaInvitados);
        Instant horaFin = horaInicio.plus(duracionReal);

        //prints 
        System.out.println("Hora de inicio: " + horaInicio);
        System.out.println("Hora de fin: " + horaFin + "\n");



        InstanteAleatorio instanteAleatorio = new InstanteAleatorio();
        Instant RandInstant = instanteAleatorio.getRandInstant(horaInicio, duracionPrevista);
        
        for (int i = 0; i < listaInvitados.size(); i++) {
            RandInstant = instanteAleatorio.getRandInstant(horaInicio, duracionPrevista);
            System.out.println(RandInstant);
            if (RandInstant.isBefore(horaInicio)) {
                asistencia.listaAsistencia.add(listaAusencias.remove(0));
            }

            else if (RandInstant.isBefore(horaFin)) {
                asistencia.listaAtrasos.add(listaAusencias.get(i));
                asistencia.listaAsistencia.add(listaAusencias.remove(0));

                Long retraso = RandInstant.toEpochMilli() - horaInicio.toEpochMilli();
                if (retraso > 0) {
                    Retraso r = new Retraso(retraso);
                }
            }
        }
    }

    public ArrayList obtenerAsistencias() {
        return asistencia.listaAsistencia;
    }

    // public void crearListaAusencias(){
    // ArrayList<Integer> listaAsistenciaId = new ArrayList<Integer>();

    // for(int i=0 ; i<listaInvitados.size() ; i++){
    // for(int j=0; j<asistencia.listaAsistencia.size() ; j++){
    // if(listaInvitados.get(i).intValue() ==
    // asistencia.listaAsistencia.get(j).getId()){
    // listaAsistenciaId.add(asistencia.listaAsistencia.get(j).getId());
    // }
    // }
    // }
    // for(int i=0 ; i<listaInvitados.size() ; i++){
    // if(!listaAsistenciaId.contains(listaInvitados.get(i))){
    // listaAusencias.add(listaInvitados.get(i));
    // }
    // }
    // }

    public ArrayList obtenerAusencias() {
        return listaAusencias;
    }

    public ArrayList obtenerRetrasos() {
        return asistencia.listaAtrasos;
    }

    public int obtenerTotalAsistencia() {
        return asistencia.listaAsistencia.size();
    }

    public float obtenerPorcentajeAsistencia() {
        return (float) (asistencia.listaAsistencia.size() / listaInvitados.size());
    }

    public float calcularTiempoReal() {
        return (float) duracionReal.toMinutes();
    }

    public void iniciar() {
        this.horaInicio = Instant.now();
    }

    public void finalizar() {
        horaFin = Instant.now();
        duracionReal = Duration.between(horaInicio, horaFin);
        simularLlegada(listaInvitados);
    }

    abstract String getLugar();
}

    