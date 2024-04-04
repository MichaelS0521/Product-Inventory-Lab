package models;

public class Sneaker {
    private int id;
    private String name;
    private String brand;
    private String sport;
    private double size;
    private int qty;
    private float price;

    public Sneaker(int id, String name, String brand, String sport, int qty, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.sport = sport;
        this.qty = qty;
        this.price = price;
    }

    public Sneaker(int id, String name, String brand, String sport, double size, int qty, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.sport = sport;
        this.size = size;
        this.qty = qty;
        this.price = price;
    }

    public Sneaker() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getSport() {
        return sport;
    }

    public int getQty() {
        return qty;
    }

    public float getPrice() {
        return price;
    }

    public double getSize() {
        return size;
    }

    public void setId(int id) { this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n********************\n" +
                "ID: [" + id +
                "]\nName: " + name +
                "\nBrand: " + brand +
                "\nSport: " + sport +
                "\nSize: " + size +
                "\nQuantity: " + qty +
                "\nPrice: $" + price +
                "\n********************\n";
    }

}
