package tarea2;

/**
 * El enum tipoReunion representa las distintas tematicas que puede tener una reunion.
 * 
 * @author Dario Sepulveda
 * @since 11 de mayo de 2024
 * 
 *        
 */

public enum tipoReunion {
    TECNICA(1),
    MARKETING(2),
    OTRO(3);

    private int cualReunion;
    /**
     * Constructor privado para inicializar el tipo de reunion.
     *
     * @param cualReunion El identificador de la reunion.
     */
    private tipoReunion(int cualReunion) {
        this.cualReunion = cualReunion;
    }

    /**
     * Obtiene el tipo de reunion.
     *
     * @return El tipo de reunion.
     */
    public int getCualReunion(){
        return cualReunion;
    }
}