package tarea2;

import java.time.*;
import java.util.ArrayList;

class Asistencia {
    public ArrayList<Integer> listaAsistencia = new ArrayList<Integer>();
    public ArrayList<Integer> listaAtrasos = new ArrayList<Integer>();

    private Long hora;

    public Asistencia(Long hora) {
        this.hora = hora;
    }
}