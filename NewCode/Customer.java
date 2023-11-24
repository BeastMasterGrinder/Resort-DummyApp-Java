import java.io.Serializable;


class Customer implements Serializable{
    private int id;
    private String name;
    private String level;   // Beginner, Intermediate, Expert

    // Constructor
    public Customer(int id, String name, String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public void displayDetails() {
        System.out.println("Customer ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Ski Level: " + level);
    }
}