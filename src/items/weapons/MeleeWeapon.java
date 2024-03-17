package items.weapons;

public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String shortName, String longName){
        super(shortName,longName);
    }
    public void remainingUses(){
        System.out.println("You used the melee weapon.");
    }
}