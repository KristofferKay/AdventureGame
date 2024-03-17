package items;

import items.food.Consumables;
import items.food.Food;

public class Item {
    private String shortName;
    private String longName;

    public Item(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    @Override
    public String toString() {
        return shortName;
    }

    public boolean isConsumable(){
        return this instanceof Consumables;
    }

}