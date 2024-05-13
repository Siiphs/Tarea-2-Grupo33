package tarea2;
import java.util.ArrayList;

 public class Departamento{
        private String nombre;
        private ArrayList<Empleado> lista;
        static ArrayList<Empleado> listaGeneral = new ArrayList<Empleado>();
        static int indice = 0;

        public Departamento(int cantidad) {
            lista = new ArrayList<Empleado>();

            for (int i = 0; i < cantidad; i++) {
                Empleado e = new Empleado();
                e.setId(indice);
                e.setNombre(nombre); // You need to set a valid name here
                e.setApellido("a");
                e.setCorreo(nombre + "a" + "@gmail.com");
                e.setDepartamento(this.nombre);

                lista.add(e);
                indice += 1;
                listaGeneral.add(e);
            }
        }

        public int obtenerCantidadEmpleados() {
            return lista.size();
        }
    }
