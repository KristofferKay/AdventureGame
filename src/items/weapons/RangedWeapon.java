package items.weapons;

public class RangedWeapon extends Weapon{


    public RangedWeapon(String shortName, String longName, int numberOfUses) {
        super(shortName, longName, numberOfUses);
    }


    @Override
    public String canUse(){
        if(super.getNumberOfUses() > 0){
            return "Remaining number of uses: " + super.getNumberOfUses();
        }else{
            return "broken";
        }
    }

    @Override
    public void useWeapon(){
        super.setNumberOfUses(super.getNumberOfUses()-1);
    }
}
