import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {

    List<Usuario> usuarios;

    Scanner teclado = new Scanner(System.in);
    private String nombre;
    private String contra;

    public Login() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Luis Perez", "Estudiante", "1234"));
        usuarios.add(new Usuario("Nicolas Llancaqueo", "Estudiante", "L412"));
        usuarios.add(new Usuario("Pepe Romero", "Profesor", "7686"));
        usuarios.add(new Usuario("Juanito Perez", "Estudiante", "ADS123"));
        usuarios.add(new Usuario("Marcela Riquelme", "Estudiante", "PC12ZX"));

    }


    public void iniciarSesion() {

        System.out.println("╔═════════════════════════╗");
        System.out.println("║   Iniciar Sesión        ║");
        System.out.println("╠═════════════════════════╣");

        System.out.println("║  Ingresar nombre:       ║");
        nombre = teclado.next();

        System.out.println("║  Ingresar contraseña:   ║");
        contra = teclado.next();

        System.out.println("╚═════════════════════════╝");

        autenticacion();
    }

    public void autenticacion() {
        boolean verificarUsuario = usuarios.stream()
                .anyMatch(x -> x.getNombre().equals(this.nombre) && x.getContraseña().equals(contra));

        if (verificarUsuario) {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║        Inicio de Sesión Exitoso        ║");
            System.out.println("╚════════════════════════════════════════╝");
        } else {
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║  Nombre de Usuario o Contraseña Incorrectos  ║");
            System.out.println("║                                              ║");
            System.out.println("║       ¿Desea Intentarlo de Nuevo?            ║");
            System.out.println("║     [1] Sí                     [2] No        ║");
            System.out.println("╚══════════════════════════════════════════════╝");
        }
        try {
            int opcion = teclado.nextInt();

            if (opcion == 1) {
                iniciarSesion();
            }

        } catch (Exception e) {

            System.out.println(e.getMessage() + " | Ingrese datos validos");
            teclado.nextLine();
            autenticacion();
        }
    }





    public String getNombre() {
        return nombre;
    }

    public String getContra() {
        return contra;
    }
}
