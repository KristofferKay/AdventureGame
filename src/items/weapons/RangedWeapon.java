package items.weapons;

public class RangedWeapon extends Weapon{

    private int numberOfUses;

    public RangedWeapon(String shortName, String longName, int numberOfUses) {
        super(shortName, longName);
        this.numberOfUses = numberOfUses;
    }

    public int getNumberOfUses(){
        return numberOfUses;
    }

    @Override
    public boolean canUse(){
        return "Remaining number of uses: " + numberOfUses;
    }
}
