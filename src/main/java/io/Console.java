package io;

import models.Reel;
import models.Rod;
import models.Sneaker;
import services.ReelService;
import services.RodService;
import services.SneakerService;

import java.util.Scanner;

public class Console {

    private static Scanner scan = new Scanner(System.in);
    public static void printWelcome(){
        System.out.println("\n" +
                "**************************************************\n" +
                "***           Welcome and Bienvenue            ***\n" +
                "***                    to                      ***\n" +
                "***        ZipCode Inventory Manager           ***\n" +
                "**************************************************\n");
    }

    public static void println(String val) {
        print(val);
    }

    public static String getStringInput(String prompt) {
        println(prompt);

        return scan.nextLine();
    }

    public static int getIntInput(String prompt) {
        println(prompt);

        return scan.nextInt();
    }

    public static double getDoubleInput(String prompt) {
        println(prompt);

        return scan.nextDouble();
    }

    public static float getFloatInput(String prompt) {
        println(prompt);

        return scan.nextFloat();
    }


    public static void print(String output) {
        System.out.println(output);
    }

    public static Sneaker createSneakerInput() {
        String sneakerName = getStringInput("Name:");
        String sneakerBrand = getStringInput("Brand:");
        String sneakerSport = getStringInput("Sport:");
        double sneakerSize = getDoubleInput("Size:");
        int sneakerQty = getIntInput("Qty:");
        float sneakerPrice = getFloatInput("Price:");

        return SneakerService.create(sneakerName, sneakerBrand, sneakerSport, sneakerSize, sneakerQty,sneakerPrice);
    }

    public static Rod createRodInput() {
        String rodName = getStringInput("Name:");
        String rodBrand = getStringInput("Brand:");
        String rodType = getStringInput("RodType {Fresh/Salt/Fly}:");
        double rodSize = getDoubleInput("Size:");
        int rodQty = getIntInput("Qty:");
        float rodPrice = getFloatInput("Price:");

        return RodService.create(rodName, rodBrand, rodType, rodSize, rodQty, rodPrice);
    }

    public static Reel createReelInput() {
        String reelName = getStringInput("Name:");
        String reelBrand = getStringInput("Brand:");
        String reelGearRatio = getStringInput("Gear Ratio {5.2:1, 6.2:1} :");
        int reelSize = getIntInput("Size:");
        int reelQty = getIntInput("Qty:");
        float reelPrice = getFloatInput("Price:");

        return ReelService.create(reelName, reelBrand, reelGearRatio, reelSize, reelQty, reelPrice);
    }

}
