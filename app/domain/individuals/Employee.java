package app.domain.individuals;

public class Employee {
    private String name;

    // constructor methode
    public Employee(String name) {
        this.name = name;
    }

    // setters en gitters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
