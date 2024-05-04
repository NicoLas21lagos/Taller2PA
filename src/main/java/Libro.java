import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String titulo;
    private String autor;
    private String categoria;
    private int ejemplaresDisponibles;
    private List<Integer> calificaciones;
    private List<String> comentarios;

    public Libro(String titulo, String autor, String categoria, int ejemplaresDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public Libro(String titulo, String autor, String categoria, int ejemplaresDisponibles, List<Integer> calificaciones, List<String> comentarios) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
        this.calificaciones = calificaciones;
        this.comentarios = comentarios;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean tieneMejorValoracion(double valoracionMinima) {
        for (Integer calificacion : calificaciones) {
            if (calificacion >= valoracionMinima) {
                return true;
            }
        }
        return false;
    }

    public boolean tienePeorValoracion(double valoracionMaxima) {
        for (Integer calificacion : calificaciones) {
            if (calificacion <= valoracionMaxima) {
                return true;
            }
        }
        return false;
    }




    @Override
    public String toString() {
        return "Titulo= " + titulo + " | autor= " + autor + " | Categoria= " + categoria +" | EjemplaresDisponibles= " + ejemplaresDisponibles + " | Calificaciones= " + calificaciones + " | Comentarios= " + comentarios;
    }


    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public List<Integer> getCalificaciones() {
        return calificaciones;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }


}
