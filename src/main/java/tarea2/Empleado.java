package tarea2;

/**
 * Un empleado el cual es invitado a una reunion de la empresa en que trabaja.
 * 
 * @author Joseph Matamala, Dario Sepulveda, Felipe Tilleria
 * @since 9 de mayo de 2024
 * 
 *        El empleado esta relacionado con la interfaz invitable, por lo tanto
 *        este consigue el metodo invitar() que luego reemplaza.
 * @see Invitable
 * 
 */

public class Empleado implements Invitable {
    /**
     * Las caracteristicas que tiene cada empleado dentro de la empresa:
     * 
     * @param id           codigo de identificacion
     * @param nombre       nombre del empleado
     * @param apellidos    apellidos del empleado
     * @param correo       direccion de gmail del empleado
     * @param departamento area de trabajo del empleado dentro de su empresa
     * 
     * @param invitacion   es la invitacion que recibe el empleado a su reunion de
     *                     trabajo, la cual contiene
     *                     la sala o enlace; dependiendo de si es virtual o
     *                     presencial, el dia de reunion y la hora correspondiente.
     * 
     * @see Invitacion
     * 
     */
    private int id;
    private String nombre;
    private String apellidos;
    private String correo;
    private String departamento;
    private Invitacion invitacion;

    /**
     * El metodo constructor de empleado no contiene propiedades ya que estas se
     * tratan de forma externa.
     */
    public Empleado() {
    }

    /**
     * Metodos getter y setter para cada propiedad del empleado:
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellido(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /*
     * El metodo invitar añade al empleado a la lista de invitados de la reunion y
     * le entrega una referencia de la reunion al empleado dentro de su invitacion.
     */
    @Override
    public void invitar(Reunion r) {
        r.listaInvitados.add(id);
        this.invitacion = new Invitacion(r);
    }

    /**
     * Obtiene la invitacion del empleado.
     *
     * @return la invitacion.
     */
    public Invitacion getInvitacion() {
        return invitacion;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", departamento='" + departamento + '\'' +
                ", invitacion=" + invitacion +
                '}';
    }

}