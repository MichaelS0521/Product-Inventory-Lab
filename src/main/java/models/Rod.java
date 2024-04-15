package models;

import services.RodService;

public class Rod {
    private int id;
    private String name;
    private String brand;
    private String rodType;
    private String size;
    private int qty;
    private float price;

    public Rod(int id, String name, String brand, String rodType, String size, int qty, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.rodType = rodType;
        this.size = size;
        this.qty = qty;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getRodType() {
        return rodType;
    }

    public String getSize() {
        return size;
    }

    public int getQty() {
        return qty;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setRodType(String rodType) {
        this.rodType = rodType;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void decrementId() {
        id--;
    }

    @Override
    public String toString() {
        return "\n********************\n" +
                RodService.inStock(id) +
                "\nID: [" + id + "]" +
                "\nName: " + name +
                "\nBrand: " + brand +
                "\nRod Type: " + rodType +
                "\nSize: " + size +
                "\nQuantity: " + qty +
                "\nPrice: 💲" + price +
                "\n********************\n";
    }
}
