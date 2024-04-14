package io;

import models.Reel;
import models.Rod;
import services.ReelService;
import services.RodService;
import services.SneakerService;
import utils.CSVUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RodApp {
    public static void main(String... args) throws IOException {

        RodApp application = new RodApp();
        Console.printWelcome();
        application.loadData();
        application.rodMenu();

    }

    public void loadData(){
        // (1)
        String csvFile = "/Users/michael/Desktop/Projects/Product-Inventory-Lab/src/main/resources/Rod.csv";
        String line = "";
        String csvSplitBy = ",";

        // (2)
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            RodService.rodId = Integer.parseInt(br.readLine());  // (3)

            while ((line = br.readLine()) != null) {
                // split line with comma
                String[] rodData = line.split(csvSplitBy);

                // (4)
                int id = Integer.parseInt(rodData[0]);
                String name = rodData[1];
                String brand = rodData[2];
                String rodType = rodData[3];
                String rodSize = rodData[4];
                int qty = Integer.parseInt(rodData[5]);
                float price = Float.parseFloat(rodData[6]);

                // (5)
                RodService.rodInventory.add(new Rod(id, name, brand, rodType, rodSize, qty, price));
            }
        } catch (IOException e) {
            System.out.println("Cant find anything in the file.");
            e.printStackTrace();
        }

        String csvFile2 = "/Users/michael/Desktop/Projects/Product-Inventory-Lab/src/main/resources/Reel.csv";
        String line2 = "";
        String csvSplitBy2 = ",";

        // (2)
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile2))) {
            ReelService.reelId = Integer.parseInt(br.readLine());  // (3)

            while ((line2 = br.readLine()) != null) {
                // split line with comma
                String[] reelData = line2.split(csvSplitBy2);

                // (4)
                int id = Integer.parseInt(reelData[0]);
                String name = reelData[1];
                String brand = reelData[2];
                String gearRatio = reelData[3];
                String reelType = reelData[4];
                int reelSize = Integer.parseInt(reelData[5]);
                int qty = Integer.parseInt(reelData[6]);
                float price = Float.parseFloat(reelData[7]);

                // (5)
                ReelService.reelInventory.add(new Reel(id, name, brand, gearRatio, reelType, reelSize, qty, price));
            }
        } catch (IOException e) {
            System.out.println("Cant find anything in the file.");
            e.printStackTrace();
        }
    }

    private void rodMenu() throws IOException {
        label:
        while (true) {
            String userInput = Console.getStringInput("Input command:\n[-create] [-update] [-find] [-inv] [-remove] [-save] [-stop]").toLowerCase();
            switch (userInput) {
                case "-create":
                    String createdInput = Console.getStringInput("You picked Create, Please input the following:\n [-rod] [-reel]").toLowerCase();
                    switch (createdInput) {
                        case "-rod":
                            Console.print("You picked Creating a Rod, Please input the following:");
                            Console.createRodInput();
                            break;
                        case "-reel":
                            Console.print("You picked Creating a Reel, Please input the following:");
                            Console.createReelInput();
                            break;
                    }
                    break;
                case "-update":
                    String updatedInput = Console.getStringInput("You picked Update, Please input the following:\n [-rod] [-reel]").toLowerCase();
                    switch (updatedInput) {
                        case "-rod":
                            int rodId = Console.getIntInput("You picked update a Rod, Please enter an Id:");
                            Rod fishingRod = RodService.findRod(rodId);
                            if (fishingRod != null) {
                                String name = Console.getStringInput("Enter new name:");
                                String brand = Console.getStringInput("Enter new brand:");
                                String rodType = Console.getStringInput("Enter new Rod Type {Fresh/Salt/Fly}:");
                                String size = Console.getStringInput("Enter new size:");
                                int quantity = Console.getIntInput("Enter new quantity:");
                                float price = Console.getFloatInput("Enter new price:");

                                boolean updated = RodService.update(rodId, name, brand, rodType, size, quantity, price);
                                if (updated) {
                                    Console.print("Rod updated successfully.");
                                } else {
                                    Console.print("Failed to update Rod. Rod not found.");
                                }
                            } else {
                                Console.print("Rod not found with ID: " + rodId);
                            }
                            break;
                        case "-reel":
                            int reelId = Console.getIntInput("You picked update a Reel, Please enter an Id:");
                            Reel reel = ReelService.findReel(reelId);
                            if (reel != null) {
                                String name = Console.getStringInput("Enter new name:");
                                String brand = Console.getStringInput("Enter new brand:");
                                String gearRatio = Console.getStringInput("Enter new Gear Ratio:");
                                String reelType = Console.getStringInput("Enter new Reel Type:");
                                int size = Console.getIntInput("Enter new size:");
                                int quantity = Console.getIntInput("Enter new quantity:");
                                float price = Console.getFloatInput("Enter new price:");

                                boolean updated = ReelService.update(reelId, name, brand, gearRatio, reelType, size, quantity, price);
                                if (updated) {
                                    Console.print("Reel updated successfully.");
                                } else {
                                    Console.print("Failed to update Reel. Reel not found.");
                                }
                            } else {
                                Console.print("Reel not found with ID: " + reelId);
                            }
                            break;
                    }
                    break;
                case "-find":
                    String findInput = Console.getStringInput("You picked find, Please input the following:\n [-rod] [-reel]").toLowerCase();
                    switch (findInput) {
                        case "-rod":
                            int rodId = Console.getIntInput("You picked find a Rod, Please enter an Id:");
                            Rod rod = RodService.findRod(rodId);
                            if (rod != null) {
                                Console.print("Rod found:\n" + rod.toString());
                            } else {
                                Console.print("Rod not found with ID: " + rodId);
                            }
                            break;
                        case "-reel":
                            int reelId = Console.getIntInput("You picked find a Reel, Please enter an Id:");
                            Reel reel = ReelService.findReel(reelId);
                            if (reel != null) {
                                Console.print("Reel found:\n" + reel.toString());
                            } else {
                                Console.print("Reel not found with ID: " + reelId);
                            }
                            break;
                    }
                    break;
                case "-inv":
                    String invInput = Console.getStringInput("You picked inventory, Please input the following:\n [-rod] [-reel]").toLowerCase();
                    switch (invInput) {
                        case "-rod":
                            Console.print("You picked Rod Inventory:");
                            Rod[] allRods = RodService.findAll();
                            for (Rod rod : allRods) {
                                Console.print(rod.toString());
                            }
                            RodService.findAll();
                            break;
                        case "-reel":
                            Console.print("You picked Reel Inventory:");
                            Reel[] allReels = ReelService.findAll();
                            for (Reel reel : allReels) {
                                Console.print(reel.toString());
                            }
                            ReelService.findAll();
                            break;
                    }
                    break;
                case "-remove":
                    String removeInput = Console.getStringInput("You picked remove, Please input the following:\n [-rod] [-reel]").toLowerCase();
                    switch (removeInput) {
                        case "-rod":
                            int rodId = Console.getIntInput("You picked remove a Rod, Please enter an Id:");
                            RodService.delete(rodId);
                            break;
                        case "-reel":
                            int reelID = Console.getIntInput("You picked remove a Reel, Please enter an Id:");
                            ReelService.delete(reelID);
                            break;
                    }
                    break;
                case "-save":
                    CSVUtils.writeRodList();
                    CSVUtils.writeReelList();
                    break;
                case "-stop":
                    Console.print("You have ended the program, Goodbye!");
                    return;
                default:
                    Console.print("Invalid command. Please try again.");
            }
        }
    }
}
