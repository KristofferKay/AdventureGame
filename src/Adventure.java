
public class Adventure {
    private Room currentRoom;
    private Map map;



    public Adventure() {
        map = new Map();
        currentRoom = map.getRoom1();
    }



    // method to move the player from room to room
    public boolean move(String userInput) {
        switch (userInput.toLowerCase()) {
            case "go north":
            case "north":
            case "n":
                goNorth();
                break;
            case "go south":
            case "south":
            case "s":
                goSouth();
                break;
            case "go west":
            case "west":
            case "w":
                goWest();
                break;
            case "go east":
            case "east":
            case "e":
                goEast();
                break;
        } return true;
    }

    public void goNorth(){
        if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            System.out.println("Going north...");
            currentRoomPrint();
        } else {
            noRoomMsg();
        }
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


}