import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String tipo; // Estudiante, Profesor, Personal de la Biblioteca
    private List<Libro> historialPrestamos;
    private List<Libro> librosReservados;
    private List<Integer> calificaciones;

    private String contraseña;

    public Usuario(String nombre, String tipo, String contraseña) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.contraseña= contraseña;
        this.historialPrestamos = new ArrayList<>();
        this.librosReservados = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }

    public void agregarPrestamo(Libro libro) {
        historialPrestamos.add(libro);
    }

    public void realizarReserva(Libro libro) {
        librosReservados.add(libro);
    }

    public void agregarCalificacion(int calificacion) {
        calificaciones.add(calificacion);
    }


    /*

    - Buscar libros
    - solicitar prestamo
    - Renovar Prestamo
    - Devolver Libro

     */




    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }
}


