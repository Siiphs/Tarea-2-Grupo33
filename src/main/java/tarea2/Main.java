package tarea2;

import java.util.*;
import java.io.*;
import java.time.*;

public class Main {
    public static void main(String[] args) {

        //para colores de titulos
        final String ANSI_ORANGE = "\u001B[38;2;255;165;0m";
        final String ANSI_RESET = "\u001B[0m";

        Departamento Qa = new Departamento(3);
        Departamento Dev = new Departamento(8);
        Departamento Marketing = new Departamento(5);

        Instant hola = Instant.parse("2024-05-13T23:05:55.088Z");


        System.out.println(ANSI_ORANGE + "\n  \u001B[3m" + "Todos los invitados \n" + ANSI_RESET);

        for (int i = 0; i < Departamento.listaGeneral.size(); i++) {
            System.out.println("      Nombre: " + Departamento.listaGeneral.get(i).getNombre() + " "
                    + Departamento.listaGeneral.get(i).getApellido() + ", correo: "
                    + Departamento.listaGeneral.get(i).getCorreo() + ", id: " + Departamento.listaGeneral.get(i).getId());
        } System.out.println("\n");

        
        Reunion rp = new ReunionPresencial(Instant.now(), Duration.ofHours(1), 3, true);

        Departamento.listaGeneral.get(0).invitar(rp);

        Invitacion invitacion = Departamento.listaGeneral.get(0).getInvitacion();

        System.out.println(ANSI_ORANGE + "\n  \u001B[3m" + "Invitacion \n" + ANSI_RESET);
        // System.err.println(invitacion.getHora());
        System.err.println("      Hora:  " + invitacion.getFecha());
        System.err.println("      Lugar: " + invitacion.getLugar() + "\n\n");

        Reunion rv = new ReunionVirtual(hola, Duration.ofHours(1), 2, false);

        Dev.invitar(rv);
        

        rv.iniciar();

        System.out.println("lista de invitados a la reunion virtual: " + rv.listaInvitados.size()+ "\n");

        rv.finalizar();

        
        System.out.println(ANSI_ORANGE + "\n  \u001B[3m" + "Lista de ausencias: " + rv.listaAusencias.size() + ANSI_RESET + "\n");
        for (int i = 0; i < rv.listaAusencias.size(); i++) {
            System.out.println((i+1) + ".  id: " + rv.listaAusencias.get(i) + ", Ausente: " + Departamento.listaGeneral.get(rv.listaAusencias.get(i)).getNombre() + " "
            + Departamento.listaGeneral.get(rv.listaAusencias.get(i)).getApellido());
        }

        System.out.println(ANSI_ORANGE + "\n  \u001B[3m" + "Lista de asistencias: " + rv.obtenerAsistencias().size() + ANSI_RESET + "\n");

        
        for (int i = 0; i < rv.obtenerAsistencias().size(); i++) {
            System.out.println((i+1) + ".  id: " + rv.obtenerAsistencias().get(i) + ", Asistente: " + Departamento.listaGeneral.get(rv.obtenerAsistencias().get(i)).getNombre() + " "
            + Departamento.listaGeneral.get(rv.obtenerAsistencias().get(i)).getApellido());
        }

        System.out.println(ANSI_ORANGE + "\n  \u001B[3m" + "Lista de retrasos: " + rv.obtenerRetrasos().size() + ANSI_RESET + "\n");

        for (int i = 0; i < rv.obtenerRetrasos().size(); i++) {
            System.out.println((i+1) + ".  id: " + rv.obtenerRetrasos().get(i) + ", Restrasado: " + Departamento.listaGeneral.get(rv.obtenerRetrasos().get(i)).getNombre() + " "
            + Departamento.listaGeneral.get(rv.obtenerRetrasos().get(i)).getApellido());
        }
    }
}