package services;

import models.Sneaker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SneakerService {
    public static int nextId = 1;  // (1)

    public static final List<Sneaker> inventory = new ArrayList<>();

    public static Sneaker create(String name, String brand, String sport, double size, int quantity, float price) {

        for (Sneaker exsistingSneaker : inventory) {
            if (exsistingSneaker.getId() == nextId) {
                nextId++;
            }
        }

        // (2)
        Sneaker createdSneaker = new Sneaker(nextId, name, brand, sport, size, quantity, price);

        // (3)
        inventory.add(createdSneaker);

        nextId++;

        // (4)
        return createdSneaker;
    }

    //read
    // should take an int and return an object with that id, if exists
    public static Sneaker findSneaker(int id) {
        for (Sneaker sneaker : inventory) {
            if (sneaker.getId() == id) {
                return sneaker;
            }
        }
        return null;
    }

    //read all
    public static Sneaker[] findAll() {
        Sneaker[] sneakerArray = new Sneaker[inventory.size()];

        sneakerArray = inventory.toArray(sneakerArray);

        return sneakerArray;
    }

    //delete
    public static boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        for (Sneaker sneaker : inventory) {
            if (sneaker.getId() == id) {
                inventory.remove(id);
                return true;
            }
        }
        return false;
    }

    public static boolean update(int id, String name, String brand, String sport, double size, int quantity, float price) {
        for (Sneaker sneaker : inventory) {
            if (sneaker.getId() == id) {
                sneaker.setName(name);
                sneaker.setBrand(brand);
                sneaker.setSport(sport);
                sneaker.setSize(size);
                sneaker.setQty(quantity);
                sneaker.setPrice(price);
                return true;
            }

        }
        return false;
    }

}
