package tarea2;

/**
 * Una lista con nombres y apellidos comunes que pueden tener los empleados.
 * 
 * @author Felipe Tilleria
 * @since 12 de mayo de 2024
 * 
 */
import java.util.*;

public class ListaNombres {
    /**
     * @param nombres   es una lista estatica con nombres comunes que luego se
     *                  asignaran de forma aleatoria a cada empleado
     *                  de un Departamento.
     * 
     * @param apellidos igual que nombres.
     * 
     * @see Departamento
     */
    static ArrayList<String> nombres = new ArrayList<>(Arrays.asList(
            "Lucía", "Mateo", "Valentina", "Santiago", "Isabella", "Benjamín", "Camila", "Matías", "Sofía", "Sebastián",
            "Valeria", "Nicolás", "Martina", "Diego", "Florencia", "Daniel", "Antonia", "Joaquín", "Emma", "Felipe",
            "Agustina", "Tomás", "Catalina", "Andrés", "Isidora", "Gabriel", "Josefa", "Emilio", "Trinidad", "Juan",
            "Renata", "Pablo", "Constanza", "Alejandro", "María José", "Lucas", "Ignacia", "Hugo", "Valentín",
            "Francisca",
            "Rafael", "Isabel", "Vicente", "Carmen", "Maximiliano", "Paula", "Feliciano", "Josefina", "Bruno", "Amanda",
            "Eduardo", "Emilia", "Raúl", "Gabriela", "Gonzalo", "Daniela", "Miguel", "Carolina", "Fernando", "Laura",
            "Rodrigo", "Valentina", "Luis", "María", "Javier", "Ana", "Cristóbal", "Paulina", "Ángel", "Isidora",
            "Roberto", "Margarita", "Óscar", "Verónica", "Jorge", "Patricia", "Alberto", "Rosa", "Manuel", "Beatriz"));

    static ArrayList<String> apellidos = new ArrayList<>(Arrays.asList(
            "García", "Rodríguez", "Martínez", "López", "Hernández", "Pérez", "González", "Sánchez", "Ramírez",
            "Torres",
            "Flores", "Rivera", "Díaz", "Vargas", "Cruz", "Morales", "Ortiz", "Silva", "Rojas", "Reyes", "Mendoza",
            "Fernández", "Álvarez", "Jiménez", "Romero", "Chávez", "Gómez", "Ruiz", "Gutiérrez", "Núñez", "Herrera",
            "Castillo", "Cortés", "Acosta", "Guerrero", "Miranda", "Campos", "Vega", "Méndez", "Delgado", "Peralta",
            "Soto", "Guzmán", "Ramos", "Vásquez", "Castro", "Montes", "León", "Cabrera", "Peña", "Carrillo", "Aguilar",
            "Bautista", "Escobar", "Navarro", "Solís", "Pacheco", "Castañeda", "Valenzuela", "Cervantes", "Villanueva",
            "Cordero", "Barrera", "Salazar", "Cárdenas", "Cáceres", "Cano", "Cuevas", "Cisneros", "Villalobos", "Lara",
            "Castaño", "Córdova", "Carranza", "Cádiz", "Cabello", "Cepeda", "Castañón", "Carrasco", "Cavazos",
            "Cedillo",
            "Cervantes", "Villanueva", "Cordero", "Barrera", "Salazar", "Cárdenas", "Cáceres", "Cano", "Cuevas",
            "Cisneros",
            "Villalobos", "Lara", "Castaño", "Córdova", "Carranza", "Cádiz", "Cabello", "Cepeda", "Castañón",
            "Carrasco",
            "Cavazos", "Cedillo", "Cervantes", "Villanueva", "Cordero", "Barrera", "Salazar", "Cárdenas", "Cáceres",
            "Cano"));

    /**
     * El constructor de la clase no necesita argumentos ya que esta lista se
     * mantiene constante
     * en el funcionamiento del programa.
     */
    public ListaNombres() {
    }

    /**
     * Obtiene un nombre aleatorio haciendo uso de la biblioteca de java Math.
     *
     * @return un nombre aleatorio.
     */
    public static String getNombre() {
        return nombres.get((int) (Math.random() * nombres.size()));
    }

    /**
     * Obtiene un apellido aleatorio haciendo uso de la biblioteca de java Math.
     *
     * @return un apellido aleatorio.
     */
    public static String getApellido() {
        return apellidos.get((int) (Math.random() * apellidos.size()));
    }

}
