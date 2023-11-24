import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


class MtBullerResort {
    private ArrayList<Accommodation> accommodations;
    private ArrayList<Customer> customers;
    private ArrayList<TravelPackage> travelPackages;

    public MtBullerResort() {
        accommodations = new ArrayList<>();
        customers = new ArrayList<>();
        travelPackages = new ArrayList<>();
    }

    public static void main(String[] args) {
        MtBullerResort MtBResort = new MtBullerResort();
        MtBResort.populateLists();
        MtBResort.run();
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while(choice != 0){
            clearConsole();
            System.out.println("Welcome to Mt Buller Resort");
            System.out.println("===========================");
            System.out.println("1. Display all accommodations");
            System.out.println("2. Display available accommodations");
            System.out.println("3. Create a travel package");
            System.out.println("4. Add a lift pass");
            System.out.println("5. Add lessons");
            System.out.println("6. List all packages");
            System.out.println("7. Save packages to a file");
            System.out.println("8. Read packages from a file");
            System.out.println("0: Exit");
            System.out.println("===========================");
            System.out.println("Enter your choice: ");
            

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid choice: ");
                scanner.next(); // Consume the invalid input
            }
            choice = scanner.nextInt();

            switch (choice){
                case 0:
                    break;
                case 1:
                    this.displayAllAccommodations();  // display all accommodations
                    break;
                case 2:
                    this.displayAvailableAccommodations(); // display available accommodations
                    break;
                case 3:
                    System.out.println("Enter customer ID: ");
                    int customerId = scanner.nextInt();
                    Customer customer = this.getCustomerByID(customerId);
                    System.out.println("Enter date: ");
                    String date = scanner.next();
                    System.out.println("Enter number of nights: ");
                    int nights = scanner.nextInt();
                    System.out.println("Any lesson you want to add? [Y/N]");
                    String lesson = scanner.next();

                    this.createPackage(customer, date, nights, lesson);
                    break;
                case 4:
                    System.out.println("Enter package ID: ");
                    int packageId = scanner.nextInt();
                    this.addLiftPassToPackage(packageId - 1);
                    break;
                case 5:
                    System.out.println("Enter package ID: ");
                    int packageId2 = scanner.nextInt();
                    System.out.println("Enter the number of lessons you want to add: ");
                    int numLessons = scanner.nextInt();
                    this.addLessonsToPackage(packageId2 - 1, numLessons);
                    break;
                case 6:
                    this.listPackages();
                    break;
                case 7:
                    this.savePackagesToFile("packages.bin");
                    break;
                case 8:
                    this.readPackagesFromFile("packages.bin");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.print("Press Enter to continue...");
            // scanner.nextLine();
            System.console().readLine();
            // System.out.print("\033[H\033[2J");
            // System.out.flush();
        }
        scanner.close();
    }

    
    public void displayAllAccommodations() {
        for (Accommodation accommodation : accommodations) {
            accommodation.displayDetails();
            System.out.println();
        }
    }

