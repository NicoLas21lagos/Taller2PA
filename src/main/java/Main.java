package org.example;

import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int x = 0;
        System.out.println("=====================Bienvenido=====================");
        Login login = new Login();
        Biblioteca biblioteca = new Biblioteca();
        Administrador administrador = new Administrador(biblioteca);

        do {
            try {
                System.out.println("â•”â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•—");
                System.out.println("â•‘           [1] INICIAR SESION           â•‘");
                System.out.println("â•‘           [2] CREAR CUENTA             â•‘");
                System.out.println("â•‘           [3] ADMINISTRADOR            â•‘");
                System.out.println("â•‘           [4] SALIR                    â•‘");
                System.out.println("â•‘           ELIJA UNA OPCION             â•‘");
                System.out.println("â•šâ•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
                x = validar(4);

                switch (x) {
                    case 1 -> {
                        if (login.autenticacion()) {
                            Usuario usuarioLogeado = login.buscarUsuarioLogeado(login.getNombre(), login.getContra());
                            menu(usuarioLogeado,biblioteca);
                        }
                    }
                    case 2 -> login.validacionRegistroUsuario();
                    case 3 -> menu(new Usuario("Admin","","admin123"),biblioteca);
                }
            } catch (Exception e) {
                System.out.println("ERROR vuelva a intentar");
            }

        } while (x != 4);
        System.out.println("Finalizando...");

    }

    public static void menu(Usuario usuarioLogeado, Biblioteca biblioteca) {
        int opcion = 0;
        do {
            try {
                System.out.println("â•”â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•—");
                System.out.println("â•‘           MenÃº Principal                â•‘");
                System.out.println("â•‘ [1] Solicitar PrÃ©stamo de Libro         â•‘");
                System.out.println("â•‘ [2] Ver Disponibilidad del Libro        â•‘");
                System.out.println("â•‘ [3] Renovar PrÃ©stamo                    â•‘");
                System.out.println("â•‘ [4] Devolver Libro                      â•‘");
                System.out.println("â•‘ [5] Ver Historial Libros Prestados      â•‘");
                System.out.println("â•‘ [6] Buscar Libro por TÃ­tulo             â•‘");
                System.out.println("â•‘ [7] Buscar Libro por Autor              â•‘");
                System.out.println("â•‘ [8] Buscar Libro por CategorÃ­a          â•‘");
                System.out.println("â•‘ [9] Buscar Libro por mejor ValoraciÃ³n   â•‘");
                System.out.println("â•‘ [10] Buscar Libro por peor ValoraciÃ³n   â•‘");
                System.out.println("â•‘ [11] Buscar Libro por Valoracion exacta   â•‘");
                System.out.println("â•‘ [12] Buscar Libro por fecha             â•‘");
                System.out.println("â•‘ [13] Salir                              â•‘");
                System.out.println("â•šâ•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
                System.out.print("Ingrese su opciÃ³n: ");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1 -> usuarioLogeado.solicitarPrestamoLibro(biblioteca);
                    case 2 -> usuarioLogeado.verDisponibilidadLibro(biblioteca);
                    case 3 -> usuarioLogeado.renovarPrestamo();
                    case 4 -> usuarioLogeado.devolverLibro(biblioteca);
                    case 5 -> usuarioLogeado.verHistorialDePrestamos(biblioteca);
                    case 6 -> usuarioLogeado.buscarLibroPorTitulo(biblioteca);
                    case 7 -> usuarioLogeado.buscarLibroPorAutor(biblioteca);
                    case 8 -> usuarioLogeado.buscarLibroPorCategoria(biblioteca);
                    case 9 -> usuarioLogeado.buscarLibroPorMejorValoracion(biblioteca);
                    case 10 -> usuarioLogeado.buscarLibroPorPeorValoracion(biblioteca);
                    case 11 -> usuarioLogeado.buscarLibroPorValoracion(biblioteca);
                    case 12 -> System.out.println("FALTA IMPLEMENTAR");

                    default -> System.out.println("OpciÃ³n invÃ¡lida. Por favor, ingrese una opciÃ³n vÃ¡lida.");
                }
            } catch (Exception e) {
                System.out.println("ERROR vuelva a intentar");
                teclado.nextLine();
            }
        } while (opcion != 13);
    }

    public static int validar(int x) {
        int n = -1;
        do {
            Scanner teclado = new Scanner(System.in);
            n = teclado.nextInt();
            if (n <= 0 || n > x) {
                System.out.println("ingrese un numero valido");
            }
        } while (n <= 0 || n > x);
        return n;
    }





}


/*

//parte del profe

Sistema de GestiÃ³n de Biblioteca

En una biblioteca universitaria, se necesita un sistema de gestiÃ³n para administrar el prÃ©stamo y
la devoluciÃ³n de libros. Los USUARIO pueden ser estudiantes, profesores o personal de la biblioteca.
Cada libro tiene un tÃ­tulo, un autor, una categorÃ­a y un nÃºmero de ejemplares disponibles para prÃ©stamo.
Los usuarios pueden buscar libros por tÃ­tulo, autor o categorÃ­a, y pueden solicitar el prÃ©stamo de un libro
si estÃ¡ disponible.

El sistema debe permitir a los usuarios registrarse y autenticarse para acceder a sus cuentas.(Iniciar Sesion/registrarse)


Una vez autenticados, los usuarios pueden realizar diferentes acciones, como buscar libros, solicitar prÃ©stamos,
renovar prÃ©stamos y devolver libros. Los administradores de la biblioteca tienen acceso adicional para agregar
nuevos libros, eliminar libros, modificar informaciÃ³n de libros y administrar usuarios.




1- Que existan secciones como filtros de bÃºsqueda por valoraciÃ³n(mejores valorados y peores valorados),
los mÃ¡s llevados, los mÃ¡s recientes y antiguos.

2- Establecer un lÃ­mite de libros prestados por usuario registrado, por ejemplo que un usuario
puede solicitar un mÃ¡ximo de 7 libros.

3- Cuando un usuario solicita un prÃ©stamo de x libro tenga un tiempo lÃ­mite de devoluciÃ³n 30 dÃ­as y cuando sea
el dÃ­a de devolver el libro, se le envÃ­e una notificaciÃ³n al usuario como recordatorio.

4- Que un usuario ya registrado al devolver el libro o al solicitar un prÃ©stamo, tenga la opciÃ³n de agregar una reseÃ±a
sobre este, con una valoraciÃ³n y su respectiva opiniÃ³n.

5- En el rol de administrador, realizar sanciones a los usuarios que no devuelvan los
libros en la fecha correspondida o superen el lÃ­mite de entrega.

6- En el rol de administrador, sancionar y censurar reseÃ±as no aptas en los libros.

7- Agregar un contador de sanciones al usuario si este pasa mÃ¡s de 3
sanciones, serÃ¡ bloqueado y eliminado de la biblioteca.



*/
