package org.example;

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



    public List<Libro> getLibros() {
        return libros;
    }

}
