package tarea2;

public enum tipoReunion {
    TECNICA(1),
    MARKETING(2),
    OTRO(3);

    private int cualReunion;

    private tipoReunion(int cualReunion) {
        this.cualReunion = cualReunion;
    }

    public int getCualReuniion() {
        return cualReunion;
    }
}