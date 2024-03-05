import java.util.Scanner;

public class UserInterface {
    // initiate scanner
    Scanner scanner = new Scanner(System.in);
    // creates a obj from Adventure class
    Adventure adventure = new Adventure();

    // Runs the welcome messages
    public void intro(){
        System.out.println("Welcome to the adventure game");
        System.out.println("Please type one of the following: Go north, Go South, Go West, Go east");
        System.out.println("You can always use Exit, help and look"); //TODO lav i et menu format
    }

    // navigation method
    public void navigate() {
        boolean loop = true;

        while (loop) {
            System.out.print("> ");
            String userInput = scanner.nextLine();
            loop = adventure.move(userInput);
        }
    }
    }
