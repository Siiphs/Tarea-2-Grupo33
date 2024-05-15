package tarea2;
import java.time.*;
import java.util.*;
public class InstanteAleatorio {

    public InstanteAleatorio() { }
    
    public Instant getRandInstant(Instant horainicio, Duration duracionPrevista) {
        Instant horafin = horainicio.plus(duracionPrevista);
        long inicio = horainicio.toEpochMilli() - 1000 * 60 * 60 * 2;
        long fin = horafin.toEpochMilli() + 1000 * 60 * 30;
        Random r = new Random();
        long randomMillis = inicio + (long) (r.nextDouble() * (fin - inicio));
        Instant randomInstant = Instant.ofEpochMilli(randomMillis);
        return randomInstant;
    }
}