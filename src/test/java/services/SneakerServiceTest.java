package services;

import models.Sneaker;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;


public class SneakerServiceTest {
    private SneakerService inventory;

    @Before
    public void setUp() {

        inventory = new SneakerService();
        inventory.create("Nike Air Max", "Nike", "Running", 10.5, 5, 120.0f);
        inventory.create("Adidas Superstar", "Adidas", "Casual", 9.0, 3, 80.0f);
        inventory.create("Reebok Classic", "Reebok", "Lifestyle", 11.0, 8, 90.0f);
    }

    @Test
    public void createTest(){

        // (1)
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        double expectedSize = 10.5;
        int expectedQty = 10;
        float expectedPrice = 80.00f;

        Sneaker testSneaker = SneakerService.create(expectedName, expectedBrand,
                expectedSport, expectedSize, expectedQty, expectedPrice);

        // (3)
        int actualId = testSneaker.getId();
        String actualName = testSneaker.getName();
        String actualBrand = testSneaker.getBrand();
        String actualSport = testSneaker.getSport();
        double actualSize = testSneaker.getSize();
        int actualQty = testSneaker.getQuantity();
        float actualPrice = testSneaker.getPrice();

        // (4)
        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedBrand, actualBrand);
        Assertions.assertEquals(expectedSport, actualSport);
        Assertions.assertEquals(expectedSize, actualSize);
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void findSneakerTest() {
        Sneaker sneakerFound = inventory.findSneaker(2);
        Assertions.assertEquals(2, sneakerFound.getId());
    }

    @Test
    public void findAll() {
        Sneaker[] sneakers = inventory.findAll();

        Assertions.assertEquals(3, sneakers.length);
    }

    @Test
    public void delete() {
        boolean removedSneaker = inventory.delete(2);
        Sneaker[] sneakers = inventory.findAll();

        Assertions.assertEquals(2, sneakers.length);
        Assertions.assertTrue(removedSneaker);
    }
}

