

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Login login = new Login();
        login.iniciarSesion();

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
}