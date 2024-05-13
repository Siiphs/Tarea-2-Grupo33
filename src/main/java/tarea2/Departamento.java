package tarea2;

import java.util.*;
public class Departamento {
    private String nombre;
    private ArrayList<Empleado> lista;
    static ArrayList<Empleado> listaGeneral = new ArrayList<Empleado>();
    static int indice = 0;

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
            indice += 1;
            listaGeneral.add(e);
        }
    }

    public int obtenerCantidadDeEmpleados() {
        return lista.size();
    }
}