
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrador {

    static Scanner sc = new Scanner(System.in);

    private Biblioteca biblioteca;
    private final List<Libro> libros = new ArrayList<>();
    public Administrador(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void menuAdmin(){
    //....

    }
    public void ingresarLibros() {

        System.out.println("Ingrese el número de libros que desea ingresar:");
        int cantidadLibros = sc.nextInt();

        for (int i = 0; i < cantidadLibros; i++) {
            System.out.println("Ingrese el título del libro:");
            String titulo = sc.next();
            System.out.println("Ingrese el autor del libro:");
            String autor = sc.next();
            System.out.println("Ingrese la categoría del libro:");
            String categoria = sc.next();
            System.out.println("Ingrese la cantidad disponible del libro:");
            int cantidad = sc.nextInt();


            libros.add(new Libro(titulo, autor, categoria, cantidad));
        }
        agregarLibros(libros);
    }

    public void agregarLibros(List<Libro> libros) {

        for (Libro libro : libros) {
            this.biblioteca.addLibros(libro);
        }
        System.out.println("Libros ingresados exitosamente a la biblioteca.");
    }


    public void eliminarLibro(Biblioteca biblioteca, String tituloLibro) {
        boolean encontrado = false;
        for (int i = 0; i < biblioteca.getLibros().size(); i++) {
            Libro libro = (Libro) biblioteca.getLibros().get(i);
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                biblioteca.getLibros().remove(i);
                System.out.println("Libro eliminado exitosamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El libro no fue encontrado en la biblioteca.");
        }
    }

    public void modificarInformacionDelLibro() {

    }

    public void administrarUsuarios() {
    }

    public void sancionPorDevolucion() {
    }

    public void sancionComentario() {
    }

    public void eliminarUsuario() {
    }

    public void menuAdiministrador(){

    }
}

