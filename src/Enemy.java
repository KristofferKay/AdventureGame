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
    private Weapon enemyWeapon;



    public Enemy(String enemyName, String description, Room currentRoom, int enemyHealth, Weapon weapon) {
        this.enemyName = enemyName;
        this.description = description;
        this.currentRoom = currentRoom;
        this.enemyHealth = enemyHealth;
        this.currentWeapon = weapon;
    }

    public String attack(Player player) {
        int damageDealt = enemyWeapon.getDamagePoints();
        player.hit(damageDealt);
        return "Enemy attacked player with " + damageDealt + " damage.";
    }

    public String hit(int damage) {
        enemyHealth -= damage;
        if (enemyHealth <= 0) {
            die();
            return "Enemy has been defeated!";
        } else {
            return "Enemy has been hit for " + damage + " damage.";
        }
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
    public Room getCurrentRoom(){
        return currentRoom;
    }
    public void setCurrentRoom(Room currentRoom){
        this.currentRoom=currentRoom;
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
