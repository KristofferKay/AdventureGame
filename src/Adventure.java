public class Adventure {
    String look;

    public void currentRoom(String look) {
        this.look = look;

        if (look.contains("look")) {
            System.out.println("looking around");
        }
    }

    public void buildMap(){
        Room room1 = new Room("Room 1", "description");
        Room room2 = new Room("Room 2", "description");
        Room room3 = new Room("Room 3", "description");
        Room room4 = new Room("Room 4", "description");
        Room room5 = new Room("Room 5", "description");
        Room room6 = new Room("Room 6", "description");
        Room room7 = new Room("Room 7", "description");
        Room room8 = new Room("Room 8", "description");
        Room room9 = new Room("Room 9", "description");

        room1.setEast(room2);
        room1.setSouth(room4);

        room2.setWest(room1);
        room2.setEast(room3);

        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);

        room9.setWest(room8);
        room9.setNorth(room6);
    }
}
