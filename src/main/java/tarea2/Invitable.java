package tarea2;

/**
 * La interfaz Invitable nos permite poder invitar a empleados y departamentos
 * completos
 * a una reunion.
 * 
 * @author Dario Sepulveda
 * @since 11 de mayo de 2024
 * 
 * 
 */

public interface Invitable {
    /**
     * El metodo abstracto invitar se reemplaza mas tarde en las clases de Empleado
     * y Departamento.
     * 
     * @see Empleado
     * @see Departamento
     */
    public void invitar(Reunion r);
}
