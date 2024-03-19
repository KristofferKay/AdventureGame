import items.weapons.Weapon;

public class Enemy {

    private String enemyName;
    private String description;
    private int enemyHealth;
    private Room currentRoom;
    private Weapon currentWeapon;
    String enemyWeaponName;
    String  enemyWeaponDesc;
    int enemyNrUse;
    int enemyWpnDmg;



    public Enemy(String enemyName, String description, Room currentRoom, int enemyHealth, Weapon weapon) {
        this.enemyName = enemyName;
        this.description = description;
        this.enemyHealth = enemyHealth;
        this.currentWeapon = weapon;
    }

    public String attackingEnemy(){
        if(enemyHealth>0){
            return String.valueOf(enemyWpnDmg);

        }else{
            return "dead";
        }
    }

    public void die(){
        currentRoom.addItem(currentWeapon);
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getEnemyWpnDmg() {
        return enemyWpnDmg;
    }
    public void setEnemyWpnDmg(int enemyWpnDmg){
        this.enemyWpnDmg = enemyWpnDmg;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }


    public int getEnemyHealth() {
        return enemyHealth;
    }
}
