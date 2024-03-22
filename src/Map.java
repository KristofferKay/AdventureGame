import items.food.Food;
import items.Item;
import items.food.Liquid;
import items.weapons.MeleeWeapon;
import items.weapons.RangedWeapon;
import org.w3c.dom.ranges.Range;
import java.io.*;

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
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";



    //create rooms, add items to the  rooms
    public Map() {

        room1 = new Room("Room 1",
                "The room looks quite empty and dark. It has two doors: one leads to the east, another - to the south. ",
                "Empty room.");
        room1.addItem(new MeleeWeapon("Sword","sharp sword",100, 17));
        room1.addItem(new RangedWeapon("cross-bow","Worn Cross-Bow",10, 7));

        room2 = new Room("Room 2",
                "It is a nicely decorated room with a big dining table in the middle, full of food. You can go out of the room through a big wooden door east" +
                "and through a metal door west.",
                "Room with a dining table.");
        room2.addItem(new Food("knife", "A kitchen knife, small but quite sharp. Please dont eat it",-100),
                new Food("cheese", "An old stinky piece of cheese.",1),
                new Liquid("water", "A bottle filled with water.",5),
                new Food("apple", "A fresh delicious apple.",10),
                new Liquid("akvavit", "A bottle of Akvavit, tastes horrible and just makes you drunk.", -30),
                new Liquid("poison", "Probably deadly.", -80));

        room2.addEnemy(new Enemy("undead-chef", "A Zombified kitchen chef", room2, 35, new MeleeWeapon("kitchen-knife","A Kitchen knife, probably used for cooking the food in the room..", 100, 10)));


        room3 = new Room("Room 3",
                "This room looks like a weapon storage. There are different swords and shields hanging on the walls, and there are also bows and arrows. " +
                "You can leave the room through a door east, and a room south.",
                "Room - weapon storage.");
        room3.addItem(new MeleeWeapon("sword", "A one-handed knights sword, new and shiny.",100,15),
                new MeleeWeapon("shield", "A round metal shield with runes on it.",100,0),
                new RangedWeapon("bow", "A light wooden bow", 10,9),
                new RangedWeapon("compound-bow", "A heavy but effective Compound bow",3,20));



        room3.addEnemy(new Enemy("giant-troll", "A giant monster with a axe", room3, 40, new MeleeWeapon("axe","A Giant axe. Might be too heavy for one hand..", 100, 19)),
                new Enemy("undead-dwarf", "A small, well geared dwarf", room3, 50, new MeleeWeapon("small-sword","A small sword. clearly made for a dwarf..", 100, 12)));

        room4 = new Room("Room 4",
                "Seems like you entered the library. There are lots of books on the book shelves. But there is one small book which draws your attention." +
                "Grab it and continue either through a metal door north, or through a passage south.",
                "Room - library.");
        room4.addItem(new MeleeWeapon("mysterious-book","A mysterious book, it could contain the answers as to who this castle belonged  to",5,0));
        room4.addEnemy(new Enemy("book keeper","A Book-Keeper skeleton throwing books at you..",room4,8,new MeleeWeapon("books","Could be used for reading, but you decide to use them as throwing objects..",4,3)));

        room5 = new Room("Room 5",
                "Right after the door there is a stair going down to a dungeon. There is a faint blue light glowing at the bottom of the stairs. Its probably a portal?",
                "Secret room with a portal.");

        room6 = new Room("Room 6",
                "Looks like you are in trouble. Right after you enter the room you got attacked by a bunch of skeletons," +
                "armoured with rusty but sharp swords. Fight if you can or run - the room has two doors: one north and one south.",
                "Room with skeletons.");
        room6.addEnemy(new Enemy("skeleton-knight","A skeleton wearing a knights helmet",room6,15, new MeleeWeapon("rusty-sword","A worn rusty old sword..",100,13)),new Enemy("skeleton-knight","A skeleton wearing knights Armor",room6,15, new MeleeWeapon("rusty-mace","A worn rusty old Mace..",100,15)),
                new Enemy("skeleton-mage","A skeleton holding what seems to be a grimoire, you sense mana radiating from the book",room6,22,new MeleeWeapon("fireball","The grimoire contains fireball spells",100,30)));

        room7 = new Room("Room 7",
                "It looks like a hall for big gatherings, as it has a tribune and many " +
                "wooden chairs. You notice an old man, sitting quietly in the corner." +
                "There is a passage going north, and a nicely decorated room on the east side of the hall.",
                "Big hall room.");
        room7.addEnemy(new Enemy("old-man", "an evil old mage, he seems to be the one controlling the skeletons, You notice a glowing sword behind him right as he charges towards you!", room7, 1, new MeleeWeapon("holy-sword","A powerful holy sword, you can tell without a doubt this sword belonged to the King of this castle..", 100, 999999)));

        room8 = new Room("Room 8",
                "It's hot in here! thanks to a dragon, which sits on a huge chest and exhales fire. " +
                "The dragon is obviously not in a friendly mood. There is no way you can defeat it without a powerful weapon. You can escape  through a decorated door leading west, and a wooden door towards east. There is also a large " +
                "metal gate in the northern side of the room, but it has a lock on it.",
                "Room with a dragon and a chest.");
        room8.addEnemy(new Enemy("dragon","A giant dragon exhaling flames, looks like its guarding a chest",room8,1100,new MeleeWeapon("fire-breath","A huge burst of fire, Burning everything in its path..",25,3000000)));

        room9 = new Room("Room 9",
                "It is a very dark room, you literally cannot see anything. But after you lit up a match it gets possible to notice a door in the northern" +
                "side of the room, and also a door towards the west. But wait with leaving - you are not alone in the room." +
                "There are Undead soldiers all around the room",
                "Dark room.");
        room9.addEnemy(new Enemy("undead-knight","A Zombie wearing a knights helmet",room9,25, new MeleeWeapon("broken-sword","A broken rusty old sword..",100,6)),new Enemy("undead-general","A powerful Zombie wearing knights Armor",room9,35, new MeleeWeapon("metal-gauntlets","Two Metal Gauntlets for punching your foes..",100,20)),
                new Enemy("undead-mage","A Zombie holding what seems to be a grimoire, you sense mana radiating from the book",room9,19,new MeleeWeapon("shadowball","The grimoire contains Dark spells..",100,22)));
        buildMap();
    }
    //add connections between the rooms
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

    public void setRoom1(Room room1) {
        this.room1 = room1;
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
