package items.weapons;

public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String shortName, String longName){
        super(shortName,longName);
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