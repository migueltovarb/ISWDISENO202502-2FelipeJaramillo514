package dos;

public class Main {
    public static void main(String[] args) {
        // Crear un item de factura
        InvoiceItem item1 = new InvoiceItem("A101", "Laptop Lenovo", 3, 2500.50);

        // Mostrar datos iniciales
        System.out.println("=== DETALLE DE FACTURA ===");
        System.out.println("ID: " + item1.getID());
        System.out.println("Descripción: " + item1.getDesc());
        System.out.println("Cantidad: " + item1.getQty());
        System.out.println("Precio unitario: $" + item1.getUnitPrice());
        System.out.println("Total: $" + item1.getTotal());

        // Modificar cantidad y precio
        System.out.println("\n=== ACTUALIZANDO DATOS ===");
        item1.setQty(5);
        item1.setUnitPrice(2300.75);

        System.out.println("Nueva cantidad: " + item1.getQty());
        System.out.println("Nuevo precio unitario: $" + item1.getUnitPrice());
        System.out.println("Nuevo total: $" + item1.getTotal());

        // Representación con toString()
        System.out.println("\n=== toString() del item ===");
        System.out.println(item1);
    }
}
