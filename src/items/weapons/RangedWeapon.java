package items.weapons;

public class RangedWeapon extends Weapon{

    private int numberOfUses;

    public RangedWeapon(String shortName, String longName) {
        super(shortName, longName);
        numberOfUses = 10;
    }

    public boolean canUse(){
        return numberOfUses > 0;
    }
}
