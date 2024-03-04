public class Adventure {

    Room room1 = new Room("East", "You are in room1  ");
    String look;

    public void currentRoom(String look) {
        this.look = look;

        if (look.contains("look")) {
            System.out.println("looking around");

        }
    }
}
