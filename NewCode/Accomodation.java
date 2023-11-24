import java.io.Serializable;


class Accommodation implements Serializable{
    private int id;
    private String type; // Hotel, Lodge, Apartment
    private String name;
    private double price;
    private boolean available;

    //Constructor
    public Accommodation(int id, String type, String name, double price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void displayDetails() {
        System.out.println("Accommodation ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Price per night: $" + price);
        System.out.println("Available: " + (available ? "Yes" : "No"));
    }
}