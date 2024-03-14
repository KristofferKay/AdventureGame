public class Food extends Item {
    private int healthPoints;

    public Food(String shortName, String description, int healthPoints) {
        super(shortName, description);
        this.healthPoints=healthPoints;

    }
    public int getHealthPoints () {
        return healthPoints;
    }
}
