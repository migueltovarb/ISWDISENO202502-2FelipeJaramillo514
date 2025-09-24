package cuatro;

public class Main {
    public static void main(String[] args) {
        // Crear un autor
        Author author1 = new Author("Gabriel Garcia Marquez", "gabo@email.com", 'm');

        // Mostrar datos iniciales
        System.out.println("=== INFORMACIÓN DEL AUTOR ===");
        System.out.println("Nombre: " + author1.getName());
        System.out.println("Email: " + author1.getEmail());
        System.out.println("Género: " + author1.getGender());

        // Cambiar email
        System.out.println("\n=== ACTUALIZANDO EMAIL ===");
        author1.setEmail("gabriel.garcia@email.com");
        System.out.println("Nuevo email: " + author1.getEmail());

        // Usar toString()
        System.out.println("\n=== toString() ===");
        System.out.println(author1);
    }
}
