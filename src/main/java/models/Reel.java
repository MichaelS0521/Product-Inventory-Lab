package models;

public class Reel {
    private int id;
    private String name;
    private String brand;
    private String gearRatio;
    private String reelStyle;
    private int size;
    private int qty;
    private float price;

    public Reel(int id, String name, String brand, String gearRatio, String reelStyle, int size, int qty, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.gearRatio = gearRatio;
        this.reelStyle = reelStyle;
        this.size = size;
        this.qty = qty;
        this.price = price;
    }

    public String getReelStyle() {
        return reelStyle;
    }

    public void setReelStyle(String reelStyle) {
        this.reelStyle = reelStyle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGearRatio() {
        return gearRatio;
    }

    public void setGearRatio(String gearRatio) {
        this.gearRatio = gearRatio;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getPrice() {
        return price;
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
                "ID: [" + id +
                "]\nName: " + name +
                "\nBrand: " + brand +
                "\nGear Ratio: " + gearRatio +
                "\nReel Style: " + reelStyle +
                "\nSize: " + size +
                "\nQuantity: " + qty +
                "\nPrice: $" + price +
                "\n********************\n";
    }
}
