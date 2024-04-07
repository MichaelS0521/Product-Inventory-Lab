package utils;

import models.Sneaker;
import services.SneakerService;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        FileWriter writer = new FileWriter(csvFile, true); //(1)

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

    public void loadData(){
        // (1)
        String csvFile = "/Users/michael/Desktop/Projects/Product-Inventory-Lab/src/main/resources/Sneaker.csv";
        String line = "";
        String csvSplitBy = ",";

        // (2)
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            if (br.readLine() != null) {
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
            }
            } catch(IOException e){
                System.out.println("Cant find anything in the file.");
                e.printStackTrace();
            }
    }

}