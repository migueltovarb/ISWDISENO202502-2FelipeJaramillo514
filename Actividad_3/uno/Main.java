package One;
public class Main {
    public static void main(String[] args) {
        // Crear un empleado
        Employee emp1 = new Employee(101, "Laura", "Gomez", 2500);

        // Mostrar datos iniciales
        System.out.println("=== DATOS DEL EMPLEADO ===");
        System.out.println("ID: " + emp1.getID());
        System.out.println("Nombre: " + emp1.getFirstName());
        System.out.println("Apellido: " + emp1.getLastName());
        System.out.println("Nombre completo: " + emp1.getName());
        System.out.println("Salario mensual: $" + emp1.getSalary());
        System.out.println("Salario anual: $" + emp1.getAnnualSalary());

        // Aumentar salario en 15%
        System.out.println("\n=== AUMENTO DE SALARIO (15%) ===");
        int nuevoSalario = emp1.raiseSalary(15);
        System.out.println("Nuevo salario mensual: $" + nuevoSalario);
        System.out.println("Nuevo salario anual: $" + emp1.getAnnualSalary());

        // Representación con toString
        System.out.println("\n=== toString() del empleado ===");
        System.out.println(emp1);
    }
}
