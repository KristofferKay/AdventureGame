import java.util.Scanner;

public class UserInterface {
    // initiate scanner
    Scanner scanner = new Scanner(System.in);
    // creates a obj from Adventure class
    Adventure adventure = new Adventure();
    Player player = new Player();
    
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
                player.move(command);
            } //TODO add else if to capture mismatch from user
        }
    }
    // Runs the welcome messages
    public void intro(){
        System.out.println("");
        System.out.println("\033[1mWelcome to the adventure game!\033[0m");
        System.out.println("To start the game, write one of the following: Go north, Go South, Go West, Go east.");
        System.out.println("");
        helpMsg();
    }

    // println for currentroom that the player is in
    public void currentRoomPrint() {
        System.out.printf("You are now in %s. \n %s\n", player.getCurrentRoom().getName(), player.getCurrentRoom().getDescription());

    }
    public void exit(){
        System.out.println("Exiting game, thanks for playing...");
    }

    public void look(){
        System.out.println("Looking around...");
        currentRoomPrint();
    }

    // if no room is near, this msg will display
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
}
