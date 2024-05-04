import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private String nombre;
    private String tipo; // Estudiante, Profesor, Personal de la Biblioteca
    private List<Libro> historialPrestamos;
    private List<Libro> librosReservados;
    private List<Integer> calificaciones;

    private String contraseña;

    Scanner teclado = new Scanner(System.in);
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

    public Libro buscarLibroPorTitulo(Biblioteca biblioteca){
        System.out.println("Ingrese el nombre del titulo que desea buscar: ");
        String tituloLibro = teclado.nextLine();
        for (Libro libro: biblioteca.getLibros()){
            if (libro.getTitulo().equals(tituloLibro)){
                System.out.println(libro);
                return libro;
            }
        }
        return null;
    }
    public void buscarLibroPorAutor(Biblioteca biblioteca){
        System.out.println("Ingrese el nombre del autor que desea buscar: ");
        String nombreAutor = teclado.nextLine();
        for (Libro libro: biblioteca.getLibros()){
            if (libro.getAutor().equals(nombreAutor)){
                System.out.println(libro);
            }
        }
    }
    public void buscarLibroPorCategoria(Biblioteca biblioteca){
        System.out.println("Ingrese el nombre por categoria que desea buscar: ");
        String nombreLibroCategoria = teclado.nextLine();
        for (Libro libro: biblioteca.getLibros()){
            if (libro.getCategoria().equals(nombreLibroCategoria)){
                System.out.println(libro);
            }
        }
    }

    public void buscarLibroPorMejorValoracion(Biblioteca biblioteca){
        System.out.println("Ingrese valoracion de libro: (Mejor)");
        int mejorValoracionLibro = teclado.nextInt();
        for (Libro libro : biblioteca.getLibros()){
            //colocar logica
            }
        }



    public void buscarLibroPorPeorValoracion(){

    }

    public void buscarLibroPorMasLLevado(){


    }



    public void solicitarPrestamoLibro(Biblioteca biblioteca){
        Libro libro = buscarLibroPorTitulo(biblioteca);

        if (libro.getEjemplaresDisponibles()>0){
            librosReservados.add(libro);
            libro.setEjemplaresDisponibles(libro.getEjemplaresDisponibles()-1);
            historialPrestamos.add(libro);

        }else {
            System.out.println("Libro no disponible ["+libro+"]");
        }

    }

    public void verDisponibilidadLibro(Biblioteca biblioteca){
        Libro libro = buscarLibroPorTitulo(biblioteca);
        if (libro.getEjemplaresDisponibles()>0){
            System.out.println("Se encuentra disponible el libro ["+libro+"]");
        }
    }
    public void renovarPrestamo(){

    }
    public void devolverLibro(Biblioteca biblioteca){
        System.out.println("Ingrese el nombre del libro");
        String nombreLibro = teclado.nextLine();
        for (Libro libro: librosReservados){
            if (libro.getTitulo().equals(nombreLibro)){
                for (Libro libroBiblioteca: biblioteca.getLibros()){
                    if (libroBiblioteca.getTitulo().equals(nombreLibro)){
                        libroBiblioteca.setEjemplaresDisponibles(libro.getEjemplaresDisponibles()+1);
                        librosReservados.remove(libro);
                    }
                }
            }
        }


    }
    public void verHistorialDePrestamos(Biblioteca biblioteca){
        historialPrestamos.forEach(System.out::println);
    }


    @Override
    public String toString() {
        return "Nombre= " + nombre+ " | Tipo= " + tipo + " | Contraseña= " + contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }
}


