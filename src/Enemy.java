public class Enemy {

    private String enemyName;
    private String description;
    private int enemyHealth;

    public Enemy(String enemyName, String description, int enemyHealth) {
        this.enemyName = enemyName;
        this.description = description;
        this.enemyHealth = enemyHealth;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }
}
