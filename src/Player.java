import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> inventory;

    private int health;


    public Player(Room firstRoom) {
        this.currentRoom = firstRoom;
        this.inventory = new ArrayList<>();
        health = 100;
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
            addItem(takenItem); // Add the item to the player's inventory
        }
        return takenItem;
    }

    public Item dropItem(String shortName) {
        Item droppedItem = findItemInInventory(shortName);
        if (droppedItem != null) {
            removeItem(droppedItem);
            getCurrentRoom().addItem(droppedItem);
        }
        return droppedItem;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
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

    public String eat(String shortName){
        Item foundItem = findItemInInventory(shortName);
        if(foundItem == null){ //item is not found in the player's inventory
            foundItem = currentRoom.findItemInRoom(shortName); //find the item in the room
            if(foundItem != null){//if the item is found in the rom and it's food
                if(foundItem.isFood()){
                    currentRoom.removeItemInRoom(shortName);
                    health = health + ((Food) foundItem).getHealthPoints();
                    return "eaten";
                }else{
                    return "not eatable";
                }

            }else{
                return "does not exist";
            }
        }else{ //the item is in the inventory
            if(foundItem.isFood()){
                inventory.remove(foundItem);
                health = health + ((Food) foundItem).getHealthPoints();
                return "eaten";
            }else{
                return "not eatable";
            }
        }}


    public void setHealth(int health) {
        this.health = health;
    }
}
