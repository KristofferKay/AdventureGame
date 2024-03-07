public class Map {

    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;
    private Room room5;
    private Room room6;
    private Room room7;
    private Room room8;
    private Room room9;


    public Map() {
        room1 = new Room("Room 1",
                "The room looks quite empty and dark. It has two doors: one leads to the east, another - to the south. ",
                "Empty room.");

        room2 = new Room("Room 2",
                "It is a nicely decorated room with a big dining table in the middle, full of food. You can go out of the room through a big wooden door in the east" +
                "and through a metal door in the west.",
                "Room with a dining table.");
        room2.addItem(new Item("Kitchen knive", "A kitchen knive, small but quite sharp."),
                new Item("Cheese", "A piece of old stinking cheese."),
                new Item("water", "A bottle filled with water."),
                new Item("apple", "A fresh delicious apple."));
        room3 = new Room("Room 3",
                "This room looks like a weapon storage. There are different swords and shields hanging on the walls, and there are also bows and arrows. " +
                "You can leave the room throw a door in the east, and a room in the south.",
                "Room - weapon storage.");
        room3.addItem(new Item("One hand sword", "A sword for using in one hand, new and shiny."),
                new Item("Shield", "A round metal shield with runes on it."),
                new Item("Bow", "A light wooden bow"));
        room4 = new Room("Room 4",
                "Seems like you entered the library. There are lots of books on the book shelfs. But there is one small book which drawns your attention." +
                "Grab it and continue either throw a metal door in the north, or through a passage in the south.",
                "Room - library.");
        room5 = new Room("Room 5",
                "Right after the door there is a stairs going down to a dungeon. There is blue light in the darkness. Probably it is a portal?",
                "Secret room with a portal.");
        room6 = new Room("Room 6",
                "Looks like you are in trouble. Right after you enter the room you got attacked by a bunch of skeletons," +
                "armoured with rusty but sharp swords. Fight if you can or run - the room has two doors: one in the north and one in the south.",
                "Room with skeletons.");
        room7 = new Room("Room 7",
                "It looks like a hall for big gatherings, as it has a tribune and many " +
                "wooden chairs. You can notice an old man, sitting quietly in the corner." +
                "There is a passage going north, and a nicely decorated room in the east side of the hall.",
                "Big hall room.");
        room8 = new Room("Room 8",
                "It's hot in here! thanks to a dragon, which sits on a huge chest and exhales fire. " +
                "The dragon is obviously not in a friendly mood. You can escape it through a decorated door leading to the west, and a wooden door towards the east. There is also a large " +
                "metal gate in the northern side of the room, but it has a lock on it.",
                "Room with a dragon and a chest.");
        room9 = new Room("Room 9",
                "It is a very dark room, you literally cannot see anything. But after you lit up a match it gets possible to notice a door in the northes" +
                "side of the room, and also a door towards the west. But wait with leaving - you are not alone in the room." +
                "There is a young woman hiding under the table.",
                "Dark room.");
        buildMap();
    }

    public void buildMap() {

        room1.setEast(room2);
        room1.setSouth(room4);

        room2.setEast(room3);

        room3.setSouth(room6);

        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setSouth(room9);

        room7.setEast(room8);

        room8.setEast(room9);
    }


    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room r1) {
        this.room1 = r1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setRoom2(Room room2) {
        this.room2 = room2;
    }

    public Room getRoom3() {
        return room3;
    }

    public void setRoom3(Room room3) {
        this.room3 = room3;
    }

    public Room getRoom4() {
        return room4;
    }

    public void setRoom4(Room room4) {
        this.room4 = room4;
    }

    public Room getRoom5() {
        return room5;
    }

    public void setRoom5(Room room5) {
        this.room5 = room5;
    }

    public Room getRoom6() {
        return room6;
    }

    public void setRoom6(Room room6) {
        this.room6 = room6;
    }

    public Room getRoom7() {
        return room7;
    }

    public void setRoom7(Room room7) {
        this.room7 = room7;
    }

    public Room getRoom8() {
        return room8;
    }

    public void setRoom8(Room room8) {
        this.room8 = room8;
    }

    public Room getRoom9() {
        return room9;
    }

    public void setRoom9(Room room9) {
        this.room9 = room9;
    }
}
