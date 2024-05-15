package tarea2;

import java.util.*;
import java.time.*;

/**
 * La reunion que se crea es la oficina o enlace de Google Meet principal con su
 * respectiva invitacion para que lleguen los empleados.
 * 
 * @author Felipe Tilleria, Dario Sepulveda, Joseph Matamala
 * @since 11 de mayo de 2024
 * 
 */
abstract class Reunion {
    /**
     * Cada reunion tiene las siguientes caracteristicas iniciales:
     * 
     * @param fecha            el dia en que se va a realizar
     * 
     * @param horaPrevista     la hora estimada en la que la reunion va a comenzar
     * 
     * @param duracionPrevista el tiempo estimado que deberia durar la reunion, con
     *                         esto tambien se obtiene su hora de termino estimada
     * 
     * @param asistencia       lugar en que se registran los empleados que
     *                         asistieron, ya sea a la hora o con un atraso
     * 
     *                         Y tambien cualidades que se pueden tomar una vez ha finalizado:
     * 
     * 
     * @param duracionReal     tiempo que la reunion duro
     * 
     * @param horaFin          hora a la que la reunion efectivamente termino
     * 
     * @param listaNotas       notas sobre la reunion que se tomaron a lo largo de
     *                         esta
     * 
     */
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista, duracionReal;
    private Instant horaInicio, horaFin = null;
    private Asistencia asistencia;
    private ArrayList<Nota> listaNotas;

    /**
     * @param listaInvitados contiene todos los empleados que estan invitados a la
     *                       reunion, segun su id dentro de la empresa
     * 
     * @param listaAusencias toma un registro de todos los empleados que no
     *                       asistieron a la reunion, una vez que esta haya
     *                       terminado
     */
    public ArrayList<Integer> listaInvitados, listaAusencias;

    /**
     * @param indice registra el numero de la sala en que una reunion presencial se
     *               puede llevar a cabo
     * 
     * @see ReunionPresencial
     */
    static long indice = 1;

    /**
     * Obtiene la fecha en que se realiza la reunion.
     *
     * @return el dia en que se realiza.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Obtiene la hora en la que la reunion deberia comenzar.
     *
     * @return la hora prevista.
     */
    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    /**
     * Metodo constructor de la reunion. En este se declara la hora en la que
     * deberia comenzar, el tiempo estimado que va a durar, la tematica de la
     * reunion y la modalidad (presencial o virtual).
     * 
     * @param horaPrevista     la hora estimada en la que la reunion va a comenzar
     * 
     * @param duracionPrevista el tiempo estimado que deberia durar la reunion, con
     *                         esto tambien se obtiene su hora de termino estimada
     * @param tipoReunion      tematica de la reunion, esta puede ser tecnica, de
     *                         marketing u otro tipo. Estos tipos son extraidos de
     *                         un enum con todas las tematicas que puede tener.
     * 
     * @param esPresencial     representa si la reunion sera presencial o, en caso
     *                         de ser falso, virtual.
     * 
     *                         Ademas de estos parametros, el constructor prepara
     *                         una lista de invitados para la reunion y otra de las
     *                         asistencias que tendra.
     * 
     * @see tipoReunion
     */
    public Reunion(Instant horaPrevista, Duration duracionPrevista, int tipoReunion, boolean esPresencial) {
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.fecha = Date.from(horaPrevista);

        listaInvitados = new ArrayList<Integer>();
        listaNotas = new ArrayList<Nota>();
        asistencia = new Asistencia(horaPrevista.toEpochMilli());
    }

    /**
     * Hace una simulacion de los empleados llegando a la reunion. Invita a todos
     * los empleados del departamento y les asigna un tiempo de llegada aleatorio.
     * Con esto podemos posteriormente llenar las listas de asistencias, atrasos y
     * ausencias.
     * 
     * @param listaInvitados contiene todos los empleados que estan invitados a la
     *                       reunion, segun su id dentro de la empresa
     * 
     */
    public void simularLlegada(ArrayList<Integer> listaInvitados) {
        listaAusencias = new ArrayList<Integer>(listaInvitados);
        Instant horaFin = horaInicio.plus(duracionPrevista);

        /**
         * Crea una instancia de una hora aleatoria a la que el empleado va a llegar.
         */
        InstanteAleatorio instanteAleatorio = new InstanteAleatorio();
        Instant RandInstant = instanteAleatorio.getRandInstant(horaInicio, duracionPrevista);

        /**
         * En este ciclo el metodo le asigna a cada empleado de la lista de invitados su
         * hora de llegada.
         * Inicialmente todos los empleados se encuentran ausentes, por lo tanto estos
         * se van quitando de la lista de ausencias conforme llegan a la reunion.
         * En el caso de que un empleado llegue despues de que la reunion haya
         * finalizado este metodo no hace nada (quiere decir, el empleado no es removido
         * de la lista de ausencias).
         */
        for (int i = 0; i < listaInvitados.size(); i++) {
            RandInstant = instanteAleatorio.getRandInstant(horaInicio, duracionPrevista);
            System.out.println(RandInstant);
            if (RandInstant.isBefore(horaInicio)) {
                asistencia.listaAsistencia.add(listaAusencias.remove(0));
            }

            else if (RandInstant.isBefore(horaFin)) {
                asistencia.listaAtrasos.add(listaAusencias.get(0));
                asistencia.listaAsistencia.add(listaAusencias.remove(0));

                Long retraso = RandInstant.toEpochMilli() - horaInicio.toEpochMilli();
                if (retraso > 0) {
                    Retraso r = new Retraso(retraso);
                }
            }
        }
    }

