package tarea2;

import java.time.*;
import java.util.ArrayList;

class Asistencia{
    public ArrayList<Empleado> listaAsistencia = new ArrayList<Empleado>();
    public ArrayList<Empleado> listaAtrasos = new ArrayList<Empleado>();

    private Instant hora;
    public Asistencia(Instant hora){
        this.hora = hora;
    }
}