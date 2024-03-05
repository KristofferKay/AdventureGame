public class Adventure {
    Room currentRoom;
    Room r1;
    Room r2;
    Room r3;
    Room r4;
    Room r5;
    Room r6;
    Room r7;
    Room r8;
    Room r9;


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
        currentRoom = r1;
        buildMap();

    }

    public void move( String direction) {
        Room nextRoom = null;
        switch (direction) {
            case "go north":
                nextRoom = currentRoom.getNorth();
                break;
            case "go east":
                nextRoom = currentRoom.getEast();
                break;
            case "go south":
                nextRoom = currentRoom.getSouth();
                break;
            case "go west":
                nextRoom = currentRoom.getWest();
                break;
        }
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("You move " + direction + " and enter " + currentRoom.getName());
        } else {
            System.out.println("You cannot move " + direction + " you cannot go that way");
        }
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



}