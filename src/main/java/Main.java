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
                System.out.println("╔════════════════════════════════════════╗");
                System.out.println("║           [1] INICIAR SESION           ║");
                System.out.println("║           [2] CREAR CUENTA             ║");
                System.out.println("║           [3] ADMINISTRADOR            ║");
                System.out.println("║           [4] SALIR                    ║");
                System.out.println("║           ELIJA UNA OPCION             ║");
                System.out.println("╚════════════════════════════════════════╝");
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


        int opcion;
        do {
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║           Menú Principal                ║");
            System.out.println("╠═════════════════════════════════════════╣");
            System.out.println("║ [1] Solicitar Préstamo de Libro         ║");
            System.out.println("║ [2] Ver Disponibilidad del Libro        ║");
            System.out.println("║ [3] Renovar Préstamo                    ║");
            System.out.println("║ [4] Devolver Libro                      ║");
            System.out.println("║ [5] Ver Historial Libros Prestados      ║");
            System.out.println("║ [6] Buscar Libro por Título             ║");
            System.out.println("║ [7] Buscar Libro por Autor              ║");
            System.out.println("║ [8] Buscar Libro por Categoría          ║");
            System.out.println("║ [9] Buscar Libro por mejor Valoración   ║");
            System.out.println("║ [10] Buscar Libro por peor Valoración   ║");
            System.out.println("║ [11] Buscar Libro por mas llevado       ║");
            System.out.println("║ [12] Buscar Libro por fecha             ║");
            System.out.println("║ [13] Salir                              ║");
            System.out.println("╚═════════════════════════════════════════╝");

            System.out.print("Ingrese su opción: ");
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
                case 9 -> System.out.println("FALTA IMPLEMENTAR");
                case 10 -> System.out.println("FALTA IMPLEMENTAR");
                case 11 -> System.out.println("FALTA IMPLEMENTAR");
                case 12 -> System.out.println("FALTA IMPLEMENTAR");

                default -> System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
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

Sistema de Gestión de Biblioteca

En una biblioteca universitaria, se necesita un sistema de gestión para administrar el préstamo y
la devolución de libros. Los USUARIO pueden ser estudiantes, profesores o personal de la biblioteca.
Cada libro tiene un título, un autor, una categoría y un número de ejemplares disponibles para préstamo.
Los usuarios pueden buscar libros por título, autor o categoría, y pueden solicitar el préstamo de un libro
si está disponible.

El sistema debe permitir a los usuarios registrarse y autenticarse para acceder a sus cuentas.(Iniciar Sesion/registrarse)


Una vez autenticados, los usuarios pueden realizar diferentes acciones, como buscar libros, solicitar préstamos,
renovar préstamos y devolver libros. Los administradores de la biblioteca tienen acceso adicional para agregar
nuevos libros, eliminar libros, modificar información de libros y administrar usuarios.




1- Que existan secciones como filtros de búsqueda por valoración(mejores valorados y peores valorados),
los más llevados, los más recientes y antiguos.

2- Establecer un límite de libros prestados por usuario registrado, por ejemplo que un usuario
puede solicitar un máximo de 7 libros.

3- Cuando un usuario solicita un préstamo de x libro tenga un tiempo límite de devolución 30 días y cuando sea
el día de devolver el libro, se le envíe una notificación al usuario como recordatorio.

4- Que un usuario ya registrado al devolver el libro o al solicitar un préstamo, tenga la opción de agregar una reseña
sobre este, con una valoración y su respectiva opinión.

5- En el rol de administrador, realizar sanciones a los usuarios que no devuelvan los
libros en la fecha correspondida o superen el límite de entrega.

6- En el rol de administrador, sancionar y censurar reseñas no aptas en los libros.

7- Agregar un contador de sanciones al usuario si este pasa más de 3
sanciones, será bloqueado y eliminado de la biblioteca.



*/
