public class Player {

    private Room currentRoom;

    public Player(Room firstRoom) {
        this.currentRoom = firstRoom;
    }

    public Room goNorth() {
        if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            currentRoom.setBeenThere(true);
            return currentRoom;
        }
        return null;
    }
    public Room goSouth(){
        if (currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            currentRoom.setBeenThere(true);
            return currentRoom;
        }
        return null;
    }

    public Room goEast(){
        if (currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
            currentRoom.setBeenThere(true);
            return currentRoom;
        }
        return null;
        }

    public Room goWest() {
        if (currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            currentRoom.setBeenThere(true);
            return currentRoom;
        }
        return null;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}