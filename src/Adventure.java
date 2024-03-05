
public class Adventure {
    private Room currentRoom;
    private Room r1;
    private Room r2;
    private Room r3;
    private Room r4;
    private Room r5;
    private Room r6;
    private Room r7;
    private Room r8;
    private Room r9;

    public Adventure() {
        r1 = new Room("room 1", "east south");
        r2 = new Room("room 2", "west east");
        r3 = new Room("room 3", "west south");
        r4 = new Room("room 4", "north south");
        r5 = new Room("room 5", "south");
        r6 = new Room("room 6", "north south");
        r7 = new Room("room 7", "north east");
        r8 = new Room("room 8", "west north east");
        r9 = new Room("room 9", "west north");
        buildMap();
        currentRoom = r1;

    }

    public void buildMap() {

        r1.setEast(r2);
        r1.setSouth(r4);

        r2.setWest(r1);
        r2.setEast(r3);

        r3.setWest(r2);
        r3.setSouth(r6);

        r4.setNorth(r1);
        r4.setSouth(r7);

        r5.setSouth(r8);

        r6.setNorth(r3);
        r6.setSouth(r9);

        r7.setNorth(r4);
        r7.setEast(r8);

        r8.setWest(r7);
        r8.setNorth(r5);
        r8.setEast(r9);

        r9.setWest(r8);
        r9.setNorth(r6);
    }

    // method to move the player from room to room
    public boolean move(String userInput) {
        switch (userInput.toLowerCase()) {
            case "go north":
                goNorth();
                break;
            case "go south":
                goSouth();
                break;
            case "go west":
                goWest();
                break;
            case "go east":
                goEast();
                break;
        } return true;
    }

    public void goNorth(){
        if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            System.out.println("Going north");
            currentRoomPrint();
        } else {
            noRoomMsg();
        }
    }

    public void goSouth(){
        if (currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            System.out.println("Going south");
            currentRoomPrint();
        } else {
            noRoomMsg();
        }
    }

    public void goEast(){
        if (currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
            System.out.println("Going east");
            currentRoomPrint();
        } else {
            noRoomMsg();
        }
    }

    public void goWest(){
        if (currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            System.out.println("Going west");
            currentRoomPrint();
        } else {
            noRoomMsg();
        }
    }

    // println for currentroom that the player is in
    public void currentRoomPrint() {
        System.out.printf("You are now in %s %s", currentRoom.getName(), currentRoom.getDescription());
    }

    public void exit(){
        System.out.println("Exiting game, thanks for playing..");
    }

    public void look(){
        System.out.println("Looking around..");
        currentRoomPrint();
    }

    // if no room is near, this msg will display
    public void noRoomMsg() {
        System.out.println("You cannot go there");
    }
    public void helpMsg(){
        System.out.println("\033[1mHere's a list of commands!\033[0m:\n" +
                "* go north/south/east/west - Move to room in given direction \n" +
                "* exit - Exit out of the game \n" +
                "* look - Look around your current room\n" +
                "* help - Get a list of commands");
    }
}