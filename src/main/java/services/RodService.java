package services;

import models.Rod;

import java.util.ArrayList;
import java.util.List;

public class RodService {
    public static int rodId = 1;
    public static final List<Rod> rodInventory = new ArrayList<>();

    //    "ID: [" + id +
//            "]\nName: " + name +
//            "\nBrand: " + brand +
//            "\nRod Type: " + rodType +
//            "\nSize: " + size +
//            "\nQuantity: " + qty +
//            "\nPrice: $" + price +
    public static Rod create(String name, String brand, String rodType, double size, int qty, float price) {

        Rod fishingRod = new Rod(rodId++, name, brand, rodType, size, qty, price);

        rodInventory.add(fishingRod);

        return fishingRod;
    }

    public static Rod findRod(int id) {
        for (Rod rod : rodInventory) {
            if (rod.getId() == id) {
                return rod;
            }
        }
        return null;
    }

    //read all
    public static Rod[] findAll() {
        Rod[] rods = new Rod[rodInventory.size()];

        rods = rodInventory.toArray(rods);

        return rods;
    }

    //delete
    public static boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        for (Rod rod : rodInventory) {
            if (rod.getId() == id) {
                rodInventory.remove(id);
                return true;
            }
        }
        return false;
    }

    public static boolean update(int id, String name, String brand, String rodType, double size, int qty, float price) {
        for (Rod rod : rodInventory) {
            if (rod.getId() == id) {
                rod.setName(name);
                rod.setBrand(brand);
                rod.setRodType(rodType);
                rod.setSize(size);
                rod.setQty(qty);
                rod.setPrice(price);
                return true;
            }

        }
        return false;
    }
}
