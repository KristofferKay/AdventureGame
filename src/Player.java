import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> inventory;

    public Player(Room firstRoom) {
        this.currentRoom = firstRoom;
        this.inventory = new ArrayList<>();
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

    private Item findItemInInventory(String shortName) {
        for (Item item : inventory) {
            if (item.getShortName().equals(shortName)) {
                return item;
            }
        }
        return null;
    }
}
