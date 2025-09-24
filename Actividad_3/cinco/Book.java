package cinco;

public class Book {
    private String name;
    private Author author; // relación con Author
    private double price;
    private int qty = 0; // por defecto en 0

    // Constructor 1
    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    // Constructor 2
    public Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    // Métodos Get
    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    // Métodos Set
    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    // toString (reutilizando Author.toString)
    @Override
    public String toString() {
        return "Book[name=" + name + "," + author.toString() + ", price=" + price + ", qty=" + qty + "]";
    }
}
