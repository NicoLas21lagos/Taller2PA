package org.example;

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

        System.out.println("â•”â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•—");
        System.out.println("â•‘   Iniciar SesiÃ³n        â•‘");
        System.out.println("â• â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•£");

        try {
            System.out.println("â•‘  Ingresar nombre:       â•‘");
            nombre = correccionPalabras(teclado.nextLine());
            System.out.println("â•‘  Ingresar contraseÃ±a:   â•‘");
            contra = teclado.nextLine();

            System.out.println(nombre + " | " + contra);
            System.out.println("â•šâ•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");

        } catch (Exception e) {
            System.out.println("Ocurrió un error al iniciar sesión: " + e.getMessage());
        }
    }

    public boolean autenticacion() {
        iniciarSesion();
        boolean resultado = false;
        boolean verificarUsuario = usuarios.stream()
                .anyMatch(x -> x.getNombre().equals(this.nombre) && x.getContraseña().equals(contra));
        try {
            if (verificarUsuario) {
                System.out.println("â•”â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•—");
                System.out.println("â•‘        Inicio de SesiÃ³n Exitoso        â•‘");
                System.out.println("â•šâ•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");

                resultado = true;
            } else {
                System.out.println("â•”â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•—");
                System.out.println("â•‘  Nombre de Usuario o ContraseÃ±a Incorrectos  â•‘");
                System.out.println("â•‘                                              â•‘");
                System.out.println("â•‘        Â¿Desea Intentarlo de Nuevo?           â•‘");
                System.out.println("â•‘     [1] SÃ­                     [2] No        â•‘");
                System.out.println("â•šâ•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");

                int opcion = Integer.parseInt(teclado.nextLine());
                if (opcion == 1) {
                    iniciarSesion();
                }
            }
        } catch (Exception e) {

            System.out.println(e.getMessage() + " | Ingrese datos validos");
            teclado.nextLine();
            autenticacion();
        }
        return resultado;
    }

    public Usuario buscarUsuarioLogeado(String nombre, String contra){
        for (Usuario usuario : usuarios){
            if (usuario.getNombre().equals(nombre) && usuario.getContraseña().equals(contra)){
                return usuario;
            }
        }
        return null;
    }

    public String[] registrarUsuario() {
        try {
            System.out.println("â• â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•£");
            System.out.println("â•‘     Ingresar nombre:                 â•‘");
            String nombre = correccionPalabras(teclado.nextLine());

            System.out.println("â•‘     Ingresar tipo personal           â•‘");
            System.out.println("â•‘     (Estudiante, Profesor o          â•‘");
            System.out.println("â•‘     Personal De La Biblioteca)       â•‘");
            String tipoPersona = correccionPalabras(teclado.nextLine());


            System.out.println("â•‘     Ingresar contraseÃ±a:             â•‘");
            String contrasena = teclado.nextLine();

            System.out.println("â•‘     Ingresar contraseÃ±a nuevamente:  â•‘");
            String contrasenaConfirmacion = teclado.nextLine();
            System.out.println("â•šâ•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");

            return new String[]{nombre, tipoPersona, contrasena, contrasenaConfirmacion};
        } catch (Exception e) {
            System.out.println("Ocurrió un error durante el registro " + e.getMessage());
            return null;
        }
    }



    public void validacionRegistroUsuario() {

        try {

            String[] datos = registrarUsuario();

            //validar el tipo de usuario
            if (!datos[1].equals("Profesor") && !datos[1].equals("Estudiante") && !datos[1].equals("Personal De La Biblioteca")) {
                System.out.println("Ingrese datos validos");
                System.out.println("Se encontro [" + datos[1] + "]");
                registrarUsuario();
            } else if (!datos[2].equals(datos[3])) {
                System.out.println("Ingrese datos validos");
                System.out.println("Se encontro [" + datos[2] + "] distinto a [" + datos[3] + "]");
                registrarUsuario();
            }

            usuarios.add(new Usuario(datos[0], datos[1], datos[2]));
            System.out.println("â•”â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•—");
            System.out.println("â•‘       Creacion de cuenta exitosa       â•‘");
            System.out.println("â•šâ•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");

            for (Usuario user : usuarios) {
                System.out.println(user.toString());
            }



        } catch (Exception e) {
            System.out.println(e.getMessage() + " | Ingresa datos validos");
            teclado.nextLine();
            registrarUsuario();
        }
    }

    public String correccionPalabras(String texto) {
        StringBuilder nuevoString = new StringBuilder();

        String[] palabras = texto.toLowerCase().split(" ");

        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {

                nuevoString.append(Character.toUpperCase(palabra.charAt(0)))
                        .append(palabra.substring(1)).append(" ");
            }
        }
        return nuevoString.toString().trim();
    }

    public String getNombre() {
        return nombre;
    }

    public String getContra() {
        return contra;
    }
}
