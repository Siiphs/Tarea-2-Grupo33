package tarea2;

import java.util.*;
import java.time.*;

public class InstanteAleatorio {
    public InstanteAleatorio() {
    }

    static public long getRandInstant(Instant horaPrevista, Duration duracionPrevista) {
        Date dateInicio = Date.from(horaPrevista);
        Date dateFin = new Date(dateInicio.getTime() + duracionPrevista.toMillis() + (1000 * 60 * 30));
        long RandInstant = (long) (Math.random() * (dateFin.getTime() - dateInicio.getTime())) + dateInicio.getTime()
                - (1000 * 60 * 30);
        return RandInstant;
    }
}