import items.food.Consumables;
import items.Item;
import items.weapons.Weapon;

import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private Weapon currentWeapon;
    private ArrayList<Item> inventory;

    private int health;


    public Player(Room firstRoom) {
        this.currentRoom = firstRoom;
        this.inventory = new ArrayList<>();
        health = 100;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public Room goNorth() {
        leaveRoom();
        if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            return currentRoom;
        }
        return null;
    }

    public Room goSouth() {
        leaveRoom();
        if (currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            return currentRoom;
        }
        return null;
    }

    public Room goEast() {
        leaveRoom();
        if (currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
            return currentRoom;
        }
        return null;
    }

    public Room goWest() {
        leaveRoom();
        if (currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            return currentRoom;
        }
        return null;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void leaveRoom() {
        currentRoom.setBeenThere(true);
    }

    public Item takeItem(String shortName) {

        Item takenItem = currentRoom.removeItemInRoom(shortName);
        if (takenItem != null) {
            addItemToInventory(takenItem); // Add the item to the player's inventory
        }
        return takenItem;
    }

    public Item dropItem(String shortName) {
        Item droppedItem = findItemInInventory(shortName);
        if (droppedItem != null) {
            removeItemFromInventory(droppedItem);
            getCurrentRoom().addItem(droppedItem);
            if(droppedItem.equals(currentWeapon)){
                dropEquipped();
            }
        }
        return droppedItem;
    }

    public void dropEquipped(){
        currentWeapon = null;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
    }

    public Item findItemInInventory(String shortName) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return item;
            }
        }
        return null;
    }

    public int currentHealth() {
        return health;
    }


    public String consume(String shortName) {
        Item foundItem = findItemInInventory(shortName);
        if (foundItem == null) { //item is not found in the player's inventory
            foundItem = currentRoom.findItemInRoom(shortName); //find the item in the room
            if (foundItem != null) {//if the item is found in the room, and it's consumable
                if (foundItem.isConsumable()) {
                    currentRoom.removeItemInRoom(shortName);
                    health = health + ((Consumables) foundItem).getHealthPoints();
                    if (((Consumables) foundItem).isFood()) return "eaten";
                    if (((Consumables) foundItem).isLiquid()) return "drunken";
                } else {
                    return "not consumable";
                }
            } else {
                return "does not exist";
            }
        } else { //the item is in the inventory
            if (foundItem.isConsumable()) {
                inventory.remove(foundItem);
                health = health + ((Consumables) foundItem).getHealthPoints();
                if (((Consumables) foundItem).isFood()) return "eaten";
                if (((Consumables) foundItem).isLiquid()) return "drunken";
            } else {
                return "not consumable";
            }
        }
        return "";
    }

    public String equip(String shortName) {
        Item foundItem = findItemInInventory(shortName);
        if (foundItem == null) return "does not exist";
        if (foundItem instanceof Weapon) {
            currentWeapon = (Weapon) foundItem;
            return "equipped";
        } else {
            return "not a weapon";
        }
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String attack(){
        if (currentWeapon != null){
            currentWeapon.useWeapon();
            return currentWeapon.canUse();
        }
        return null;
    }
}
