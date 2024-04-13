package utils;

import models.Reel;
import models.Rod;
import models.Sneaker;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static services.ReelService.reelId;
import static services.ReelService.reelInventory;
import static services.RodService.rodId;
import static services.RodService.rodInventory;
import static services.SneakerService.inventory;
import static services.SneakerService.nextId;

public class CSVUtils {
    private static final char DEFAULT_SEPARATOR = ',';  // (1)

    // (2)
    public static void writeLine(Writer w, List<String> values) throws IOException {
        boolean first = true;

        StringBuilder sb = new StringBuilder();

        // (3)
        for (String value : values) {
            if (!first) {
                sb.append(DEFAULT_SEPARATOR);
            }
            sb.append(value);
            first = false;
        }
        sb.append("\n");

        w.append(sb.toString());  // (4)
    }

    public static void writeList() throws IOException {
        String csvFile = "/Users/michael/Desktop/Projects/Product-Inventory-Lab/src/main/resources/Sneaker.csv";
        FileWriter writer = new FileWriter(csvFile); //(1)

        CSVUtils.writeLine(writer, new ArrayList<>(Arrays.asList(String.valueOf(nextId))));  // (2)

        for (Sneaker s : inventory) {
            List<String> list = new ArrayList<>(); // (3)
            list.add(String.valueOf(s.getId()));
            list.add(s.getName());
            list.add(s.getBrand());
            list.add(s.getSport());
            list.add(String.valueOf(s.getQty()));
            list.add(String.valueOf(s.getPrice()));

            CSVUtils.writeLine(writer, list);  // (4)
        }

// (5)
        writer.flush();
        writer.close();

    }

    public static void writeRodList() throws IOException {
        String csvFile = "/Users/michael/Desktop/Projects/Product-Inventory-Lab/src/main/resources/Rod.csv";
        FileWriter writer = new FileWriter(csvFile); //(1)

        CSVUtils.writeLine(writer, new ArrayList<>(Arrays.asList(String.valueOf(rodId))));  // (2)

        for (Rod rod : rodInventory) {
            List<String> list = new ArrayList<>(); // (3)
            list.add(String.valueOf(rod.getId()));
            list.add(rod.getName());
            list.add(rod.getBrand());
            list.add(rod.getRodType());
            list.add(String.valueOf(rod.getSize()));
            list.add(String.valueOf(rod.getQty()));
            list.add(String.valueOf(rod.getPrice()));

            CSVUtils.writeLine(writer, list);  // (4)
        }

// (5)
        writer.flush();
        writer.close();

    }

    public static void writeReelList() throws IOException {
        String csvFile = "/Users/michael/Desktop/Projects/Product-Inventory-Lab/src/main/resources/Reel.csv";
        FileWriter writer = new FileWriter(csvFile); //(1)

        CSVUtils.writeLine(writer, new ArrayList<>(Arrays.asList(String.valueOf(reelId))));  // (2)

        for (Reel reel : reelInventory) {
            List<String> list = new ArrayList<>(); // (3)
            list.add(String.valueOf(reel.getId()));
            list.add(reel.getName());
            list.add(reel.getBrand());
            list.add(reel.getGearRatio());
            list.add(String.valueOf(reel.getSize()));
            list.add(String.valueOf(reel.getQty()));
            list.add(String.valueOf(reel.getPrice()));

            CSVUtils.writeLine(writer, list);  // (4)
        }

// (5)
        writer.flush();
        writer.close();

    }

}