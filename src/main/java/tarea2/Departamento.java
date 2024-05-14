package tarea2;

import java.util.*;

/**
 * El Departamento es el conjunto de empleados de la emrpesa que trabajan en una misma area.
 * 
 * @author Joseph Matamala, Felipe Tilleria
 * 
 * @since 11 de mayo de 2024
 * 
 * El Departamento esta relacionado con la interfaz invitable, por lo tanto
 * este consigue el metodo invitar() que luego reemplaza.
 * @see Invitable
 * 
 */
public class Departamento implements Invitable{
    /**
     * Las caracteristicas que tiene cada departamento:
     * @param nombre el area del que el departamento esta encargado.
     * @param lista los empleados que tiene cada departamento.
     */
    private String nombre;
    private ArrayList<Empleado> lista;

    /**
     * @param listaGeneral es una lista con todos los empleados que existen en el momento actual.
     */
    static ArrayList<Empleado> listaGeneral = new ArrayList<Empleado>();
    static int indice = 0;

    /**
     * El metodo constructor de Departamento recibe la cantidad de empleados que tendra asignado para luego asignar un nombre, correo y apellido aleatorios.
     * @param cantidad corresponde a la cantidad de empleados del departamento.
     * @param indice asigna una id a cada empleado de forma incremental.
     * 
     */
    public Departamento(int cantidad) {
        lista = new ArrayList<Empleado>();

        for (int i = 0; i < cantidad; i++) {
            Empleado e = new Empleado();
            String n = ListaNombres.getNombre();
            String a = ListaNombres.getApellido();
            e.setId(indice);
            e.setNombre(n);
            e.setApellido(a);
            e.setCorreo(n + a + "@gmail.com");
            e.setDepartamento(this.nombre);

            lista.add(e);
            indice ++;
            listaGeneral.add(e);
        }
    }

    /**
     * Metodo que retorna la cantidad de empleados de un departamento, ya que la variable local cantidad es luego perdida.
     * 
     * @return cantidad de empleados que trabajan en el departamento.
     */
    public int obtenerCantidadDeEmpleados() {
        return lista.size();
    }

    /**
     * El metodo invitar añade a cada empleado de la lista de empleados del departamento a la lista de invitados de la reunion, y a este le entrega una invitacion con referencia a la reunion dicha.
     */
    @Override
    public void invitar(Reunion r){
        for(int i = 0; i < lista.size(); i++){
            r.listaInvitados.add(lista.get(i).getId());
            Invitacion invitacion = new Invitacion(r);
        }
    }
}