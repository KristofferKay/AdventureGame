public class Food extends Item{
    int healthPoints;
    public Food(String shortName, String longName) {
        super(shortName, longName);
    }

    public Food(String shortName, String longName, int healthPoints) {
        super(shortName, longName);
        this.healthPoints = healthPoints;
    }
}
