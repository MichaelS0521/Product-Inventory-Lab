package services;

import models.Reel;
import models.Rod;

import java.rmi.server.RemoteRef;
import java.util.ArrayList;
import java.util.List;

public class ReelService {
    public static int reelId = 1;
    public static final List<Reel> reelInventory = new ArrayList<>();

    public static Reel create(String name, String brand, String gearRatio, String reelStyle, int size, int qty, float price) {

        Reel createdReel = new Reel(reelId++, name, brand, gearRatio, reelStyle, size, qty, price);

        reelInventory.add(createdReel);

        return createdReel;
    }

    public static Reel findReel(int id) {
        for (Reel reel : reelInventory) {
            if (reel.getId() == id) {
                return reel;
            }
        }
        return null;
    }

    //read all
    public static Reel[] findAll() {
        Reel[] reels = new Reel[reelInventory.size()];

        reels = reelInventory.toArray(reels);

        return reels;
    }

    //delete
    public static boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        for (Reel reel : reelInventory) {
            if (reel.getId() == id) {
                reelInventory.remove(id);
                return true;
            }
        }
        return false;
    }

    public static boolean update(int id, String name, String brand, String gearRatio, String reelStyle, int size, int qty, float price) {
        for (Reel reel : reelInventory) {
            if (reel.getId() == id) {
                reel.setName(name);
                reel.setBrand(brand);
                reel.setGearRatio(gearRatio);
                reel.setReelStyle(reelStyle);
                reel.setSize(size);
                reel.setQty(qty);
                reel.setPrice(price);
                return true;
            }

        }
        return false;
    }
}
