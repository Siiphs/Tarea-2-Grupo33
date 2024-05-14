package tarea2;

import java.util.*;
import java.time.*;

abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista, duracionReal;
    private Instant horaInicio, horaFin = null;
    private Asistencia asistencia;
    private ArrayList<Nota> listaNotas;

    public ArrayList<Integer> listaInvitados, listaAusencias;

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

        listaAusencias = new ArrayList<Integer>();
        listaInvitados = new ArrayList<Integer>();
        asistencia = new Asistencia(horaPrevista.toEpochMilli());
    }

    public void simularLlegada(ArrayList<Integer> listaInvitados) {
        listaAusencias = listaInvitados;
        long horaLlegada = InstanteAleatorio.getRandInstant(horaInicio, duracionReal);

        for (int i = 0; i < listaInvitados.size(); i++) {
            if (horaLlegada < horaInicio.toEpochMilli()) {
                asistencia.listaAsistencia.add(listaAusencias.get(i));
                listaAusencias.remove(i);
            }

            else if (horaLlegada < (duracionReal.toMillis() + horaInicio.toEpochMilli())) {
                asistencia.listaAtrasos.add(listaAusencias.get(i));
                asistencia.listaAsistencia.add(listaAusencias.get(i));

                Long retraso = horaLlegada - horaInicio.toEpochMilli();
                if (retraso > 0) {
                    Retraso r = new Retraso(retraso);
                }
                listaAusencias.remove(i);
            }
        }
    }

    public ArrayList<Integer> obtenerAsistencias() {
        return asistencia.listaAsistencia;
    }

    public void agregarNota(String contenido) {
        Nota nota = new Nota(contenido);
        listaNotas.add(nota);
    }

    public ArrayList<Nota> obtenerNotas() {
        return listaNotas;
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

    public ArrayList<Integer> obtenerAusencias() {
        return listaAusencias;
    }

    public ArrayList<Integer> obtenerRetrasos() {
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