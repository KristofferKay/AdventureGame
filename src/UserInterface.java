import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Adventure adventure = new Adventure();
    PlaySound playSound = new PlaySound();



    public void startGame() {
        intro();

        while(true){
            System.out.print("> ");
            String userInput = scanner.nextLine().toLowerCase();
            String[] splitUserInput = userInput.split(" "); //for extracting take or drop
            String editedCommand = splitUserInput[0].toLowerCase();

            switch(editedCommand){
                case "exit" -> {
                    exit();
                    return;
                }
                case "north", "n" -> goNorth();
                case "south", "s" -> goSouth();
                case "west", "w" -> goWest();
                case "east", "e" -> goEast();
                case "look" -> look();
                case "help" -> helpMsg();
                case "inventory", "inv" -> inventory();
                case "take" -> takeItem(splitUserInput);
                case "drop" -> dropItem(splitUserInput);
                case "health" -> health();
                case "eat" -> eat(splitUserInput);
                default -> System.out.println("Invalid command. Try again");
            }
        }
    }
    // Runs the welcome messages
    public void intro(){

        System.out.println("");
        System.out.println("             _                 _                   _____                      \n" +
                "    /\\      | |               | |                 / ____|                     \n" +
                "   /  \\   __| |_   _____ _ __ | |_ _   _ _ __ ___| |  __  __ _ _ __ ___   ___ \n" +
                "  / /\\ \\ / _` \\ \\ / / _ \\ '_ \\| __| | | | '__/ _ \\ | |_ |/ _` | '_ ` _ \\ / _ \\\n" +
                " / ____ \\ (_| |\\ V /  __/ | | | |_| |_| | | |  __/ |__| | (_| | | | | | |  __/\n" +
                "/_/    \\_\\__,_| \\_/ \\___|_| |_|\\__|\\__,_|_|  \\___|\\_____|\\__,_|_| |_| |_|\\___|\n" +
                "                                                                              ");
        System.out.println("\033[1mWelcome to the adventure game!\033[0m");
        System.out.println("To start the game, write one of the following: north, south, west, east.");
        System.out.println("Type help to get a list of commands.");
        System.out.println("*************************************");

//      Uncomment to play music, beaware ITS LOUD.
//      PlaySoundMethod();
    }

    // println for currentroom that the player is in
    public void currentRoomPrint() {
        Room currentRoom = adventure.getPlayer().getCurrentRoom();
        System.out.printf("You are now in %s. \n%s\n", currentRoom.getName(),
                currentRoom.getDescription());
    }

    public void exit(){
        System.out.println("Exiting game, thanks for playing...");
    }

    public void look(){
        Room currentRoom = adventure.getPlayer().getCurrentRoom();
        System.out.println("Looking around...");
        System.out.println(currentRoom.getLongDescription());
    }

    // if no room is near, this msg will display so
    public void noRoomMsg() {
        System.out.println("You cannot go there.");
    }

    public void helpMsg(){
        System.out.println("\033[1mHere's a list of commands\033[0m:\n" +
                "* north/south/east/west or n/s/e/w - Move to a room in given direction \n" +
                "* exit - Exit out of the game \n" +
                "* look - Look around your current room\n" +
                "* help - Get a list of commands\n" +
                "* inventory/inv - See the list of items in your inventory\n" +
                "* take -itemName - Take the item\n" +
                "* drop -itemName - Drop the item\n" +
                "* health - See your current health\n" +
                "\033[1m**********************************\033[0m");
    }

    public void inventory(){
        List<Item> playerItems = adventure.getInventory();
        if(!playerItems.isEmpty()){
            System.out.println("You have these items in your bag:");
            for(Item item : playerItems){
                System.out.println(item.getShortName());
            }
        }else{
            System.out.println("Your bag is empty.");
        }
    }

    public void health() {
        int health = 100;

        if (health == 100) {
            System.out.println("Your health is " + health + " you have full health");
            adventure.health(health);
        } else if (health == 50) {
            System.out.println("Your health is " + health + " you have halft health");
            adventure.health(health);
        } else if (health == 20) {
            System.out.println("Your health is " + health + " you should not fight, find something to eat to get more health");
            adventure.health(health);
        } else {
            System.out.println("Your health is " + health + " you are dying");
            adventure.health(health);
        }

    }

    public void takeItem(String[] splitString) {
            Item takeItem = adventure.takeItem(splitString[1]);
            if (takeItem != null) {
                System.out.println("You picked up " + takeItem.getShortName());
            } else {
                System.out.println("There are no " + splitString[1] + " in the room");
            }
    }

    public void dropItem(String[] splitString) {
            Item dropItem = adventure.dropItem(splitString[1]);
            if (dropItem != null) {
                System.out.println("You dropped " + dropItem.getShortName());
            } else {
                System.out.println("There are no " + splitString[1] + " in your inventory");
            }
    }

    public void eat(String[] splitString){
        Food food = adventure.eat(splitString[1]);
        if(food != null){
            System.out.println("You just ate " + food.getShortName());
        }
    }

    public void goNorth(){
        Room northernRoom = adventure.goNorth();
        if(northernRoom != null){
            System.out.println("Going north...");
            currentRoomPrint();
        }else{
            noRoomMsg();
        }
    }

    public void goSouth(){
        Room southernRoom = adventure.goSouth();
        if(southernRoom != null){
            System.out.println("Going south...");
            currentRoomPrint();
        }else{
            noRoomMsg();
        }
    }

    public void goEast(){
        Room easternRoom = adventure.goEast();
        if(easternRoom != null){
            System.out.println("Going east...");
            currentRoomPrint();
        }else{
            noRoomMsg();
        }
    }

    public void goWest(){
        Room westernRoom = adventure.goWest();
        if(westernRoom != null){
            System.out.println("Going west...");
            currentRoomPrint();
        }else{
            noRoomMsg();
        }
    }

//    public void PlaySoundMethod() {
//        String lydfilSti = "/introsound.wav";
//        PlaySound.afspilLydfil(lydfilSti);
//    }
}

