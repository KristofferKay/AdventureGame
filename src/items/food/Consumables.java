package items.food;

import items.Item;

public class Consumables extends Item {
    private int healthPoints;

    public Consumables(String shortName, String description, int healthPoints) {
        super(shortName, description);
        this.healthPoints=healthPoints;
    }
    public int getHealthPoints () {
        return healthPoints;
    }
}
