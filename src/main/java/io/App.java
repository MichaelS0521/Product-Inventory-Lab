package io;

import models.Sneaker;
import services.SneakerService;
import utils.CSVUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.lang.invoke.StringConcatFactory;


public class App {

    public static void main(String... args) throws IOException {

        App application = new App();
        Console.printWelcome();
        application.loadData();
        application.init();

    }

    public void loadData(){
        // (1)
        String csvFile = "/Users/michael/Desktop/Projects/Product-Inventory-Lab/src/main/resources/Sneaker.csv";
        String line = "";
        String csvSplitBy = ",";

        // (2)
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            SneakerService.nextId = Integer.parseInt(br.readLine());  // (3)

            while ((line = br.readLine()) != null) {
                // split line with comma
                String[] sneakerData = line.split(csvSplitBy);

                // (4)
                int id = Integer.parseInt(sneakerData[0]);
                String name = sneakerData[1];
                String brand = sneakerData[2];
                String sport = sneakerData[3];
                int qty = Integer.parseInt(sneakerData[4]);
                float price = Float.parseFloat(sneakerData[5]);

                // (5)
                SneakerService.inventory.add(new Sneaker(id, name, brand, sport, qty, price));
            }
        } catch (IOException e) {
            System.out.println("Cant find anything in the file.");
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        while (true) {
            String userInput = Console.getStringInput("Input command:\n[-create] [-update] [-find] [-inv] [-remove] [-save] [-stop]").toLowerCase();
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
            } else if (userInput.equals("-save")) {
                CSVUtils.writeList();
            }
            else if (userInput.equals("-stop")) {
                Console.print("You have ended the program, Goodbye!");
                break;
            }
        }
    }

}
