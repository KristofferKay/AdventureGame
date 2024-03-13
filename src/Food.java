public class Food extends Item {
    private int healthPoints;
    private String description;

    public Food(String shortName, int healthPoints) {
        super(shortName);
        this.healthPoints = healthPoints;
    }

    public Food(String shortName, int healthPoints, description) {
        super(shortName,description);
        this.healthPoints = healthPoints;
        public int getHealthPoints () {
            return healthPoints;
        }
    }


}
