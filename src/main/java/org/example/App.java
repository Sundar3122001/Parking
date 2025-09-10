package org.example;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MultiVehicleParkingSystem system = new MultiVehicleParkingSystem();

        // --- Setup facilities ---
        system.addFacility(new Facility("CycleLot", "Cycle", 10, 100000, 10));
        system.addFacility(new Facility("CarLot", "Car", 12, 75000, 15));
        system.addFacility(new Facility("BikeLot", "Bike", 8, 100000, 15));
        system.addFacility(new Facility("MinibusLot", "Minibus", 6, 100000, 6));
        system.addFacility(new Facility("CargoLot", "Cargo", 6, 100000, 6));

        int choice = -1;

        while (choice != 0) {
            System.out.println("\n===== Multi-Vehicle Parking System =====");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Release Vehicle");
            System.out.println("3. Show Availability");
            System.out.println("4. Report Theft");
            System.out.println("5. Register User & Verify Identity");
            System.out.println("6. Add Valet");
            System.out.println("7. Assign Valet to Facility");
            System.out.println("8. Show Valets in Facility");
            System.out.println("9. Show Available Valets"); // NEW
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            switch (choice) {
                case 1: // Park Vehicle
                    System.out.print("Enter Vehicle Type (Cycle/Car/Bike/Minibus/Cargo): ");
                    String vType = scanner.nextLine();
                    System.out.print("Enter Vehicle ID: ");
                    String vId = scanner.nextLine();
                    Vehicle vehicle;
                    switch (vType.toLowerCase()) {
                        case "cycle": vehicle = new Cycle(vId); break;
                        case "car": vehicle = new Car(vId); break;
                        case "bike": vehicle = new Bike(vId); break;
                        case "minibus": vehicle = new Minibus(vId); break;
                        case "cargo": vehicle = new Cargo(vId); break;
                        default:
                            System.out.println("Invalid vehicle type!");
                            continue;
                    }
                    System.out.print("Enter Facility Name: ");
                    String facilityName = scanner.nextLine();
                    system.parkVehicle(vehicle, facilityName);
                    break;

                case 2: // Release Vehicle
                    System.out.print("Enter Vehicle ID: ");
                    String rId = scanner.nextLine();
                    System.out.print("Enter Facility Name: ");
                    String rFacility = scanner.nextLine();
                    system.releaseVehicle(rId, rFacility);
                    break;

                case 3: // Show Availability
                    system.showAvailability();
                    break;

                case 4: // Report Theft
                    System.out.print("Enter Vehicle ID: ");
                    String tId = scanner.nextLine();
                    System.out.print("Enter Facility Name: ");
                    String tFacility = scanner.nextLine();
                    system.reportTheft(tId, tFacility);
                    break;

                case 5: // Register User
                    System.out.print("Enter User ID: ");
                    String uId = scanner.nextLine();
                    System.out.print("Enter User Name: ");
                    String uName = scanner.nextLine();
                    User user = new User(uId, uName);
                    system.registerUser(user);
                    boolean verified = system.verifyIdentity(uId);
                    System.out.println("User " + uName + " verified: " + verified);
                    break;

                case 6: // Add Valet
                    System.out.print("Enter Valet ID: ");
                    String valetId = scanner.nextLine();
                    System.out.print("Enter Valet Name: ");
                    String valetName = scanner.nextLine();
                    System.out.print("Enter Valet Skill: ");
                    String skill = scanner.nextLine();
                    Valet valet = new Valet(valetId, valetName, skill);
                    system.getValetSystem().addValet(valet);
                    System.out.println("Valet " + valetName + " added.");
                    break;

                case 7: // Assign Valet
                    System.out.print("Enter Valet ID: ");
                    String assignId = scanner.nextLine();
                    System.out.print("Enter Facility Name: ");
                    String assignFacility = scanner.nextLine();
                    Facility fac = system.getFacility(assignFacility);
                    if(fac != null)
                        system.getValetSystem().assignValetToFacility(assignId, fac);
                    else
                        System.out.println("Facility not found!");
                    break;

                case 8: // Show Valets in Facility
                    System.out.print("Enter Facility Name: ");
                    String showFacility = scanner.nextLine();
                    Facility f = system.getFacility(showFacility);
                    if(f != null) {
                        List<Valet> valets = system.getValetSystem().getValetsForFacility(f);
                        System.out.println("Valets in " + showFacility + ":");
                        for(Valet v : valets)
                            System.out.println("- " + v.getValetId() + " (" + v.getName() + ", Skill: " + v.getSkillSet() + ")");
                    } else {
                        System.out.println("Facility not found!");
                    }
                    break;

                case 9: // Show Available Valets
                    system.getValetSystem().showAvailableValets();
                    break;

                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        scanner.close();
    }
}
