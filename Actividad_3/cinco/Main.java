package cinco;

public class Main {
    public static void main(String[] args) {
        // Crear autor
        Author author = new Author("Gabriel Garcia Marquez", "gabo@email.com", 'm');

        // Crear libro con primer constructor
        Book book1 = new Book("Cien Años de Soledad", author, 99.99);

        // Crear libro con segundo constructor
        Book book2 = new Book("El amor en los tiempos del cólera", author, 79.99, 10);

        // Mostrar información
        System.out.println("=== INFORMACIÓN DE LOS LIBROS ===");
        System.out.println(book1);
        System.out.println(book2);

        // Cambiar precio y cantidad
        System.out.println("\n=== ACTUALIZANDO DATOS DEL LIBRO 2 ===");
        book2.setPrice(89.99);
        book2.setQty(15);

        // Ver cambios
        System.out.println(book2);
    }
}
