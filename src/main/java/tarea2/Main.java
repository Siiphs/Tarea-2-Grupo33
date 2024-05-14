package tarea2;

import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args) {

        Departamento Qa = new Departamento(3);
        Departamento Dev = new Departamento(8);
        Departamento Marketing = new Departamento(5);

        Instant hola = Instant.parse("2024-05-13T23:05:55.088Z");

        // int size = Departamento.listaGeneral.size();
        System.out.println("Nombre: " + Departamento.listaGeneral.get(0).getNombre() + " "
                + Departamento.listaGeneral.get(0).getApellido() + ", correo: "
                + Departamento.listaGeneral.get(0).getCorreo() + ", id: " + Departamento.listaGeneral.get(0).getId());
        Reunion rp = new ReunionPresencial(hola, Duration.ofHours(1), 3, true);

        Departamento.listaGeneral.get(0).invitar(rp);

        Invitacion invitacion = Departamento.listaGeneral.get(0).getInvitacion();

        System.err.println(invitacion.getHora());
        System.err.println(invitacion.getFecha());
        System.err.println(invitacion.getLugar());

        Reunion rv = new ReunionVirtual(hola, Duration.ofHours(2), 2, false);

        Dev.invitar(rv);

        rv.iniciar();
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
            System.out.println("Ausente: " + Departamento.listaGeneral.get(rv.listaAusencias.get(i)).getNombre() + " "
                    + Departamento.listaGeneral.get(rv.listaAusencias.get(i)).getApellido());

        }
    }
}