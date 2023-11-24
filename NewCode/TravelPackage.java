
import java.io.Serializable;


class TravelPackage implements Serializable {
    private Customer customer;
    private Accommodation accommodation;
    private String startDate;
    private int duration;
    private double liftPassCost;
    private int numberOfLessons;
    private double costTotal;

    // Constructor
    public TravelPackage(Customer customer, Accommodation accommodation, String startDate, int duration) {
        this.customer = customer;
        this.accommodation = accommodation;
        this.startDate = startDate;
        this.duration = duration;
        this.liftPassCost = 0.0;
        this.numberOfLessons = 0;
    }

    

    public int getCustomerId() {
        return customer.getId();
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public String getStartDate() {
        return startDate;
    }

    public int getDuration() {
        return duration;
    }

    public double getLiftPassCost() {
        return liftPassCost;
    }

    public int getNumberOfLessons() {
        return numberOfLessons;
    }

    public void setLiftPassCost(double liftPassCost) {
        this.liftPassCost = liftPassCost;
    }

    public void setNumberOfLessons(int numberOfLessons) {
        this.numberOfLessons = numberOfLessons;
    }

    public void setCostTotal(double costTotal) {
        this.costTotal = costTotal;
    }

    //get travel package by Id
    public TravelPackage getTravelPackage() {
        return this;
    }

    public void displayDetails() {
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Accommodation ID: " + accommodation.getId());
        System.out.println("Start Date: " + startDate);
        System.out.println("Duration (days): " + duration);
        System.out.println("Lift Pass Cost: $" + liftPassCost);
        System.out.println("Number of Lessons: " + numberOfLessons);
        System.out.println("Total Cost: $" + costTotal);
    }
}