package items.weapons;

public class RangedWeapon extends Weapon{


    public RangedWeapon(String shortName, String longName, int numberOfUses,int damagePoints) {
        super(shortName, longName, numberOfUses,damagePoints);
    }


    @Override
    public String canUse(){
        if(super.getNumberOfUses() > 0){
            return "Remaining number of uses for your weapon: " + super.getNumberOfUses();
        }else{
            return "broken";
        }
    }

    @Override
    public String useWeapon(){
        int result = super.getNumberOfUses()-1;
        super.setNumberOfUses(result);
        return "You used a ranged weapon.";
    }

}
