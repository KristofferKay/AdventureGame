import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Adventure adventure = new Adventure();



    public void startGame() {
        intro();
        while(true){
            String command = scanner.nextLine().toLowerCase();
            if(command.equals("exit")){
                adventure.exit();
                break;
            } else if(command.equals("look")){
                adventure.look();
            } else if(command.equals("help")){
                //adventure.help();
            } else {
                adventure.move(command);
            }
        }
    }
    public void intro(){
        System.out.println("Welcome to the adventure game");
        System.out.println("Please type one of the following: Go north, Go South, Go West, Go east");
        System.out.println("You can always use Exit, help and look"); //TODO lav i et menu format
    }

    }
