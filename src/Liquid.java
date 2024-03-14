public class Liquid extends Consumables{
    private int healthPoints;
    public Liquid(String shortName, String description, int healthPoints) {
        super(shortName, description, healthPoints);
        this.healthPoints=healthPoints;
    }

    public boolean isLiquid(){
        return this instanceof Liquid;
    }

}
