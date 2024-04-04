package io;

import models.Sneaker;
import services.SneakerService;

import java.lang.invoke.StringConcatFactory;


public class App {

    public static void main(String... args) {

        App application = new App();
        Console.printWelcome();
        application.init();

    }

    private void init() {
        while (true) {
            String userInput = Console.getStringInput("Input command:\n[-create] [-update] [-find] [-inv] [-remove] [-stop]").toLowerCase();
            if (userInput.equals("-create")) {
                Console.print("You picked Creating a Sneaker, Please input the following:");
                Console.createSneakerInput();
            } else if (userInput.equals("-update")) {
                int sneakerId = Console.getIntInput("You picked update a Sneaker, Please enter an Id:");
                Sneaker existingSneaker = SneakerService.findSneaker(sneakerId);
                if (existingSneaker != null) {
                    String name = Console.getStringInput("Enter new name:");
                    String brand = Console.getStringInput("Enter new brand:");
                    String sport = Console.getStringInput("Enter new sport:");
                    double size = Console.getDoubleInput("Enter new size:");
                    int quantity = Console.getIntInput("Enter new quantity:");
                    float price = Console.getFloatInput("Enter new price:");

                    boolean updated = SneakerService.update(sneakerId, name, brand, sport, size, quantity, price);
                    if (updated) {
                        Console.print("Sneaker updated successfully.");
                    } else {
                        Console.print("Failed to update sneaker. Sneaker not found.");
                    }
                } else {
                    Console.print("Sneaker not found with ID: " + sneakerId);
                }
            } else if (userInput.equals("-find")) {
                int sneakerId = Console.getIntInput("You picked find a Sneaker, Please enter an Id:");
                Sneaker foundSneaker = SneakerService.findSneaker(sneakerId);
                if (foundSneaker != null) {
                    Console.print("Sneaker found:\n" + foundSneaker.toString());
                } else {
                    Console.print("Sneaker not found with ID: " + sneakerId);
                }
            } else if (userInput.equals("-inv")) {
                Console.print("You picked Sneaker Inventory:");
                Sneaker[] allSneakers = SneakerService.findAll();
                for (Sneaker sneaker : allSneakers) {
                    Console.print(sneaker.toString());
                }
                SneakerService.findAll();
            } else if (userInput.equals("-remove")) {
                int sneakerId = Console.getIntInput("You picked remove a Sneaker, Please enter an Id:");
                SneakerService.delete(sneakerId);
            } else if (userInput.equals("-stop")) {
                Console.print("You have ended the program, Goodbye!");
                break;
            }
        }
    }

}
