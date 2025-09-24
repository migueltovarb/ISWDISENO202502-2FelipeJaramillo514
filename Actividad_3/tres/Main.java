package tres;

public class Main {
    public static void main(String[] args) {
        // Crear dos cuentas
        Account acc1 = new Account("C001", "Maria", 5000);
        Account acc2 = new Account("C002", "Juan", 2000);

        // Mostrar información inicial
        System.out.println("=== ESTADO INICIAL DE CUENTAS ===");
        System.out.println(acc1);
        System.out.println(acc2);

        // Acreditar en la cuenta de Maria
        System.out.println("\n=== CREDITANDO A MARIA (1500) ===");
        acc1.credit(1500);
        System.out.println(acc1);

        // Debitar en la cuenta de Juan
        System.out.println("\n=== DEBITANDO A JUAN (1000) ===");
        acc2.debit(1000);
        System.out.println(acc2);

        // Intentar debitar más de lo que tiene Juan
        System.out.println("\n=== INTENTANDO DEBITAR A JUAN (2000) ===");
        acc2.debit(2000);
        System.out.println(acc2);

        // Transferir de Maria a Juan
        System.out.println("\n=== TRANSFIRIENDO DE MARIA A JUAN (2000) ===");
        acc1.transferTo(acc2, 2000);
        System.out.println(acc1);
        System.out.println(acc2);
    }
}