    /**
     * Metodo que consigue la lista de empleados que asistieron a la reunion.
     * 
     * @return la lista de empleados que asistieron, segun su identificacion.
     */
    public ArrayList<Integer> obtenerAsistencias() {
        return asistencia.listaAsistencia;
    }

    /**
     * Agrega una nota que se tomo en la reunion a la lista de notas escritas.
     * 
     * @param contenido contiene la informacion que se escribio.
     */

    public void agregarNota(String contenido) {
        Nota nota = new Nota(contenido);
        listaNotas.add(nota);
    }

    /**
     * Metodo que consigue la lista de notas de la reunion.
     * 
     * @return la lista de notas de la reunion.
     */
    public ArrayList<Nota> obtenerNotas() {
        return listaNotas;
    }

    /**
     * Metodo que consigue la lista de empleados que faltaron en la reunion.
     * 
     * @return la lista de empleados que quedaron ausentes, segun su identificacion.
     */
    public ArrayList<Integer> obtenerAusencias() {
        return listaAusencias;
    }

    /**
     * Metodo que consigue la lista de empleados que asistieron a la reunion pero
     * que llegaron con un retraso.
     * 
     * @return la lista de empleados que llegaron tarde a la reunion, segun su
     *         identificacion.
     */
    public ArrayList<Integer> obtenerRetrasos() {
        return asistencia.listaAtrasos;
    }

    /**
     * Metodo que consigue la cantidad de empleados que asistieron a la reunion.
     * 
     * @return el numero de empleados que asistieron.
     */
    public int obtenerTotalAsistencia() {
        return asistencia.listaAsistencia.size();
    }

    /**
     * Metodo que calcula el porcentaje de empleados que asistieron de la lista de
     * invitados completa.
     * Este valor lo deja en un numero flotante, 1 equivaliendo a que todos los
     * empleados asistieron.
     * 
     * @return ratio de empleados que llegaron a la reunion.
     */
    public float obtenerPorcentajeAsistencia() {
        return (float) ((float)asistencia.listaAsistencia.size() / (float)listaInvitados.size());
    }

    /**
     * Metodo que convierte la variable de tipo Duration duracionReal, a un numero
     * flotante (en minutos).
     * 
     * @return tiempo, en minutos, que duro la reunion.
     */
    public float calcularTiempoReal() {
        return (float) duracionReal.toMinutes();
    }

    /**
     * Metodo que inicia la reunion, quiere decir, le asigna un valor al tiempo de
     * inicio real.
     * 
     * @param horaInicio el momento en que la reunion realmente comienza.
     */
    public void iniciar() {
        this.horaInicio = Instant.now();
        
    }

    public Instant getHoraInicio(){
        return horaInicio;
    }

    public Instant getHoraFin(){
        return horaFin;
    }
    /**
     * Metodo que finaliza la reunion realizada.
     * Una vez finalizada se calcula el tiempo que duro con la hora de finalizacion.
     * Tambien se realiza la simulacion automatica de empleados ingresando a la
     * reunion, ya que para poder hacer esta se necesita la hora de finalizacion
     * real.
     */
    public void finalizar() {
        horaFin = Instant.now();
        duracionReal = Duration.between(horaInicio, horaFin);
        simularLlegada(listaInvitados);
    }

    /**
     * Plantilla para que la reunion presencial o virtual nos de su sala o enlace,
     * respectivamente.
     * 
     * @see ReunionPresencial
     * @see ReunionVirtual
     * 
     * @return la sala en la que la reunion tomara lugar o el enlace de Google Meet
     *         al que los empleados van a ingresar.
     */
    abstract String getLugar();
}