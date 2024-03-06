
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

    // println for currentroom that the player is in
    public void currentRoomPrint() {
        System.out.printf("You are now in %s. \n %s\n", currentRoom.getName(), currentRoom.getDescription());

    }
    public void exit(){
        System.out.println("Exiting game, thanks for playing...");
    }

    public void look(){
        System.out.println("Looking around...");
        currentRoomPrint();
    }

    // if no room is near, this msg will display
    public void noRoomMsg() {
        System.out.println("You cannot go there.");
    }
    public void helpMsg(){
        System.out.println("\033[1mHere's a list of commands!\033[0m:\n" +
                "* go north/south/east/west - Move to room in given direction \n" +
                "* exit - Exit out of the game \n" +
                "* look - Look around your current room\n" +
                "* help - Get a list of commands\n" +
                "\033[1m**********************************\033[0m");
    }
}