package services;

import models.Sneaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class SneakerService {
    private static int nextId = 1;  // (1)

    private static List<Sneaker> inventory = new ArrayList<>();

    public static Sneaker create(String name, String brand, String sport, double size, int quantity, float price) {

        // (2)
        Sneaker createdSneaker = new Sneaker(nextId++, name, brand, sport, size, quantity, price);

        // (3)
        inventory.add(createdSneaker);

        // (4)
        return createdSneaker;
    }

    //read
    // should take an int and return an object with that id, if exists
    public Sneaker findSneaker(int id) {
        for (Sneaker sneaker : inventory) {
            if (sneaker.getId() == id) {
                return sneaker;
            }
        }
        return null;
    }

    //read all
    public Sneaker[] findAll() {
        // should return a basic array copy of the ArrayList
        Sneaker[] sneakerArray = new Sneaker[inventory.size()];

        sneakerArray = inventory.toArray(sneakerArray);

        return sneakerArray;
    }

    //delete
    public boolean delete(int id) {
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
}
