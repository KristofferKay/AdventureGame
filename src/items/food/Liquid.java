package items.food;

public class Liquid extends Consumables {

    public Liquid(String shortName, String description, int healthPoints) {
        super(shortName, description, healthPoints);
    }

    public boolean isLiquid(){
        return this instanceof Liquid;
    } //TODO it always returns true, should be placed either in Item or in Consumables

}
