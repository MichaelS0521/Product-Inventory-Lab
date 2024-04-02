package models;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SneakerTest {

    @Test
    public void setNameTest() {
        String expected = "Nike";

        Sneaker testSneaker = new Sneaker(0, null, null, null, 0, 0.00f);
        testSneaker.setName(expected);

        Assertions.assertEquals(expected, testSneaker.getName());
    }

    @Test
    public void constructorTest() {
        int expectedId = 6;
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        int expectedQty = 10;
        float expectedPrice = 80.00f;

        Sneaker testSneaker = new Sneaker(expectedId, expectedName, expectedBrand, expectedSport, expectedQty, expectedPrice);

        Assertions.assertEquals(expectedId, testSneaker.getId());
        Assertions.assertEquals(expectedName, testSneaker.getName());
        Assertions.assertEquals(expectedBrand, testSneaker.getBrand());
        Assertions.assertEquals(expectedSport, testSneaker.getSport());
        Assertions.assertEquals(expectedQty, testSneaker.getQty());
        Assertions.assertEquals(expectedPrice, testSneaker.getPrice());
    }
}
