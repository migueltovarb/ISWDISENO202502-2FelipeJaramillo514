package superMarket;
import java.util.Scanner;

public class SuperMarket {
    
    private static final int MAX_PRODUCTOS = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nombres = new String[MAX_PRODUCTOS];
        int[] cantidades = new int[MAX_PRODUCTOS];
        int opcion;

        
        System.out.println("| Registro Productos Super Market |");
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            System.out.print("Ingrese nombre del producto " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();
            System.out.print("Ingrese cantidad inicial de " + nombres[i] + ": ");
            int cantidad = sc.nextInt();
            while (cantidad < 0) { 
                System.out.print("Cantidad no válida. Ingrese un número positivo: ");
                cantidad = sc.nextInt();
            }
            cantidades[i] = cantidad;
            sc.nextLine(); 
        }

        
        do {
            System.out.println("\n | Menú Inventario |");
            System.out.println("1. Mostrar todos los productos y sus existencias");
            System.out.println("2. Buscar un producto por nombre y ver su cantidad");
            System.out.println("3. Actualizar el inventario");
            System.out.println("4. Generar alerta de productos con cantidad menor a 10");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("\n| Lista de Productos |");
                    int total = 0; 
                    for (int i = 0; i < MAX_PRODUCTOS; i++) {
                        System.out.println(nombres[i] + ": " + cantidades[i]);
                        total += cantidades[i];
                    }
                    System.out.println("Total de productos en inventario: " + total);
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String buscar = sc.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < MAX_PRODUCTOS; i++) {
                        if (nombres[i].equalsIgnoreCase(buscar)) {
                            System.out.println("Cantidad de " + nombres[i] + ": " + cantidades[i]);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del producto a actualizar: ");
                    String actualizar = sc.nextLine();
                    boolean existe = false;
                    for (int i = 0; i < MAX_PRODUCTOS; i++) {
                        if (nombres[i].equalsIgnoreCase(actualizar)) {
                            System.out.print("Ingrese la cantidad a agregar (+) o quitar (-): ");
                            int cambio = sc.nextInt();
                            if (cantidades[i] + cambio < 0) {
                                System.out.println("Error: no se puede dejar la cantidad negativa.");
                            } else {
                                cantidades[i] += cambio;
                                System.out.println("Inventario actualizado. Nueva cantidad: " + cantidades[i]);
                            }
                            existe = true;
                        }
                    }
                    if (!existe) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n| Alerta de baja existencia |");
                    boolean alerta = false;
                    for (int i = 0; i < MAX_PRODUCTOS; i++) {
                        if (cantidades[i] < 10) {
                            System.out.println("ALERTA: " + nombres[i] + " tiene solo " + cantidades[i] + " unidades.");
                            alerta = true;
                        }
                    }
                    if (!alerta) {
                        System.out.println("No hay productos con baja existencia.");
                    }
                    break;

                case 5:
                    System.out.println("Gracias por usar Super Market");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 5);

        sc.close();
    }
}

                    