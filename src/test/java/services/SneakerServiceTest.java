package services;

import models.Sneaker;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class SneakerServiceTest {

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
    public void findTest() {
        List<Sneaker> inventory = new ArrayList<>();
        inventory.add(SneakerService.create("AirMax", "Nike", "Baseball", 10.5, 10, 99.99f));
        inventory.add(SneakerService.create("Tracks", "Adidas", "Track & Field", 11.5, 10, 79.99f));
        inventory.add(SneakerService.create("Extremes", "Nike", "Basketball", 11.0, 10, 100.99f));

        
    }
}

