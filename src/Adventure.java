import java.util.Scanner;

public class Adventure {
    Scanner scanner = new Scanner(System.in);

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

    public boolean move(String userInput) {
            switch (userInput.toLowerCase()) {
                case "go north":
                    System.out.println("Going north");
                    if (currentRoom.getNorth() != null) {
                        currentRoom = currentRoom.getNorth();
                        currentRoomPrint();
                    } else {
                        noRoomMsg();
                    } break;
                case "go south":
                    System.out.println("Going south");
                    if (currentRoom.getSouth() != null) {
                        currentRoom = currentRoom.getSouth();
                        currentRoomPrint();
                    } else {
                        noRoomMsg();
                    } break;
                case "go west":
                    System.out.println("Going west");
                    if (currentRoom.getWest() != null) {
                        currentRoom = currentRoom.getWest();
                        currentRoomPrint();
                    } else {
                        noRoomMsg();
                    } break;
                case "go east":
                    System.out.println("Going east");
                    if (currentRoom.getEast() != null) {
                        currentRoom = currentRoom.getEast();
                        currentRoomPrint();
                    } else {
                        noRoomMsg();
                    } break;
                case "look":
                    System.out.println("Looking around..");
                    currentRoomPrint();
                    break;
                case "exit":
                    System.out.println("Exiting game, thanks for playing..");
                    break;

            } return true;
        }

    public void currentRoomPrint() {
        System.out.println(currentRoom.getName() + " " + currentRoom.getDescription());
    }

    public void noRoomMsg() {
        System.out.println("You cannot go there");
    }
}