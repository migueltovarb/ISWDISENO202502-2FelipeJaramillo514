package cuatro;

public class Author {
    // Atributos privados
    private String name;
    private String email;
    private char gender; // 'm' o 'f'

    // Constructor
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    // Métodos Get
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    // Método Set
    public void setEmail(String email) {
        this.email = email;
    }

    // Representación String
    @Override
    public String toString() {
        return "Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
    }
}
