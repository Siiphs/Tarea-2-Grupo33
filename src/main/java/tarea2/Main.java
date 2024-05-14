package tarea2;

public class Main {
    public static void main(String[] args) {
        // Create an instance of Main
        Main mainInstance = new Main();

        // Create an instance of Departamento
        Departamento fdsa = mainInstance.new Departamento(6);
        Departamento fds = mainInstance.new Departamento(2);
        int size = Departamento.listaGeneral.size();
        System.out.println(size);
    }
}