package tarea2;

import java.util.*;

public class Departamento implements Invitable {
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
            indice++;
            listaGeneral.add(e);
        }
    }

    public int obtenerCantidadDeEmpleados() {
        return lista.size();
    }

    public ArrayList<Empleado> getLista() {
        return lista;
    }

    @Override
    public void invitar(Reunion r) {
        for (int i = 0; i < lista.size(); i++) {
            r.listaInvitados.add(lista.get(i).getId());
            lista.get(i).invitar(r);
        }
    }
}