package tarea2;

import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Departamento Qa = new Departamento(3);
        Departamento Dev = new Departamento(8);
        Departamento Marketing = new Departamento(5);


        // empleado print ejemplo
        System.out.println("\nNombre: " + Departamento.listaGeneral.get(0).getNombre() + " " + Departamento.listaGeneral.get(0).getApellido() + ", correo: " + Departamento.listaGeneral.get(0).getCorreo() + ", id: " + Departamento.listaGeneral.get(0).getId());
        
        // reunion presencial
        ReunionPresencial rp = new ReunionPresencial(Instant.parse("2024-05-13T23:05:55.088Z"), Duration.ofHours(1), 3, true);

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












    
        // Reunion rv = new ReunionVirtual(hola, Duration.ofHours(2), 2, false);

        // Departamento.listaGeneral.get(1).invitar(rv);

        // Invitacion invitacion2 = Departamento.listaGeneral.get(1).getInvitacion();

        // System.err.println(invitacion2.getHora());
        // System.err.println(invitacion2.getFecha());
        // System.err.println(invitacion2.getLugar());


        
    

    }
}