package tres;

public class Account {
    // Atributos
    private String id;
    private String name;
    private int balance = 0;

    // Constructor con id y name
    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructor con id, name y balance inicial
    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Métodos Get
    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    // Acreditar (sumar dinero)
    public int credit(int amount) {
        balance += amount;
        return balance;
    }

    // Debitar (restar dinero si hay saldo)
    public int debit(int amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }

    // Transferir a otra cuenta
    public int transferTo(Account another, int amount) {
        if (amount <= balance) {
            this.balance -= amount;
            another.credit(amount);
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }

    // Representación String
    @Override
    public String toString() {
        return "Account[id=" + id + ", name=" + name + ", balance=" + balance + "]";
    }
}
