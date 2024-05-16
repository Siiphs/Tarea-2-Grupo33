package tarea2;

import java.time.*;

/**
 * El metodo Main es usado para hacer pruebas del funcionamiento de reuniones,
 * sumado a los tests realizados en las respectivas pruebas unitarias.
 * 
 * @author Felipe Tilleria, Joseph Matamala
 * @since 12 de mayo de 2024
 */

public class Main {
    public static void main(String[] args) throws Exception{
        try{
                /**
                 * Strings para colorear las pruebas realizadas.
                 */
                final String ANSI_ORANGE = "\u001B[38;2;255;165;0m";
                final String ANSI_RESET = "\u001B[0m";

                //Departamento Qa = new Departamento(-8);
                
                Departamento Dev = new Departamento(8);

                Instant ejemploInicio = Instant.parse("2024-05-13T23:05:55.088Z");

                System.out.println(ANSI_ORANGE + "\n  \u001B[3m" + "Todos los invitados \n" + ANSI_RESET);

                for (int i = 0; i < Departamento.listaGeneral.size(); i++) {
                System.out.println("Nombre: " + Departamento.listaGeneral.get(i).getNombre() + " "
                        + Departamento.listaGeneral.get(i).getApellidos() + ", correo: "
                        + Departamento.listaGeneral.get(i).getCorreo() + ", id: "
                        + Departamento.listaGeneral.get(i).getId());
                }
                System.out.println("\n");

                Reunion rp = new ReunionPresencial(Instant.now(), Duration.ofHours(1), tipoReunion.OTRO.getCualReunion(), true);

                Departamento.listaGeneral.get(0).invitar(rp);

                Invitacion invitacion = Departamento.listaGeneral.get(0).getInvitacion();

                System.out.println(ANSI_ORANGE + "\n  \u001B[3m" + "Invitacion \n" + ANSI_RESET);
                System.err.println("Hora:  " + invitacion.getFecha());
                System.err.println("Lugar: " + invitacion.getLugar() + "\n\n");

                Reunion rv = new ReunionVirtual(ejemploInicio, Duration.ofHours(1), tipoReunion.MARKETING.getCualReunion(), false);

                Dev.invitar(rv);

                rv.iniciar();

                // Nota nota = new Nota();
                rv.agregarNota("Nota escrita en la reunión");
                rv.agregarNota("otra nota");
                rv.agregarNota("tercera nota");

                System.out.println(ANSI_ORANGE +"lista de invitados a la reunion virtual: " + rv.listaInvitados.size() + ANSI_RESET + "\n");

                rv.finalizar();

                System.out.println(
                        ANSI_ORANGE + "\n  \u001B[3m" + "Lista de ausencias: " + rv.listaAusencias.size() + ANSI_RESET + "\n");
                for (int i = 0; i < rv.listaAusencias.size(); i++) {
                System.out.println((i + 1) + ".  id: " + rv.listaAusencias.get(i) + ", Ausente: "
                        + Departamento.listaGeneral.get(rv.listaAusencias.get(i)).getNombre() + " "
                        + Departamento.listaGeneral.get(rv.listaAusencias.get(i)).getApellidos());
                }

                System.out.println(ANSI_ORANGE + "\n  \u001B[3m" + "Lista de asistencias: " + rv.obtenerAsistencias().size()
                        + ANSI_RESET + "\n");

                for (int i = 0; i < rv.obtenerAsistencias().size(); i++) {
                System.out.println((i + 1) + ".  id: " + rv.obtenerAsistencias().get(i) + ", Asistente: "
                        + Departamento.listaGeneral.get(rv.obtenerAsistencias().get(i)).getNombre() + " "
                        + Departamento.listaGeneral.get(rv.obtenerAsistencias().get(i)).getApellidos());
                }

                System.out.println(ANSI_ORANGE + "\n  \u001B[3m" + "Lista de retrasos: " + rv.obtenerRetrasos().size()
                        + ANSI_RESET + "\n");

                for (int i = 0; i < rv.obtenerRetrasos().size(); i++) {
                System.out.println((i + 1) + ".  id: " + rv.obtenerRetrasos().get(i) + ", Restrasado: "
                        + Departamento.listaGeneral.get(rv.obtenerRetrasos().get(i)).getNombre() + " "
                        + Departamento.listaGeneral.get(rv.obtenerRetrasos().get(i)).getApellidos());
                }

                System.out.println(ANSI_ORANGE + "\n  \u001B[3m" + "Porcentaje de asistencia: " + rv.obtenerPorcentajeAsistencia() * 100 + "%" + ANSI_RESET + "\n");
                
                // generar informe
                GenerarTxt.crearInforme(invitacion, rv);
        } catch(Exception e){
                System.out.println(e.getMessage());
        }
        
        
        
        



        
        }
}