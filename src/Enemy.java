import items.weapons.Weapon;

public class Enemy {

    private String enemyName;
    private String description;
    private int enemyHealth;

    String enemyWeaponName;
    String  enemyWeaponDesc;
    int enemyNrUse;
    int enemyWpnDmg;



    public Enemy(String enemyName, String description, int enemyHealth, String enemyWeaponName, String enemyWeaponDesc,int  enemyNrUse, int enemyWpnDmg) {
        this.enemyName = enemyName;
        this.description = description;
        this.enemyHealth = enemyHealth;
        this.enemyWeaponName = enemyWeaponName;
        this.enemyWeaponDesc = enemyWeaponDesc;
        this.enemyNrUse = enemyNrUse;
        this.enemyWpnDmg = enemyWpnDmg;
        Weapon weapon = new Weapon(enemyWeaponName, enemyWeaponDesc, enemyNrUse, enemyWpnDmg) {
            @Override
            public String canUse() {
                return null;
            }

            @Override
            public String useWeapon() {

                return null;
            }
        };
    }
    public String attackingEnemy(){
        if(enemyHealth>0){
            return String.valueOf(enemyWpnDmg);

        }else{
            return "dead";
        }
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
