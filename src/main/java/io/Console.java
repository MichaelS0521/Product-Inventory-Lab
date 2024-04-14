package io;

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

        return scan.next();
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

    public static void createSneakerInput() {
        String sneakerName = getStringInput("Name:");
        String sneakerBrand = getStringInput("Brand:");
        String sneakerSport = getStringInput("Sport:");
        double sneakerSize = getDoubleInput("Size:");
        int sneakerQty = getIntInput("Qty:");
        float sneakerPrice = getFloatInput("Price:");

        SneakerService.create(sneakerName, sneakerBrand, sneakerSport, sneakerSize, sneakerQty, sneakerPrice);
    }

    public static void createRodInput() {
        String rodName = getStringInput("Name:");
        String rodBrand = getStringInput("Brand:");
        String rodType = getStringInput("RodType {Fresh/Salt/Fly}:");
        String rodSize = getStringInput("Size:");
        int rodQty = getIntInput("Qty:");
        float rodPrice = getFloatInput("Price:");

        RodService.create(rodName, rodBrand, rodType, rodSize, rodQty, rodPrice);
    }

    public static void createReelInput() {
        String reelName = getStringInput("Name:");
        String reelBrand = getStringInput("Brand:");
        String reelGearRatio = getStringInput("Gear Ratio {5.2:1, 6.2:1, 7.2:1, 8.1:1}:");
        String reelStyle = getStringInput("Reel Style {BaitCaster, SpinningReel, FlyReel}:");
        int reelSize = getIntInput("Size {500, 1000, 1500, etc...:");
        int reelQty = getIntInput("Qty:");
        float reelPrice = getFloatInput("Price: $");

        ReelService.create(reelName, reelBrand, reelGearRatio, reelStyle, reelSize, reelQty, reelPrice);
    }

}
