public class Player {
    private Room currentRoom;




    public Room goNorth() {
        if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            return currentRoom;

        }
        return null;
    }
    public void goSouth(){
        if (currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            System.out.println("Going south...");

            currentRoomPrint();
        } else {
            noRoomMsg();
        }
    }

    public void goEast(){
        if (currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
            System.out.println("Going east...");
            currentRoomPrint();
        } else {
            noRoomMsg();
        }
    }
    public void goWest(){
        if (currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            System.out.println("Going west...");
            currentRoomPrint();
        } else {
            noRoomMsg();
        }
    }

    // println for currentroom that the player is in
    public void currentRoomPrint() {
        System.out.printf("You are now in %s. \n %s\n", currentRoom.getName(), currentRoom.getDescription());

    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
