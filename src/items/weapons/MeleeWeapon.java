package items.weapons;

public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String shortName, String longName,int numberOfUses,int damagePoints){
        super(shortName,longName,numberOfUses,damagePoints);
    }

    @Override
    public String canUse() {
        return "";
    }

    @Override
    public String useWeapon() {
        return "melee weapon";
    }


}