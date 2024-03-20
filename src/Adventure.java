import items.Item;
import items.weapons.Weapon;

import java.util.ArrayList;

public class Adventure {
    private Map map;
    private Player player;


    public Adventure() {
        map = new Map();
        player = new Player(map.getRoom1());
    }

    public Player getPlayer() {
        return player;
    }

    public Room goNorth() {
        return player.goNorth();
    }

    public Room goSouth() {
        return player.goSouth();
    }

    public Room goWest() {
        return player.goWest();
    }

    public Room goEast() {
        return player.goEast();
    }

    public ArrayList<Item> getInventory() {
        return player.getInventory();
    }

    public Item takeItem(String shortName) {
        return player.takeItem(shortName);
    }

    public Item dropItem(String shortName) {
        return player.dropItem(shortName);
    }

    public int health(){
        return player.getHealth();
    }

    public Weapon getPlayersCurrentWeapon(){
        return player.getCurrentWeapon();
    }
    public String consume(String shortName){
        return player.consume(shortName);
    }

    public String equip(String shortName){
        return player.equip(shortName);
    }

    public String attack(String enemyName){
        return player.attack(enemyName);
    }

    public String attack(){
        return player.attack();
    }

    public String isAttackPossible(){
        return player.isAttackPossible();
    }

    public String enemyAttacks(Enemy attackingEnemy, Player player) {
        return attackingEnemy.attack(player);
    }
}