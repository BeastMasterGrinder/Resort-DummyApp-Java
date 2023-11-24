# Mt Buller Resort Java Project

## Overview
This Java project, Mt Buller Resort, is a simple console-based application that manages a ski resort's accommodation bookings and travel packages. The system allows users to interactively perform various tasks, including displaying available accommodations, creating travel packages, adding lift passes and lessons to packages, listing all packages, and saving/loading packages to/from a file.

## Project Structure
The project consists of the following main classes:

- `MtBullerResort`: The main class that orchestrates the functionality of the resort. It includes methods for displaying menus, managing user input, and performing operations on accommodations, customers, and travel packages.

- `Accommodation`: Represents a lodging option at the resort. Each accommodation has an ID, type (Hotel, Lodge, Apartment), name, price per night, and availability status.

- `Customer`: Represents a customer with an ID, name, and ski level (Beginner, Intermediate, Expert).

- `TravelPackage`: Represents a travel package, including details about the customer, chosen accommodation, start date, duration, lift pass cost, number of lessons, and total cost.

## Getting Started
To run the Mt Buller Resort application, follow these steps:

1. Ensure you have a Java development environment set up on your machine.
2. Compile the source code files (`MtBullerResort.java`, `Accommodation.java`, `Customer.java`, `TravelPackage.java`).
3. Run the compiled `MtBullerResort` class.

## Application Usage
Upon running the application, you will be presented with a menu where you can choose various options. The available options include:

1. Display all accommodations
2. Display available accommodations
3. Create a travel package
4. Add a lift pass to a package
5. Add lessons to a package
6. List all packages
7. Save packages to a file
8. Read packages from a file
0. Exit

Simply follow the on-screen prompts and input the required information to perform the desired actions. The application will guide you through the process.

## Important Notes
- The project includes basic error handling for invalid input, such as non-integer inputs and incorrect accommodation or lift pass types.
- Accommodations are initially marked as available, and their availability status is updated when included in a travel package.
- Lift pass costs are calculated based on user input for pass type and duration.
- Lessons can be added to a package based on the customer's ski level.

## Data Persistence
The application provides functionality to save travel packages to a binary file (`packages.bin`) and read them back. This enables data persistence between different runs of the application.

## Contributions
Contributions to the project are welcome. If you encounter any issues or have suggestions for improvements, feel free to submit them.

Thank you for using the Mt Buller Resort Java application!
