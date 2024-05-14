package tarea2;

import java.time.*;

public class Retraso extends Asistencia {
    private Long hora;

    public Retraso(Long hora) {
        super(hora);
    }

    Long getMinutos() {
        return hora / 1000 / 60;
    }
}