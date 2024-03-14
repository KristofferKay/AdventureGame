public class Food extends Consumables {
    private int healthPoints;

    public Food(String shortName, String description, int healthPoints) {
        super(shortName, description, healthPoints);
        this.healthPoints=healthPoints;
    }
    public boolean isFood(){
        return this instanceof Food;
    } // TODO skal isFood ligge i consumable i stedet?

}
