package org.example;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TruckService truckService = new TruckService();
        /*Truck tata = new Truck("Tata", "2019", 1000, "Ankit");
        Truck eitcher = new Truck("Eitcher", "2020", 1200, "Gaurav");
        Truck mahindra = new Truck("Mahindra", "2021", 1500, "Tushar");
        truckService.addTruck(tata);
        truckService.addTruck(eitcher);
        truckService.addTruck(mahindra);*/

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Show the user a menu
            System.out.println("\nSelect an operation:");
            System.out.println("1. Add Truck");
            System.out.println("2. Fetch Truck by ID");
            System.out.println("3. Update Truck");
            System.out.println("4. Delete Truck by ID");
            System.out.println("5. Get All Trucks");
            System.out.println("6. Exit");
            System.out.print("Enter choice : ");

            // Get user's choice
            choice = scanner.nextInt();

            // Perform action based on the choice using a switch statement
            switch (choice) {
                case 1: {
                    // Add Truck
                    System.out.println("Adding a new truck...");
                    Truck newTruck = new Truck("Scania", "2024", 1200, "John");
                    truckService.addTruck(newTruck);
                    System.out.println("Truck added: " + newTruck);
                    break;
                }
                case 2: {
                    // Fetch Truck by ID
                    System.out.print("Enter Truck ID to fetch: ");
                    int id = scanner.nextInt();
                    Truck truck = truckService.getTruckById(id);
                    if (truck != null) {
                        System.out.println("Truck found: " + truck);
                    } else {
                        System.out.println("Truck with ID " + id + " not found.");
                    }
                    break;
                }
                case 3: {
                    // Update Truck data
                    System.out.print("Enter Truck ID to update: ");
                    int id = scanner.nextInt();
                    Truck truckToUpdate = truckService.getTruckById(id);
                    if (truckToUpdate != null) {
                        truckToUpdate.setDriverName("Ramesh");
                        truckService.updateTruck(truckToUpdate);
                        System.out.println("Truck updated: " + truckToUpdate);
                    } else {
                        System.out.println("Truck with ID " + id + " not found.");
                    }
                    break;
                }
                case 4: {
                    // Delete Truck by ID
                    System.out.print("Enter Truck ID to delete: ");
                    int id = scanner.nextInt();
                    truckService.deleteTruck(id);
                    System.out.println("Truck with ID " + id + " deleted.");
                    break;
                }
                case 5: {
                    // Get All Trucks
                    System.out.println("Fetching all trucks...");
                    List<Truck> allTrucks = truckService.getAllTrucks();
                    if (allTrucks.isEmpty()) {
                        System.out.println("No trucks available.");
                    } else {
                        System.out.println("All trucks:");
                        for (Truck truck : allTrucks) {
                            System.out.println(truck);
                        }
                    }
                    break;
                }
                case 6: {
                    // Exit the program
                    System.out.println("Exiting the program...");
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                    break;
                }
            }
        } while (choice != 6);

        scanner.close();
    }
}
