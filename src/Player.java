public class Player {

    private Room currentRoom;

    public Player(Room firstRoom) {
        this.currentRoom = firstRoom;
    }

    public Room goNorth() {
        leaveRoom();
        if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            return currentRoom;
        }
        return null;
    }
    public Room goSouth(){
        leaveRoom();
        if (currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            return currentRoom;
        }
        return null;
    }

    public Room goEast(){
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

    public void leaveRoom(){
        currentRoom.setBeenThere(true);
    }
}