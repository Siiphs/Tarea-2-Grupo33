package tarea2;

import java.time.*;

public class Retraso extends Asistencia{
    private Instant hora;

    public Retraso(Instant hora){
        super(hora);
    }

    Instant getHora(){
        return hora;
    }

}