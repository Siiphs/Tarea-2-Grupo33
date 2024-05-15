package tarea2;

/**
 * Una nota que se puede tomar en algun momento de la reunion.
 * Esta quedara guardada en la lista de todas las notas que hayan sido tomadas.
 * 
 * @author Joseph Matamala
 * @since 12 de mayo de 2024
 * 
 * @param contenido informacion que contiene la nota escrita.
 */

public class Nota {
    private String contenido;

    public Nota(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene el contenido que guarda la nota escrita.
     *
     * @return la informacion de la nota.
     */
    public String getContenido() {
        return contenido;
    }
}