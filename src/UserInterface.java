import java.util.Scanner;

public class UserInterface {
    // initiate scanner
    Scanner scanner = new Scanner(System.in);
    // creates a obj from Adventure class
    Adventure adventure = new Adventure();
    
    public void startGame() {
        intro();
        while(true){
            String command = scanner.nextLine().toLowerCase();
            System.out.print("> ");
            if(command.equals("exit")){
                adventure.exit();
                break;
            } else if(command.equals("look")){
                adventure.look();
            } else if(command.equals("help")){
                adventure.helpMsg();
            } else {
                adventure.move(command);
            }
        }
    }
    // Runs the welcome messages
    public void intro(){
        System.out.println("\033[1mWelcome to the adventure game!\033[0m");
        System.out.println("To start the game, write one of the following: Go north, Go South, Go West, Go east.");
        adventure.helpMsg();
        System.out.print("> ");
    }
    }
