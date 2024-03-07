import java.util.Scanner;

public class UserInterface {
    // initiate scanner
    Scanner scanner = new Scanner(System.in);
    // creates a obj from Adventure class
    Adventure adventure = new Adventure();
    PlaySound playSound = new PlaySound();



    public void startGame() {
        intro();

        while(true){
            System.out.print("> ");
            String command = scanner.nextLine().toLowerCase();
            if(command.equals("exit")){
                exit();
                break;
            } else if(command.equals("look")){
                look();
            } else if(command.equals("help")){
                helpMsg();
            } else {
                move(command);

            } //TODO add else if to capture mismatch from user
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
        System.out.println("To start the game, write one of the following: Go north, Go South, Go West, Go east.");
        System.out.println("");
        helpMsg();
//      Uncomment to play music, beaware ITS LOUD.
//      PlaySoundMethod();
    }

    // println for currentroom that the player is in
    public void currentRoomPrint() {
        Room currentRoom = adventure.getPlayer().getCurrentRoom();
        System.out.printf("You are now in %s. \n %s\n", currentRoom.getName(),
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

    // if no room is near, this msg will display do
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


    // method to move the player from room to rooms
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
            default:
                System.out.println("Invalid command. Try again");
        } return true;
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

