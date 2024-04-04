package io;

import models.Sneaker;
import services.SneakerService;

import java.util.Scanner;

public class Console {

    private static Scanner scan = new Scanner(System.in);
    public static void printWelcome(){
        System.out.println("\n" +
                "**************************************************\n" +
                "***           Welcome and Bienvenue            ***\n" +
                "***                    to                      ***\n" +
                "***          ZipCo Inventory Manager           ***\n" +
                "**************************************************\n");
    }

    public static void println(String val) {
        print(val);
    }

    public static String getStringInput(String prompt) {
        print(prompt);

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

}