    public void displayAvailableAccommodations() {
        for (Accommodation accommodation : accommodations) {
            if (accommodation.isAvailable()) {
                accommodation.displayDetails();
                System.out.println();
            }
        }
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addAccommodation(Accommodation accommodation) {
        accommodations.add(accommodation);
    }

    public void listCustomers() {
        for (Customer customer : customers) {
            customer.displayDetails();
            System.out.println();
        }
    }

    public Customer getCustomerByID(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    public Accommodation geAccommodationByID(int accommodationId) {
        for (Accommodation accommodation : accommodations) {
            if (accommodation.getId() == accommodationId) {
                return accommodation;
            }
        }
        return null;
    }

    public void populateLists(){
        Accommodation accommodation1 = new Accommodation(1, "Hotel", "LuxuryStays", 100.0);
        Accommodation accommodation2 = new Accommodation(2, "Lodge", "OrangeLagoon", 80.0);
        Accommodation accommodation3 = new Accommodation(3, "Apartment", "J&G", 120.0);
        Accommodation accommodation4 = new Accommodation(4, "Apartment", "CozyCreek", 90.0);
        Accommodation accommodation5 = new Accommodation(5, "Apartment", "MountainView", 150.0);
        Accommodation accommodation6 = new Accommodation(6, "Lodge", "SnowHaven", 200.0);
        Accommodation accommodation7 = new Accommodation(7, "Hotel", "BackpackersInn", 50.0);
        Accommodation accommodation8 = new Accommodation(8, "Lodge", "LakefrontRetreat", 110.0);
        Accommodation accommodation9 = new Accommodation(9, "Hotel", "BudgetInn", 70.0);
        Accommodation accommodation10 = new Accommodation(10, "Lodge", "GardenEscape", 180.0);


        Customer customer1 = new Customer(1, "John Doe", "Intermediate");
        Customer customer2 = new Customer(2, "Jane Smith", "Beginner");
        Customer customer3 = new Customer(3, "Mike Johnson", "Expert");

        this.addCustomer(customer1);
        this.addCustomer(customer2);
        this.addCustomer(customer3);

        this.addAccommodation(accommodation1);
        this.addAccommodation(accommodation2);
        this.addAccommodation(accommodation3);
        this.addAccommodation(accommodation4);
        this.addAccommodation(accommodation5);
        this.addAccommodation(accommodation6);
        this.addAccommodation(accommodation7);
        this.addAccommodation(accommodation8);
        this.addAccommodation(accommodation9);
        this.addAccommodation(accommodation10);
    }


    public void createPackage(Customer customer, String startDate, int duration, String lesson) {
        // You need to prompt the user for accommodation choice, lift pass, and lessons
        // Validate inputs and calculate the package cost
        // Then create a TravelPackage object and add it to travelPackages ArrayList

        System.out.println("List of All accommodations: ");
        displayAvailableAccommodations();

        System.out.println("Enter accommodation ID: ");
        Scanner scanner = new Scanner(System.in);
        int accommodationId = scanner.nextInt();
        Accommodation accommodation = null;
        accommodation = geAccommodationByID(accommodationId);
        if (accommodation == null) {
            System.out.println("Invalid accommodation ID");
            scanner.close();
            return;
        }
        accommodation.setAvailable(false);

        /*
         * Full day lift pass costs $26. There are discounts for a lift pass as following.  If a customer buys a lift pass for 5 days, the total price is reduced by 10%, if customer buys a lift pass for a season, the total price is $200. 
         */
        double lessonCost = 0.0;

        System.out.println("Enter lift pass type (1. Full day, 2. 5 days, 3. Season): ");
        int liftPassType = scanner.nextInt();
        double liftPassCost = 26.0;
        switch (liftPassType) {
            case 1:
                break;
            case 2:
                liftPassCost *= 5; // for 5 days
                liftPassCost *= 0.9;
                break;
            case 3:
                liftPassCost = 200; // for season
                break;
            default:
                System.out.println("Invalid lift pass type");
                scanner.close();
                return;
        }
        int numberOfLessons = 0;
        if (lesson == "Y" || lesson == "y"){
            // lessons based on the customer's level can only buy 1 lesson
            if( customer.getLevel() == "Beginner" || customer.getLevel() == "Intermediate" || customer.getLevel() == "Expert"){
                System.out.println("Enter number of lessons: ");
                numberOfLessons = scanner.nextInt();
                if (numberOfLessons < 1) {
                    System.out.println("Invalid number of lessons");
                    scanner.close();
                    return;
                }
                // Beginner lessons: 25 Intermediate lessons: 20 Expert lessons: 15
                switch (customer.getLevel()) {
                    case "Beginner":
                        lessonCost = 25.0 * numberOfLessons;
                        break;
                    case "Intermediate":
                        lessonCost = 20.0 * numberOfLessons;
                        break;
                    case "Expert":
                        lessonCost = 15.0 * numberOfLessons;
                        break;
                }
            }
        }

        TravelPackage travelPackage = new TravelPackage(customer, accommodation, startDate, duration);
        
        travelPackage.setLiftPassCost(liftPassCost);
        travelPackage.setNumberOfLessons(numberOfLessons);
        
        
        //add all the cost together and set the customer cost
        double costTotal = accommodation.getPrice() * duration + liftPassCost + numberOfLessons * 25.0;
        travelPackage.setCostTotal(costTotal);
        
        travelPackages.add(travelPackage);
        System.out.println("Package created successfully");

        // scanner.close();
    }

    public void addLiftPassToPackage(int id) {
        
        travelPackages.get(id).setLiftPassCost(26.0);
    }

    public void addLessonsToPackage(int id, int numberOfLessons) {
        
        travelPackages.get(id).setNumberOfLessons((travelPackages.get(id).getNumberOfLessons() + numberOfLessons));
    }

    public void listPackages() {
        for (TravelPackage travelPackage : travelPackages) {
            travelPackage.displayDetails();
            System.out.println();
        }
    }

    public void savePackagesToFile(String fileName) {
        //Save the packages ArrayList to a binary file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(travelPackages);
            System.out.println("Packages saved to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving packages to file: " + e.getMessage());
        }
    }

    public void readPackagesFromFile(String fileName) {
        //Read the packages ArrayList from a binary file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            travelPackages = (ArrayList<TravelPackage>) ois.readObject();
            System.out.println("Packages read from file: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading packages from file: " + e.getMessage());
        }
    }
    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}


