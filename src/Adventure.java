
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
        r1 = new Room("Room 1", "The room looks quite empty and dark. It has two doors: one leads to the east, another - to the south.");
        r2 = new Room("Room 2", "It is a nicely decorated room with a big dining table in the middle, full of food. You can go out of the room through a big wooden door in the east" +
                "and through a metal door in the west.");
        r3 = new Room("Room 3", "This room looks like a weapon storage. There are different swords and shields hanging on the walls, and there are also bows and arrows." +
                "You can leave the room throw a door in the east, and a room in the south.");
        r4 = new Room("Room 4", "Seems like you entered the library. There are lots of books on the book shelfs. But there is one small book which drawns your attention." +
                "Grab it and continue either throw a metal door in the north, or through a passage in the south.");
        r5 = new Room("Room 5", "Right after the door there is a stairs going down to a dungeon. There is blue light in the darkness. Probably it is a portal?");
        r6 = new Room("Room 6", "Looks like you are in trouble. Right after you enter the room you got attacked by a bunch of skeletons," +
                "armoured with rusty but sharp swords. Fight if you can or run - the room has two doors: one in the north and one in the south.");
        r7 = new Room("Room 7", "It looks like a hall for big gatherings, as it has a tribune and many " +
                "wooden chairs. You can notice an old man, sitting quietly in the corner." +
                "There is a passage going north, and a nicely decorated room in the east side of the hall.");
        r8 = new Room("Room 8", "It's hot in here! thanks to a dragon, which sits on a huge chest and exhales fire. " +
                "The dragon is obviously not in a friendly mood. You can escape it through a decorated door leading to the west, and a wooden door towards the east. There is also a large " +
                "metal gate in the northern side of the room, but it has a lock on it.");
        r9 = new Room("Room 9", "It is a very dark room, you literally cannot see anything. But after you lit up a match it gets possible to notice a door in the northes" +
                "side of the room, and also a door towards the west. But wait with leaving - you are not alone in the room." +
                "There is a young woman hiding under the table.");
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