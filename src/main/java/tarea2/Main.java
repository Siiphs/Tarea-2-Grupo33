package tarea2;

import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //para colores de titulos
        final String ANSI_ORANGE = "\u001B[38;2;255;165;0m";
        final String ANSI_RESET = "\u001B[0m";

        Departamento Qa = new Departamento(3);
        Departamento Dev = new Departamento(8);
        Departamento Marketing = new Departamento(5);

        // Instant hola = Instant.parse("2024-05-13T23:05:55.088Z");


        System.out.println(ANSI_ORANGE + "\u001B[3m" + "Todos los invitados" + ANSI_RESET);
        System.out.println("\n      Nombre: " + Departamento.listaGeneral.get(0).getNombre() + " "
                + Departamento.listaGeneral.get(0).getApellido() + ", correo: "
                + Departamento.listaGeneral.get(0).getCorreo() + ", id: " + Departamento.listaGeneral.get(0).getId() + "\n");

        Reunion rp = new ReunionPresencial(Instant.now(), Duration.ofHours(1), 3, true);

        // invitar a un empleado
        Departamento.listaGeneral.get(0).invitar(rp);

        // obtener invitacion
        System.out.println( "\n \033[38;5;208mInvitación a la Reunión Presencial\033[0m \n");
        Invitacion invitacion = Departamento.listaGeneral.get(0).getInvitacion();
        System.err.println("    Hora:   " + invitacion.getHora());
        System.err.println("    Fecha:  " + invitacion.getFecha());
        System.err.println("    Lugar:  " + invitacion.getLugar());


        //Empleados que llegaron antes de la reunion    

        //inciar reunion
        rp.iniciar();

        Thread.sleep(10000 * 3);
        
        //finalizar reunion
        rp.finalizar();

        //duración de la reunion
        System.out.println("\n \033[38;5;208mHoraciones de la Reunión Presencial\033[0m \n");
        System.out.println("    Hora inicio de la reunion:  " + rp.getHoraInicio());
        System.out.println("    Hora fin de la reunion:     " + rp.getHoraFin());
        System.out.println("    Duración de la reunión:     " + rp.getDuracionReal());












        // System.err.println(invitacion.getHora());
        System.err.println("Hora: " + invitacion.getFecha());
        System.err.println("Lugar: " + invitacion.getLugar() + "\n");

        Reunion rv = new ReunionVirtual(Instant.now(), Duration.ofHours(1), 2, false);

        Dev.invitar(rv);
        

        rv.iniciar();

        System.out.println("lista de invitados a la reunion virtual: " + rv.listaInvitados.size()+ "\n");

        rv.finalizar();
        
        System.out.println("\n lista de ausencias: " + rv.listaAusencias.size() + "\n");

        // for(int i = 0; i < rv.obtenerAsistencias().size(); i++){
        // System.out.println("Asistencia: " +
        // Departamento.listaGeneral.get(rv.obtenerAsistencias().get(i)).getNombre() + "
        // " +
        // Departamento.listaGeneral.get(rv.obtenerAsistencias().get(i)).getApellido());
        // }

        // for(int i = 0; i < rv.obtenerRetrasos().size(); i++){
        // System.out.println("Retraso: " +
        // Departamento.listaGeneral.get(rv.obtenerRetrasos().get(i)).getNombre() + " "
        // + Departamento.listaGeneral.get(rv.obtenerRetrasos().get(i)).getApellido());
        // }
        
        for (int i = 0; i < rv.listaAusencias.size(); i++) {
            System.out.println((i+1) + ".  id: " + rv.listaAusencias.get(i) + ", Ausente: " + Departamento.listaGeneral.get(rv.listaAusencias.get(i)).getNombre() + " "
            + Departamento.listaGeneral.get(rv.listaAusencias.get(i)).getApellido());

        }
    }
}