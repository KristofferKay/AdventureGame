package items.weapons;

public class RangedWeapon extends Weapon{
    private int remaining;

    public RangedWeapon(String shortName, String longName,int remaining){
        super(shortName,longName);
        this.remaining= remaining;
    }
    public int getRemaining(){
        return remaining;
    }
    public void remainingUses(){
        if (remaining > 0){
            remaining--;
            System.out.println("You used the ranged weapon.");
        }else {
            System.out.println("The ranged weapon out of ammunition.");
        }
    }
}