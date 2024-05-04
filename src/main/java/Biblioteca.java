import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteca {
    private final List<Libro> libros = new ArrayList<>();

    //---------------------------------------------------------------------------
    //cosas agregadas Luis
    public Biblioteca() {
        libros.add(new Libro("Harry Potter","Camilo Sesto","Misterio",5, Collections.singletonList(8), Collections.singletonList("")));
        libros.add(new Libro("El Psicoanlista","John Katzenbach","Thriller",10, Collections.singletonList(7), Collections.singletonList("")));
        libros.add(new Libro("Clean Code","Robert C. Martin","Educativo",5, Collections.singletonList(5), Collections.singletonList("")));
        libros.add(new Libro("Papelucho Detective","Marcela Paz","Infantil",5, Collections.singletonList(6), Collections.singletonList("")));

    }
    public void addLibros(Libro libro){
        this.libros.add(libro);
    }

    //---------------------------------------------------------------------------

    public boolean buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarLibroPorAutor(String autor) {
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarLibroPorCategoria(String categoria) {
        for (Libro libro : libros) {
            if (libro.getCategoria().equalsIgnoreCase(categoria)) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarLibroPorMejorValoracion(int valoracionMinima) {
        for (Libro libro : libros) {
            if (libro.tieneMejorValoracion(valoracionMinima)) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarLibroPorPeorValoracion(int valoracionMaxima) {
        for (Libro libro : libros) {
            if (libro.tienePeorValoracion(valoracionMaxima)) {
                return true;
            }
        }
        return false;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public List<Libro> buscarLibroPorMasLlevado() {
        return libros;
    }

    public List<Libro> buscarLibroPorFecha() {
        return libros;

    }

    public void solicitarPrestamoDeLibro(Libro libro) {
    }

    public boolean verDisponibilidadDelLibro(Libro libro) {
        return true;
    }

    public void renovarPrestamo(Libro libro) {
    }

    public void devolverLibro(Libro libro) {
    }




}
