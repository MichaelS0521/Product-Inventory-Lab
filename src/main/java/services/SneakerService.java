package services;

import models.Sneaker;

import java.util.ArrayList;
import java.util.List;

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
}
